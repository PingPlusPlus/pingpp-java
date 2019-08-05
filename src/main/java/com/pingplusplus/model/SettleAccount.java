package com.pingplusplus.model;

import com.pingplusplus.exception.*;
import com.pingplusplus.net.APIResource;
import com.pingplusplus.net.UserBasedResource;

import java.util.Map;

public class SettleAccount extends UserBasedResource {
    String id;
    String object;
    Boolean livemode;
    String channel;
    Long created;
    SettleAccountRecipient recipient;

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

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public Long getCreated() {
        return created;
    }

    public void setCreated(Long created) {
        this.created = created;
    }

    public SettleAccountRecipient getRecipient() {
        return recipient;
    }

    public void setRecipient(SettleAccountRecipient recipient) {
        this.recipient = recipient;
    }

    public Boolean getLivemode() {
        return livemode;
    }

    public void setLivemode(Boolean livemode) {
        this.livemode = livemode;
    }

    /**
     * 创建 settle_account
     *
     * @param userId
     * @param params
     * @return SettleAccount
     * @throws AuthenticationException
     * @throws InvalidRequestException
     * @throws APIConnectionException
     * @throws APIException
     * @throws ChannelException
     * @throws RateLimitException
     */
    public static SettleAccount create(String userId, Map<String, Object>params)
            throws AuthenticationException, InvalidRequestException,
            APIConnectionException, APIException, ChannelException, RateLimitException {
        User.checkUserId(userId);
        return request(APIResource.RequestMethod.POST, classURL(SettleAccount.class, userId), params, SettleAccount.class);
    }

    /**
     * 查询 settle_account
     *
     * @param userId
     * @param id
     * @return SettleAccount
     * @throws AuthenticationException
     * @throws InvalidRequestException
     * @throws APIConnectionException
     * @throws APIException
     * @throws ChannelException
     * @throws RateLimitException
     */
    public static SettleAccount retrieve(String userId, String id)
            throws AuthenticationException, InvalidRequestException,
            APIConnectionException, APIException, ChannelException, RateLimitException {
        User.checkUserId(userId);
        return request(APIResource.RequestMethod.GET, instanceURL(SettleAccount.class, userId, id), null, SettleAccount.class);
    }

    /**
     * 查询 settle_account 列表
     *
     * @param userId
     * @param params
     * @return SettleAccountCollection
     * @throws AuthenticationException
     * @throws InvalidRequestException
     * @throws APIConnectionException
     * @throws APIException
     * @throws ChannelException
     * @throws RateLimitException
     */
    public static SettleAccountCollection list(String userId, Map<String, Object> params)
            throws AuthenticationException, InvalidRequestException,
            APIConnectionException, APIException, ChannelException, RateLimitException {
        User.checkUserId(userId);
        return request(APIResource.RequestMethod.GET, classURL(SettleAccount.class, userId), params, SettleAccountCollection.class);
    }

    /**
     * 删除 settle_account
     *
     * @param userId
     * @param id
     * @return DeletedSettleAccount
     * @throws AuthenticationException
     * @throws InvalidRequestException
     * @throws APIConnectionException
     * @throws APIException
     * @throws ChannelException
     * @throws RateLimitException
     */
    public static DeletedSettleAccount delete(String userId, String id)
            throws AuthenticationException, InvalidRequestException,
            APIConnectionException, APIException, ChannelException, RateLimitException {
        User.checkUserId(userId);
        return request(APIResource.RequestMethod.DELETE, instanceURL(SettleAccount.class, userId, id), null, DeletedSettleAccount.class);
    }

    /**
     * 更新 settle_account
     *
     * @param userId 用户 ID
     * @param id 结算账户 ID
     * @param params 更新数据
     * @return SettleAccount
     * @throws AuthenticationException 认证异常
     * @throws InvalidRequestException 错误请求
     * @throws APIConnectionException 连接异常
     * @throws APIException 系统异常
     * @throws ChannelException 渠道异常
     * @throws RateLimitException 请求超限
     */
    public static SettleAccount update(String userId, String id, Map<String, Object> params)
            throws AuthenticationException, InvalidRequestException,
            APIConnectionException, APIException, ChannelException, RateLimitException {
        User.checkUserId(userId);
        return request(APIResource.RequestMethod.PUT, instanceURL(SettleAccount.class, userId, id), params, SettleAccount.class);
    }

    /**
     * 更新银行手机号
     *
     * @param userId 用户 ID
     * @param id 结算账号 ID
     * @param params 更新参数
     * @return SettleAccount
     * @throws AuthenticationException 认证异常
     * @throws InvalidRequestException 错误请求
     * @throws APIConnectionException 连接异常
     * @throws APIException 系统异常
     * @throws ChannelException 渠道异常
     * @throws RateLimitException 请求超限
     */
    public static SettleAccount updateMobile(String userId, String id, Map<String, Object> params) throws AuthenticationException,
            InvalidRequestException, APIConnectionException,
            APIException, ChannelException, RateLimitException {
        return request(RequestMethod.PUT, String.format("%s/mobile", instanceURL(SettleAccount.class, userId, id)),
                params, SettleAccount.class);
    }

    /**
     * 打款验证
     *
     * @param userId 用户 ID
     * @param id 结算账号 ID
     * @param params 参数
     * @return SettleAccount
     * @throws AuthenticationException 认证异常
     * @throws InvalidRequestException 错误请求
     * @throws APIConnectionException 连接异常
     * @throws APIException 系统异常
     * @throws ChannelException 渠道异常
     * @throws RateLimitException 请求超限
     */
    public static SettleAccount verify(String userId, String id, Map<String, Object> params) throws AuthenticationException,
            InvalidRequestException, APIConnectionException,
            APIException, ChannelException, RateLimitException {
        return request(RequestMethod.POST, String.format("%s/verify", instanceURL(SettleAccount.class, userId, id)),
                params, SettleAccount.class);
    }
}
