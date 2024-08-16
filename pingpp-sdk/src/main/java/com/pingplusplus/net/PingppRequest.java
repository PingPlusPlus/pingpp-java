package com.pingplusplus.net;

import com.pingplusplus.Pingpp;
import com.pingplusplus.exception.APIConnectionException;
import com.pingplusplus.exception.AuthenticationException;
import com.pingplusplus.exception.InvalidRequestException;
import com.pingplusplus.exception.PingppException;
import com.pingplusplus.util.StringUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class PingppRequest {
    /**
     * The HTTP method for the request (GET, POST, DELETE or PUT).
     * */
    APIResource.RequestMethod method;

    /**
     * The URL for the request.
     */
    URL url;

    /**
     * The body of the request.
     */
    HttpContent content;

    /**
     * The HTTP headers of the request
     */
    HttpHeaders headers;

    /**
     * The parameters of the request.
     */
    Map<String, Object> params;

    /**
     * The options of the request.
     */
    RequestOptions options;

    /**
     * Initializes a new instance of the {@link PingppRequest} class.
     *
     * @param method the HTTP method
     * @param url the URL
     * @param params the parameters
     * @param options the options
     * @throws PingppException if the request cannot be initialized for any reason
     */
    public PingppRequest(
            APIResource.RequestMethod method,
            String url,
            Map<String, Object> params,
            RequestOptions options)
            throws PingppException {
        try {
            this.params = (params != null) ? Collections.unmodifiableMap(params) : null;
            this.options = (options != null) ? options : RequestOptions.getDefault();
            this.method = method;
            this.url = buildURL(method, url, params, this.options);
            this.content = buildContent(method, params);
            this.headers = buildHeaders(method, this.options);
        } catch (IOException e) {
            throw new APIConnectionException(
                    String.format(
                            "IOException during API request to Pingpp (%s): %s "
                                    + "Please check your internet connection and try again.",
                            Pingpp.getApiBase(), e.getMessage()),
                    e);
        }
    }

    private static URL buildURL(
            APIResource.RequestMethod method, String spec, Map<String, Object> params, RequestOptions options)
            throws IOException, InvalidRequestException {
        StringBuilder sb = new StringBuilder();

        if (spec.contains(APIResource.URIAppIdHolder)) {
            if (options.getAppId() == null) {
                throw new InvalidRequestException(
                        "Please set app_id using Pingpp.appId = <APP_ID> or ReqquestOptions",
                        "invalid_request_error",
                        "request_param_error",
                        "app_id",
                        0,
                        null);
            }
            spec = spec.replaceFirst(APIResource.URIAppIdHolder, options.getAppId());
        }
        sb.append(spec);

        if ((method != APIResource.RequestMethod.POST && method != APIResource.RequestMethod.PUT) && (params != null)) {
            String queryString = createQuery(params);
            if (!queryString.isEmpty()) {
                sb.append("?");
                sb.append(queryString);
            }
        }

        return new URL(sb.toString());
    }

    private static HttpContent buildContent(
            APIResource.RequestMethod method, Map<String, Object> params) {
        if (method != APIResource.RequestMethod.POST && method != APIResource.RequestMethod.PUT) {
            return null;
        }

        if (params == null) {
            return null;
        }

        return HttpContent.buildJSONContent(params);
    }

    /**
     * @param params the parameters
     * @return queryString
     */
    private static String createQuery(Map<String, Object> params) {
        if (params == null) {
            return "";
        }

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
     * @param k the key
     * @param v the value
     * @return urlEncodedString
     */
    private static String urlEncodePair(String k, String v) {
        return String.format("%s=%s", urlEncode(k), urlEncode(v));
    }

    /**
     * @param str the string to encode
     * @return urlEncodedString
     */
    protected static String urlEncode(String str) {
        if (str == null) {
            return null;
        }

        try {
            return URLEncoder.encode(str, StandardCharsets.UTF_8.name());
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError("UTF-8 is unknown");
        }
    }

    /**
     * @param params the parameters
     * @return flattenParams
     */
    private static Map<String, String> flattenParams(Map<String, Object> params) {
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
            } else if (value == null) {
                flatParams.put(key, "");
            } else {
                flatParams.put(key, value.toString());
            }
        }
        return flatParams;
    }

    private static HttpHeaders buildHeaders(APIResource.RequestMethod method, RequestOptions options)
            throws AuthenticationException {
        Map<String, List<String>> headerMap = new HashMap<String, List<String>>();

        // Accept
        headerMap.put("Accept", Collections.singletonList("application/json"));

        // Accept-Charset
        headerMap.put("Accept-Charset", Collections.singletonList(APIResource.CHARSET.name()));

        // Accept-Language
        headerMap.put("Accept-Language", Collections.singletonList(options.getAcceptLanguage()));

        // Authorization
        String apiKey = options.getApiKey();
        if (apiKey == null) {
            throw new AuthenticationException(
                    "No API key provided. Set your API key using `Pingpp.apiKey = \"<API-KEY>\"`.");
        } else if (apiKey.isEmpty()) {
            throw new AuthenticationException(
                    "Your API key is invalid, as it is an empty string.");
        } else if (StringUtils.containsWhitespace(apiKey)) {
            throw new AuthenticationException(
                    "Your API key is invalid, as it contains whitespace.");
        }
        headerMap.put("Authorization", Collections.singletonList(String.format("Bearer %s", apiKey)));

        return HttpHeaders.of(headerMap);
    }

    public APIResource.RequestMethod getMethod() {
        return method;
    }

    public URL getUrl() {
        return url;
    }

    public HttpContent getContent() {
        return content;
    }

    public HttpHeaders getHeaders() {
        return headers;
    }

    public Map<String, Object> getParams() {
        return params;
    }

    public RequestOptions getOptions() {
        return options;
    }
}
