package com.pingplusplus.model;

/**
 * Created by sunkai on 15/5/11.
 */

import com.pingplusplus.exception.*;
import com.pingplusplus.net.APIResource;

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
    Map extra;
    Map<String, String> metadata;

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

    public Map getExtra() {
        return extra;
    }

    public void setExtra(Map extra) {
        this.extra = extra;
    }

    public Map<String, String> getMetadata() {
        return metadata;
    }

    public void setMetadata(Map<String, String> metadata) {
        this.metadata = metadata;
    }


    /**
     * 创建 Transfer
     * @param params
     * @return
     * @throws AuthenticationException
     * @throws InvalidRequestException
     * @throws APIConnectionException
     * @throws APIException
     * @throws ChannelException
     */
    public static Transfer create(Map<String, Object> params)
            throws AuthenticationException, InvalidRequestException,
            APIConnectionException, APIException, ChannelException, RateLimitException {
        return request(RequestMethod.POST, classURL(Transfer.class), params, Transfer.class);
    }

    /**
     * 查询 Transfer
     * @param id
     * @return
     * @throws AuthenticationException
     * @throws InvalidRequestException
     * @throws APIConnectionException
     * @throws APIException
     * @throws ChannelException
     */
    public static Transfer retrieve(String id) throws AuthenticationException,
            InvalidRequestException, APIConnectionException,
            APIException, ChannelException, RateLimitException {
        return request(RequestMethod.GET, instanceURL(Transfer.class, id), null, Transfer.class);
    }

    /**
     * 查询 Transfer
     * @param id
     * @param params
     * @return
     * @throws AuthenticationException
     * @throws InvalidRequestException
     * @throws APIConnectionException
     * @throws APIException
     * @throws ChannelException
     */
    public static Transfer retrieve(String id, Map<String, Object> params) throws AuthenticationException,
            InvalidRequestException, APIConnectionException,
            APIException, ChannelException, RateLimitException {
        return request(RequestMethod.GET, instanceURL(Transfer.class, id), params, Transfer.class);
    }

    /**
     * 查询 Transfer
     * @param params 分页参数等
     * @return TransferCollection
     * @throws AuthenticationException
     * @throws InvalidRequestException
     * @throws APIConnectionException
     * @throws APIException
     * @throws ChannelException
     */
    public static TransferCollection list(Map<String, Object> params)
            throws AuthenticationException, InvalidRequestException,
            APIConnectionException, APIException, ChannelException, RateLimitException {
        return request(RequestMethod.GET, classURL(Transfer.class), params, TransferCollection.class);
    }

    @Deprecated
    public static TransferCollection all(Map<String, Object> params)
            throws AuthenticationException, InvalidRequestException,
            APIConnectionException, APIException, ChannelException, RateLimitException {
        return list(params);
    }

    /**
     * 更新 Transfer
     * @param id transfer id
     * @param params 更新参数
     * @return Transfer
     * @throws AuthenticationException
     * @throws InvalidRequestException
     * @throws APIConnectionException
     * @throws APIException
     * @throws ChannelException
     */
    public static Transfer update(String id, Map<String, Object> params)
            throws AuthenticationException, InvalidRequestException,
            APIConnectionException, APIException, ChannelException, RateLimitException {
        return request(RequestMethod.PUT, instanceURL(Transfer.class, id), params, Transfer.class);
    }

    /**
     * 撤销/取消 Transfer
     * @param id transfer id
     * @return Transfer
     * @throws AuthenticationException
     * @throws InvalidRequestException
     * @throws APIConnectionException
     * @throws APIException
     * @throws ChannelException
     */
    public static Transfer cancel(String id)
            throws AuthenticationException, InvalidRequestException,
            APIConnectionException, APIException, ChannelException, RateLimitException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("status", "canceled");
        return update(id, params);
    }
}
