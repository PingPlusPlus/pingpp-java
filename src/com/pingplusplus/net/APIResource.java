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
import com.pingplusplus.model.*;
import org.apache.commons.codec.binary.Base64;
import sun.security.util.DerInputStream;
import sun.security.util.DerValue;

import java.io.*;
import java.math.BigInteger;
import java.net.URL;
import java.net.URLEncoder;
import java.security.*;
import java.security.spec.*;
import java.util.ArrayList;
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
        GET, POST, DELETE, PUT
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
            .registerTypeAdapter(EventData.class, new EventDataDeserializer())
            .registerTypeAdapter(PingppRawJsonObject.class, new PingppRawJsonObjectDeserializer())
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

        return conn;
    }

    private static java.net.HttpURLConnection createDeleteConnection(
            String url, String query, String apiKey) throws IOException, APIConnectionException {
        String getURL = formatURL(url, query);
        java.net.HttpURLConnection conn = createPingppConnection(getURL,
                apiKey);
        conn.setRequestMethod("DELETE");

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
                "application/json;charset=%s", CHARSET));
        String signature = generateSign(query);
        if (signature != null) {
            conn.setRequestProperty("Pingplusplus-Signature", signature);
        }

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
     * @param url
     * @param query
     * @param apiKey
     * @return
     * @throws IOException
     * @throws APIConnectionException
     */
    private static java.net.HttpURLConnection createPutConnection(
            String url, String query, String apiKey) throws IOException, APIConnectionException {
        java.net.HttpURLConnection conn = createPingppConnection(url,
                apiKey);

        conn.setDoOutput(true);
        conn.setRequestMethod("PUT");
        conn.setRequestProperty("Content-Type", String.format(
                "application/json;charset=%s", CHARSET));
        String signature = generateSign(query);
        if (signature != null) {
            conn.setRequestProperty("Pingplusplus-Signature", signature);
        }

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
     */
    private static String createJSONString(Map<String, Object> params) {
        Gson gson = new GsonBuilder().enableComplexMapKeySerialization().create();
        return gson.toJson(params);
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
                case PUT:
                    conn = createPutConnection(url, query, apiKey);
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

        String query = null;

        switch (method) {
            case GET:
            case DELETE:
                try {
                    query = createQuery(params);
                } catch (UnsupportedEncodingException e) {
                    throw new InvalidRequestException("Unable to encode parameters to " + CHARSET, null, e);
                }
                break;
            case POST:
            case PUT:
                query = createJSONString(params);
                break;
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

    /**
     * 生成请求签名
     *
     * @param data
     */

    private static String generateSign(String data)
            throws IOException {
        if (Pingpp.privateKey == null) {
            if (Pingpp.privateKeyPath == null) {
                return null;
            }
            FileInputStream inputStream = new FileInputStream(Pingpp.privateKeyPath);
            byte[] keyBytes = new byte[inputStream.available()];
            inputStream.read(keyBytes);
            inputStream.close();
            String keyString = new String(keyBytes, CHARSET);
            Pingpp.privateKey = keyString.replaceAll("(-+BEGIN (RSA )?PRIVATE KEY-+\\r?\\n|-+END (RSA )?PRIVATE KEY-+\\r?\\n?)", "");
        }

        byte[] privateKeyBytes = Base64.decodeBase64(Pingpp.privateKey);

        DerInputStream derReader = new DerInputStream(privateKeyBytes);
        DerValue[] seq = derReader.getSequence(0);

        if (seq.length < 9) {
            System.out.println("Could not parse a PKCS1 private key.");
            return null;
        }

        // skip version seq[0];
        BigInteger modulus = seq[1].getBigInteger();
        BigInteger publicExp = seq[2].getBigInteger();
        BigInteger privateExp = seq[3].getBigInteger();
        BigInteger prime1 = seq[4].getBigInteger();
        BigInteger prime2 = seq[5].getBigInteger();
        BigInteger exp1 = seq[6].getBigInteger();
        BigInteger exp2 = seq[7].getBigInteger();
        BigInteger crtCoef = seq[8].getBigInteger();
        RSAPrivateCrtKeySpec spec = new RSAPrivateCrtKeySpec(modulus, publicExp, privateExp, prime1, prime2, exp1, exp2, crtCoef);

        try {
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            PrivateKey privateKey = keyFactory.generatePrivate(spec);

            Signature signature = Signature.getInstance("SHA256withRSA");
            signature.initSign(privateKey);
            signature.update(data.getBytes(CHARSET));
            byte[] signBytes = signature.sign();

            return Base64.encodeBase64String(signBytes).replaceAll("\n|\r", "");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (SignatureException e) {
            e.printStackTrace();
        }

        return null;
    }
}
