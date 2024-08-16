package com.pingplusplus.model;

import com.pingplusplus.Pingpp;
import com.pingplusplus.exception.PingppException;
import com.pingplusplus.net.APIResource;
import com.pingplusplus.net.RequestOptions;

import java.util.Map;

public class ChargeRefundCollection extends PingppCollectionAPIResource<Refund> {

    public ChargeRefundCollection list(Map<String, Object> params)
            throws PingppException {

        return list(params, null);
    }

    public ChargeRefundCollection list(Map<String, Object> params, RequestOptions options)
            throws PingppException {

        String url = String.format("%s%s", Pingpp.getApiBase(), this.getURL());
        return APIResource.request(APIResource.RequestMethod.GET, url, params, ChargeRefundCollection.class, options);
    }

    public Refund retrieve(String id)
            throws PingppException {

        return retrieve(id, null);
    }

    public Refund retrieve(String id, RequestOptions options)
            throws PingppException {

        String url = String.format("%s%s/%s", Pingpp.getApiBase(), this.getURL(), id);
        return APIResource.request(APIResource.RequestMethod.GET, url, null, Refund.class, options);
    }

    public Refund create(Map<String, Object> params)
            throws PingppException {

        return create(params, null);
    }

    public Refund create(Map<String, Object> params, RequestOptions options)
            throws PingppException {

        String url = String.format("%s%s", Pingpp.getApiBase(), this.getURL());
        return APIResource.request(APIResource.RequestMethod.POST, url, params, Refund.class, options);
    }

}
