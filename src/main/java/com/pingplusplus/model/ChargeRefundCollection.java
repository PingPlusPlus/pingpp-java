package com.pingplusplus.model;

import com.pingplusplus.Pingpp;
import com.pingplusplus.exception.*;

import java.util.Map;

public class ChargeRefundCollection extends PingppCollectionAPIResource<Refund> {

    public ChargeRefundCollection list(Map<String, Object> params)
            throws AuthenticationException, InvalidRequestException,
            APIConnectionException, APIException, ChannelException, RateLimitException {

        return list(null, params);
    }

    public ChargeRefundCollection list(String apiKey, Map<String, Object> params)
            throws AuthenticationException, InvalidRequestException,
            APIConnectionException, APIException, ChannelException, RateLimitException {

        String url = String.format("%s%s", Pingpp.getApiBase(), this.getURL());
        return request(RequestMethod.GET, url, apiKey, params, ChargeRefundCollection.class);
    }

    public Refund retrieve(String id)
            throws AuthenticationException, InvalidRequestException,
            APIConnectionException, APIException, ChannelException, RateLimitException {

        return retrieve(id, null);
    }

    public Refund retrieve(String id, String apiKey)
            throws AuthenticationException, InvalidRequestException,
            APIConnectionException, APIException, ChannelException, RateLimitException {

        String url = String.format("%s%s/%s", Pingpp.getApiBase(), this.getURL(), id);
        return request(RequestMethod.GET, url, apiKey, null, Refund.class);
    }

    public Refund create(Map<String, Object> params)
            throws AuthenticationException, InvalidRequestException,
            APIConnectionException, APIException, ChannelException, RateLimitException {

        return create(null, params);
    }

    public Refund create(String apiKey, Map<String, Object> params)
            throws AuthenticationException, InvalidRequestException,
            APIConnectionException, APIException, ChannelException, RateLimitException {

        String url = String.format("%s%s", Pingpp.getApiBase(), this.getURL());
        return request(RequestMethod.POST, url, apiKey, params, Refund.class);
    }

}
