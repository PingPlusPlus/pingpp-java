package com.pingplusplus.model;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.gson.LongSerializationPolicy;
import com.pingplusplus.exception.PingppException;
import com.pingplusplus.net.APIResource;
import com.pingplusplus.net.RequestOptions;

import java.lang.reflect.Type;
import java.util.Map;

public class RedEnvelope extends APIResource {
    String id;
    String object;
    Long created;
    Long received;
    Long refunded;
    Boolean livemode;
    String status;
    Object app;
    String channel;
    String orderNo;
    String transactionNo;
    Integer amount;
    Integer amountSettle;
    String currency;
    String recipient;
    String subject;
    String body;
    String description;
    String failureMsg;
    Map<String, String> extra;
    Map<String, Object> metadata;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTransactionNo() {
        return transactionNo;
    }

    public void setTransactionNo(String transactionNo) {
        this.transactionNo = transactionNo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getAmountSettle() {
        return amountSettle;
    }

    public void setAmountSettle(Integer amountSettle) {
        this.amountSettle = amountSettle;
    }

    public Long getCreated() {
        return created;
    }

    public void setCreated(Long created) {
        this.created = created;
    }

    public Long getReceived() {
        return received;
    }

    public void setReceived(Long received) {
        this.received = received;
    }

    public Long getRefunded() {
        return refunded;
    }

    public void setRefunded(Long refunded) {
        this.refunded = refunded;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public Boolean getLivemode() {
        return livemode;
    }

    public void setLivemode(Boolean livemode) {
        this.livemode = livemode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFailureMsg() {
        return failureMsg;
    }

    public void setFailureMsg(String failureMsg) {
        this.failureMsg = failureMsg;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public Object getApp() {
        return app;
    }

    public void setApp(Object app) {
        this.app = app;
    }

    public Map<String, String> getExtra() {
        return extra;
    }

    public void setExtra(Map<String, String> extra) {
        this.extra = extra;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }


    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Map<String, Object> getMetadata() {
        return metadata;
    }

    public void setMetadata(Map<String, Object> metadata) {
        this.metadata = metadata;
    }

    /**
     * 创建 RedEnvelope
     *
     * @param params
     * @return RedEnvelope
     * @throws PingppException
     */
    public static RedEnvelope create(Map<String, Object> params)
            throws PingppException {
        return create(params, null);
    }

    /**
     * 创建 RedEnvelope
     *
     * @param params
     * @param options the specific options
     * @return RedEnvelope
     * @throws PingppException
     */
    public static RedEnvelope create(Map<String, Object> params, RequestOptions options)
            throws PingppException {
        return APIResource.request(APIResource.RequestMethod.POST, classURL(RedEnvelope.class), params, RedEnvelope.class, options);
    }

    /**
     * 查询 RedEnvelope
     *
     * @param id
     * @return RedEnvelope
     * @throws PingppException
     */
    public static RedEnvelope retrieve(String id) throws PingppException {
        return retrieve(id, null, null);
    }

    /**
     * 查询 RedEnvelope
     *
     * @param id
     * @param options the specific options
     * @return RedEnvelope
     * @throws PingppException
     */
    public static RedEnvelope retrieve(String id, RequestOptions options) throws PingppException {
        return retrieve(id, null, options);
    }

    /**
     * 查询 RedEnvelope
     *
     * @param id
     * @param params
     * @return RedEnvelope
     * @throws PingppException
     */
    public static RedEnvelope retrieve(String id, Map<String, Object> params) throws PingppException {
        return retrieve(id, params, null);
    }

    /**
     * 查询 RedEnvelope
     *
     * @param id
     * @param params
     * @param options the specific options
     * @return RedEnvelope
     * @throws PingppException
     */
    public static RedEnvelope retrieve(String id, Map<String, Object> params, RequestOptions options) throws PingppException {
        return APIResource.request(APIResource.RequestMethod.GET, instanceURL(RedEnvelope.class, id), params, RedEnvelope.class, options);
    }

    /**
     * 查询 RedEnvelope
     *
     * @param params
     * @return RedEnvelopeCollection
     * @throws PingppException
     */
    public static RedEnvelopeCollection list(Map<String, Object> params)
            throws PingppException {
        return list(params, null);
    }

    /**
     * 查询 RedEnvelope
     *
     * @param params
     * @param options the specific options
     * @return RedEnvelopeCollection
     * @throws PingppException
     */
    public static RedEnvelopeCollection list(Map<String, Object> params, RequestOptions options)
            throws PingppException {
        return APIResource.request(APIResource.RequestMethod.GET, classURL(RedEnvelope.class), params, RedEnvelopeCollection.class, options);
    }

}
