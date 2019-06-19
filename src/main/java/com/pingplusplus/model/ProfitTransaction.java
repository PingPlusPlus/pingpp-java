package com.pingplusplus.model;

import com.pingplusplus.exception.*;
import com.pingplusplus.net.APIResource;

import java.util.Map;

/**
 * 分账明细
 */
public class ProfitTransaction extends APIResource {
    String id;
    String object;
    Boolean livemode;
    String app;
    Long created;
    Integer amount;
    String currency;
    String name;
    String status;
    String description;
    String splitReceiver;
    String splitProfit;
    Long timeFinished;
    String failureMsg;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSplitReceiver() {
        return splitReceiver;
    }

    public void setSplitReceiver(String splitReceiver) {
        this.splitReceiver = splitReceiver;
    }

    public String getSplitProfit() {
        return splitProfit;
    }

    public void setSplitProfit(String splitProfit) {
        this.splitProfit = splitProfit;
    }

    public Long getTimeFinished() {
        return timeFinished;
    }

    public void setTimeFinished(Long timeFinished) {
        this.timeFinished = timeFinished;
    }

    public String getFailureMsg() {
        return failureMsg;
    }

    public void setFailureMsg(String failureMsg) {
        this.failureMsg = failureMsg;
    }

    /**
     * 查询分账明细
     *
     * @param id  id
     * @return ProfitTransaction
     * @throws AuthenticationException
     * @throws InvalidRequestException
     * @throws APIConnectionException
     * @throws APIException
     * @throws ChannelException
     */
    public static ProfitTransaction retrieve(String id) throws AuthenticationException,
            InvalidRequestException, APIConnectionException,
            APIException, ChannelException, RateLimitException {
        return retrieve(id, null);
    }

    /**
     * 查询分账明细
     *
     * @param id  id
     * @param apiKey  Ping++ ApiKey
     * @return ProfitTransaction
     * @throws AuthenticationException
     * @throws InvalidRequestException
     * @throws APIConnectionException
     * @throws APIException
     * @throws ChannelException
     * @throws RateLimitException
     */
    public static ProfitTransaction retrieve(String id, String apiKey) throws AuthenticationException,
            InvalidRequestException, APIConnectionException,
            APIException, ChannelException, RateLimitException {
        return request(RequestMethod.GET, instanceURL(ProfitTransaction.class, id), apiKey, null, ProfitTransaction.class);
    }

    /**
     * 查询分账明细列表
     *
     * @param params  分页参数等
     * @return ProfitTransactionCollection
     * @throws AuthenticationException
     * @throws InvalidRequestException
     * @throws APIConnectionException
     * @throws APIException
     * @throws ChannelException
     */
    public static ProfitTransactionCollection list(Map<String, Object> params)
            throws AuthenticationException, InvalidRequestException,
            APIConnectionException, APIException, ChannelException, RateLimitException {
        return list(params, null);
    }

    /**
     * 查询分账明细列表
     *
     * @param apiKey Ping++ APiKey
     * @param params 分页参数等
     * @return ProfitTransactionCollection
     * @throws AuthenticationException
     * @throws InvalidRequestException
     * @throws APIConnectionException
     * @throws APIException
     * @throws ChannelException
     * @throws RateLimitException
     */
    public static ProfitTransactionCollection list(Map<String, Object> params, String apiKey)
            throws AuthenticationException, InvalidRequestException,
            APIConnectionException, APIException, ChannelException, RateLimitException {
        return request(RequestMethod.GET, classURL(ProfitTransaction.class), apiKey, params, ProfitTransactionCollection.class);
    }
}
