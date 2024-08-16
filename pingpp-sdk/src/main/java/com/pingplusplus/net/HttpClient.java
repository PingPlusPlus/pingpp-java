package com.pingplusplus.net;

import com.pingplusplus.Pingpp;
import com.pingplusplus.exception.APIConnectionException;
import com.pingplusplus.exception.PingppException;
import com.pingplusplus.util.PingppSignature;
import com.pingplusplus.util.StreamUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.ConnectException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public abstract class HttpClient {
    /** Maximum sleep time between tries to send HTTP requests after network failure. */
    public static final long maxNetworkRetriesDelay = 5000;

    /** Minimum sleep time between tries to send HTTP requests after network failure. */
    public static final long minNetworkRetriesDelay = 500;

    /** A value indicating whether the client should sleep between automatic request retries. */
    boolean networkRetriesSleep = true;

    /** Initializes a new instance of the {@link HttpClient} class. */
    public HttpClient() {}

    /**
     * Sends the given request to Pingpp's API.
     *
     * @param request the request
     * @return the response
     * @throws PingppException If the request fails for any reason
     */
    public abstract PingppResponse request(PingppRequest request) throws PingppException;

    /**
     * Sends the given request to Pingpp's API, retrying the request in cases of intermittent
     * problems.
     *
     * @param request the request
     * @return the response
     * @throws PingppException If the request fails for any reason
     */
    public PingppResponse requestWithRetries(PingppRequest request) throws PingppException {
        APIConnectionException requestException = null;
        PingppResponse response = null;
        int retry = 0;

        while (true) {
            requestException = null;

            try {
                response = this.request(request);
            } catch (APIConnectionException e) {
                requestException = e;
            }

            if (!this.shouldRetry(retry, requestException, request, response)) {
                break;
            }

            retry += 1;

            try {
                Thread.sleep(this.sleepTime(retry));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        if (requestException != null) {
            throw requestException;
        }

        response.setNumRetries(retry);

        return response;
    }

    /**
     * Builds the value of the {@code User-Agent} header.
     *
     * @return a string containing the value of the {@code User-Agent} header
     */
    protected static String buildUserAgentString() {
        return String.format("Pingpp/v1 JavaBindings/%s", Pingpp.VERSION);
    }

    /**
     * Builds the value of the {@code X-Pingpp-Client-User-Agent} header.
     *
     * @return a string containing the value of the {@code X-Pingpp-Client-User-Agent} header
     */
    protected static String buildXPingppClientUserAgentString() {
        String[] propertyNames = {
                "os.name",
                "os.version",
                "os.arch",
                "java.version",
                "java.vendor",
                "java.vm.version",
                "java.vm.vendor"
        };

        Map<String, String> propertyMap = new HashMap<>();
        for (String propertyName : propertyNames) {
            propertyMap.put(propertyName, System.getProperty(propertyName));
        }
        propertyMap.put("bindings.version", Pingpp.VERSION);
        propertyMap.put("lang", "Java");
        propertyMap.put("publisher", "Pingpp");

        return APIResource.GSON.toJson(propertyMap);
    }

    protected static String buildPingppSignature(PingppRequest request, String currentTime)
            throws IOException {
        StringBuilder sb = new StringBuilder();
        if (request.content != null) {
            sb.append(request.content.stringContent());
        }
        sb.append(getRequestURIFromURL(request.url));
        sb.append(currentTime);

        String stringToBeSigned = sb.toString();

        return generateSign(stringToBeSigned, request.options);
    }

    private boolean shouldRetry(
            int numRetries, PingppException exception, PingppRequest request, PingppResponse response) {
        // Do not retry if we are out of retries.
        if (numRetries >= request.options.getMaxNetworkRetries()) {
            return false;
        }

        // Retry on connection error.
        if ((exception != null)
                && (exception.getCause() != null)
                && (exception.getCause() instanceof ConnectException)) {
            return true;
        }

        // Retry on 500, 503, and other internal errors.
        if ((response != null) && (response.getResponseCode() >= 500)) {
            return true;
        }

        return false;
    }

    private long sleepTime(int numRetries) {
        if (!networkRetriesSleep) {
            return 0;
        }

        long delay = (long) (minNetworkRetriesDelay * Math.pow(2, numRetries - 1));

        if (delay > maxNetworkRetriesDelay) {
            delay = maxNetworkRetriesDelay;
        }

        double jitter = ThreadLocalRandom.current().nextDouble(0.75, 1.0);
        delay = (long) (delay * jitter);

        if (delay < minNetworkRetriesDelay) {
            delay = minNetworkRetriesDelay;
        }

        return delay;
    }

    protected static String currentTimeString() {
        int requestTime = (int) (System.currentTimeMillis() / 1000);
        return Integer.toString(requestTime);
    }

    private static String getRequestURIFromURL(URL url) {
        String path = url.getPath();
        String query = url.getQuery();
        if (query == null) {
            return path;
        }
        return path + "?" + query;
    }

    private static String generateSign(String data, RequestOptions options)
            throws IOException {
        String privatekey =  options.getPrivateKey();
        if (privatekey == null) {
            if (Pingpp.privateKeyPath == null) {
                return null;
            }
            FileInputStream inputStream = new FileInputStream(Pingpp.privateKeyPath);
            privatekey = StreamUtils.readToEnd(inputStream, APIResource.CHARSET);
            inputStream.close();
        }

        return PingppSignature.sign(data, privatekey, APIResource.CHARSET.name());
    }

}
