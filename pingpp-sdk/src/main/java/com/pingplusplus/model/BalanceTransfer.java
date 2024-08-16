package com.pingplusplus.model;

import com.pingplusplus.exception.PingppException;
import com.pingplusplus.net.APIResource;
import com.pingplusplus.net.AppBasedResource;
import com.pingplusplus.net.RequestOptions;

import java.util.Map;

public class BalanceTransfer extends AppBasedResource {
    String id;
    String object;
    String app;
    String orderNo;
    Long created;
    Boolean livemode;
    String status;
    Integer amount;
    String user;
    String userFee;
    String recipient;
    String userBalanceTransaction;
    String recipientBalanceTransaction;
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

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getUserFee() {
        return userFee;
    }

    public void setUserFee(String userFee) {
        this.userFee = userFee;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getUserBalanceTransaction() {
        return userBalanceTransaction;
    }

    public void setUserBalanceTransaction(String userBalanceTransaction) {
        this.userBalanceTransaction = userBalanceTransaction;
    }

    public String getRecipientBalanceTransaction() {
        return recipientBalanceTransaction;
    }

    public void setRecipientBalanceTransaction(String recipientBalanceTransaction) {
        this.recipientBalanceTransaction = recipientBalanceTransaction;
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
     * 创建 balance_transfer
     *
     * @param params
     * @return BalanceTransfer
     * @throws PingppException
     */
    public static BalanceTransfer create(Map<String, Object> params)
            throws PingppException {
        return create(params, null);
    }

    /**
     * 创建 balance_transfer
     *
     * @param params
     * @param options the specific options
     * @return BalanceTransfer
     * @throws PingppException
     */
    public static BalanceTransfer create(Map<String, Object> params, RequestOptions options)
            throws PingppException {
        return APIResource.request(APIResource.RequestMethod.POST, classURL(BalanceTransfer.class), params, BalanceTransfer.class, options);
    }

    /**
     * 查询 balance_transfer
     *
     * @param id
     * @return BalanceTransfer
     * @throws PingppException
     */
    public static BalanceTransfer retrieve(String id)
            throws PingppException {
        return retrieve(id, null);
    }

    /**
     * 查询 balance_transfer
     *
     * @param id
     * @param options the specific options
     * @return BalanceTransfer
     * @throws PingppException
     */
    public static BalanceTransfer retrieve(String id, RequestOptions options)
            throws PingppException {
        return APIResource.request(APIResource.RequestMethod.GET, instanceURL(BalanceTransfer.class, id), null, BalanceTransfer.class, options);
    }

    /**
     * 查询 balance_transfer 列表
     *
     * @param params
     * @return BalanceTransferCollection
     * @throws PingppException
     */
    public static BalanceTransferCollection list(Map<String, Object> params)
            throws PingppException {
        return list(params, null);
    }

    /**
     * 查询 balance_transfer 列表
     *
     * @param params
     * @param options the specific options
     * @return BalanceTransferCollection
     * @throws PingppException
     */
    public static BalanceTransferCollection list(Map<String, Object> params, RequestOptions options)
            throws PingppException {
        return APIResource.request(APIResource.RequestMethod.GET, classURL(BalanceTransfer.class), params, BalanceTransferCollection.class, options);
    }
}
