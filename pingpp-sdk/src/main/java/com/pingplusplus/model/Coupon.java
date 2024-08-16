package com.pingplusplus.model;

import com.pingplusplus.exception.PingppException;
import com.pingplusplus.net.APIResource;
import com.pingplusplus.net.RequestOptions;
import com.pingplusplus.net.UserBasedResource;

import java.util.Map;

public class Coupon extends UserBasedResource {
    String id;
    String object;
    String app;
    Integer actualAmount;
    CouponTemplate couponTemplate;
    Long created;
    Boolean livemode;
    Map<String, Object> metadata;
    String order;
    Boolean redeemed;
    Long timeEnd;
    Long timeStart;
    String user;
    Boolean valid;
    Integer userTimesCirculated;

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

    public Integer getActualAmount() {
        return actualAmount;
    }

    public void setActualAmount(Integer actualAmount) {
        this.actualAmount = actualAmount;
    }

    public CouponTemplate getCouponTemplate() {
        return couponTemplate;
    }

    public void setCouponTemplate(CouponTemplate couponTemplate) {
        this.couponTemplate = couponTemplate;
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

    public Map<String, Object> getMetadata() {
        return metadata;
    }

    public void setMetadata(Map<String, Object> metadata) {
        this.metadata = metadata;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public Boolean getRedeemed() {
        return redeemed;
    }

    public void setRedeemed(Boolean redeemed) {
        this.redeemed = redeemed;
    }

    public Long getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(Long timeEnd) {
        this.timeEnd = timeEnd;
    }

    public Long getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(Long timeStart) {
        this.timeStart = timeStart;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Boolean getValid() {
        return valid;
    }

    public void setValid(Boolean valid) {
        this.valid = valid;
    }

    public Integer getUserTimesCirculated() {
        return userTimesCirculated;
    }

    public void setUserTimesCirculated(Integer userTimesCirculated) {
        this.userTimesCirculated = userTimesCirculated;
    }

    /**
     * 创建 coupon
     *
     * @param userId
     * @param params
     * @return Coupon
     * @throws PingppException
     */
    public static Coupon create(String userId, Map<String, Object>params)
            throws PingppException {
        User.checkUserId(userId);
        return create(userId, params, null);
    }

    /**
     * 创建 coupon
     *
     * @param userId
     * @param params
     * @param options the specific options
     * @return Coupon
     * @throws PingppException
     */
    public static Coupon create(String userId, Map<String, Object>params, RequestOptions options)
            throws PingppException {
        User.checkUserId(userId);
        return APIResource.request(APIResource.RequestMethod.POST, classURL(Coupon.class, userId), params, Coupon.class, options);
    }

    /**
     * 查询 coupon
     *
     * @param userId
     * @param id
     * @return Coupon
     * @throws PingppException
     */
    public static Coupon retrieve(String userId, String id)
            throws PingppException {
        User.checkUserId(userId);
        return retrieve(userId, id, null);
    }

    /**
     * 查询 coupon
     *
     * @param userId
     * @param id
     * @param options the specific options
     * @return Coupon
     * @throws PingppException
     */
    public static Coupon retrieve(String userId, String id, RequestOptions options)
            throws PingppException {
        User.checkUserId(userId);
        return APIResource.request(APIResource.RequestMethod.GET, instanceURL(Coupon.class, userId, id), null, Coupon.class, options);
    }

    /**
     * 查询 coupon 列表
     *
     * @param userId
     * @param params
     * @return CouponCollection
     * @throws PingppException
     */
    public static CouponCollection list(String userId, Map<String, Object> params)
            throws PingppException {
        User.checkUserId(userId);
        return list(userId, params, null);
    }

    /**
     * 查询 coupon 列表
     *
     * @param userId
     * @param params
     * @param options the specific options
     * @return CouponCollection
     * @throws PingppException
     */
    public static CouponCollection list(String userId, Map<String, Object> params, RequestOptions options)
            throws PingppException {
        User.checkUserId(userId);
        return APIResource.request(APIResource.RequestMethod.GET, classURL(Coupon.class, userId), params, CouponCollection.class, options);
    }

    /**
     * 更新 coupon
     *
     * @param userId
     * @param id
     * @param params
     * @return Coupon
     * @throws PingppException
     */
    public static Coupon update(String userId, String id, Map<String, Object>params)
            throws PingppException {
        User.checkUserId(userId);
        return update(userId, id, params, null);
    }

    /**
     * 更新 coupon
     *
     * @param userId
     * @param id
     * @param params
     * @param options the specific options
     * @return Coupon
     * @throws PingppException
     */
    public static Coupon update(String userId, String id, Map<String, Object>params, RequestOptions options)
            throws PingppException {
        User.checkUserId(userId);
        return APIResource.request(APIResource.RequestMethod.PUT, instanceURL(Coupon.class, userId, id), params, Coupon.class, options);
    }

    /**
     * 删除 coupon
     *
     * @param userId
     * @param id
     * @return DeletedCoupon
     * @throws PingppException
     */
    public static DeletedCoupon delete(String userId, String id)
            throws PingppException {
        User.checkUserId(userId);
        return delete(userId, id, null);
    }

    /**
     * 删除 coupon
     *
     * @param userId
     * @param id
     * @param options the specific options
     * @return DeletedCoupon
     * @throws PingppException
     */
    public static DeletedCoupon delete(String userId, String id, RequestOptions options)
            throws PingppException {
        User.checkUserId(userId);
        return APIResource.request(APIResource.RequestMethod.DELETE, instanceURL(Coupon.class, userId, id), null, DeletedCoupon.class, options);
    }
}
