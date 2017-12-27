package com.pingplusplus.model;

import com.pingplusplus.exception.*;
import com.pingplusplus.net.APIResource;

import java.util.List;
import java.util.Map;

public class BatchRefund extends APIResource {
    String id;
    String object;
    String app;
    String batchNo;
    Long created;
    String description;
    Boolean livemode;
    Map<String, Object> metadata;
    List<BatchRefundCharges> charges;
    ChargeRefundCollection refunds;
    String refundUrl;
    String status;
    Long timeSucceeded;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public String getApp() {
        return app;
    }

    public void setApp(String app) {
        this.app = app;
    }

    public String getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo;
    }

    public Long getCreated() {
        return created;
    }

    public void setCreated(Long created) {
        this.created = created;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Map<String, Object> getMetadata() {
        return metadata;
    }

    public Boolean getLivemode() {
        return livemode;
    }

    public void setLivemode(Boolean livemode) {
        this.livemode = livemode;
    }

    public void setMetadata(Map<String, Object> metadata) {
        this.metadata = metadata;
    }

    public List<BatchRefundCharges> getCharges() {
        return charges;
    }

    public void setCharges(List<BatchRefundCharges> charges) {
        this.charges = charges;
    }

    public ChargeRefundCollection getRefunds() {
        return refunds;
    }

    public void setRefunds(ChargeRefundCollection refunds) {
        this.refunds = refunds;
    }

    public String getRefundUrl() {
        return refundUrl;
    }

    public void setRefundUrl(String refundUrl) {
        this.refundUrl = refundUrl;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getTimeSucceeded() {
        return timeSucceeded;
    }

    public void setTimeSucceeded(Long timeSucceeded) {
        this.timeSucceeded = timeSucceeded;
    }

    /**
     * @param clazz
     * @return String
     */
    protected static String classURL(Class<?> clazz) {
        return apiBasePrefixedURL("/v1/batch_refunds");
    }

    /**
     * 创建 batch_refund
     *
     * @param params
     * @return BatchRefund
     * @throws AuthenticationException
     * @throws InvalidRequestException
     * @throws APIConnectionException
     * @throws APIException
     * @throws ChannelException
     * @throws RateLimitException
     */
    public static BatchRefund create(Map<String, Object>params)
            throws AuthenticationException, InvalidRequestException,
            APIConnectionException, APIException, ChannelException, RateLimitException {
        return create(null, params);
    }

    /**
     * 创建 batch_refund
     *
     * @param apiKey  Ping++ ApiKey
     * @param params
     * @return BatchRefund
     * @throws AuthenticationException
     * @throws InvalidRequestException
     * @throws APIConnectionException
     * @throws APIException
     * @throws ChannelException
     * @throws RateLimitException
     */
    public static BatchRefund create(String apiKey, Map<String, Object>params)
            throws AuthenticationException, InvalidRequestException,
            APIConnectionException, APIException, ChannelException, RateLimitException {
        return request(RequestMethod.POST, classURL(BatchRefund.class), apiKey, params, BatchRefund.class);
    }

    /**
     * 查询 batch_refund
     *
     * @param id
     * @return BatchRefund
     * @throws AuthenticationException
     * @throws InvalidRequestException
     * @throws APIConnectionException
     * @throws APIException
     * @throws ChannelException
     * @throws RateLimitException
     */
    public static BatchRefund retrieve(String id)
            throws AuthenticationException, InvalidRequestException,
            APIConnectionException, APIException, ChannelException, RateLimitException {
        return retrieve(id, null);
    }

    /**
     * 查询 batch_refund
     *
     * @param id
     * @param apiKey  Ping++ ApiKey
     * @return BatchRefund
     * @throws AuthenticationException
     * @throws InvalidRequestException
     * @throws APIConnectionException
     * @throws APIException
     * @throws ChannelException
     * @throws RateLimitException
     */
    public static BatchRefund retrieve(String id, String apiKey)
            throws AuthenticationException, InvalidRequestException,
            APIConnectionException, APIException, ChannelException, RateLimitException {
        return request(RequestMethod.GET, instanceURL(BatchRefund.class, id), apiKey, null, BatchRefund.class);
    }

    /**
     * 查询 batch_refund 列表
     *
     * @param params
     * @return BatchRefundCollection
     * @throws AuthenticationException
     * @throws InvalidRequestException
     * @throws APIConnectionException
     * @throws APIException
     * @throws ChannelException
     * @throws RateLimitException
     */
    public static BatchRefundCollection list(Map<String, Object> params)
            throws AuthenticationException, InvalidRequestException,
            APIConnectionException, APIException, ChannelException, RateLimitException {
        return list(null, params);
    }

    /**
     * 查询 batch_refund 列表
     *
     * @param apiKey  Ping++ ApiKey
     * @param params
     * @return BatchRefundCollection
     * @throws AuthenticationException
     * @throws InvalidRequestException
     * @throws APIConnectionException
     * @throws APIException
     * @throws ChannelException
     * @throws RateLimitException
     */
    public static BatchRefundCollection list(String apiKey, Map<String, Object> params)
            throws AuthenticationException, InvalidRequestException,
            APIConnectionException, APIException, ChannelException, RateLimitException {
        return request(RequestMethod.GET, classURL(BatchRefund.class), apiKey, params, BatchRefundCollection.class);
    }
}
