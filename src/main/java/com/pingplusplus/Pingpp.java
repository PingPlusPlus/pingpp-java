package com.pingplusplus;

public abstract class Pingpp
{
	public static final String LIVE_API_BASE = "https://api.pingxx.com/";
	public static final String VERSION = "2.0.1";
	public static volatile String apiKey;
	public static volatile String apiVersion = "2015-01-01";

	private static volatile boolean verifySSL = true;
	private static volatile String apiBase = LIVE_API_BASE;

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

	public static boolean getVerifySSL() {
		return verifySSL;
	}

	public static String getApiBase() {
		return apiBase;
	}

    public static void setApiBase(String apiBase) {
        Pingpp.apiBase = apiBase;
    }
}
