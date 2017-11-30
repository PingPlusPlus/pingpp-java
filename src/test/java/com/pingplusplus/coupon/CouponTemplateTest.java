package com.pingplusplus.coupon;

import com.pingplusplus.PingppAccountTestBase;
import com.pingplusplus.exception.*;
import com.pingplusplus.model.CouponTemplate;
import com.pingplusplus.model.CouponTemplateCollection;
import com.pingplusplus.model.DeletedCouponTemplate;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class CouponTemplateTest extends PingppAccountTestBase {
    /**
     * 创建优惠券模板
     */
    @Test
    public void testCouponTemplateCreate() throws RateLimitException,
            APIException, ChannelException, InvalidRequestException,
            APIConnectionException, AuthenticationException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("name", "25%OFF"); // 优惠券模板名称, 可选
        params.put("type", 2);        // 优惠券模板的类型 1：现金券；2：折扣券, 必传
        params.put("percent_off", 25); // 折扣百分比, 如 20 表示 8 折, 100 表示免费。当 type 为 2 时，必传。
        params.put("amount_available", 1000); // 订单金额大于等于该值时，优惠券有效（适用于满减）；0 表示无限制, 可选
        params.put("max_circulation", 1000); // 优惠券最大生成数量，当已生成数量达到最大值时，不能再生成优惠券；默认 null，表示可以无限生成, 可选
        Map<String, Object> metadata = new HashMap<String, Object>();
        metadata.put("custom_key", "custom_value");
        params.put("metadata", metadata);
        Map<String, Object> expiration = new HashMap<String, Object>();
        Long duration = new Long(2592000);
        expiration.put("duration", duration);
        params.put("expiration", expiration); // 优惠券模板过期策略

        CouponTemplate obj = CouponTemplate.create(params);

        assertEquals("object should be coupon_template", "coupon_template", obj.getObject());
        assertEquals("amount_available", params.get("amount_available"), obj.getAmountAvailable());
        assertEquals("max_circulation", params.get("max_circulation"), obj.getMaxCirculation());
        assertEquals("type", params.get("type"), obj.getType());
        assertEquals("name", params.get("name"), obj.getName());
        assertEquals("percent_off", params.get("percent_off"), obj.getPercentOff());
        assertEquals("expiration duration", expiration.get("duration"), obj.getExpiration().getDuration());
        assertEquals("times_circulated", 0, obj.getTimesCirculated().intValue());
        assertEquals("times_redeemed", 0, obj.getTimesRedeemed().intValue());
    }

    /**
     * 查询优惠券模板
     */
    @Test public void testCouponTemplateRetrieve() throws RateLimitException,
            APIException, ChannelException, InvalidRequestException,
            APIConnectionException, AuthenticationException {
        String couponTemplateId = "300117082315262900016402";
        // 查询优惠券模板方法
        // 参数: couponTemplateId (优惠券模板 id)
        CouponTemplate obj = CouponTemplate.retrieve(couponTemplateId);

        assertEquals("object should be coupon_template", "coupon_template", obj.getObject());
    }

    /**
     * 查询优惠券模板列表
     */
    @Test public void testCouponTemplateList() throws RateLimitException,
            APIException, ChannelException, InvalidRequestException,
            APIConnectionException, AuthenticationException {
        Map<String, Object> params = new HashMap<>();
        params.put("page", 1);
        params.put("per_page", 3);
        // 查询优惠券模板列表
        // 参数: params
        CouponTemplateCollection objs = CouponTemplate.list(params);

        assertEquals("object should be list", "list", objs.getObject());
    }

    /**
     * 更新优惠券模板
     */
    @Test public void testCouponTemplateUpdate() throws RateLimitException,
            APIException, ChannelException, InvalidRequestException,
            APIConnectionException, AuthenticationException {
        String couponTemplateId = "300117082315262900016402";
        Map<String, Object> params = new HashMap<>();
        Map<String, Object> metadata = new HashMap<>();
        metadata.put("key1", "value1");
        params.put("metadata", metadata);
        // 更新优惠券模板方法
        // 参数: couponTemplateId (优惠券模板 id)
        CouponTemplate obj = CouponTemplate.update(couponTemplateId, params);

        assertEquals("object should be coupon_template", "coupon_template", obj.getObject());
    }

    /**
     * 删除优惠券模板
     */
    @Test public void testCouponTemplateDelete() throws RateLimitException,
            APIException, ChannelException, InvalidRequestException,
            APIConnectionException, AuthenticationException {
        String couponTemplateId = "300117082315262900016402";
        // 删除优惠券模板方法
        // 参数: couponTemplateId (优惠券模板 id)
        DeletedCouponTemplate obj = CouponTemplate.delete(couponTemplateId);

        assertEquals("id", couponTemplateId, obj.getId());
    }
}
