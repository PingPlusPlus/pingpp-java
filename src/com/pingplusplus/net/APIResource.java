package com.pingplusplus.net;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.pingplusplus.Pingpp;
import com.pingplusplus.exception.APIConnectionException;
import com.pingplusplus.exception.APIException;
import com.pingplusplus.exception.AuthenticationException;
import com.pingplusplus.exception.ChannelException;
import com.pingplusplus.exception.InvalidRequestException;
import com.pingplusplus.model.Charge;
import com.pingplusplus.model.ChargeRefundCollection;
import com.pingplusplus.model.PingppObject;
import com.pingplusplus.model.RedEnvelope;
import com.pingplusplus.model.Transfer;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import javax.net.ssl.HttpsURLConnection;

/**
 * extends the abstract class when you need requset anything from ping++
 */
public abstract class APIResource extends PingppObject {
    /**
     * URLEncoder charset
     */
    public static final String CHARSET = "UTF-8";


    /**
     * Http requset method
     */
    protected enum RequestMethod {
        GET, POST, DELETE
    }

    /**
     * Gson object use to transform json string to Charge object
     */
    public static final Gson GSON = new GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .registerTypeAdapter(Charge.class, new ChargeDeserializer())
            .registerTypeAdapter(RedEnvelope.class, new RedEnvelopeDeserializer())
            .registerTypeAdapter(Transfer.class, new TransferDeserializer())
            .registerTypeAdapter(ChargeRefundCollection.class, new ChargeRefundCollectionDeserializer())
            .create();

    /**
     * @param clazz
     * @return
     */
    private static String className(Class<?> clazz) {
        String className = clazz.getSimpleName().toLowerCase().replace("$", " ");

        if (className.equals("redenvelope")) {
            return "red_envelope";
        }
        if (className.equals("smscode")) {
            return "sms_code";
        } else {
            return className;
        }
    }

    /**
     * @param clazz
     * @return
     */
    protected static String singleClassURL(Class<?> clazz) {
        return String.format("%s/v1/%s", Pingpp.getApiBase(), className(clazz));
    }

    /**
     * @param clazz
     * @return
     */
    protected static String classURL(Class<?> clazz) {
        return String.format("%ss", singleClassURL(clazz));
    }

    /**
     * @param clazz
     * @param id
     * @return
     * @throws InvalidRequestException
     */
    protected static String instanceURL(Class<?> clazz, String id) throws InvalidRequestException {
        try {
            return String.format("%s/%s", classURL(clazz), urlEncode(id));
        } catch (UnsupportedEncodingException e) {
            throw new InvalidRequestException("Unable to encode parameters to " + CHARSET, null, e);
        }
    }


    /**
     * @param str
     * @return
     * @throws UnsupportedEncodingException
     */
    private static String urlEncode(String str) throws UnsupportedEncodingException {
        if (str == null) {
            return null;
        } else {
            return URLEncoder.encode(str, CHARSET);
        }
    }

    /**
     * @param k
     * @param v
     * @return
     * @throws UnsupportedEncodingException
     */
    private static String urlEncodePair(String k, String v)
            throws UnsupportedEncodingException {
        return String.format("%s=%s", urlEncode(k), urlEncode(v));
    }

    /**
     * @param apiKey
     * @return
     */
    static Map<String, String> getHeaders(String apiKey) {
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("Accept-Charset", CHARSET);
        headers.put("User-Agent",
                String.format("Pingpp/v1 JavaBindings/%s", Pingpp.VERSION));

        if (apiKey == null) {
            apiKey = Pingpp.apiKey;
        }

        headers.put("Authorization", String.format("Bearer %s", apiKey));
        headers.put("Accept-Language", Pingpp.AcceptLanguage);

        // debug headers
        String[] propertyNames = {"os.name", "os.version", "os.arch",
                "java.version", "java.vendor", "java.vm.version",
                "java.vm.vendor"};
        Map<String, String> propertyMap = new HashMap<String, String>();
        for (String propertyName : propertyNames) {
            propertyMap.put(propertyName, System.getProperty(propertyName));
        }
        propertyMap.put("bindings.version", Pingpp.VERSION);
        propertyMap.put("lang", "Java");
        propertyMap.put("publisher", "Pingpp");
        headers.put("X-Pingpp-Client-User-Agent", GSON.toJson(propertyMap));
        if (Pingpp.apiVersion != null) {
            headers.put("Pingplusplus-Version", Pingpp.apiVersion);
        }
        return headers;
    }

    /**
     * @param url
     * @param apiKey
     * @return
     * @throws IOException
     */
    private static java.net.HttpURLConnection createPingppConnection(
            String url, String apiKey) throws IOException {
        URL pingppURL = null;
        pingppURL = new URL(url);

        HttpsURLConnection conn = (HttpsURLConnection) pingppURL.openConnection();

        conn.setConnectTimeout(30 * 1000);
        conn.setReadTimeout(80 * 1000);
        conn.setUseCaches(false);
        for (Map.Entry<String, String> header : getHeaders(apiKey).entrySet()) {
            conn.setRequestProperty(header.getKey(), header.getValue());
        }

        return conn;
    }

    /**
     * @throws APIConnectionException
     */
    private static void throwInvalidCertificateException() throws APIConnectionException {
        throw new APIConnectionException("Invalid server certificate. You tried to connect to a server that has a revoked SSL certificate, which means we cannot securely send data to that server. ");
    }

    /**
     * @param hconn
     * @throws IOException
     * @throws APIConnectionException
     */
    private static void checkSSLCert(java.net.HttpURLConnection hconn) throws IOException, APIConnectionException {
        if (!Pingpp.getVerifySSL() && !hconn.getURL().getHost().equals("api.pingxx.com")) {
            return;
        }

        javax.net.ssl.HttpsURLConnection conn = (javax.net.ssl.HttpsURLConnection) hconn;
        conn.connect();

        Certificate[] certs = conn.getServerCertificates();

        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1");

            byte[] der = certs[0].getEncoded();
            md.update(der);
            byte[] digest = md.digest();

            byte[] revokedCertDigest = {(byte) 0x05, (byte) 0xc0, (byte) 0xb3, (byte) 0x64, (byte) 0x36, (byte) 0x94, (byte) 0x47, (byte) 0x0a, (byte) 0x88, (byte) 0x8c, (byte) 0x6e, (byte) 0x7f, (byte) 0xeb, (byte) 0x5c, (byte) 0x9e, (byte) 0x24, (byte) 0xe8, (byte) 0x23, (byte) 0xdc, (byte) 0x53};

            if (Arrays.equals(digest, revokedCertDigest)) {
                throwInvalidCertificateException();
            }

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } catch (CertificateEncodingException e) {
            throwInvalidCertificateException();
        }
    }

    /**
     * @param url
     * @param query
     * @return
     */
    private static String formatURL(String url, String query) {
        if (query == null || query.isEmpty()) {
            return url;
        } else {
            // In some cases, URL can already contain a question mark (eg, upcoming invoice lines)
            String separator = url.contains("?") ? "&" : "?";
            return String.format("%s%s%s", url, separator, query);
        }
    }

    /**
     * @param url
     * @param query
     * @param apiKey
     * @return
     * @throws IOException
     * @throws APIConnectionException
     */
    private static java.net.HttpURLConnection createGetConnection(
            String url, String query, String apiKey) throws IOException, APIConnectionException {
        String getURL = formatURL(url, query);
        java.net.HttpURLConnection conn = createPingppConnection(getURL,
                apiKey);
        conn.setRequestMethod("GET");

        checkSSLCert(conn);

        return conn;
    }

    private static java.net.HttpURLConnection createDeleteConnection(
            String url, String query, String apiKey) throws IOException, APIConnectionException {
        String getURL = formatURL(url, query);
        java.net.HttpURLConnection conn = createPingppConnection(getURL,
                apiKey);
        conn.setRequestMethod("DELETE");

        checkSSLCert(conn);

        return conn;
    }

    /**
     * @param url
     * @param query
     * @param apiKey
     * @return
     * @throws IOException
     * @throws APIConnectionException
     */
    private static java.net.HttpURLConnection createPostConnection(
            String url, String query, String apiKey) throws IOException, APIConnectionException {
        java.net.HttpURLConnection conn = createPingppConnection(url,
                apiKey);

        conn.setDoOutput(true);
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", String.format(
                "application/x-www-form-urlencoded;charset=%s", CHARSET));

        checkSSLCert(conn);

        OutputStream output = null;
        try {
            output = conn.getOutputStream();
            output.write(query.getBytes(CHARSET));
        } finally {
            if (output != null) {
                output.close();
            }
        }
        return conn;
    }

    /**
     * @param params
     * @return
     * @throws UnsupportedEncodingException
     * @throws InvalidRequestException
     */
    private static String createQuery(Map<String, Object> params)
            throws UnsupportedEncodingException, InvalidRequestException {
        Map<String, String> flatParams = flattenParams(params);
        StringBuilder queryStringBuffer = new StringBuilder();
        for (Map.Entry<String, String> entry : flatParams.entrySet()) {
            if (queryStringBuffer.length() > 0) {
                queryStringBuffer.append("&");
            }
            queryStringBuffer.append(urlEncodePair(entry.getKey(),
                    entry.getValue()));
        }
        return queryStringBuffer.toString();
    }

    /**
     * @param params
     * @return
     * @throws InvalidRequestException
     */
    private static Map<String, String> flattenParams(Map<String, Object> params)
            throws InvalidRequestException {
        if (params == null) {
            return new HashMap<String, String>();
        }
        Map<String, String> flatParams = new HashMap<String, String>();
        for (Map.Entry<String, Object> entry : params.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (value instanceof Map<?, ?>) {
                Map<String, Object> flatNestedMap = new HashMap<String, Object>();
                Map<?, ?> nestedMap = (Map<?, ?>) value;
                for (Map.Entry<?, ?> nestedEntry : nestedMap.entrySet()) {
                    flatNestedMap.put(
                            String.format("%s[%s]", key, nestedEntry.getKey()),
                            nestedEntry.getValue());
                }
                flatParams.putAll(flattenParams(flatNestedMap));
            } else if (value instanceof ArrayList<?>) {
                ArrayList<?> ar = (ArrayList<?>) value;
                Map<String, Object> flatNestedMap = new HashMap<String, Object>();
                int size = ar.size();
                for (int i = 0; i < size; i++) {
                    flatNestedMap.put(String.format("%s[%d]", key, i), ar.get(i));
                }
                flatParams.putAll(flattenParams(flatNestedMap));
            } else if ("".equals(value)) {
                throw new InvalidRequestException("You cannot set '" + key + "' to an empty string. " +
                        "We interpret empty strings as null in requests. " +
                        "You may set '" + key + "' to null to delete the property.",
                        key, null);
            } else if (value == null) {
                flatParams.put(key, "");
            } else {
                flatParams.put(key, value.toString());
            }
        }
        return flatParams;
    }


    // represents Errors returned as JSON
    private static class ErrorContainer {
        private APIResource.Error error;
    }

    /**
     *
     */
    private static class Error {
        @SuppressWarnings("unused")
        String type;

        String message;

        String code;

        String param;

        @Override
        public String toString() {
            StringBuffer sb = new StringBuffer();
            if (null != type && !type.isEmpty()) {
                sb.append("Error type: " + type + "\n");
            }
            if (null != message && !message.isEmpty()) {
                sb.append("\t Error message: " + message + "\n");
            }
            if (null != code && !code.isEmpty()) {
                sb.append("\t Error code: " + code + "\n");
            }

            return sb.toString();
        }
    }

    /**
     * @param responseStream
     * @return
     * @throws IOException
     */
    private static String getResponseBody(InputStream responseStream)
            throws IOException {
        //\A is the beginning of
        // the stream boundary
        String rBody = new Scanner(responseStream, CHARSET)
                .useDelimiter("\\A")
                .next(); //
        responseStream.close();
        return rBody;
    }

    /**
     * @param method
     * @param url
     * @param query
     * @param apiKey
     * @return
     * @throws APIConnectionException
     */
    private static PingppResponse makeURLConnectionRequest(
            APIResource.RequestMethod method, String url, String query,
            String apiKey) throws APIConnectionException {
        java.net.HttpURLConnection conn = null;
        try {
            switch (method) {
                case GET:
                    conn = createGetConnection(url, query, apiKey);
                    break;
                case POST:
                    conn = createPostConnection(url, query, apiKey);
                    break;
                case DELETE:
                    conn = createDeleteConnection(url, query, apiKey);
                    break;
                default:
                    throw new APIConnectionException(
                            String.format("Unrecognized HTTP method %s. ", method));
            }
            // trigger the request
            int rCode = conn.getResponseCode();
            String rBody = null;
            Map<String, List<String>> headers;

            if (rCode >= 200 && rCode < 300) {
                rBody = getResponseBody(conn.getInputStream());
            } else {
                rBody = getResponseBody(conn.getErrorStream());
            }
            headers = conn.getHeaderFields();
            return new PingppResponse(rCode, rBody, headers);

        } catch (IOException e) {
            throw new APIConnectionException(
                    String.format(
                            "IOException during API request to Pingpp (%s): %s "
                                    + "Please check your internet connection and try again. If this problem persists,"
                                    + "you should check Pingpp's service status at https://pingxx.com,"
                                    + " or let us know at support@pingxx.com.",
                            Pingpp.getApiBase(), e.getMessage()), e);
        } finally {
            if (conn != null) {
                conn.disconnect();
            }
        }
    }

    /**
     * @param method
     * @param url
     * @param params
     * @param clazz
     * @param <T>
     * @return
     * @throws AuthenticationException
     * @throws InvalidRequestException
     * @throws APIConnectionException
     * @throws APIException
     */
    protected static <T> T request(APIResource.RequestMethod method, String url, Map<String, Object> params, Class<T> clazz) throws AuthenticationException,
            InvalidRequestException, APIConnectionException,
            APIException, ChannelException {
        if ((Pingpp.apiKey == null || Pingpp.apiKey.length() == 0)) {
            throw new AuthenticationException(
                    "No API key provided. (HINT: set your API key using 'Pingpp.apiKey = <API-KEY>'. "
                            + "You can generate API keys from the Pingpp web interface. "
                            + "See https://pingxx.com for details.");
        }

        String query;

        try {
            query = createQuery(params);
        } catch (UnsupportedEncodingException e) {
            throw new InvalidRequestException("Unable to encode parameters to " + CHARSET, null, e);
        }

        PingppResponse response;
        try {
            // HTTPSURLConnection verifies SSL cert by default
            response = makeURLConnectionRequest(method, url, query, Pingpp.apiKey);
        } catch (ClassCastException ce) {
            throw ce;
        }
        int rCode = response.getResponseCode();
        String rBody = response.getResponseBody();
        if (rCode < 200 || rCode >= 300) {
            handleAPIError(rBody, rCode);
        }
        return GSON.fromJson(rBody, clazz);
    }

    /**
     * 错误处理
     *
     * @param rBody
     * @param rCode
     * @throws InvalidRequestException
     * @throws AuthenticationException
     * @throws APIException
     */
    private static void handleAPIError(String rBody, int rCode)
            throws InvalidRequestException, AuthenticationException,
            APIException, ChannelException {
        APIResource.Error error = GSON.fromJson(rBody,
                APIResource.ErrorContainer.class).error;
        switch (rCode) {
            case 400:
                throw new InvalidRequestException(error.toString(), error.param, null);
            case 404:
                throw new InvalidRequestException(error.toString(), error.param, null);
            case 402:
                throw new ChannelException(error.toString(), error.param, null);
            case 401:
                throw new AuthenticationException(error.toString());
            default:
                throw new APIException(error.toString(), null);
        }
    }
}
