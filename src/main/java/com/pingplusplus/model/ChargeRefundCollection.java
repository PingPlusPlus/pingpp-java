package com.pingplusplus.model;

import java.util.Map;

import com.pingplusplus.Pingpp;
import com.pingplusplus.exception.APIConnectionException;
import com.pingplusplus.exception.APIException;
import com.pingplusplus.exception.AuthenticationException;
import com.pingplusplus.exception.InvalidRequestException;

public class ChargeRefundCollection extends PingppColllectionAPIResource<Refund> {
	public ChargeRefundCollection all(Map<String, Object> params)
			throws AuthenticationException, InvalidRequestException,
			APIConnectionException, APIException {
		return all(params, null);
	}

	public ChargeRefundCollection all(Map<String, Object> params,
			String apiKey) throws AuthenticationException,
			InvalidRequestException, APIConnectionException,
			APIException {
		String url = String.format("%s%s", Pingpp.getApiBase(), this.getURL());
		return request(RequestMethod.GET, url, params,
				ChargeRefundCollection.class, apiKey);
	}

	public Refund retrieve(String id)
			throws AuthenticationException, InvalidRequestException,
			APIConnectionException, APIException {
		return retrieve(id, null);
	}

	public Refund retrieve(String id, String apiKey) throws AuthenticationException,
			InvalidRequestException, APIConnectionException,
			APIException {
		String url = String.format("%s%s/%s", Pingpp.getApiBase(), this.getURL(), id);
		return request(RequestMethod.GET, url, null,
				Refund.class, apiKey);
	}

	public Refund create(Map<String, Object> params)
			throws AuthenticationException, InvalidRequestException,
			APIConnectionException, APIException {
		return create(params, null);
	}

	public Refund create(Map<String, Object> params,
			String apiKey) throws AuthenticationException,
			InvalidRequestException, APIConnectionException,
			APIException {
		String url = String.format("%s%s", Pingpp.getApiBase(), this.getURL());
		return request(RequestMethod.POST, url, params,
				Refund.class, apiKey);
	}
}
