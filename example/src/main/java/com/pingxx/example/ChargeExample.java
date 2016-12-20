/**
 * Ping++ Server SDK
 * 说明：
 * 以下代码只是为了方便商户测试而提供的样例代码，商户可根据自己网站需求按照技术文档编写, 并非一定要使用该代码。
 * 接入支付流程参考开发者中心：https://www.pingxx.com/docs/server/charge ，文档可筛选后端语言和接入渠道。
 * 该代码仅供学习和研究 Ping++ SDK 使用，仅供参考。
 */
package com.pingxx.example;

import java.util.*;

import com.pingplusplus.exception.APIConnectionException;
import com.pingplusplus.exception.APIException;
import com.pingplusplus.exception.AuthenticationException;
import com.pingplusplus.exception.ChannelException;
import com.pingplusplus.exception.InvalidRequestException;
import com.pingplusplus.exception.RateLimitException;
import com.pingplusplus.exception.PingppException;
import com.pingplusplus.model.Charge;
import com.pingplusplus.model.ChargeCollection;

/**
 * Charge 对象相关示例
 *
 * 该实例程序演示了如何从 Ping++ 服务器获得 charge ，查询 charge。
 *
 * 开发者需要填写 apiKey 和 appId ，
 *
 * apiKey 有 TestKey 和 LiveKey 两种。
 *
 * TestKey 模式下不会产生真实的交易。
 */
public class ChargeExample {

    private String appId;

    ChargeExample(String appId) {
        this.appId = appId;
    }

    public static void runDemos(String appId) {

        ChargeExample chargeExample = new ChargeExample(appId);
        System.out.println("------- 创建 charge -------");
        Charge charge = chargeExample.createCharge();
        System.out.println("------- 查询 charge -------");
        chargeExample.retrieve(charge.getId());
        System.out.println("------- 查询 charge 列表 -------");
        chargeExample.list();
    }

    /**
     * 创建 Charge
     *
     * 创建 Charge 用户需要组装一个 map 对象作为参数传递给 Charge.create();
     * map 里面参数的具体说明请参考：https://www.pingxx.com/api#api-c-new
     * @return Charge
     */
    public Charge createCharge() {
        Charge charge = null;
        Map<String, Object> chargeMap = new HashMap<String, Object>();
        chargeMap.put("amount", 100);//订单总金额, 人民币单位：分（如订单总金额为 1 元，此处请填 100）
        chargeMap.put("currency", "cny");
        chargeMap.put("subject", "Your Subject");
        chargeMap.put("body", "Your Body");
        String orderNo = new Date().getTime() + Main.randomString(7);
        chargeMap.put("order_no", orderNo);// 推荐使用 8-20 位，要求数字或字母，不允许其他字符
        chargeMap.put("channel", "alipay");// 支付使用的第三方支付渠道取值，请参考：https://www.pingxx.com/api#api-c-new
        chargeMap.put("client_ip", "127.0.0.1"); // 发起支付请求客户端的 IP 地址，格式为 IPV4，如: 127.0.0.1
        Map<String, String> app = new HashMap<String, String>();
        app.put("id", appId);
        chargeMap.put("app", app);

        Map<String, Object> extra = new HashMap<String, Object>();
//        extra.put("open_id", "USER_OPENID");
        chargeMap.put("extra", extra);
        try {
            //发起交易请求
            charge = Charge.create(chargeMap);
            // 传到客户端请先转成字符串 .toString(), 调该方法，会自动转成正确的 JSON 字符串
            String chargeString = charge.toString();
            System.out.println(chargeString);
        } catch (APIConnectionException e) {
            e.printStackTrace();
        } catch (ChannelException e) {
            e.printStackTrace();
        } catch (RateLimitException e) {
            e.printStackTrace();
        } catch (AuthenticationException e) {
            e.printStackTrace();
        } catch (APIException e) {
            e.printStackTrace();
        } catch (InvalidRequestException e) {
            e.printStackTrace();
        }
        return charge;
    }

    /**
     * 创建 Charge (微信公众号)
     *
     * 创建 Charge 用户需要组装一个 map 对象作为参数传递给 Charge.create();
     * map 里面参数的具体说明请参考：https://www.pingxx.com/api#api-c-new
     * @return Charge
     */
    public Charge createChargeWithOpenid(String openid) {
        Charge charge = null;
        Map<String, Object> chargeMap = new HashMap<String, Object>();
        chargeMap.put("amount", 100);//订单总金额, 人民币单位：分（如订单总金额为 1 元，此处请填 100）
        chargeMap.put("currency", "cny");
        chargeMap.put("subject", "Your Subject");
        chargeMap.put("body", "Your Body");
        String orderNo = new Date().getTime() + Main.randomString(7);
        chargeMap.put("order_no", orderNo);// 推荐使用 8-20 位，要求数字或字母，不允许其他字符
        chargeMap.put("channel", "wx_pub");// 支付使用的第三方支付渠道取值，请参考：https://www.pingxx.com/api#api-c-new
        chargeMap.put("client_ip", "127.0.0.1"); // 发起支付请求客户端的 IP 地址，格式为 IPV4，如: 127.0.0.1
        Map<String, String> app = new HashMap<String, String>();
        app.put("id", appId);
        chargeMap.put("app", app);

        Map<String, Object> extra = new HashMap<String, Object>();
        extra.put("open_id", openid);// 用户在商户微信公众号下的唯一标识，获取方式可参考 WxPubOAuthExample.java
        chargeMap.put("extra", extra);
        try {
            //发起交易请求
            charge = Charge.create(chargeMap);
            // 传到客户端请先转成字符串 .toString(), 调该方法，会自动转成正确的 JSON 字符串
            String chargeString = charge.toString();
            System.out.println(chargeString);
        } catch (PingppException e) {
            e.printStackTrace();
        }
        return charge;
    }

    /**
     * 查询 Charge
     *
     * 该接口根据 charge Id 查询对应的 charge 。
     * 参考文档：https://www.pingxx.com/api#api-c-inquiry
     *
     * 该接口可以传递一个 expand ， 返回的 charge 中的 app 会变成 app 对象。
     * 参考文档： https://www.pingxx.com/api#api-expanding
     * @param id
     */
    public Charge retrieve(String id) {
        Charge charge = null;
        try {
            Map<String, Object> params = new HashMap<String, Object>();
            charge = Charge.retrieve(id, params);
            System.out.println(charge);
        } catch (PingppException e) {
            e.printStackTrace();
        }

        return charge;
    }

    /**
     * 分页查询 Charge
     *
     * 该接口为批量查询接口，默认一次查询10条。
     * 用户可以通过添加 limit 参数自行设置查询数目，最多一次不能超过 100 条。
     *
     * 该接口同样可以使用 expand 参数。
     * @return chargeCollection
     */
    public ChargeCollection list() {
        ChargeCollection chargeCollection = null;
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("limit", 3);
        Map<String, String> app = new HashMap<String, String>();
        app.put("id", appId);
        params.put("app", app);

        try {
            chargeCollection = Charge.list(params);
            System.out.println(chargeCollection);
        } catch (AuthenticationException e) {
            e.printStackTrace();
        } catch (InvalidRequestException e) {
            e.printStackTrace();
        } catch (APIConnectionException e) {
            e.printStackTrace();
        } catch (APIException e) {
            e.printStackTrace();
        } catch (ChannelException e) {
            e.printStackTrace();
        } catch (RateLimitException e) {
            e.printStackTrace();
        }

        return chargeCollection;
    }
}
