package com.pingplusplus.model;

import com.pingplusplus.exception.*;
import com.pingplusplus.net.APIResource;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BatchTransfer extends APIResource {
    String id;
    String object;
    String app;
    Integer amount;
    String batchNo;
    String channel;
    String currency;
    Long created;
    String description;
    Map<String, Object> extra;
    String failureMsg;
    Integer fee;
    Boolean livemode;
    Map<String, Object> metadata;
    List<BatchTransferRecipient> recipients;
    String status;
    Long timeSucceeded;
    String type;

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

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
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

    public Map<String, Object> getExtra() {
        return extra;
    }

    public void setExtra(Map<String, Object> extra) {
        this.extra = extra;
    }

    public String getFailureMsg() {
        return failureMsg;
    }

    public void setFailureMsg(String failureMsg) {
        this.failureMsg = failureMsg;
    }

    public Integer getFee() {
        return fee;
    }

    public void setFee(Integer fee) {
        this.fee = fee;
    }

    public Boolean getLivemode() {
        return livemode;
    }

    public void setLivemode(Boolean livemode) {
        this.livemode = livemode;
    }

    public Map<String, Object> getMetadata() {
        return metadata;
    }

    public void setMetadata(Map<String, Object> metadata) {
        this.metadata = metadata;
    }

    public List<BatchTransferRecipient> getRecipients() {
        return recipients;
    }

    public void setRecipients(List<BatchTransferRecipient> recipients) {
        this.recipients = recipients;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    /**
     * @param clazz
     * @return String
     */
    protected static String classURL(Class<?> clazz) {
        return apiBasePrefixedURL("/v1/batch_transfers");
    }

    /**
     * 创建 batch_transfer
     *
     * @param params
     * @return BatchTransfer
     * @throws AuthenticationException
     * @throws InvalidRequestException
     * @throws APIConnectionException
     * @throws APIException
     * @throws ChannelException
     * @throws RateLimitException
     */
    public static BatchTransfer create(Map<String, Object>params)
            throws AuthenticationException, InvalidRequestException,
            APIConnectionException, APIException, ChannelException, RateLimitException {
        return create(null, params);
    }

    /**
     * 创建 batch_transfer
     *
     * @param apiKey  Ping++ ApiKey
     * @param params
     * @return BatchTransfer
     * @throws AuthenticationException
     * @throws InvalidRequestException
     * @throws APIConnectionException
     * @throws APIException
     * @throws ChannelException
     * @throws RateLimitException
     */
    public static BatchTransfer create(String apiKey, Map<String, Object>params)
            throws AuthenticationException, InvalidRequestException,
            APIConnectionException, APIException, ChannelException, RateLimitException {
        return request(RequestMethod.POST, classURL(BatchTransfer.class), apiKey, params, BatchTransfer.class);
    }

    /**
     * 查询 batch_transfer
     *
     * @param id
     * @return BatchTransfer
     * @throws AuthenticationException
     * @throws InvalidRequestException
     * @throws APIConnectionException
     * @throws APIException
     * @throws ChannelException
     * @throws RateLimitException
     */
    public static BatchTransfer retrieve(String id)
            throws AuthenticationException, InvalidRequestException,
            APIConnectionException, APIException, ChannelException, RateLimitException {
        return retrieve(id, null);
    }

    /**
     * 查询 batch_transfer
     *
     * @param id
     * @param apiKey  Ping++ ApiKey
     * @return BatchTransfer
     * @throws AuthenticationException
     * @throws InvalidRequestException
     * @throws APIConnectionException
     * @throws APIException
     * @throws ChannelException
     * @throws RateLimitException
     */
    public static BatchTransfer retrieve(String id, String apiKey)
            throws AuthenticationException, InvalidRequestException,
            APIConnectionException, APIException, ChannelException, RateLimitException {
        return request(RequestMethod.GET, instanceURL(BatchTransfer.class, id), apiKey, null, BatchTransfer.class);
    }

    /**
     * 查询 batch_transfer 列表
     *
     * @param params
     * @return BatchTransferCollection
     * @throws AuthenticationException
     * @throws InvalidRequestException
     * @throws APIConnectionException
     * @throws APIException
     * @throws ChannelException
     * @throws RateLimitException
     */
    public static BatchTransferCollection list(Map<String, Object> params)
            throws AuthenticationException, InvalidRequestException,
            APIConnectionException, APIException, ChannelException, RateLimitException {
        return list(null, params);
    }

    /**
     * 查询 batch_transfer 列表
     *
     * @param apiKey  Ping++ ApiKey
     * @param params
     * @return BatchTransferCollection
     * @throws AuthenticationException
     * @throws InvalidRequestException
     * @throws APIConnectionException
     * @throws APIException
     * @throws ChannelException
     * @throws RateLimitException
     */
    public static BatchTransferCollection list(String apiKey, Map<String, Object> params)
            throws AuthenticationException, InvalidRequestException,
            APIConnectionException, APIException, ChannelException, RateLimitException {
        return request(RequestMethod.GET, classURL(BatchTransfer.class), apiKey, params, BatchTransferCollection.class);
    }

    /**
     * 更新 BatchTransfer
     * @param id batch_transfer ID
     * @param params 更新参数
     * @return BatchTransfer
     * @throws AuthenticationException
     * @throws InvalidRequestException
     * @throws APIConnectionException
     * @throws APIException
     * @throws ChannelException
     */
    public static BatchTransfer update(String id, Map<String, Object> params)
            throws AuthenticationException, InvalidRequestException,
            APIConnectionException, APIException, ChannelException, RateLimitException {
        return update(id, null, params);
    }

    /**
     * 更新 BatchTransfer
     *
     * @param id
     * @param apiKey  Ping++ ApiKey
     * @param params
     * @return BatchTransfer
     * @throws AuthenticationException
     * @throws InvalidRequestException
     * @throws APIConnectionException
     * @throws APIException
     * @throws ChannelException
     * @throws RateLimitException
     */
    public static BatchTransfer update(String id, String apiKey, Map<String, Object> params)
            throws AuthenticationException, InvalidRequestException,
            APIConnectionException, APIException, ChannelException, RateLimitException {
        return request(RequestMethod.PUT, instanceURL(BatchTransfer.class, id), apiKey, params, BatchTransfer.class);
    }
}
