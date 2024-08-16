package com.pingplusplus.net;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.Map;
import static java.util.Objects.requireNonNull;

public class HttpContent {
    /** The request's content, as a byte array. */
    byte[] byteArrayContent;

    /** The value of the {@code Content-Type} header. */
    String contentType;

    private HttpContent(byte[] byteArrayContent, String contentType) {
        this.byteArrayContent = byteArrayContent;
        this.contentType = contentType;
    }

    /**
     * The request's content, as a string.
     * @return the string content
     */
    public String stringContent() {
        return new String(this.byteArrayContent, APIResource.CHARSET);
    }

    public static HttpContent buildJSONContent(Map<String, Object> params) {
        requireNonNull(params);

        return new HttpContent(
                createJSONString(params).getBytes(APIResource.CHARSET),
                String.format("application/json; charset=%s", APIResource.CHARSET));
    }

    /**
     * @param params the parameters
     * @return JSONString
     */
    private static String createJSONString(Map<String, Object> params) {
        Gson gson = new GsonBuilder().enableComplexMapKeySerialization().create();
        return gson.toJson(params);
    }
}
