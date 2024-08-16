package com.pingplusplus.model;

import com.pingplusplus.exception.PingppException;
import com.pingplusplus.net.APIResource;
import com.pingplusplus.net.AppBasedResource;
import com.pingplusplus.net.RequestOptions;

import java.util.Map;

public class BalanceTransaction extends AppBasedResource {
    String id;
    String object;
    String app;
    Integer amount;
    Integer availableBalance;
    Long created;
    String description;
    Boolean livemode;
    String source;
    String type;
    String user;

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

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getAvailableBalance() {
        return availableBalance;
    }

    public void setAvailableBalance(Integer availableBalance) {
        this.availableBalance = availableBalance;
    }

    public Long getCreated() {
        return created;
    }

    public void setCreated(Long created) {
        this.created = created;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getLivemode() {
        return livemode;
    }

    public void setLivemode(Boolean livemode) {
        this.livemode = livemode;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    /**
     * 查询 balance_transaction
     *
     * @param id
     * @return BalanceTransaction
     * @throws PingppException
     */
    public static BalanceTransaction retrieve(String id)
            throws PingppException {
        return retrieve(id, null);
    }

    /**
     * 查询 balance_transaction
     *
     * @param id
     * @param options the specific options
     * @return BalanceTransaction
     * @throws PingppException
     */
    public static BalanceTransaction retrieve(String id, RequestOptions options)
            throws PingppException {
        return APIResource.request(APIResource.RequestMethod.GET, instanceURL(BalanceTransaction.class, id), null, BalanceTransaction.class, options);
    }

    /**
     * 查询 balance_transaction 列表
     *
     * @param params
     * @return BalanceTransactionCollection
     * @throws PingppException
     */
    public static BalanceTransactionCollection list(Map<String, Object> params)
            throws PingppException {
        return list(params, null);
    }

    /**
     * 查询 balance_transaction 列表
     *
     * @param params
     * @param options the specific options
     * @return BalanceTransactionCollection
     * @throws PingppException
     */
    public static BalanceTransactionCollection list(Map<String, Object> params, RequestOptions options)
            throws PingppException {
        return APIResource.request(APIResource.RequestMethod.GET, classURL(BalanceTransaction.class), params, BalanceTransactionCollection.class, options);
    }
}
