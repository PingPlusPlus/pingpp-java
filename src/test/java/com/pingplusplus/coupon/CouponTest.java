package com.pingplusplus.coupon;

import com.pingplusplus.PingppAccountTestBase;
import com.pingplusplus.exception.*;
import com.pingplusplus.model.Coupon;
import com.pingplusplus.model.CouponCollection;
import com.pingplusplus.model.CouponTemplate;
import com.pingplusplus.model.DeletedCoupon;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class CouponTest extends PingppAccountTestBase {
    /**
     * 创建单个优惠券 Coupon
     */
    @Test
    public void testCouponCreate() throws RateLimitException,
            APIException, ChannelException, InvalidRequestException,
            APIConnectionException, AuthenticationException {
        String userId = "test_user_001"; // 用户 ID, 必传
        Map<String, Object> params = new HashMap<>();
        params.put("coupon_template", "300117082315262900016402"); // 优惠券模板 id, 必传
        // 创建优惠券 Coupon 方法
        // 参数一: userId
        // 参数二: params
        Coupon obj = Coupon.create(userId, params);

        assertEquals("object should be coupon", "coupon", obj.getObject());
    }

    /**
     * 批量创建优惠券
     */
    @Test public void testCouponBatchCreate() throws RateLimitException,
            APIException, ChannelException, InvalidRequestException,
            APIConnectionException, AuthenticationException {
        String couponId = "300117082315262900016402"; // 优惠券模板 id
        Map<String, Object> params = new HashMap<>();
        List<String> users = new ArrayList<>(); // 用户 ID 列表
        users.add("test_user_002");
        params.put("users", users);
        CouponCollection objs = CouponTemplate.createCoupons(couponId, params);

        assertEquals("object should be list", "list", objs.getObject());
    }

    /**
     * 查询单个优惠券 Coupon
     */
    @Test public void testCouponRetrieve() throws RateLimitException,
            APIException, ChannelException, InvalidRequestException,
            APIConnectionException, AuthenticationException {
        String userId = "test_user_001";
        String couponId = "300317082315265100025202";
        // 查询单个优惠券 Coupon
        // 参数一: userId
        // 参数二: couponId (优惠券 id)
        Coupon obj = Coupon.retrieve(userId, couponId);

        assertEquals("object should be coupon", "coupon", obj.getObject());
    }

    /**
     * 查询用户优惠券 Coupon 列表
     */
    @Test public void testUserCouponList() throws RateLimitException,
            APIException, ChannelException, InvalidRequestException,
            APIConnectionException, AuthenticationException {
        String userId = "test_user_001";
        Map<String, Object> params = new HashMap<>();
        params.put("page", 1);
        params.put("per_page", 3);
        // 查询用户优惠券 Coupon 列表方法
        // 参数一: userId
        // 参数二: params
        CouponCollection objs = Coupon.list(userId, params);

        assertEquals("object should be list", "list", objs.getObject());
    }

    /**
     * 查询优惠券模板下的优惠券列表
     */
    @Test public void testCouponList() throws RateLimitException,
            APIException, ChannelException, InvalidRequestException,
            APIConnectionException, AuthenticationException {
        String couponId = "300117082315262900016402";
        Map<String, Object> params = new HashMap<>();
        params.put("page", 1);
        params.put("per_page", 3);
        // 查询优惠券模板下的优惠券列表
        // 参数一: userId
        // 参数二: params
        CouponCollection objs = CouponTemplate.listCoupons(couponId, params);

        assertEquals("object should be list", "list", objs.getObject());
    }

    /**
     * 更新优惠券 Coupon
     */
    @Test public void testCouponUpdate() throws RateLimitException,
            APIException, ChannelException, InvalidRequestException,
            APIConnectionException, AuthenticationException {
        String userId = "test_user_001";
        String couponId = "300317082315265100025202";
        Map<String, Object> params = new HashMap<>();
        Map<String, Object> metadata = new HashMap<>();
        metadata.put("key1", "value1");
        params.put("metadata", metadata);

        // 更新优惠券 Coupon 方法
        // 参数一: userId
        // 参数二: couponId (优惠券 id)
        // 参数三: params
        Coupon obj = Coupon.update(userId, couponId, params);

        assertEquals("object should be coupon", "coupon", obj.getObject());
    }

    /**
     * 删除优惠券 Coupon
     */
    @Test public void testCouponDelete() throws RateLimitException,
            APIException, ChannelException, InvalidRequestException,
            APIConnectionException, AuthenticationException {
        String userId = "test_user_001";
        String couponId = "300317022810293600038701";
        // 删除优惠券 Coupon
        // 参数一: userId
        // 参数二: couponId (优惠券 id)
        DeletedCoupon obj = Coupon.delete(userId, couponId);

        assertEquals("id", couponId, obj.getId());
    }
}
