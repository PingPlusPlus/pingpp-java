package com.pingplusplus.model;

import com.pingplusplus.exception.*;
import com.pingplusplus.net.APIResource;
import com.pingplusplus.net.AppBasedResource;

import java.util.Map;

public class BatchWithdrawal extends AppBasedResource {
    String id;
    String object;
    String app;
    Long created;
    Boolean livemode;
    Integer amount;
    Integer amountSucceeded;
    Integer amountFailed;
    Integer amountCanceled;
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

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getAmountSucceeded() {
        return amountSucceeded;
    }

    public void setAmountSucceeded(Integer amountSucceeded) {
        this.amountSucceeded = amountSucceeded;
    }

    public Integer getAmountFailed() {
        return amountFailed;
    }

    public void setAmountFailed(Integer amountFailed) {
        this.amountFailed = amountFailed;
    }

    public Integer getAmountCanceled() {
        return amountCanceled;
    }

    public void setAmountCanceled(Integer amountCanceled) {
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
     * @throws AuthenticationException
     * @throws InvalidRequestException
     * @throws APIConnectionException
     * @throws APIException
     * @throws ChannelException
     * @throws RateLimitException
     */
    public static BatchWithdrawal create(Map<String, Object> params)
            throws AuthenticationException, InvalidRequestException,
            APIConnectionException, APIException, ChannelException, RateLimitException {
        return request(APIResource.RequestMethod.POST, classURL(BatchWithdrawal.class), params, BatchWithdrawal.class);
    }

    /**
     * 查询 batch_withdrawal
     *
     * @param id
     * @return BatchWithdrawal
     * @throws AuthenticationException
     * @throws InvalidRequestException
     * @throws APIConnectionException
     * @throws APIException
     * @throws ChannelException
     * @throws RateLimitException
     */
    public static BatchWithdrawal retrieve(String id)
            throws AuthenticationException, InvalidRequestException,
            APIConnectionException, APIException, ChannelException, RateLimitException {
        return request(APIResource.RequestMethod.GET, instanceURL(BatchWithdrawal.class, id), null, BatchWithdrawal.class);
    }

    /**
     * 查询 batch_withdrawal 列表
     *
     * @param params
     * @return BatchWithdrawalCollection
     * @throws AuthenticationException
     * @throws InvalidRequestException
     * @throws APIConnectionException
     * @throws APIException
     * @throws ChannelException
     * @throws RateLimitException
     */
    public static BatchWithdrawalCollection list(Map<String, Object> params)
            throws AuthenticationException, InvalidRequestException,
            APIConnectionException, APIException, ChannelException, RateLimitException {
        return request(APIResource.RequestMethod.GET, classURL(BatchWithdrawal.class), params, BatchWithdrawalCollection.class);
    }
}
