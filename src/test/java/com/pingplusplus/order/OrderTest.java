package com.pingplusplus.order;

import com.pingplusplus.PingppAccountTestBase;
import com.pingplusplus.PingppAccountTestData;
import com.pingplusplus.exception.*;
import com.pingplusplus.model.*;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/*
 * @author Afon, @date 17-03-28
 */
public class OrderTest extends PingppAccountTestBase {

    /**
     * 创建 order
     */
    @Test public void testCreateOrder() throws RateLimitException,
            APIException, ChannelException, InvalidRequestException,
            APIConnectionException, AuthenticationException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("uid", "test_user_001"); // 用户在当前 app 下的 User ID, 可选
        params.put("app", PingppAccountTestData.getAppID()); // App ID, 必传
        params.put("merchant_order_no", "2017" + System.currentTimeMillis()); // 商户订单号, 必传
        params.put("subject", "ORDER_SUBJECT"); // 商品的标题, 必传
        params.put("body", "ORDER_BODY"); // 商品的描述信息, 必传
        params.put("amount", 100); // 订单总金额，单位：分, 必传
        params.put("currency", "cny"); // 仅支持人民币 cny, 必传
        params.put("client_ip", "192.168.1.125"); // 客户端的 IP 地址 (IPv4 格式，要求商户上传真实的，渠道可能会判断), 必传

        Order obj = Order.create(params); // 创建 Order 对象 方法

        assertEquals("object should be order", "order", obj.getObject());
        assertEquals("amount", ((Integer)params.get("amount")).intValue(), obj.getAmount().intValue());
        assertEquals("app", params.get("app"), obj.getApp());
        assertEquals("user ID", params.get("uid"), obj.getUid());
        assertEquals("merchant_order_no", params.get("merchant_order_no"), obj.getMerchantOrderNo());
        assertEquals("subject", params.get("subject"), obj.getSubject());
        assertEquals("body", params.get("body"), obj.getBody());
    }

    /**
     * 支付 order
     */
    @Test public void testPayOrder() throws RateLimitException,
            APIException, ChannelException, InvalidRequestException,
            APIConnectionException, AuthenticationException {
        Map<String, Object> params = new HashMap<>();
        params.put("channel", "alipay_wap");
        params.put("charge_amount", 100);
        Map<String, Object> extra = new HashMap<>(); // extra: 根据各个渠道传入相应的参数
        extra.put("success_url", "http://www.pingxx.com");
        params.put("extra", extra);
        Order order = Order.pay("2001708220000281981", params); // 创建支付 Order 对象 方法

        assertEquals("object should be order", "order", order.getObject());
    }

    /**
     * 取消 order
     */
    @Test public void testCancelOrder() throws RateLimitException,
            APIException, ChannelException, InvalidRequestException,
            APIConnectionException, AuthenticationException {
        Order order = Order.cancel("2001708220000280391"); // 取消 Order 对象方法

        assertEquals("object should be order", "order", order.getObject());
    }

    /**
     * 查询单个 order
     */
    @Test public void testOrderRetrieve() throws RateLimitException,
            APIException, ChannelException, InvalidRequestException,
            APIConnectionException, AuthenticationException {
        Order obj = Order.retrieve("2001708220000281981"); // 查询单个 order 方法  参数: orderId

        assertNotNull(obj);
        assertEquals("object should be order", "order", obj.getObject());
    }

    /**
     * 获取 order 列表
     */
    @Test public void testGetOrderList() throws RateLimitException,
            APIException, ChannelException, InvalidRequestException,
            APIConnectionException, AuthenticationException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("page", 1);
        params.put("per_page", 3);
        params.put("paid", false);
        params.put("app", PingppAccountTestData.getAppID());
        params.put("refunded", false);

        OrderCollection objs = Order.list(params); //查询 order 列表方法

        assertEquals("object should be list", "list", objs.getObject());
        assertEquals("data count should be same with limit", ((Integer)params.get("per_page")).intValue(), objs.getData().size());
    }

    /**
     * 查询订单中 Charge 对象
     */
    @Test public void testOrderChargeRetrieve() throws RateLimitException,
            APIException, ChannelException, InvalidRequestException,
            APIConnectionException, AuthenticationException {
        // 查询订单中 Charge 对象
        // 参数一: order id
        // 参数二: charge id
        Charge obj = Order.retrieveCharge("2001708220000221911", "ch_88mbTKu9mbn9mfT4KSCiHiX5");
        assertEquals("object should be charge", "charge", obj.getObject());
    }

    /**
     * 查询订单中 Charge 列表
     */
    @Test public void testOrderChargeList() throws RateLimitException,
            APIException, ChannelException, InvalidRequestException,
            APIConnectionException, AuthenticationException {
        Map<String, Object> params = new HashMap<>();
        params.put("page", 1);
        params.put("per_page", 10);

        // 查询订单中 Charge 列表
        // 参数一: orderId
        // 参数二: params
        ChargeCollection objs = Order.chargeList("2001708220000221911", params);
        assertEquals("object should be list", "list", objs.getObject());
    }

    /**
     * 创建 order 退款
     */
    @Test public void testOrderRefundCreate() throws RateLimitException,
            APIException, ChannelException, InvalidRequestException,
            APIConnectionException, AuthenticationException {

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("description", "Order refund test."); // 必传
        params.put("refund_mode", "to_source");

        // 创建 order 退款方法
        // 参数一: orderId
        // 参数二: params
        OrderRefundCollection objs = OrderRefund.create("2001708220000281981", params);

        assertEquals("object should be list", "list", objs.getObject());
    }

    /**
     * 查询 order 退款
     */
    @Test public void testOrderRefundRetrieve() throws RateLimitException,
            APIException, ChannelException, InvalidRequestException,
            APIConnectionException, AuthenticationException {
        // 查询 order 退款方法
        // 参数一: orderId
        // 参数二: refundId
        Refund obj = OrderRefund.retrieve("2001708220000258501", "re_5GefjD14GW50qrT40Gq9KmPS");
        assertEquals("object should be refund", "refund", obj.getObject());
    }

    /**
     * 查询 order 退款列表
     */
    @Test public void testOrderRefundList() throws RateLimitException,
            APIException, ChannelException, InvalidRequestException,
            APIConnectionException, AuthenticationException {

        // 查询 order 退款列表
        // 参数: orderId
        OrderRefundCollection objs = OrderRefund.list("2001708220000258501");
        assertEquals("object should be list", "list", objs.getObject());
    }
}
