package com.pingplusplus.model;

import com.pingplusplus.exception.PingppException;
import com.pingplusplus.net.APIResource;
import com.pingplusplus.net.RequestOptions;

import java.util.Map;

public class Refund extends APIResource {
    String id;
    String object;
    String orderNo;
    Integer amount;
    String currency;
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

    public String getInstanceURL() {
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

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
    /**
     * 创建 refund
     *
     * @param chargeId
     * @param params
     * @return Refund
     * @throws PingppException
     */
    public static Refund create(String chargeId, Map<String, Object> params)
            throws PingppException {
        return create(chargeId, params, null);
    }

    /**
     * 创建 refund
     *
     * @param chargeId
     * @param params
     * @param options the specific options
     * @return Refund
     * @throws PingppException
     */
    public static Refund create(String chargeId, Map<String, Object> params, RequestOptions options)
            throws PingppException {
        return APIResource.request(APIResource.RequestMethod.POST, String.format("%s/refunds", instanceURL(Charge.class, chargeId)),
                params, Refund.class, options);
    }

    /**
     * 查询 refund
     *
     * @param chargeId
     * @param id
     * @return Refund
     * @throws PingppException
     */
    public static Refund retrieve(String chargeId, String id)
            throws PingppException {
        return retrieve(chargeId, id, null);
    }

    /**
     * 查询 refund
     *
     * @param chargeId
     * @param id
     * @param options the specific options
     * @return Refund
     * @throws PingppException
     */
    public static Refund retrieve(String chargeId, String id, RequestOptions options)
            throws PingppException {
        return APIResource.request(APIResource.RequestMethod.GET, String.format("%s/refunds/%s", instanceURL(Charge.class, chargeId), id),null, Refund.class, options);
    }

    /**
     * 查询 refund 列表
     *
     * @param chargeId
     * @param params
     * @return ChargeRefundCollection
     * @throws PingppException
     */
    public static ChargeRefundCollection list(String chargeId, Map<String, Object>params)
            throws PingppException {
        return list(chargeId, params, null);
    }

    /**
     * 查询 refund 列表
     *
     * @param chargeId
     * @param params
     * @param options the specific options
     * @return ChargeRefundCollection
     * @throws PingppException
     */
    public static ChargeRefundCollection list(String chargeId, Map<String, Object>params, RequestOptions options)
            throws PingppException {
        return request(RequestMethod.GET, String.format("%s/refunds", instanceURL(Charge.class, chargeId)),
                params, ChargeRefundCollection.class, options);
    }
}
