package com.pingplusplus.model;

import com.pingplusplus.exception.PingppException;
import com.pingplusplus.net.APIResource;
import com.pingplusplus.net.RequestOptions;

import java.util.Map;

public class AgreementNotify extends APIResource {
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Boolean getSucceed() {
        return succeed;
    }

    public void setSucceed(Boolean succeed) {
        this.succeed = succeed;
    }

    String id;
    Boolean succeed;

    public static AgreementNotify create(String id, Map<String, Object> params) throws PingppException {
        return create(id, params, null);
    }

    /**
     *
     * @param agreementId
     * @param params
     * @param options
     * @return
     * @throws PingppException
     */
    public static AgreementNotify create(String agreementId, Map<String, Object> params, RequestOptions options) throws PingppException {
        return APIResource.request(APIResource.RequestMethod.POST, String.format("%s/notify", instanceURL(Agreement.class, agreementId)), params, AgreementNotify.class, options);
    }
}
