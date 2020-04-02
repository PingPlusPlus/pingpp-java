package com.pingplusplus.model;

import com.pingplusplus.exception.PingppException;
import com.pingplusplus.net.APIResource;
import com.pingplusplus.net.RequestOptions;

import java.util.Map;

public class RoyaltySettlement extends APIResource {
    String id;
    String object;
    Boolean livemode;
    Long created;
    Long amount;
    Long amountSucceeded;
    Long amountFailed;
    Long amountCanceled;
    Integer count;
    Integer countSucceeded;
    Integer countFailed;
    Integer countCanceled;
    Integer fee;
    String method;
    String operationUrl;
    String payerApp;
    String status;
    Long timeFinished;
    RoyaltyTransactionCollection royaltyTransactions;
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

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Long getAmountSucceeded() {
        return amountSucceeded;
    }

    public void setAmountSucceeded(Long amountSucceeded) {
        this.amountSucceeded = amountSucceeded;
    }

    public Long getAmountFailed() {
        return amountFailed;
    }

    public void setAmountFailed(Long amountFailed) {
        this.amountFailed = amountFailed;
    }

    public Long getAmountCanceled() {
        return amountCanceled;
    }

    public void setAmountCanceled(Long amountCanceled) {
        this.amountCanceled = amountCanceled;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getCountSucceeded() {
        return countSucceeded;
    }

    public void setCountSucceeded(Integer countSucceeded) {
        this.countSucceeded = countSucceeded;
    }

    public Integer getCountFailed() {
        return countFailed;
    }

    public void setCountFailed(Integer countFailed) {
        this.countFailed = countFailed;
    }

    public Integer getCountCanceled() {
        return countCanceled;
    }

    public void setCountCanceled(Integer countCanceled) {
        this.countCanceled = countCanceled;
    }

    public Integer getFee() {
        return fee;
    }

    public void setFee(Integer fee) {
        this.fee = fee;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getOperationUrl() {
        return operationUrl;
    }

    public void setOperationUrl(String operationUrl) {
        this.operationUrl = operationUrl;
    }

    public String getPayerApp() {
        return payerApp;
    }

    public void setPayerApp(String payerApp) {
        this.payerApp = payerApp;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getTimeFinished() {
        return timeFinished;
    }

    public void setTimeFinished(Long timeFinished) {
        this.timeFinished = timeFinished;
    }

    public RoyaltyTransactionCollection getRoyaltyTransactions() {
        return royaltyTransactions;
    }

    public void setRoyaltyTransactions(RoyaltyTransactionCollection royaltyTransactions) {
        this.royaltyTransactions = royaltyTransactions;
    }

    public Map<String, Object> getMetadata() {
        return metadata;
    }

    public void setMetadata(Map<String, Object> metadata) {
        this.metadata = metadata;
    }

    /**
     * 创建 royalty_settlement
     *
     * @param params
     * @return RoyaltySettlement
     * @throws PingppException
     */
    public static RoyaltySettlement create(Map<String, Object> params) throws PingppException {
        return create(params, null);
    }

    /**
     * 创建 royalty_settlement
     *
     * @param params
     * @param options the specific options
     * @return RoyaltySettlement
     * @throws PingppException
     */
    public static RoyaltySettlement create(Map<String, Object> params, RequestOptions options) throws PingppException {
        return APIResource.request(APIResource.RequestMethod.POST, classURL(RoyaltySettlement.class), params, RoyaltySettlement.class, options);
    }

    /**
     * 查询 royalty_settlement
     *
     * @param id
     * @return RoyaltySettlement
     * @throws PingppException
     */
    public static RoyaltySettlement retrieve(String id) throws PingppException {
        return retrieve(id, null);
    }

    /**
     * 查询 royalty_settlement
     *
     * @param id
     * @param options the specific options
     * @return RoyaltySettlement
     * @throws PingppException
     */
    public static RoyaltySettlement retrieve(String id, RequestOptions options) throws PingppException {
        return APIResource.request(APIResource.RequestMethod.GET, instanceURL(RoyaltySettlement.class, id), null, RoyaltySettlement.class, options);
    }

    /**
     * 查询 royalty_settlement 列表
     *
     * @param params
     * @return RoyaltySettlement
     * @throws PingppException
     */
    public static RoyaltySettlementCollection list(Map<String, Object> params)
            throws PingppException {
        return list(params, null);
    }

    /**
     * 查询 royalty_settlement 列表
     *
     * @param params
     * @param options the specific options
     * @return RoyaltySettlement
     * @throws PingppException
     */
    public static RoyaltySettlementCollection list(Map<String, Object> params, RequestOptions options)
            throws PingppException {
        return APIResource.request(APIResource.RequestMethod.GET, classURL(RoyaltySettlement.class), params, RoyaltySettlementCollection.class, options);
    }

    /**
     * 更新 royalty_settlement
     *
     * @param id
     * @param params
     * @return RoyaltySettlement
     * @throws PingppException
     */
    public static RoyaltySettlement update(String id, Map<String, Object> params)
            throws PingppException {
        return update(id, params, null);
    }

    /**
     * 更新 royalty_settlement
     *
     * @param id
     * @param params
     * @param options the specific options
     * @return RoyaltySettlement
     * @throws PingppException
     */
    public static RoyaltySettlement update(String id, Map<String, Object> params, RequestOptions options)
            throws PingppException {
        return APIResource.request(APIResource.RequestMethod.PUT, instanceURL(RoyaltySettlement.class, id), params, RoyaltySettlement.class, options);
    }
}
