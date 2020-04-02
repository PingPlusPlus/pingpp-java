package com.pingplusplus.model;

import com.pingplusplus.exception.InvalidRequestException;
import com.pingplusplus.exception.PingppException;
import com.pingplusplus.net.APIResource;
import com.pingplusplus.net.AppBasedResource;
import com.pingplusplus.net.RequestOptions;

import java.util.List;
import java.util.Map;

public class User extends AppBasedResource {
    String id;
    String object;
    String app;
    String address;
    Long availableBalance;
    Integer availableCoupons;
    String avatar;
    Long created;
    Boolean disabled;
    String email;
    String gender;
    Boolean identified;
    Boolean livemode;
    String mobile;
    String name;
    Map<String, Object> metadata;
    String relatedApp;
    List<SettleAccount> settleAccounts;
    String type;
    Long withdrawableBalance;
    Map<String, Object> identityInfo;
    Map<String, Object> extra;
    Long totalBalance;
    String parentUserId;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getAvailableCoupons() {
        return availableCoupons;
    }

    public void setAvailableCoupons(Integer availableCoupons) {
        this.availableCoupons = availableCoupons;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Long getAvailableBalance() {
        return availableBalance;
    }

    public void setAvailableBalance(Long availableBalance) {
        this.availableBalance = availableBalance;
    }

    public Long getCreated() {
        return created;
    }

    public void setCreated(Long created) {
        this.created = created;
    }

    public Boolean getDisabled() {
        return disabled;
    }

    public void setDisabled(Boolean disabled) {
        this.disabled = disabled;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Boolean getIdentified() {
        return identified;
    }

    public void setIdentified(Boolean identified) {
        this.identified = identified;
    }

    public Boolean getLivemode() {
        return livemode;
    }

    public void setLivemode(Boolean livemode) {
        this.livemode = livemode;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, Object> getMetadata() {
        return metadata;
    }

    public void setMetadata(Map<String, Object> metadata) {
        this.metadata = metadata;
    }

    public Long getWithdrawableBalance() {
        return withdrawableBalance;
    }

    public void setWithdrawableBalance(Long withdrawableBalance) {
        this.withdrawableBalance = withdrawableBalance;
    }

    public String getRelatedApp() {
        return relatedApp;
    }

    public void setRelatedApp(String relatedApp) {
        this.relatedApp = relatedApp;
    }

    public List<SettleAccount> getSettleAccounts() {
        return settleAccounts;
    }

    public void setSettleAccounts(List<SettleAccount> settleAccounts) {
        this.settleAccounts = settleAccounts;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Map<String, Object> getIdentityInfo() {
        return identityInfo;
    }

    public void setIdentityInfo(Map<String, Object> identityInfo) {
        this.identityInfo = identityInfo;
    }

    public Map<String, Object> getExtra() {
        return extra;
    }

    public void setExtra(Map<String, Object> extra) {
        this.extra = extra;
    }

    public Long getTotalBalance() {
        return totalBalance;
    }

    public void setTotalBalance(Long totalBalance) {
        this.totalBalance = totalBalance;
    }

    public String getParentUserId() {
        return parentUserId;
    }

    public void setParentUserId(String parentUserId) {
        this.parentUserId = parentUserId;
    }

    /**
     * 创建 user
     *
     * @param params
     * @return User
     * @throws PingppException
     */
    public static User create(Map<String, Object>params)
            throws PingppException {
        return create(params, null);
    }

    /**
     * 创建 user
     *
     * @param params
     * @param options the specific options
     * @return User
     * @throws PingppException
     */
    public static User create(Map<String, Object>params, RequestOptions options)
            throws PingppException {
        return APIResource.request(APIResource.RequestMethod.POST, classURL(User.class), params, User.class, options);
    }

    /**
     * 查询 user
     *
     * @param id
     * @return User
     * @throws PingppException
     */
    public static User retrieve(String id)
            throws PingppException {
        User.checkUserId(id);
        return retrieve(id, null);
    }

    /**
     * 查询 user
     *
     * @param id
     * @param options the specific options
     * @return User
     * @throws PingppException
     */
    public static User retrieve(String id, RequestOptions options)
            throws PingppException {
        User.checkUserId(id);
        return APIResource.request(APIResource.RequestMethod.GET, instanceURL(User.class, id), null, User.class, options);
    }

    /**
     * 查询 user 列表
     *
     * @param params
     * @return UserCollection
     * @throws PingppException
     */
    public static UserCollection list(Map<String, Object> params)
            throws PingppException {
        return list(params, null);
    }

    /**
     * 查询 user 列表
     *
     * @param params
     * @param options the specific options
     * @return UserCollection
     * @throws PingppException
     */
    public static UserCollection list(Map<String, Object> params, RequestOptions options)
            throws PingppException {
        return APIResource.request(APIResource.RequestMethod.GET, classURL(User.class), params, UserCollection.class, options);
    }

    /**
     * 更新 user
     *
     * @param id
     * @param params
     * @return User
     * @throws PingppException
     */
    public static User update(String id, Map<String, Object>params)
            throws PingppException {
        User.checkUserId(id);
        return update(id, params, null);
    }

    /**
     * 更新 user
     *
     * @param id
     * @param params
     * @param options the specific options
     * @return User
     * @throws PingppException
     */
    public static User update(String id, Map<String, Object>params, RequestOptions options)
            throws PingppException {
        User.checkUserId(id);
        return APIResource.request(APIResource.RequestMethod.PUT, instanceURL(User.class, id), params, User.class, options);
    }

    public static void checkUserId(String userId) throws InvalidRequestException {
        if (userId == null || userId.trim().length() == 0) {
            throw new InvalidRequestException(
                    "ID should not be null or empty.",
                    "invalid_request_error",
                    "request_param_error",
                    "user_id",
                    0,
                    null);
        }
    }
}
