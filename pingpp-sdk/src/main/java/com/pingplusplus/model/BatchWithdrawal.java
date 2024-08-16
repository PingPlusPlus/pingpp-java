package com.pingplusplus.model;

import com.pingplusplus.exception.PingppException;
import com.pingplusplus.net.APIResource;
import com.pingplusplus.net.AppBasedResource;
import com.pingplusplus.net.RequestOptions;

import java.util.Map;

public class BatchWithdrawal extends AppBasedResource {
    String id;
    String object;
    String app;
    Long created;
    Boolean livemode;
    Long amount;
    Long amountSucceeded;
    Long amountFailed;
    Long amountCanceled;
    Integer count;
    Integer countSucceeded;
    Integer countFailed;
    Integer countCanceled;
    Integer fee;
    Map<String, Object> metadata;
    String operationUrl;
    String source;
    String status;
    Long timeFinished;
    Integer userFee;
    WithdrawalCollectionBase withdrawals;

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

    public Map<String, Object> getMetadata() {
        return metadata;
    }

    public void setMetadata(Map<String, Object> metadata) {
        this.metadata = metadata;
    }

    public String getOperationUrl() {
        return operationUrl;
    }

    public void setOperationUrl(String operationUrl) {
        this.operationUrl = operationUrl;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getUserFee() {
        return userFee;
    }

    public void setUserFee(Integer userFee) {
        this.userFee = userFee;
    }

    public WithdrawalCollectionBase getWithdrawals() {
        return withdrawals;
    }

    public void setWithdrawals(WithdrawalCollectionBase withdrawals) {
        this.withdrawals = withdrawals;
    }

    public Long getTimeFinished() {
        return timeFinished;
    }

    public void setTimeFinished(Long timeFinished) {
        this.timeFinished = timeFinished;
    }

    /**
     * 创建 batch_withdrawal
     *
     * @param params
     * @return BatchWithdrawal
     * @throws PingppException
     */
    public static BatchWithdrawal create(Map<String, Object> params)
            throws PingppException {
        return create(params, null);
    }

    /**
     * 创建 batch_withdrawal
     *
     * @param params
     * @param options the specific options
     * @return BatchWithdrawal
     * @throws PingppException
     */
    public static BatchWithdrawal create(Map<String, Object> params, RequestOptions options)
            throws PingppException {
        return APIResource.request(APIResource.RequestMethod.POST, classURL(BatchWithdrawal.class), params, BatchWithdrawal.class, options);
    }

    /**
     * 查询 batch_withdrawal
     *
     * @param id
     * @return BatchWithdrawal
     * @throws PingppException
     */
    public static BatchWithdrawal retrieve(String id)
            throws PingppException {
        return retrieve(id, null);
    }

    /**
     * 查询 batch_withdrawal
     *
     * @param id
     * @param options the specific options
     * @return BatchWithdrawal
     * @throws PingppException
     */
    public static BatchWithdrawal retrieve(String id, RequestOptions options)
            throws PingppException {
        return APIResource.request(APIResource.RequestMethod.GET, instanceURL(BatchWithdrawal.class, id), null, BatchWithdrawal.class, options);
    }

    /**
     * 查询 batch_withdrawal 列表
     *
     * @param params
     * @return BatchWithdrawalCollection
     * @throws PingppException
     */
    public static BatchWithdrawalCollection list(Map<String, Object> params)
            throws PingppException {
        return list(params, null);
    }

    /**
     * 查询 batch_withdrawal 列表
     *
     * @param params
     * @param options the specific options
     * @return BatchWithdrawalCollection
     * @throws PingppException
     */
    public static BatchWithdrawalCollection list(Map<String, Object> params, RequestOptions options)
            throws PingppException {
        return APIResource.request(APIResource.RequestMethod.GET, classURL(BatchWithdrawal.class), params, BatchWithdrawalCollection.class, options);
    }
}
