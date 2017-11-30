package com.pingplusplus.recharge;

import com.pingplusplus.PingppAccountTestBase;
import com.pingplusplus.exception.*;
import com.pingplusplus.model.*;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class RechargeTest extends PingppAccountTestBase {
    /**
     * 创建 recharge
     */
    @Test
    public void testRechargeCreate() throws RateLimitException,
            APIException, ChannelException, InvalidRequestException,
            APIConnectionException, AuthenticationException {
        Map<String, Object> params = new HashMap<>();
        params.put("user", "user_test_02"); // 充值目标用户 ID, 必传
        params.put("user_fee", 10);     // 用户充值收取的手续费，单位分，不得大于 amount，不可和 balance_bonus[amount] 同时传，默认 0。可选
        params.put("description", "Recharge description."); // 描述, 可选
        Map<String, Object> charge = new HashMap<>();
        charge.put("amount", 100); // 用户实际支付金额，单位分, 必传
        charge.put("channel", "alipay_wap"); // 支付使用的第三方支付渠道, 必传
        charge.put("order_no", "2017" + System.currentTimeMillis()); // 商户订单号，适配每个渠道对此参数的要求，必须在商户系统内唯一, 必传
        charge.put("client_ip", "127.0.0.1");   // 客户端的 IP，IPv4，默认 127.0.0.1, 可选
        charge.put("subject", "Recharge subject"); // 充值标题，该参数最长为 32 个 Unicode 字符, 必传
        charge.put("body", "Recharge body"); // 充值描述信息，该参数最长为 128 个 Unicode 字符, 必传
        Map<String, Object> extra = new HashMap<>(); // extra: 根据不同渠道传入相应的参数
        extra.put("success_url", "http://www.pingxx.com");
        charge.put("extra", extra);
        params.put("charge", charge);
        Recharge obj = Recharge.create(params); // 创建 recharge 方法
        assertEquals("object should be recharge", "recharge", obj.getObject());
    }

    /**
     * 查询单个 recharge
     */
    @Test public void testRechargeRetrieve() throws RateLimitException,
            APIException, ChannelException, InvalidRequestException,
            APIConnectionException, AuthenticationException {
        // 查询单个 recharge 方法
        // 参数: rechargeId
        Recharge obj = Recharge.retrieve("220170822678080532480001");

        assertEquals("object should be recharge", "recharge", obj.getObject());
    }

    /**
     * 查询 recharge 列表
     */
    @Test public void testRechargeList() throws RateLimitException,
            APIException, ChannelException, InvalidRequestException,
            APIConnectionException, AuthenticationException {
        Map<String, Object> params = new HashMap<>();
        params.put("page", 1);
        params.put("per_page", 10);
        params.put("succeeded", true); // 是否已充值成功
        params.put("refunded", true); // 是否存在退款 (跟是否退款成功没有关系)
        // 查询 recharge 列表方法
        // 参数: params
        RechargeCollection objs = Recharge.list(params);

        assertEquals("object should be list", "list", objs.getObject());
    }

    /**
     * 创建 recharge_refund
     */
    @Test public void testRechargeRefundCreate() throws RateLimitException,
            APIException, ChannelException, InvalidRequestException,
            APIConnectionException, AuthenticationException {
        Map<String, Object> params = new HashMap<>();
        params.put("description", "Recharge Refund Description"); // 必传
        // 创建 recharge_refund 方法
        // 参数一: rechargeId
        // 参数二: params
        Refund obj = RechargeRefund.create("220170822678080532480001", params);

        assertEquals("object should be refund", "refund", obj.getObject());
    }

    /**
     * 查询单个 recharge_refund
     */
    @Test public void testRechargeRefundRetrieve() throws RateLimitException,
            APIException, ChannelException, InvalidRequestException,
            APIConnectionException, AuthenticationException {
        // 查询单个 recharge_refund 方法
        // 参数一: rechargeId
        // 参数二: refundId
        Refund obj = RechargeRefund.retrieve("220170822360378572800001", "re_q5CmjDb1Ge9Sr580K4W10CaP");

        assertEquals("object should be refund", "refund", obj.getObject());
    }

    /**
     * 查询 recharge_refund 列表
     */
    @Test public void testRechargeRefundList() throws RateLimitException,
            APIException, ChannelException, InvalidRequestException,
            APIConnectionException, AuthenticationException {
        Map<String, Object> params = new HashMap<>();
        params.put("page", 1);
        params.put("per_page", 3);
        // 查询 recharge_refund 列表方法
        // 参数一: rechargeId
        // 参数二: params
        RechargeRefundCollection objs = RechargeRefund.list("220170822360378572800001", params);
        assertEquals("object should be list", "list", objs.getObject());
    }
}
