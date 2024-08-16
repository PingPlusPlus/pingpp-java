package com.pingplusplus.model;

import com.pingplusplus.exception.PingppException;
import com.pingplusplus.net.APIResource;
import com.pingplusplus.net.RequestOptions;

import java.util.Map;

public class Customs extends APIResource {
    String id;
    String object;
    Long created;
    Object app;
    String channel;
    String tradeNo;
    String customsCode;
    Integer amount;
    String charge;
    Integer transportAmount;
    Boolean isSplit;
    String subOrderNo;
    Map<String, Object> extra;
    Long timeSucceeded;
    String status;
    String failureCode;
    String failureMsg;
    String transactionNo;

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

    public Long getCreated() {
        return created;
    }

    public void setCreated(Long created) {
        this.created = created;
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

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }

    public String getCustomsCode() {
        return customsCode;
    }

    public void setCustomsCode(String customsCode) {
        this.customsCode = customsCode;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getCharge() {
        return charge;
    }

    public void setCharge(String charge) {
        this.charge = charge;
    }

    public Integer getTransportAmount() {
        return transportAmount;
    }

    public void setTransportAmount(Integer transportAmount) {
        this.transportAmount = transportAmount;
    }

    public Boolean getSplit() {
        return isSplit;
    }

    public void setSplit(Boolean split) {
        isSplit = split;
    }

    public String getSubOrderNo() {
        return subOrderNo;
    }

    public void setSubOrderNo(String subOrderNo) {
        this.subOrderNo = subOrderNo;
    }

    public Map<String, Object> getExtra() {
        return extra;
    }

    public void setExtra(Map<String, Object> extra) {
        this.extra = extra;
    }

    public Long getTimeSucceeded() {
        return timeSucceeded;
    }

    public void setTimeSucceeded(Long timeSucceeded) {
        this.timeSucceeded = timeSucceeded;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFailureCode() {
        return failureCode;
    }

    public void setFailureCode(String failureCode) {
        this.failureCode = failureCode;
    }

    public String getFailureMsg() {
        return failureMsg;
    }

    public void setFailureMsg(String failureMsg) {
        this.failureMsg = failureMsg;
    }

    public String getTransactionNo() {
        return transactionNo;
    }

    public void setTransactionNo(String transactionNo) {
        this.transactionNo = transactionNo;
    }

    /**
     * 创建 customs
     *
     * @param params
     * @return Customs
     * @throws PingppException
     */
    public static Customs create(Map<String, Object> params)
            throws PingppException {
        return create(params, null);
    }

    /**
     * 创建 customs
     *
     * @param params
     * @param options the specific options
     * @return Customs
     * @throws PingppException
     */
    public static Customs create(Map<String, Object> params, RequestOptions options)
            throws PingppException {
        return APIResource.request(APIResource.RequestMethod.POST, classURL(Customs.class), params, Customs.class, options);
    }

    /**
     * 查询 customs
     *
     * @param id
     * @return Customs
     * @throws PingppException
     */
    public static Customs retrieve(String id) throws PingppException {
        return retrieve(id, null);
    }

    /**
     * 查询 customs
     *
     * @param id
     * @param options the specific options
     * @return Customs
     * @throws PingppException
     */
    public static Customs retrieve(String id, RequestOptions options) throws PingppException {
        return APIResource.request(APIResource.RequestMethod.GET, instanceURL(Customs.class, id), null, Customs.class, options);
    }

    /**
     * 查询 customs 列表
     *
     * @param params
     * @return CustomsCollection
     * @throws PingppException
     */
    public static CustomsCollection list(Map<String, Object> params)
            throws PingppException {
        return list(params, null);
    }

    /**
     * 查询 customs 列表
     *
     * @param params
     * @param options the specific options
     * @return CustomsCollection
     * @throws PingppException
     */
    public static CustomsCollection list(Map<String, Object> params, RequestOptions options)
            throws PingppException {
        return APIResource.request(APIResource.RequestMethod.GET, classURL(Customs.class), params, CustomsCollection.class, options);
    }
}
