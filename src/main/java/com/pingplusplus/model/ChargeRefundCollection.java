package com.pingplusplus.model;

import com.pingplusplus.Pingpp;
import com.pingplusplus.exception.*;

import java.util.Map;

public class ChargeRefundCollection extends PingppCollectionAPIResource<Refund> {

    public ChargeRefundCollection all(Map<String, Object> params)
            throws AuthenticationException, InvalidRequestException,
            APIConnectionException, APIException, ChannelException, RateLimitException {

        String url = String.format("%s%s", Pingpp.getApiBase(), this.getURL());
        return request(RequestMethod.GET, url, params, ChargeRefundCollection.class);
    }

    public Refund retrieve(String id)
            throws AuthenticationException, InvalidRequestException,
            APIConnectionException, APIException, ChannelException, RateLimitException {

        String url = String.format("%s%s/%s", Pingpp.getApiBase(), this.getURL(), id);
        return request(RequestMethod.GET, url, null, Refund.class);
    }

    public Refund create(Map<String, Object> params)
            throws AuthenticationException, InvalidRequestException,
            APIConnectionException, APIException, ChannelException, RateLimitException {

        String url = String.format("%s%s", Pingpp.getApiBase(), this.getURL());
        return request(RequestMethod.POST, url, params, Refund.class);
    }

}
