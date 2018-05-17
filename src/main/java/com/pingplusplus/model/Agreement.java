package com.pingplusplus.model;

import com.pingplusplus.exception.*;
import com.pingplusplus.net.APIResource;

import java.util.Map;

/**
 * 微信企业付款
 */
public class Agreement extends APIResource {
    String id;
    String object;
    Boolean livemode;
    String app;
    Long created;
    String channel;
    String contractNo;
    String contractId;
    Map<String, Object> credential;
    String status;
    Long timeSucceeded;
    Long timeCanceled;
    String failureCode;
    String failureMsg;
    Map<String, Object> extra;
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

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo;
    }

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId;
    }

    public Map<String, Object> getCredential() {
        return credential;
    }

    public void setCredential(Map<String, Object> credential) {
        this.credential = credential;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getTimeSucceeded() {
        return timeSucceeded;
    }

    public void setTimeSucceeded(Long timeSucceeded) {
        this.timeSucceeded = timeSucceeded;
    }

    public Long getTimeCanceled() {
        return timeCanceled;
    }

    public void setTimeCanceled(Long timeCanceled) {
        this.timeCanceled = timeCanceled;
    }

    public String getFailureCode() {
        return failureCode;
    }

    public void setFailureCode(String failureCode) {
        this.failureCode = failureCode;
    }

    public String getFailureMsg() {
        return failureMsg;
    }

    public void setFailureMsg(String failureMsg) {
        this.failureMsg = failureMsg;
    }

    public Map<String, Object> getExtra() {
        return extra;
    }

    public void setExtra(Map<String, Object> extra) {
        this.extra = extra;
    }

    public Map<String, Object> getMetadata() {
        return metadata;
    }

    public void setMetadata(Map<String, Object> metadata) {
        this.metadata = metadata;
    }

    /**
     * 创建签约(agreement)
     *
     * @param params  签约参数
     * @return Agreement
     * @throws AuthenticationException
     * @throws InvalidRequestException
     * @throws APIConnectionException
     * @throws APIException
     * @throws ChannelException
     */
    public static Agreement create(Map<String, Object> params)
            throws AuthenticationException, InvalidRequestException,
            APIConnectionException, APIException, ChannelException, RateLimitException {
        return create(params, null);
    }

    /**
     * 创建签约(agreement)
     *
     * @param params  签约参数
     * @param apiKey  Ping++ APiKey
     * @return Transfer
     * @throws AuthenticationException
     * @throws InvalidRequestException
     * @throws APIConnectionException
     * @throws APIException
     * @throws ChannelException
     * @throws RateLimitException
     */
    public static Agreement create(Map<String, Object> params, String apiKey)
            throws AuthenticationException, InvalidRequestException,
            APIConnectionException, APIException, ChannelException, RateLimitException {
        return request(RequestMethod.POST, classURL(Agreement.class), apiKey, params, Agreement.class);
    }

    /**
     * 查询签约(agreement)
     *
     * @param id  id
     * @return Agreement
     * @throws AuthenticationException
     * @throws InvalidRequestException
     * @throws APIConnectionException
     * @throws APIException
     * @throws ChannelException
     */
    public static Agreement retrieve(String id) throws AuthenticationException,
            InvalidRequestException, APIConnectionException,
            APIException, ChannelException, RateLimitException {
        return retrieve(id, null);
    }

    /**
     * 查询签约(agreement)
     *
     * @param id  id
     * @param apiKey  Ping++ ApiKey
     * @return Agreement
     * @throws AuthenticationException
     * @throws InvalidRequestException
     * @throws APIConnectionException
     * @throws APIException
     * @throws ChannelException
     * @throws RateLimitException
     */
    public static Agreement retrieve(String id, String apiKey) throws AuthenticationException,
            InvalidRequestException, APIConnectionException,
            APIException, ChannelException, RateLimitException {
        return request(RequestMethod.GET, instanceURL(Agreement.class, id), apiKey, null, Agreement.class);
    }

    /**
     * 查询签约列表
     *
     * @param params  分页参数等
     * @return AgreementCollection
     * @throws AuthenticationException
     * @throws InvalidRequestException
     * @throws APIConnectionException
     * @throws APIException
     * @throws ChannelException
     */
    public static AgreementCollection list(Map<String, Object> params)
            throws AuthenticationException, InvalidRequestException,
            APIConnectionException, APIException, ChannelException, RateLimitException {
        return list(params, null);
    }

    /**
     * 查询签约列表
     *
     * @param apiKey Ping++ APiKey
     * @param params 分页参数等
     * @return AgreementCollection
     * @throws AuthenticationException
     * @throws InvalidRequestException
     * @throws APIConnectionException
     * @throws APIException
     * @throws ChannelException
     * @throws RateLimitException
     */
    public static AgreementCollection list(Map<String, Object> params, String apiKey)
            throws AuthenticationException, InvalidRequestException,
            APIConnectionException, APIException, ChannelException, RateLimitException {
        return request(RequestMethod.GET, classURL(Agreement.class), apiKey, params, AgreementCollection.class);
    }
}
