package com.pingplusplus.net;

import java.util.List;
import java.util.Map;

public class PingppResponse {
	
	int responseCode;
	String responseBody;
        Map<String, List<String>> responseHeaders;
	
	public PingppResponse(int responseCode, String responseBody) {
		this.responseCode = responseCode;
		this.responseBody = responseBody;
                this.responseHeaders = null;
	}
        public PingppResponse(int responseCode, String responseBody, Map<String, List<String>> responseHeaders) {
		this.responseCode = responseCode;
		this.responseBody = responseBody;
                this.responseHeaders = responseHeaders;
	}

	public int getResponseCode() {
		return responseCode;
	}
	
	public void setResponseCode(int responseCode) {
		this.responseCode = responseCode;
	}
	
	public String getResponseBody() {
		return responseBody;
	}
	
	public void setResponseBody(String responseBody) {
		this.responseBody = responseBody;
	}
        public Map<String, List<String>> getResponseHeaders() {
		return responseHeaders;
	}
}
