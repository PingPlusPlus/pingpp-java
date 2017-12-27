package com.pingplusplus.model;

import com.pingplusplus.exception.*;
import com.pingplusplus.net.APIResource;
import com.pingplusplus.net.AppBasedResource;

import java.util.Map;

public class CouponTemplate extends AppBasedResource {
    String id;
    String object;
    String app;
    Integer amountAvailable;
    Integer amountOff;
    Long created;
    CouponTemplateExpiration expiration;
    Boolean livemode;
    Integer maxCirculation;
    Integer maxUserCirculation;
    Map<String, Object> metadata;
    String name;
    Integer percentOff;
    Long timesCirculated;
    Long timesRedeemed;
    Integer type;
    Boolean refundable;

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

    public Integer getAmountAvailable() {
        return amountAvailable;
    }

    public void setAmountAvailable(Integer amountAvailable) {
        this.amountAvailable = amountAvailable;
    }

    public Integer getAmountOff() {
        return amountOff;
    }

    public void setAmountOff(Integer amountOff) {
        this.amountOff = amountOff;
    }

    public Long getCreated() {
        return created;
    }

    public void setCreated(Long created) {
        this.created = created;
    }

    public CouponTemplateExpiration getExpiration() {
        return expiration;
    }

    public void setExpiration(CouponTemplateExpiration expiration) {
        this.expiration = expiration;
    }

    public Boolean getLivemode() {
        return livemode;
    }

    public void setLivemode(Boolean livemode) {
        this.livemode = livemode;
    }

    public Integer getMaxCirculation() {
        return maxCirculation;
    }

    public void setMaxCirculation(Integer maxCirculation) {
        this.maxCirculation = maxCirculation;
    }

    public Map<String, Object> getMetadata() {
        return metadata;
    }

    public void setMetadata(Map<String, Object> metadata) {
        this.metadata = metadata;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPercentOff() {
        return percentOff;
    }

    public void setPercentOff(Integer percentOff) {
        this.percentOff = percentOff;
    }

    public Long getTimesCirculated() {
        return timesCirculated;
    }

    public void setTimesCirculated(Long timesCirculated) {
        this.timesCirculated = timesCirculated;
    }

    public Long getTimesRedeemed() {
        return timesRedeemed;
    }

    public void setTimesRedeemed(Long timesRedeemed) {
        this.timesRedeemed = timesRedeemed;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Boolean getRefundable() {
        return refundable;
    }

    public void setRefundable(Boolean refundable) {
        this.refundable = refundable;
    }

    public Integer getMaxUserCirculation() {
        return maxUserCirculation;
    }

    public void setMaxUserCirculation(Integer maxUserCirculation) {
        this.maxUserCirculation = maxUserCirculation;
    }

    /**
     * 创建 coupon_template
     *
     * @param params
     * @return CouponTemplate
     * @throws AuthenticationException
     * @throws InvalidRequestException
     * @throws APIConnectionException
     * @throws APIException
     * @throws ChannelException
     * @throws RateLimitException
     */
    public static CouponTemplate create(Map<String, Object>params)
            throws AuthenticationException, InvalidRequestException,
            APIConnectionException, APIException, ChannelException, RateLimitException {
        return request(APIResource.RequestMethod.POST, classURL(CouponTemplate.class), params, CouponTemplate.class);
    }

    /**
     * 查询 coupon_template
     *
     * @param id
     * @return CouponTemplate
     * @throws AuthenticationException
     * @throws InvalidRequestException
     * @throws APIConnectionException
     * @throws APIException
     * @throws ChannelException
     * @throws RateLimitException
     */
    public static CouponTemplate retrieve(String id)
            throws AuthenticationException, InvalidRequestException,
            APIConnectionException, APIException, ChannelException, RateLimitException {
        return request(APIResource.RequestMethod.GET, instanceURL(CouponTemplate.class, id), null, CouponTemplate.class);
    }

    /**
     * 查询 coupon_template 列表
     *
     * @param params
     * @return CouponTemplateCollection
     * @throws AuthenticationException
     * @throws InvalidRequestException
     * @throws APIConnectionException
     * @throws APIException
     * @throws ChannelException
     * @throws RateLimitException
     */
    public static CouponTemplateCollection list(Map<String, Object> params)
            throws AuthenticationException, InvalidRequestException,
            APIConnectionException, APIException, ChannelException, RateLimitException {
        return request(APIResource.RequestMethod.GET, classURL(CouponTemplate.class), params, CouponTemplateCollection.class);
    }

    /**
     * 更新 coupon_template
     *
     * @param params
     * @return CouponTemplate
     * @throws AuthenticationException
     * @throws InvalidRequestException
     * @throws APIConnectionException
     * @throws APIException
     * @throws ChannelException
     * @throws RateLimitException
     */
    public static CouponTemplate update(String id, Map<String, Object>params)
            throws AuthenticationException, InvalidRequestException,
            APIConnectionException, APIException, ChannelException, RateLimitException {
        return request(APIResource.RequestMethod.PUT, instanceURL(CouponTemplate.class, id), params, CouponTemplate.class);
    }

    /**
     * 删除 coupon_template
     *
     * @param id
     * @return DeletedCouponTemplate
     * @throws AuthenticationException
     * @throws InvalidRequestException
     * @throws APIConnectionException
     * @throws APIException
     * @throws ChannelException
     * @throws RateLimitException
     */
    public static DeletedCouponTemplate delete(String id)
            throws AuthenticationException, InvalidRequestException,
            APIConnectionException, APIException, ChannelException, RateLimitException {
        return request(APIResource.RequestMethod.DELETE, instanceURL(CouponTemplate.class, id), null, DeletedCouponTemplate.class);
    }

    public static String couponsURL(String tmplId) throws InvalidRequestException {
        return String.format("%s/coupons", instanceURL(CouponTemplate.class, tmplId));
    }

    /**
     * 批量创建 coupon
     *
     * @param id
     * @param params
     * @return CouponCollection
     * @throws AuthenticationException
     * @throws InvalidRequestException
     * @throws APIConnectionException
     * @throws APIException
     * @throws ChannelException
     * @throws RateLimitException
     */
    public static CouponCollection createCoupons(String id, Map<String, Object>params)
            throws AuthenticationException, InvalidRequestException,
            APIConnectionException, APIException, ChannelException, RateLimitException {
        return request(APIResource.RequestMethod.POST, couponsURL(id), params, CouponCollection.class);
    }

    /**
     * 查询 coupon 列表
     *
     * @param id
     * @param params
     * @return CouponCollection
     * @throws AuthenticationException
     * @throws InvalidRequestException
     * @throws APIConnectionException
     * @throws APIException
     * @throws ChannelException
     * @throws RateLimitException
     */
    public static CouponCollection listCoupons(String id, Map<String, Object>params)
            throws AuthenticationException, InvalidRequestException,
            APIConnectionException, APIException, ChannelException, RateLimitException {
        return request(APIResource.RequestMethod.GET, couponsURL(id), params, CouponCollection.class);
    }
}
