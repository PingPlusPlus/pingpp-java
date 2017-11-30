package com.pingplusplus.order;

import com.pingplusplus.PingppAccountTestBase;
import com.pingplusplus.PingppAccountTestData;
import com.pingplusplus.exception.*;
import com.pingplusplus.model.DeleteRoyaltyTemplate;
import com.pingplusplus.model.RoyaltyTemplate;
import com.pingplusplus.model.RoyaltyTemplateCollection;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class RoyaltyTemplateTest extends PingppAccountTestBase {
    /**
     * 创建 royalty_template
     */
    @Test
    public void testRoyaltyTemplateCreate() throws RateLimitException,
            APIException, ChannelException, InvalidRequestException,
            APIConnectionException, AuthenticationException {
        Map<String, Object> params = new HashMap<>();
        params.put("app", PingppAccountTestData.getAppID()); // App ID, 必传
        params.put("name", "royalty_templates name"); // 模板名称，允许中英文等常用字符, 可选

        Map<String, Object> rule = new HashMap<>();
        rule.put("royalty_mode", "rate"); // 分润模式。分为按订单金额（包含优惠券金额）的比例 rate 和固定金额 fixed, 必传
        rule.put("refund_mode", "no_refund"); // 退分润模式。分为退款时不退分润 no_refund、按比例退分润 proportional 和一旦退款分润全退 full_refund, 必传
        // 分配模式。指当订单确定的层级如果少于模板配置层级时，模板中多余的分润金额是归属于收款方 receipt_reserved 还是服务方 service_reserved。
        // 必传
        rule.put("allocation_mode", "receipt_reserved");

        List<Map> data = new ArrayList<>(); // 分润数据列表, 必传
        Map<String, Object> data1 = new HashMap<>();
        data1.put("level", 0);  // 子商户层级值，0 表示平台， 1 表示一级子商户，取值范围 >=0
        data1.put("value", 11); // 分润数值。rate 下取值为 0 - 10000，单位为 0.01 %，fixed 下取值为 0 - 1000000，单位为分
        Map<String, Object> data2 = new HashMap<>();
        data2.put("level", 1);
        data2.put("value", 12);
        data.add(data1);
        data.add(data2);

        rule.put("data", data);
        params.put("rule", rule);

        // 创建 royalty_template 方法
        // 参数: params
        RoyaltyTemplate obj = RoyaltyTemplate.create(params);

        assertEquals("object should be royalty_template", "royalty_template", obj.getObject());
        assertEquals("name", params.get("name"), obj.getName());
    }

    /**
     * 查询单个 royalty_template
     */
    @Test public void testRoyaltyTemplateRetrieve() throws RateLimitException,
            APIException, ChannelException, InvalidRequestException,
            APIConnectionException, AuthenticationException {
        String id = "450170822152200001";
        // 查询单个 royalty_template 方法
        // 参数: royalty_template id
        RoyaltyTemplate obj = RoyaltyTemplate.retrieve(id);

        assertEquals("object should be royalty_template", "royalty_template", obj.getObject());
        assertEquals("id", id, obj.getId());
    }

    /**
     * 查询 royalty_template 列表
     */
    @Test public void testRoyaltyTemplateList() throws RateLimitException,
            APIException, ChannelException, InvalidRequestException,
            APIConnectionException, AuthenticationException {
        Map<String, Object> params = new HashMap<>();
        params.put("per_page", 3);
        params.put("page", 1);
        // 查询 royalty_template list 列表方法
        // 参数: params
        RoyaltyTemplateCollection objs = RoyaltyTemplate.list(params);

        assertEquals("object should be list", "list", objs.getObject());
    }

    /**
     * 删除 royalty_template
     */
    @Test public void testRoyaltyTemplateDelete() throws RateLimitException,
            APIException, ChannelException, InvalidRequestException,
            APIConnectionException, AuthenticationException {
        String id = "450170822185800001";
        // 删除 royalty_template 方法
        // 参数: royalty_template id
        DeleteRoyaltyTemplate obj = RoyaltyTemplate.delete(id);

        assertEquals("id", id, obj.getId());
    }

    /**
     *  更新 royalty_template
     */
    @Test public void testRoyaltyTemplateUpdate() throws RateLimitException,
            APIException, ChannelException, InvalidRequestException,
            APIConnectionException, AuthenticationException {
        Map<String, Object> params = new HashMap<>();
        params.put("name", "royalty_templates name new");

        Map<String, Object> rule = new HashMap<>();
        rule.put("royalty_mode", "rate");
        rule.put("refund_mode", "no_refund");
        rule.put("allocation_mode", "receipt_reserved");

        List<Map> data = new ArrayList<>();
        Map<String, Object> data1 = new HashMap<>();
        data1.put("level", 0);
        data1.put("value", 11);
        Map<String, Object> data2 = new HashMap<>();
        data2.put("level", 1);
        data2.put("value", 12);
        data.add(data1);
        data.add(data2);

        rule.put("data", data);
        params.put("rule", rule);
        RoyaltyTemplate obj = RoyaltyTemplate.update("450170822152200001", params);

        assertEquals("object should be royalty_template", "royalty_template", obj.getObject());
    }
}
