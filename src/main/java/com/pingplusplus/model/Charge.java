package com.pingplusplus.model;

import com.pingplusplus.exception.*;
import com.pingplusplus.net.APIResource;

import java.util.HashMap;
import java.util.Map;

public class Charge extends APIResource {
    String id;
    String object;
    Long created;
    Boolean livemode;
    Boolean paid;
    Boolean refunded;
    Boolean reversed;
    Object app;
    String channel;
    String orderNo;
    String clientIp;
    Integer amount;
    Integer amountSettle;
    String currency;
    String subject;
    String body;
    Long timePaid;
    Long timeExpire;
    Long timeSettle;
    String transactionNo;
    ChargeRefundCollection refunds;
    Integer amountRefunded;
    String failureCode;
    String failureMsg;
    Map<String, Object> metadata;
    Map<String, Object> credential;
    Map<String, Object> extra;
    String description;

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

    public Long getCreated() {
        return created;
    }

    public void setCreated(Long created) {
        this.created = created;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
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

    public Boolean getReversed() {
        return reversed;
    }

    public void setReversed(Boolean reversed) {
        this.reversed = reversed;
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

    public String getFailureCode() {
        return failureCode;
    }

    public void setFailureCode(String failureCode) {
        this.failureCode = failureCode;
    }

    public Integer getAmountRefunded() {
        return amountRefunded;
    }

    public void setAmountRefunded(Integer amountRefunded) {
        this.amountRefunded = amountRefunded;
    }

    public Integer getAmountSettle() {
        return amountSettle;
    }

    public void setAmountSettle(Integer amountSettle) {
        this.amountSettle = amountSettle;
    }

    public String getTransactionNo() {
        return transactionNo;
    }

    public void setTransactionNo(String transactionNo) {
        this.transactionNo = transactionNo;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public ChargeRefundCollection getRefunds() {
        return refunds;
    }

    public Map<String, Object> getMetadata() {
        return metadata;
    }

    public void setMetadata(Map<String, Object> metadata) {
        this.metadata = metadata;
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

    public void setCredential(Map<String, Object> credential) {
        this.credential = credential;
    }

    public Map<String, Object> getCredential() {
        return credential;
    }

    public Map<String, Object> getExtra() {
        return extra;
    }

    public void setExtra(Map<String, Object> extra) {
        this.extra = extra;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getClientIp() {
        return clientIp;
    }

    public void setClientIp(String clientIp) {
        this.clientIp = clientIp;
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

    public Long getTimePaid() {
        return timePaid;
    }

    public void setTimePaid(Long timePaid) {
        this.timePaid = timePaid;
    }

    public Long getTimeExpire() {
        return timeExpire;
    }

    public void setTimeExpire(Long timeExpire) {
        this.timeExpire = timeExpire;
    }

    public Long getTimeSettle() {
        return timeSettle;
    }

    public void setTimeSettle(Long timeSettle) {
        this.timeSettle = timeSettle;
    }


    /**
     * 创建 charge
     *
     * @param params
     * @return
     * @throws AuthenticationException
     * @throws InvalidRequestException
     * @throws APIConnectionException
     * @throws APIException
     * @throws ChannelException
     * @throws RateLimitException
     */
    public static Charge create(Map<String, Object> params)
            throws AuthenticationException, InvalidRequestException,
            APIConnectionException, APIException, ChannelException, RateLimitException {
        return request(RequestMethod.POST, classURL(Charge.class), params, Charge.class);
    }

    /**
     * 查询 charge
     *
     * @param id
     * @return
     * @throws AuthenticationException
     * @throws InvalidRequestException
     * @throws APIConnectionException
     * @throws APIException
     * @throws ChannelException
     * @throws RateLimitException
     */
    public static Charge retrieve(String id) throws AuthenticationException,
            InvalidRequestException, APIConnectionException,
            APIException, ChannelException, RateLimitException {
        return request(RequestMethod.GET, instanceURL(Charge.class, id), null, Charge.class);
    }

    /**
     * 查询 charge
     *
     * @param id
     * @param params
     * @return
     * @throws AuthenticationException
     * @throws InvalidRequestException
     * @throws APIConnectionException
     * @throws APIException
     * @throws ChannelException
     * @throws RateLimitException
     */
    public static Charge retrieve(String id, Map<String, Object> params) throws AuthenticationException,
            InvalidRequestException, APIConnectionException,
            APIException, ChannelException, RateLimitException {
        return request(RequestMethod.GET, instanceURL(Charge.class, id), params, Charge.class);
    }

    /**
     * 查询 charge 列表
     *
     * @param params
     * @return
     * @throws AuthenticationException
     * @throws InvalidRequestException
     * @throws APIConnectionException
     * @throws APIException
     * @throws ChannelException
     * @throws RateLimitException
     */
    public static ChargeCollection list(Map<String, Object> params)
            throws AuthenticationException, InvalidRequestException,
            APIConnectionException, APIException, ChannelException, RateLimitException {
        if (params != null
                && ((params.containsKey("app") && (params.get("app") instanceof Map) && ((Map) params.get("app")).containsKey("id"))
                    || (params.containsKey("app[id]") && (params.get("app[id]") instanceof String)))) {
            return request(RequestMethod.GET, classURL(Charge.class), params, ChargeCollection.class);
        }
        throw new InvalidRequestException("Please pass app[id] as parameter.", "app[id]", null);
    }

    /**
     * 撤销 charge
     *
     * @param id
     * @param params
     * @return
     * @throws AuthenticationException
     * @throws InvalidRequestException
     * @throws APIConnectionException
     * @throws APIException
     * @throws ChannelException
     * @throws RateLimitException
     */
    public static Charge reverse(String id, Map<String, Object> params) throws AuthenticationException,
            InvalidRequestException, APIConnectionException,
            APIException, ChannelException, RateLimitException {
        String reverseUrl = String.format("%s/reverse", instanceURL(Charge.class, id));
        if (params == null) {
            params = new HashMap<String, Object>();
        }
        return request(RequestMethod.POST, reverseUrl, params, Charge.class);
    }

    /**
     * 撤销 charge
     *
     * @param id
     * @return
     * @throws AuthenticationException
     * @throws InvalidRequestException
     * @throws APIConnectionException
     * @throws APIException
     * @throws ChannelException
     * @throws RateLimitException
     */
    public static Charge reverse(String id) throws AuthenticationException,
            InvalidRequestException, APIConnectionException,
            APIException, ChannelException, RateLimitException {
        return reverse(id, null);
    }

    @Deprecated
    public static ChargeCollection all(Map<String, Object> params)
            throws RateLimitException, APIException, ChannelException,
            InvalidRequestException, APIConnectionException, AuthenticationException {
        return list(params);
    }

}
