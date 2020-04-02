package com.pingplusplus.model;

import com.pingplusplus.exception.PingppException;
import com.pingplusplus.net.APIResource;
import com.pingplusplus.net.RequestOptions;
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
     * @throws PingppException
     */
    public static SettleAccount create(String userId, Map<String, Object>params)
            throws PingppException {
        User.checkUserId(userId);
        return create(userId, params, null);
    }

    /**
     * 创建 settle_account
     *
     * @param userId
     * @param params
     * @param options the specific options
     * @return SettleAccount
     * @throws PingppException
     */
    public static SettleAccount create(String userId, Map<String, Object>params, RequestOptions options)
            throws PingppException {
        User.checkUserId(userId);
        return APIResource.request(APIResource.RequestMethod.POST, classURL(SettleAccount.class, userId), params, SettleAccount.class, options);
    }

    /**
     * 查询 settle_account
     *
     * @param userId
     * @param id
     * @return SettleAccount
     * @throws PingppException
     */
    public static SettleAccount retrieve(String userId, String id)
            throws PingppException {
        User.checkUserId(userId);
        return retrieve(userId, id, null);
    }

    /**
     * 查询 settle_account
     *
     * @param userId
     * @param id
     * @param options the specific options
     * @return SettleAccount
     * @throws PingppException
     */
    public static SettleAccount retrieve(String userId, String id, RequestOptions options)
            throws PingppException {
        User.checkUserId(userId);
        return APIResource.request(APIResource.RequestMethod.GET, instanceURL(SettleAccount.class, userId, id), null, SettleAccount.class, options);
    }

    /**
     * 查询 settle_account 列表
     *
     * @param userId
     * @param params
     * @return SettleAccountCollection
     * @throws PingppException
     */
    public static SettleAccountCollection list(String userId, Map<String, Object> params)
            throws PingppException {
        User.checkUserId(userId);
        return list(userId, params, null);
    }

    /**
     * 查询 settle_account 列表
     *
     * @param userId
     * @param params
     * @param options the specific options
     * @return SettleAccountCollection
     * @throws PingppException
     */
    public static SettleAccountCollection list(String userId, Map<String, Object> params, RequestOptions options)
            throws PingppException {
        User.checkUserId(userId);
        return APIResource.request(APIResource.RequestMethod.GET, classURL(SettleAccount.class, userId), params, SettleAccountCollection.class, options);
    }

    /**
     * 删除 settle_account
     *
     * @param userId
     * @param id
     * @return DeletedSettleAccount
     * @throws PingppException
     */
    public static DeletedSettleAccount delete(String userId, String id)
            throws PingppException {
        User.checkUserId(userId);
        return delete(userId, id, null);
    }

    /**
     * 删除 settle_account
     *
     * @param userId
     * @param id
     * @param options the specific options
     * @return DeletedSettleAccount
     * @throws PingppException
     */
    public static DeletedSettleAccount delete(String userId, String id, RequestOptions options)
            throws PingppException {
        User.checkUserId(userId);
        return APIResource.request(APIResource.RequestMethod.DELETE, instanceURL(SettleAccount.class, userId, id), null, DeletedSettleAccount.class, options);
    }

    /**
     * 更新 settle_account
     *
     * @param userId 用户 ID
     * @param id 结算账户 ID
     * @param params 更新数据
     * @return SettleAccount
     * @throws PingppException
     */
    public static SettleAccount update(String userId, String id, Map<String, Object> params)
            throws PingppException {
        User.checkUserId(userId);
        return update(userId, id, params, null);
    }

    /**
     * 更新 settle_account
     *
     * @param userId 用户 ID
     * @param id 结算账户 ID
     * @param params 更新数据
     * @param options the specific options
     * @return SettleAccount
     * @throws PingppException
     */
    public static SettleAccount update(String userId, String id, Map<String, Object> params, RequestOptions options)
            throws PingppException {
        User.checkUserId(userId);
        return APIResource.request(APIResource.RequestMethod.PUT, instanceURL(SettleAccount.class, userId, id), params, SettleAccount.class, options);
    }

    /**
     * 更新银行手机号
     *
     * @param userId 用户 ID
     * @param id 结算账号 ID
     * @param params 更新参数
     * @return SettleAccount
     * @throws PingppException
     */
    public static SettleAccount updateMobile(String userId, String id, Map<String, Object> params) throws PingppException {
        return updateMobile(userId, id, params, null);
    }

    /**
     * 更新银行手机号
     *
     * @param userId 用户 ID
     * @param id 结算账号 ID
     * @param params 更新参数
     * @param options the specific options
     * @return SettleAccount
     * @throws PingppException
     */
    public static SettleAccount updateMobile(String userId, String id, Map<String, Object> params, RequestOptions options) throws PingppException {
        return APIResource.request(APIResource.RequestMethod.PUT, String.format("%s/mobile", instanceURL(SettleAccount.class, userId, id)),
                params, SettleAccount.class, options);
    }

    /**
     * 打款验证
     *
     * @param userId 用户 ID
     * @param id 结算账号 ID
     * @param params 参数
     * @return SettleAccount
     * @throws PingppException
     */
    public static SettleAccount verify(String userId, String id, Map<String, Object> params) throws PingppException {
        return verify(userId, id, params, null);
    }

    /**
     * 打款验证
     *
     * @param userId 用户 ID
     * @param id 结算账号 ID
     * @param params 参数
     * @param options the specific options
     * @return SettleAccount
     * @throws PingppException
     */
    public static SettleAccount verify(String userId, String id, Map<String, Object> params, RequestOptions options) throws PingppException {
        return APIResource.request(APIResource.RequestMethod.POST, String.format("%s/verify", instanceURL(SettleAccount.class, userId, id)),
                params, SettleAccount.class, options);
    }
}
