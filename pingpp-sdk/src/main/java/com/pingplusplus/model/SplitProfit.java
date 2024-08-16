package com.pingplusplus.model;

import com.pingplusplus.exception.PingppException;
import com.pingplusplus.net.APIResource;
import com.pingplusplus.net.RequestOptions;

import java.util.List;
import java.util.Map;

/**
 * 分账
 */
public class SplitProfit extends APIResource {
    String id;
    String object;
    Boolean livemode;
    String app;
    Long created;
    String charge;
    String channel;
    String type;
    String orderNo;
    String transactionNo;
    String failureCode;
    String failureMsg;
    List<SplitProfitRecipient> recipients;
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

    public Boolean getLivemode() {
        return livemode;
    }

    public void setLivemode(Boolean livemode) {
        this.livemode = livemode;
    }

    public String getApp() {
        return app;
    }

    public void setApp(String app) {
        this.app = app;
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

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public List<SplitProfitRecipient> getRecipients() {
        return recipients;
    }

    public void setRecipients(List<SplitProfitRecipient> recipients) {
        this.recipients = recipients;
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
     * 创建分账
     *
     * @param params  参数
     * @return SplitProfit
     * @throws PingppException
     */
    public static SplitProfit create(Map<String, Object> params)
            throws PingppException {
        return create(params, null);
    }

    /**
     * 创建分账
     *
     * @param params  参数
     * @param options the specific options
     * @return SplitProfit
     * @throws PingppException
     */
    public static SplitProfit create(Map<String, Object> params, RequestOptions options)
            throws PingppException {
        return APIResource.request(APIResource.RequestMethod.POST, classURL(SplitProfit.class), params, SplitProfit.class, options);
    }

    /**
     * 查询分账
     *
     * @param id  id
     * @return SplitProfit
     * @throws PingppException
     */
    public static SplitProfit retrieve(String id) throws PingppException {
        return retrieve(id, null);
    }

    /**
     * 查询分账
     *
     * @param id  id
     * @param options the specific options
     * @return SplitProfit
     * @throws PingppException
     */
    public static SplitProfit retrieve(String id, RequestOptions options) throws PingppException {
        return APIResource.request(APIResource.RequestMethod.GET, instanceURL(SplitProfit.class, id), null, SplitProfit.class, options);
    }

    /**
     * 查询分账列表
     *
     * @param params  分页参数等
     * @return SplitProfitCollection
     * @throws PingppException
     */
    public static SplitProfitCollection list(Map<String, Object> params)
            throws PingppException {
        return list(params, null);
    }

    /**
     * 查询分账列表
     *
     * @param params 分页参数等
     * @param options the specific options
     * @return SplitProfitCollection
     * @throws PingppException
     */
    public static SplitProfitCollection list(Map<String, Object> params, RequestOptions options)
            throws PingppException {
        return APIResource.request(APIResource.RequestMethod.GET, classURL(SplitProfit.class), params, SplitProfitCollection.class, options);
    }
}
