package com.pingplusplus.net;

import com.google.gson.*;
import com.pingplusplus.Pingpp;
import com.pingplusplus.exception.*;
import com.pingplusplus.model.*;
import com.pingplusplus.serializer.*;
import com.pingplusplus.util.GsonUtils;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.*;

/**
 * extends the abstract class when you need requset anything from ping++
 */
public abstract class APIResource extends PingppObject {
    /**
     * URLEncoder charset
     */
    public static final Charset CHARSET = StandardCharsets.UTF_8;

    private static HttpClient httpClient = new HttpURLConnectionClient();

    public static final String URIAppIdHolder = "<APP_ID>";

    /**
     * Http requset method
     */
    protected enum RequestMethod {
        GET,
        POST,
        DELETE,
        PUT
    }

    /**
     * Gson object use to transform json string to resource object
     */
    public static final Gson GSON = GsonUtils.baseGsonBuilder()
            .registerTypeAdapter(Charge.class, new ChargeDeserializer())
            .registerTypeAdapter(RedEnvelope.class, new RedEnvelopeDeserializer())
            .registerTypeAdapter(Transfer.class, new TransferDeserializer())
            .registerTypeAdapter(ChargeRefundCollection.class, new ChargeRefundCollectionDeserializer())
            .registerTypeAdapter(EventData.class, new EventDataDeserializer())
            .registerTypeAdapter(PingppRawJsonObject.class, new PingppRawJsonObjectDeserializer())
            .registerTypeAdapter(SubApp.class, new SubAppDeserializer())
            .create();

    public static Gson getGson() {
        return GSON;
    }

    public static Class<?> getSelfClass() {
        return APIResource.class;
    }

    /**
     * @param clazz the class
     * @return className
     */
    protected static String className(Class<?> clazz) {
        String className = clazz.getSimpleName().toLowerCase().replace("$", " ");

        switch (className) {
            case "redenvelope":
                return "red_envelope";
            case "batchrefund":
                return "batch_refund";
            case "batchtransfer":
                return "batch_transfer";
            case "customs":
                return "custom";
            case "cardinfo":
                return "card_info";
            case "assettransaction":
                return "asset_transaction";
            case "balancebonus":
                return "balance_bonuse";
            case "balancetransfer":
                return "balance_transfer";
            case "balancetransaction":
                return "balance_transaction";
            case "coupontemplate":
                return "coupon_template";
            case "batchwithdrawal":
                return "batch_withdrawal";
            case "transactionstatistics":
                return "transaction_statistics";
            case "settleaccount":
                return "settle_account";
            case "subapp":
                return "sub_app";
            case "royalty":
                return "royaltie";
            case "royaltysettlement":
                return "royalty_settlement";
            case "royaltytransaction":
                return "royalty_transaction";
            case "royaltytemplate":
                return "royalty_template";
            case "balancesettlement":
                return "balance_settlement";
            case "subbank":
                return "sub_bank";
            case "splitreceiver":
                return "split_receiver";
            case "splitprofit":
                return "split_profit";
            case "profittransaction":
                return "profit_transaction";
            case "userpic":
                return "users/upload_pic";
            case "contact":
                return "sub_apps/contact";
            default:
                return className;
        }
    }

    /**
     * @param clazz the object class
     * @return singleClassURL
     */
    protected static String singleClassURL(Class<?> clazz) {
        String className = null;
        Class<?> klass = getSelfClass();
        if (!klass.getSimpleName().equalsIgnoreCase("APIResource")) {
            try {
                Method method = klass.getMethod("className", Class.class);
                className = (String)method.invoke(klass, clazz);
            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }

        if (className == null) {
            className = className(clazz);
        }

        return String.format("%s/v1/%s", Pingpp.getApiBase(), className);
    }

    /**
     * @param clazz the object class
     * @return classURL
     */
    protected static String classURL(Class<?> clazz) {
        return String.format("%ss", singleClassURL(clazz));
    }

    /**
     * @param clazz the object class
     * @param id the id of the object
     * @return instanceURL
     */
    protected static String instanceURL(Class<?> clazz, String id){
        return String.format("%s/%s", classURL(clazz), urlEncode(id));
    }

    protected static String apiBasePrefixedURL(String url) {
        return String.format("%s%s", Pingpp.getApiBase(), url);
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
            return URLEncoder.encode(str, CHARSET.name());
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError("UTF-8 is unknown");
        }
    }

    /**
     * @param method the method of request
     * @param url the URL of request
     * @param params the parameters
     * @param clazz the class
     * @param <T> type
     * @param options the specific options
     * @return PingppObject
     * @throws PingppException if some error occurs
     */
    protected static <T> T request(
            APIResource.RequestMethod method,
            String url,
            Map<String, Object> params,
            Class<T> clazz,
            RequestOptions options) throws PingppException {
        PingppRequest request = new PingppRequest(method, url, params, options);
        PingppResponse response = httpClient.requestWithRetries(request);

        int responseCode = response.getResponseCode();
        String responseBody = response.getResponseBody();

        if (responseCode < 200 || responseCode >= 300) {
            handleAPIError(response);
        }

        T resource = null;
        try {
            resource = APIResource.getGson().fromJson(responseBody, clazz);
        } catch (JsonSyntaxException e) {
            raiseMalformedJsonError(responseBody, responseCode);
        }

        if (resource instanceof PingppObject) {
            PingppObject obj = (PingppObject) resource;
            obj.setLastResponse(response);
        }

        return resource;
    }

    /**
     * 错误处理
     *
     * @param response the response
     * @throws PingppException
     */
    private static void handleAPIError(PingppResponse response)
            throws PingppException {
        PingppError error = null;
        String rBody = response.getResponseBody();
        int rCode = response.getResponseCode();
        try {
            JsonObject jsonObject = APIResource.GSON.fromJson(rBody, JsonObject.class).getAsJsonObject("error");
            error = APIResource.GSON.fromJson(jsonObject, PingppError.class);
        } catch (JsonSyntaxException e) {
            raiseMalformedJsonError(rBody, rCode);
        }

        switch (rCode) {
            case 400:
            case 404:
                throw new InvalidRequestException(error.getMessage(), error.getType(), error.getCode(), error.getParam(), rCode, null);
            case 403:
            case 429:
                throw new RateLimitException(error.getMessage(), error.getType(), error.getCode(), rCode, null);
            case 402:
                throw new ChannelException(error.getMessage(), error.getType(), error.getCode(), error.getParam(), rCode, null);
            case 401:
                throw new AuthenticationException(error.getMessage(), error.getType(), error.getCode(), rCode, null);
            case 502:
                throw new APIConnectionException(error.getMessage());
            default:
                throw new APIException(error.getMessage(), error.getType(), error.getCode(), rCode, null);
        }
    }

    private static void raiseMalformedJsonError(
            String responseBody, int responseCode) throws APIException {
        throw new APIException(
                String.format(
                        "Invalid response object from API: %s. (HTTP response code was %d)",
                        responseBody, responseCode),
                null,
                null,
                responseCode,
                null);
    }
}
