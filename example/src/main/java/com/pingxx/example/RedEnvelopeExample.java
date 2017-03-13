/* *
 * Ping++ Server SDK
 * 说明：
 * 以下代码只是为了方便商户测试而提供的样例代码，商户可根据自己网站需求按照技术文档编写, 并非一定要使用该代码。
 * 接入红包流程参考开发者中心：https://www.pingxx.com/docs/server/red-envelope ，文档可筛选后端语言和接入渠道。
 * 该代码仅供学习和研究 Ping++ SDK 使用，仅供参考。
*/
package com.pingxx.example;

import com.pingplusplus.exception.*;
import com.pingplusplus.model.RedEnvelope;
import com.pingplusplus.model.RedEnvelopeCollection;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * 该实例演示如何操作微信红包
 *
 * 开发者需要填写 apiKey 、appId 和 openid ,
 *
 * apiKey 有 TestKey 和 LiveKey 两种。
 *
 * TestKey 模式下不会产生真实的交易。
 *
 * openid 是发送红包的对象在公共平台下的 openid ,获得 openid 的方法可以参考微信文档：http://mp.weixin.qq.com/wiki/17/c0f37d5704f0b64713d5d2c37b468d75.html
 *
 */
public class RedEnvelopeExample {

    private String appId;
    /**
     * 微信用户在微信公共号的 openid
     */
    public static String openid = "USER_OPENID";// 用户在商户微信公众号下的唯一标识，获取方式可参考 WxPubOAuthExample.java

    RedEnvelopeExample(String appId) {
        this.appId = appId;
    }

    public static void runDemos(String appId) {

        RedEnvelopeExample redEnvelopeExample = new RedEnvelopeExample(appId);
        System.out.println("------- 创建 RedEnvelope -------");
        RedEnvelope redEnvelope = redEnvelopeExample.create();
        System.out.println("------- 查询 RedEnvelope -------");
        redEnvelopeExample.retrieve(redEnvelope.getId());
        System.out.println("------- 查询 RedEnvelope 列表 -------");
        redEnvelopeExample.list();
    }

    /**
     * 创建红包
     *
     * 创建红包需要传递一个 map 到 RedEnvelope.create(redenvelope)
     * map 里面的具体参数参考：https://www.pingxx.com/api#api-e-new
     * @return
     */
    public RedEnvelope create() {
        Map<String, Object> redenvelope = new HashMap<String, Object>();
        redenvelope.put("amount", 100);// 订单总金额, 人民币单位：分（如订单总金额为 1 元，此处请填 100，金额限制在 100 ~ 20000 之间，即 1 ~ 200 元）
        redenvelope.put("currency", "cny");
        redenvelope.put("subject", "Your Subject");
        redenvelope.put("body", "Your Body");
        String orderNo = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        redenvelope.put("order_no", orderNo);// 红包使用的商户订单号。wx_pub 规定为 1 ~ 28 位不能重复的数字
        redenvelope.put("channel", "wx_pub");// 目前支持 wx_pub
        redenvelope.put("recipient", openid);// 接收者 id， 为用户在 wx_pub 下的 open_id
        redenvelope.put("description", "Your Description");
        Map<String, String> app = new HashMap<String, String>();
        app.put("id", appId);
        redenvelope.put("app", app);
        Map<String, String> extra = new HashMap<String, String>();
        extra.put("send_name", "Send Name");// 商户名称，最多 32 个字节
        redenvelope.put("extra", extra);
        RedEnvelope red = null;
        try {
            red = RedEnvelope.create(redenvelope);
            System.out.println(red);
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
        return red;

    }

    /**
     * 查询红包
     *
     * 根据红包的 ID 查询红包。
     * 参考文档：https://www.pingxx.com/api#api-e-inquiry
     * @param id
     */
    public void retrieve(String id) {
        try {
            RedEnvelope redEnvelope = RedEnvelope.retrieve(id);
            System.out.println(redEnvelope);
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
    }

    /**
     * 批量查询红包
     *
     * 批量查询接口，默认一次查询 10 条。用户可以通过 limit 自定义查询数目，最多不超过 100 条。
     */
    public void list() {
        RedEnvelopeCollection redEnvelopeCollection = null;
        Map<String, Object> chargeParams = new HashMap<String, Object>();
        chargeParams.put("limit", 3);
        try {
            redEnvelopeCollection = RedEnvelope.list(chargeParams);
            System.out.println(redEnvelopeCollection);
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

    }
}
