package com.pingplusplus;

/**
 * Ping++ Base class
 */
public abstract class Pingpp {
    /**
     * ping++ api url
     */
    public static final String LIVE_API_BASE = "https://api.pingxx.com";
    /**
     * version
     */
    public static final String VERSION = "2.1.1";
    /**
     * api key
     */
    public static volatile String apiKey;
    /**
     * api version
     */
    public static volatile String apiVersion = "2015-10-10";

    public static String AcceptLanguage = "zh-CN";

    private static volatile boolean verifySSL = true;
    private static volatile String apiBase = LIVE_API_BASE;

    public static Boolean DEBUG = false;

    /**
     * (FOR TESTING ONLY)
     * If you'd like your API requests to hit your own (mocked) server,
     * you can set this up here by overriding the base api URL.
     */
    public static void overrideApiBase(final String overriddenApiBase) {
        apiBase = overriddenApiBase;
    }

    /**
     * (FOR TESTING ONLY)
     * Only disable SSL verification if you're using your own (mocked) server.
     * Disabling verification on pingxx.com is not supported
     */
    public static void setVerifySSL(boolean verify) {
        verifySSL = verify;
    }

    /**
     * get SSL state
     *
     * @return true is set SSL ,false is not set SSL
     */
    public static boolean getVerifySSL() {
        return verifySSL;
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
     * @param apiBase
     */
    public static void setApiBase(String apiBase) {
        Pingpp.apiBase = apiBase;
    }
}
