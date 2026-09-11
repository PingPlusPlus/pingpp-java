package com.pingplusplus.model;

import com.pingplusplus.exception.PingppException;
import com.pingplusplus.net.APIResource;
import com.pingplusplus.net.RequestOptions;

/**
 * Charge 的渠道交易明细。
 */
public class TradeDetail extends APIResource {
    String id;
    String app;
    String object;
    Boolean livemode;
    String channel;
    String currency;
    String orderNo;
    String transactionNo;
    Integer amount;
    Integer fee;
    Integer actualAmount;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getApp() {
        return app;
    }

    public void setApp(String app) {
        this.app = app;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public Boolean getLivemode() {
        return livemode;
    }

    public void setLivemode(Boolean livemode) {
        this.livemode = livemode;
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

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getTransactionNo() {
        return transactionNo;
    }

    public void setTransactionNo(String transactionNo) {
        this.transactionNo = transactionNo;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getFee() {
        return fee;
    }

    public void setFee(Integer fee) {
        this.fee = fee;
    }

    public Integer getActualAmount() {
        return actualAmount;
    }

    public void setActualAmount(Integer actualAmount) {
        this.actualAmount = actualAmount;
    }

    /**
     * 查询 Charge 的渠道交易明细。
     *
     * @param chargeId Charge 对象 ID
     * @return 渠道交易明细
     * @throws PingppException 请求失败时抛出
     */
    public static TradeDetail retrieve(String chargeId) throws PingppException {
        return retrieve(chargeId, null);
    }

    /**
     * 查询 Charge 的渠道交易明细。
     *
     * @param chargeId Charge 对象 ID
     * @param options 本次请求使用的配置
     * @return 渠道交易明细
     * @throws PingppException 请求失败时抛出
     */
    public static TradeDetail retrieve(String chargeId, RequestOptions options) throws PingppException {
        String url = String.format("%s/trade_detail", instanceURL(Charge.class, chargeId));
        return APIResource.request(APIResource.RequestMethod.GET, url, null, TradeDetail.class, options);
    }
}
