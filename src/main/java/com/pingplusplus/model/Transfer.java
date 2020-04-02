package com.pingplusplus.model;

/**
 * Created by sunkai on 15/5/11.
 */

import com.pingplusplus.exception.PingppException;
import com.pingplusplus.net.APIResource;
import com.pingplusplus.net.RequestOptions;

import java.util.HashMap;
import java.util.Map;

/**
 * 微信企业付款
 */
public class Transfer extends APIResource {
    String id;
    String object;
    String type;
    Long created;
    Long timeTransferred;
    Boolean livemode;
    String status;
    Object app;
    String channel;
    String orderNo;
    Integer amount;
    Integer amountSettle;
    String currency;
    String recipient;
    String description;
    String failureMsg;
    String transaction_no;
    Map<String, Object> extra;
    Map<String, Object> metadata;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getCreated() {
        return created;
    }

    public void setCreated(Long created) {
        this.created = created;
    }

    public Boolean getLivemode() {
        return livemode;
    }

    public void setLivemode(Boolean livemode) {
        this.livemode = livemode;
    }

    public Long getTimeTransferred() {
        return timeTransferred;
    }

    public void setTimeTransferred(Long timeTransferred) {
        this.timeTransferred = timeTransferred;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getApp() {
        return app;
    }

    public void setApp(Object app) {
        this.app = app;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Integer getAmountSettle() {
        return amountSettle;
    }

    public void setAmountSettle(Integer amountSettle) {
        this.amountSettle = amountSettle;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getFailureMsg() {
        return failureMsg;
    }

    public void setFailureMsg(String failureMsg) {
        this.failureMsg = failureMsg;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTransaction_no() {
        return transaction_no;
    }

    public void setTransaction_no(String transaction_no) {
        this.transaction_no = transaction_no;
    }

    public Map<String, Object> getExtra() {
        return extra;
    }

    public void setExtra(Map<String, Object> extra) {
        this.extra = extra;
    }

    public Map<String, Object> getMetadata() {
        return metadata;
    }

    public void setMetadata(Map<String, Object> metadata) {
        this.metadata = metadata;
    }


    /**
     * 创建 Transfer
     * @param params
     * @return Transfer
     * @throws PingppException
     */
    public static Transfer create(Map<String, Object> params)
            throws PingppException {
        return create(params, null);
    }

    /**
     * 创建 Transfer
     *
     * @param params
     * @param options the specific options
     * @return Transfer
     * @throws PingppException
     */
    public static Transfer create(Map<String, Object> params, RequestOptions options)
            throws PingppException {
        return APIResource.request(APIResource.RequestMethod.POST, classURL(Transfer.class), params, Transfer.class, options);
    }

    /**
     * 查询 Transfer
     * @param id
     * @return Transfer
     * @throws PingppException
     */
    public static Transfer retrieve(String id) throws PingppException {
        return retrieve(id, null, null);
    }

    /**
     * 查询 Transfer
     *
     * @param id
     * @param options the specific options
     * @return Transfer
     * @throws PingppException
     */
    public static Transfer retrieve(String id, RequestOptions options) throws PingppException {
        return retrieve(id, null, options);
    }

    /**
     * 查询 Transfer
     * @param id
     * @param params
     * @return Transfer
     * @throws PingppException
     */
    public static Transfer retrieve(String id, Map<String, Object> params) throws PingppException {
        return retrieve(id, params, null);
    }

    /**
     * 查询 Transfer
     *
     * @param id
     * @param params
     * @param options the specific options
     * @return Transfer
     * @throws PingppException
     */
    public static Transfer retrieve(String id, Map<String, Object> params, RequestOptions options) throws PingppException {
        return APIResource.request(APIResource.RequestMethod.GET, instanceURL(Transfer.class, id), params, Transfer.class, options);
    }

    /**
     * 查询 Transfer
     * @param params 分页参数等
     * @return TransferCollection
     * @throws PingppException
     */
    public static TransferCollection list(Map<String, Object> params)
            throws PingppException {
        return list(params, null);
    }

    /**
     * 查询 Transfer
     *
     * @param params 分页参数等
     * @param options the specific options
     * @return TransferCollection
     * @throws PingppException
     */
    public static TransferCollection list(Map<String, Object> params, RequestOptions options)
            throws PingppException {
        return APIResource.request(APIResource.RequestMethod.GET, classURL(Transfer.class), params, TransferCollection.class, options);
    }
}
