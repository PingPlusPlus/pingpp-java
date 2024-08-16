package com.pingplusplus.model;

import com.pingplusplus.exception.PingppException;
import com.pingplusplus.net.APIResource;
import com.pingplusplus.net.RequestOptions;

import java.util.List;
import java.util.Map;

public class BatchTransfer extends APIResource {
    String id;
    String object;
    String app;
    Long amount;
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

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
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
     * @throws PingppException
     */
    public static BatchTransfer create(Map<String, Object>params)
            throws PingppException {
        return create(params, null);
    }

    /**
     * 创建 batch_transfer
     *
     * @param params
     * @param options the specific options
     * @return BatchTransfer
     * @throws PingppException
     */
    public static BatchTransfer create(Map<String, Object>params, RequestOptions options)
            throws PingppException {
        return APIResource.request(APIResource.RequestMethod.POST, classURL(BatchTransfer.class), params, BatchTransfer.class, options);
    }

    /**
     * 查询 batch_transfer
     *
     * @param id
     * @return BatchTransfer
     * @throws PingppException
     */
    public static BatchTransfer retrieve(String id)
            throws PingppException {
        return retrieve(id, null);
    }

    /**
     * 查询 batch_transfer
     *
     * @param id
     * @param options the specific options
     * @return BatchTransfer
     * @throws PingppException
     */
    public static BatchTransfer retrieve(String id, RequestOptions options)
            throws PingppException {
        return APIResource.request(APIResource.RequestMethod.GET, instanceURL(BatchTransfer.class, id), null, BatchTransfer.class, options);
    }

    /**
     * 查询 batch_transfer 列表
     *
     * @param params
     * @return BatchTransferCollection
     * @throws PingppException
     */
    public static BatchTransferCollection list(Map<String, Object> params)
            throws PingppException {
        return list(params, null);
    }

    /**
     * 查询 batch_transfer 列表
     *
     * @param params
     * @param options the specific options
     * @return BatchTransferCollection
     * @throws PingppException
     */
    public static BatchTransferCollection list(Map<String, Object> params, RequestOptions options)
            throws PingppException {
        return APIResource.request(APIResource.RequestMethod.GET, classURL(BatchTransfer.class), params, BatchTransferCollection.class, options);
    }

    /**
     * 更新 BatchTransfer
     * @param id batch_transfer ID
     * @param params 更新参数
     * @return BatchTransfer
     * @throws PingppException
     */
    public static BatchTransfer update(String id, Map<String, Object> params)
            throws PingppException {
        return update(id, params, null);
    }

    /**
     * 更新 BatchTransfer
     *
     * @param id
     * @param params
     * @param options the specific options
     * @return BatchTransfer
     * @throws PingppException
     */
    public static BatchTransfer update(String id, Map<String, Object> params, RequestOptions options)
            throws PingppException {
        return APIResource.request(APIResource.RequestMethod.PUT, instanceURL(BatchTransfer.class, id), params, BatchTransfer.class, options);
    }
}
