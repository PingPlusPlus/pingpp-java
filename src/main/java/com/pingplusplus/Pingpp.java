package com.pingplusplus;

/**
 * Ping++ Base class
 */
public abstract class Pingpp {
    /**
     * Ping++ API BASE URL
     */
    public static final String LIVE_API_BASE = "https://api.pingxx.com";
    /**
     * version
     */
    public static final String VERSION = "2.4.1";
    /**
     * api key
     */
    public static volatile String apiKey;

    public static volatile String appId;

    public static String acceptLanguage = "zh-CN";

    private static volatile String apiBase = LIVE_API_BASE;

    public static volatile String privateKey;
    public static volatile String privateKeyPath;

    public static Boolean DEBUG = false;

    public static final int DEFAULT_CONNECT_TIMEOUT = 30 * 1000;
    public static final int DEFAULT_READ_TIMEOUT = 80 * 1000;

    private static volatile int connectTimeout = -1;
    private static volatile int readTimeout = -1;

    private static volatile int maxNetworkRetries = 1;

    /**
     * (FOR TESTING ONLY)
     * If you'd like your API requests to hit your own (mocked) server,
     * you can set this up here by overriding the base api URL.
     * @param overriddenApiBase API 地址
     */
    public static void overrideApiBase(final String overriddenApiBase) {
        apiBase = overriddenApiBase;
    }

    /**
     * get api url
     *
     * @return String  api url
     */
    public static String getApiBase() {
        return apiBase;
    }

    /**
     * set api url
     *
     * @param apiBase apiBase API 地址
     */
    public static void setApiBase(String apiBase) {
        Pingpp.apiBase = apiBase;
    }

    /**
     * 网络连接超时时间
     *
     * @return timeout value in milliseconds
     */
    public static int getConnectTimeout() {
        if (connectTimeout == -1) {
            return DEFAULT_CONNECT_TIMEOUT;
        }
        return connectTimeout;
    }

    /**
     * 设置网络连接超时时间 (毫秒)
     *
     * @param timeout timeout value in milliseconds
     */
    public static void setConnectTimeout(final int timeout) {
        connectTimeout = timeout;
    }

    /**
     * 数据读取超时时间
     *
     * @return timeout value in milliseconds
     */
    public static int getReadTimeout() {
        if (readTimeout == -1) {
            return DEFAULT_READ_TIMEOUT;
        }
        return readTimeout;
    }

    /**
     * 设置数据读取超时时间 (毫秒)
     *
     * 不同接口的耗时时间不一样，部分接口的耗时可能比较长。
     *
     * @param timeout timeout value in milliseconds
     */
    public static void setReadTimeout(final int timeout) {
        readTimeout = timeout;
    }

    /**
     * 连接失败时的最大重试次数
     *
     * @return the maximum number of times requests will be retried
     */
    public static int getMaxNetworkRetries() {
        return maxNetworkRetries;
    }

    /**
     * 设置连接失败时的最大重试次数
     *
     * @param numRetries the maximum number of times requests will be retried
     */
    public static void setMaxNetworkRetries(final int numRetries) {
        maxNetworkRetries = numRetries;
    }

    public static String getAcceptLanguage() {
        return acceptLanguage;
    }

    public static void setAcceptLanguage(String acceptLanguage) {
        Pingpp.acceptLanguage = acceptLanguage;
    }
}
