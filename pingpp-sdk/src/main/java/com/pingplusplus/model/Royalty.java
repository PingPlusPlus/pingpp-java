package com.pingplusplus.model;

import com.pingplusplus.exception.PingppException;
import com.pingplusplus.net.APIResource;
import com.pingplusplus.net.RequestOptions;

import java.util.Map;

public class Royalty extends APIResource {
    String id;
    String object;
    Boolean livemode;
    Long created;
    Integer amount;
    String description;
    String method;
    String payerApp;
    String recipientApp;
    String royaltyTransaction;
    String royaltySettlement;
    String settleAccount;
    String sourceApp;
    String sourceNo;
    String sourceUrl;
    String sourceUser;
    String status;
    Long timeSettled;
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

    public Long getCreated() {
        return created;
    }

    public void setCreated(Long created) {
        this.created = created;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getPayerApp() {
        return payerApp;
    }

    public void setPayerApp(String payerApp) {
        this.payerApp = payerApp;
    }

    public String getRecipientApp() {
        return recipientApp;
    }

    public void setRecipientApp(String recipientApp) {
        this.recipientApp = recipientApp;
    }

    public String getRoyaltyTransaction() {
        return royaltyTransaction;
    }

    public void setRoyaltyTransaction(String royaltyTransaction) {
        this.royaltyTransaction = royaltyTransaction;
    }

    public String getSettleAccount() {
        return settleAccount;
    }

    public void setSettleAccount(String settleAccount) {
        this.settleAccount = settleAccount;
    }

    public String getSourceApp() {
        return sourceApp;
    }

    public void setSourceApp(String sourceApp) {
        this.sourceApp = sourceApp;
    }

    public String getSourceNo() {
        return sourceNo;
    }

    public void setSourceNo(String sourceNo) {
        this.sourceNo = sourceNo;
    }

    public String getSourceUrl() {
        return sourceUrl;
    }

    public void setSourceUrl(String sourceUrl) {
        this.sourceUrl = sourceUrl;
    }

    public String getSourceUser() {
        return sourceUser;
    }

    public void setSourceUser(String sourceUser) {
        this.sourceUser = sourceUser;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getTimeSettled() {
        return timeSettled;
    }

    public void setTimeSettled(Long timeSettled) {
        this.timeSettled = timeSettled;
    }

    public Map<String, Object> getMetadata() {
        return metadata;
    }

    public void setMetadata(Map<String, Object> metadata) {
        this.metadata = metadata;
    }

    public String getRoyaltySettlement() {
        return royaltySettlement;
    }

    public void setRoyaltySettlement(String royaltySettlement) {
        this.royaltySettlement = royaltySettlement;
    }

    /**
     * 查询 royalty
     *
     * @param id
     * @return Royalty
     * @throws PingppException
     */
    public static Royalty retrieve(String id) throws PingppException {
        return retrieve(id, null);
    }

    /**
     * 查询 royalty
     *
     * @param id
     * @param options the specific options
     * @return Royalty
     * @throws PingppException
     */
    public static Royalty retrieve(String id, RequestOptions options) throws PingppException {
        return APIResource.request(APIResource.RequestMethod.GET, instanceURL(Royalty.class, id), null, Royalty.class, options);
    }

    /**
     * 查询 royalty 列表
     *
     * @param params
     * @return RoyaltyCollection
     * @throws PingppException
     */
    public static RoyaltyCollection list(Map<String, Object> params)
            throws PingppException {
        return list(params, null);
    }

    /**
     * 查询 royalty 列表
     *
     * @param params
     * @param options the specific options
     * @return RoyaltyCollection
     * @throws PingppException
     */
    public static RoyaltyCollection list(Map<String, Object> params, RequestOptions options)
            throws PingppException {
        return APIResource.request(APIResource.RequestMethod.GET, classURL(Royalty.class), params, RoyaltyCollection.class, options);
    }

    /**
     * 批量更新 royalty
     *
     * @param params
     * @return RoyaltyCollection
     * @throws PingppException
     */
    public static RoyaltyCollection batchUpdate(Map<String, Object> params)
            throws PingppException {
        return batchUpdate(params, null);
    }

    /**
     * 批量更新 royalty
     *
     * @param params
     * @param options the specific options
     * @return RoyaltyCollection
     * @throws PingppException
     */
    public static RoyaltyCollection batchUpdate(Map<String, Object> params, RequestOptions options)
            throws PingppException {
        return APIResource.request(APIResource.RequestMethod.PUT, classURL(Royalty.class), params, RoyaltyCollection.class, options);
    }

    /**
     * 创建分润
     *
     * @param orderId 订单 ID
     * @param params 分润信息参数
     * @return RoyaltyDataResult
     * @throws PingppException
     */
    public static RoyaltyDataResult createData(String orderId, Map<String, Object> params)
            throws PingppException {
        return createData(orderId, params, null);
    }

    /**
     * 创建分润
     *
     * @param orderId 订单 ID
     * @param params 分润信息参数
     * @param options the specific options
     * @return RoyaltyDataResult
     * @throws PingppException
     */
    public static RoyaltyDataResult createData(String orderId, Map<String, Object> params, RequestOptions options)
            throws PingppException {
        return APIResource.request(APIResource.RequestMethod.POST,
                String.format("%s/royalty_datas", instanceURL(Order.class, orderId)),
                params,
                RoyaltyDataResult.class, options);
    }
}
