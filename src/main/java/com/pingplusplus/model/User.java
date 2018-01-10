package com.pingplusplus.model;

import com.pingplusplus.exception.*;
import com.pingplusplus.net.APIResource;
import com.pingplusplus.net.AppBasedResource;

import java.util.List;
import java.util.Map;

public class User extends AppBasedResource {
    String id;
    String object;
    String app;
    String address;
    Integer availableBalance;
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
    Integer withdrawableBalance;

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

    public Integer getWithdrawableBalance() {
        return withdrawableBalance;
    }

    public void setWithdrawableBalance(Integer withdrawableBalance) {
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

    /**
     * 创建 user
     *
     * @param params
     * @return User
     * @throws AuthenticationException
     * @throws InvalidRequestException
     * @throws APIConnectionException
     * @throws APIException
     * @throws ChannelException
     * @throws RateLimitException
     */
    public static User create(Map<String, Object>params)
            throws AuthenticationException, InvalidRequestException,
            APIConnectionException, APIException, ChannelException, RateLimitException {
        return request(APIResource.RequestMethod.POST, classURL(User.class), params, User.class);
    }

    /**
     * 查询 user
     *
     * @param id
     * @return User
     * @throws AuthenticationException
     * @throws InvalidRequestException
     * @throws APIConnectionException
     * @throws APIException
     * @throws ChannelException
     * @throws RateLimitException
     */
    public static User retrieve(String id)
            throws AuthenticationException, InvalidRequestException,
            APIConnectionException, APIException, ChannelException, RateLimitException {
        User.checkUserId(id);
        return request(APIResource.RequestMethod.GET, instanceURL(User.class, id), null, User.class);
    }

    /**
     * 查询 user 列表
     *
     * @param params
     * @return UserCollection
     * @throws AuthenticationException
     * @throws InvalidRequestException
     * @throws APIConnectionException
     * @throws APIException
     * @throws ChannelException
     * @throws RateLimitException
     */
    public static UserCollection list(Map<String, Object> params)
            throws AuthenticationException, InvalidRequestException,
            APIConnectionException, APIException, ChannelException, RateLimitException {
        return request(APIResource.RequestMethod.GET, classURL(User.class), params, UserCollection.class);
    }

    /**
     * 更新 user
     *
     * @param id
     * @param params
     * @return User
     * @throws AuthenticationException
     * @throws InvalidRequestException
     * @throws APIConnectionException
     * @throws APIException
     * @throws ChannelException
     * @throws RateLimitException
     */
    public static User update(String id, Map<String, Object>params)
            throws AuthenticationException, InvalidRequestException,
            APIConnectionException, APIException, ChannelException, RateLimitException {
        User.checkUserId(id);
        return request(APIResource.RequestMethod.PUT, instanceURL(User.class, id), params, User.class);
    }

    public static void checkUserId(String userId) throws InvalidRequestException {
        if (userId == null || userId.trim().length() == 0) {
            throw new InvalidRequestException("ID should not be null or empty.", "user_id", null);
        }
    }
}
