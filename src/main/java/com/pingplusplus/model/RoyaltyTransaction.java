package com.pingplusplus.model;

import com.pingplusplus.exception.PingppException;
import com.pingplusplus.net.APIResource;
import com.pingplusplus.net.RequestOptions;

import java.util.Map;

public class RoyaltyTransaction extends APIResource {
    String id;
    String object;
    Integer amount;
    Long created;
    String recipientApp;
    String royaltySettlement;
    String settleAccount;
    String sourceUser;
    String status;
    String failureMsg;
    String transfer;

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

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Long getCreated() {
        return created;
    }

    public void setCreated(Long created) {
        this.created = created;
    }

    public String getRecipientApp() {
        return recipientApp;
    }

    public void setRecipientApp(String recipientApp) {
        this.recipientApp = recipientApp;
    }

    public String getRoyaltySettlement() {
        return royaltySettlement;
    }

    public void setRoyaltySettlement(String royaltySettlement) {
        this.royaltySettlement = royaltySettlement;
    }

    public String getSettleAccount() {
        return settleAccount;
    }

    public void setSettleAccount(String settleAccount) {
        this.settleAccount = settleAccount;
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

    public String getFailureMsg() {
        return failureMsg;
    }

    public void setFailureMsg(String failureMsg) {
        this.failureMsg = failureMsg;
    }

    public String getTransfer() {
        return transfer;
    }

    public void setTransfer(String transfer) {
        this.transfer = transfer;
    }

    /**
     * 查询 royalty_transaction
     *
     * @param id
     * @return RoyaltyTransaction
     * @throws PingppException
     */
    public static RoyaltyTransaction retrieve(String id) throws PingppException {
        return retrieve(id, null);
    }

    /**
     * 查询 royalty_transaction
     *
     * @param id
     * @param options the specific options
     * @return RoyaltyTransaction
     * @throws PingppException
     */
    public static RoyaltyTransaction retrieve(String id, RequestOptions options) throws PingppException {
        return APIResource.request(APIResource.RequestMethod.GET, instanceURL(RoyaltyTransaction.class, id), null, RoyaltyTransaction.class, options);
    }

    /**
     * 查询 royalty_transaction 列表
     *
     * @param params
     * @return RoyaltyTransactionCollection
     * @throws PingppException
     */
    public static RoyaltyTransactionCollection list(Map<String, Object> params)
            throws PingppException {
        return list(params, null);
    }

    /**
     * 查询 royalty_transaction 列表
     *
     * @param params
     * @param options the specific options
     * @return RoyaltyTransactionCollection
     * @throws PingppException
     */
    public static RoyaltyTransactionCollection list(Map<String, Object> params, RequestOptions options)
            throws PingppException {
        return APIResource.request(APIResource.RequestMethod.GET, classURL(RoyaltyTransaction.class), params, RoyaltyTransactionCollection.class, options);
    }
}
