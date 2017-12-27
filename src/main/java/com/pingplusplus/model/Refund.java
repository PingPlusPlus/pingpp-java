package com.pingplusplus.model;

import com.pingplusplus.exception.*;
import com.pingplusplus.net.APIResource;

import java.util.Map;

public class Refund extends APIResource {
    String id;
    String object;
    String orderNo;
    Integer amount;
    Long created;
    Boolean succeed;
    String status;
    Long timeSucceed;
    String description;
    String failureCode;
    String failureMsg;
    Map<String, Object> metadata;
    String charge;
    String chargeOrderNo;
    String transactionNo;
    String fundingSource;
    Map<String, Object> extra;

    public String getInstanceURL() throws InvalidRequestException {
        if (this.charge != null) {
            return String.format("%s/%s/refunds/%s", classURL(Charge.class), this.charge, this.getId());
        }
        return null;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getId() {
        return id;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Long getCreated() {
        return created;
    }

    public void setCreated(Long created) {
        this.created = created;
    }

    public String getCharge() {
        return charge;
    }

    public void setCharge(String charge) {
        this.charge = charge;
    }

    public Boolean getSucceed() {
        return succeed;
    }

    public void setSucceed(Boolean succeed) {
        this.succeed = succeed;
    }

    public Long getTimeSucceed() {
        return timeSucceed;
    }

    public void setTimeSucceed(Long timeSucceed) {
        this.timeSucceed = timeSucceed;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFailureMsg() {
        return failureMsg;
    }

    public void setFailureMsg(String failureMsg) {
        this.failureMsg = failureMsg;
    }

    public String getFailureCode() {
        return failureCode;
    }

    public void setFailureCode(String failureCode) {
        this.failureCode = failureCode;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public Map<String, Object> getMetadata() {
        return metadata;
    }

    public void setMetadata(Map<String, Object> metadata) {
        this.metadata = metadata;
    }

    public String getChargeOrderNo() {
        return chargeOrderNo;
    }

    public void setChargeOrderNo(String chargeOrderNo) {
        this.chargeOrderNo = chargeOrderNo;
    }

    public String getTransactionNo() {
        return transactionNo;
    }

    public void setTransactionNo(String transactionNo) {
        this.transactionNo = transactionNo;
    }

    public String getFundingSource() {
        return fundingSource;
    }

    public void setFundingSource(String fundingSource) {
        this.fundingSource = fundingSource;
    }

    public Map<String, Object> getExtra() {
        return extra;
    }

    public void setExtra(Map<String, Object> extra) {
        this.extra = extra;
    }

    /**
     * 创建 refund
     *
     * @param charge
     * @param params
     * @return Refund
     * @throws AuthenticationException
     * @throws InvalidRequestException
     * @throws APIConnectionException
     * @throws APIException
     * @throws ChannelException
     * @throws RateLimitException
     */
    public static Refund create(String charge, Map<String, Object> params)
            throws AuthenticationException, InvalidRequestException, APIConnectionException,
            APIException, ChannelException, RateLimitException {
        return create(charge, null, params);
    }

    /**
     * 创建 refund
     *
     * @param charge
     * @param apiKey  Ping++ ApiKey
     * @param params
     * @return Refund
     * @throws AuthenticationException
     * @throws InvalidRequestException
     * @throws APIConnectionException
     * @throws APIException
     * @throws ChannelException
     * @throws RateLimitException
     */
    public static Refund create(String charge, String apiKey, Map<String, Object> params)
            throws AuthenticationException, InvalidRequestException, APIConnectionException,
            APIException, ChannelException, RateLimitException {
        return request(RequestMethod.POST, String.format("%s/refunds", instanceURL(Charge.class, charge)),
                apiKey, params, Refund.class);
    }

    /**
     * 查询 refund
     *
     * @param charge
     * @param id
     * @return Refund
     * @throws AuthenticationException
     * @throws InvalidRequestException
     * @throws APIConnectionException
     * @throws APIException
     * @throws ChannelException
     * @throws RateLimitException
     */
    public static Refund retrieve(String charge, String id)
            throws AuthenticationException, InvalidRequestException, APIConnectionException,
            APIException, ChannelException, RateLimitException {
        return retrieve(charge, id, null);
    }

    /**
     * 查询 refund
     *
     * @param charge
     * @param id
     * @param apiKey  Ping++ ApiKey
     * @return Refund
     * @throws AuthenticationException
     * @throws InvalidRequestException
     * @throws APIConnectionException
     * @throws APIException
     * @throws ChannelException
     * @throws RateLimitException
     */
    public static Refund retrieve(String charge, String id, String apiKey)
            throws AuthenticationException, InvalidRequestException, APIConnectionException,
            APIException, ChannelException, RateLimitException {
        return request(RequestMethod.GET, String.format("%s/refunds/%s", instanceURL(Charge.class, charge), id),
                apiKey, null, Refund.class);
    }

    /**
     * 查询 refund 列表
     *
     * @param charge
     * @param params
     * @return ChargeRefundCollection
     * @throws AuthenticationException
     * @throws InvalidRequestException
     * @throws APIConnectionException
     * @throws APIException
     * @throws ChannelException
     * @throws RateLimitException
     */
    public static ChargeRefundCollection list(String charge, Map<String, Object>params)
            throws AuthenticationException, InvalidRequestException, APIConnectionException,
            APIException, ChannelException, RateLimitException {
        return list(charge, null, params);
    }

    /**
     * 查询 refund 列表
     *
     * @param charge
     * @param apiKey  Ping++ ApiKey
     * @param params
     * @return ChargeRefundCollection
     * @throws AuthenticationException
     * @throws InvalidRequestException
     * @throws APIConnectionException
     * @throws APIException
     * @throws ChannelException
     * @throws RateLimitException
     */
    public static ChargeRefundCollection list(String charge, String apiKey, Map<String, Object>params)
            throws AuthenticationException, InvalidRequestException, APIConnectionException,
            APIException, ChannelException, RateLimitException {
        return request(RequestMethod.GET, String.format("%s/refunds", instanceURL(Charge.class, charge)),
                apiKey, params, ChargeRefundCollection.class);
    }
}
