package com.pingplusplus.model;

import com.pingplusplus.exception.PingppException;
import com.pingplusplus.net.APIResource;
import com.pingplusplus.net.AppBasedResource;
import com.pingplusplus.net.RequestOptions;
import java.util.Map;

public class BalanceBonus extends AppBasedResource {
    String id;
    String object;
    String app;
    Long created;
    Boolean livemode;
    Boolean paid;
    Boolean refunded;
    Integer amount;
    Integer amountRefunded;
    String orderNo;
    Long timePaid;
    String user;
    String balanceTransaction;
    String description;
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

    public Boolean getPaid() {
        return paid;
    }

    public void setPaid(Boolean paid) {
        this.paid = paid;
    }

    public Boolean getRefunded() {
        return refunded;
    }

    public void setRefunded(Boolean refunded) {
        this.refunded = refunded;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getAmountRefunded() {
        return amountRefunded;
    }

    public void setAmountRefunded(Integer amountRefunded) {
        this.amountRefunded = amountRefunded;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Long getTimePaid() {
        return timePaid;
    }

    public void setTimePaid(Long timePaid) {
        this.timePaid = timePaid;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getBalanceTransaction() {
        return balanceTransaction;
    }

    public void setBalanceTransaction(String balanceTransaction) {
        this.balanceTransaction = balanceTransaction;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Map<String, Object> getMetadata() {
        return metadata;
    }

    public void setMetadata(Map<String, Object> metadata) {
        this.metadata = metadata;
    }

    /**
     * 创建 balance_bonus
     *
     * @param params 请求参数
     * @return BalanceBonus
     * @throws PingppException
     */
    public static BalanceBonus create(Map<String, Object> params)
            throws PingppException {
        return create(params, null);
    }

    /**
     * 创建 balance_bonus
     *
     * @param params 请求参数
     * @param options the specific options
     * @return BalanceBonus
     * @throws PingppException
     */
    public static BalanceBonus create(Map<String, Object> params, RequestOptions options)
            throws PingppException {
        return APIResource.request(APIResource.RequestMethod.POST, classURL(BalanceBonus.class), params, BalanceBonus.class, options);
    }

    /**
     * 查询 balance_bonus
     *
     * @param id
     * @return BalanceBonus
     * @throws PingppException
     */
    public static BalanceBonus retrieve(String id)
            throws PingppException {
        return retrieve(id, null);
    }

    /**
     * 查询 balance_bonus
     *
     * @param id
     * @param options the specific options
     * @return BalanceBonus
     * @throws PingppException
     */
    public static BalanceBonus retrieve(String id, RequestOptions options)
            throws PingppException {
        return APIResource.request(APIResource.RequestMethod.GET, instanceURL(BalanceBonus.class, id), null, BalanceBonus.class, options);
    }

    /**
     * 查询 balance_bonus 列表
     *
     * @param params
     * @return BalanceBonusCollection
     * @throws PingppException
     */
    public static BalanceBonusCollection list(Map<String, Object> params)
            throws PingppException {
        return list(params, null);
    }

    /**
     * 查询 balance_bonus 列表
     *
     * @param params
     * @param options the specific options
     * @return BalanceBonusCollection
     * @throws PingppException
     */
    public static BalanceBonusCollection list(Map<String, Object> params, RequestOptions options)
            throws PingppException {
        return APIResource.request(APIResource.RequestMethod.GET, classURL(BalanceBonus.class), params, BalanceBonusCollection.class, options);
    }
}
