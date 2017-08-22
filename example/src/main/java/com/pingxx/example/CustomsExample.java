/**
 * Ping++ Server SDK
 * 说明：
 * 以下代码只是为了方便商户测试而提供的样例代码，商户可根据自己网站需求按照技术文档编写, 并非一定要使用该代码。
 * 接入支付流程参考开发者中心：https://www.pingxx.com/docs/server/charge ，文档可筛选后端语言和接入渠道。
 * 该代码仅供学习和研究 Ping++ SDK 使用，仅供参考。
 */
package com.pingxx.example;

import com.pingplusplus.Pingpp;
import com.pingplusplus.exception.*;
import com.pingplusplus.model.Charge;
import com.pingplusplus.model.ChargeCollection;
import com.pingplusplus.model.Customs;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Customs 对象相关示例
 *
 * 该实例程序演示了如何从 Ping++ 服务器创建 customs ，查询 customs。
 *
 * 开发者需要填写 apiKey 和 appId ，
 *
 * apiKey 有 TestKey 和 LiveKey 两种。
 *
 * 报关（customs）仅支持 Live 模式。
 */
public class CustomsExample {

    private String appId;

    CustomsExample(String appId) {
        this.appId = appId;
    }

    public static void runDemos(String appId) {
        CustomsExample example = new CustomsExample(appId);
        System.out.println("------- 报关 customs 仅支持 live 模式 -------");

//        System.out.println("------- 创建 customs -------");
//        Customs obj = example.createCustoms();
//        System.out.println("------- 查询 customs -------");
//        example.retrieve(obj.getId());
    }

    /**
     * 创建 Customs
     *
     * 创建 Customs 用户需要组装一个 map 对象作为参数传递给 Customs.create();
     * map 里面参数的具体说明请参考：https://www.pingxx.com/api
     * @return Charge
     */
    public Customs createCustoms() {
        Customs obj = null;
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("channel", "alipay");
        String orderNo = new Date().getTime() + Main.randomString(7);
        params.put("trade_no", orderNo); // 8-20 位，要求数字或字母，不允许其他字符
        params.put("customs_code", "SHANGHAI"); // https://www.pingxx.com/api#海关编号说明
        params.put("amount", 10000); // 报关金额, 人民币单位：分（如金额为 100 元，此处请填 10000）
        params.put("charge", "<CH_ID>");
        params.put("app", appId);
        Map<String, Object> extra = new HashMap<String, Object>();
        // 根据不同渠道传不同参数
        // extra.put("pay_account", "<PAY_ACCOUNT>");
        // extra.put("certif_type", "01"); // https://www.pingxx.com/api#报关接口
        // extra.put("customer_name", "<NAME>");
        // extra.put("certif_id", "<CERTIF_ID>");
        params.put("extra", extra);

        try {
            //发起交易请求
            obj = Customs.create(params);
            System.out.println(obj);
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
        return obj;
    }

    /**
     * 查询 Customs
     *
     * 参考文档：https://www.pingxx.com/api
     *
     * @param id
     */
    public Customs retrieve(String id) {
        Customs obj = null;
        try {
            obj = Customs.retrieve(id);
            System.out.println(obj);
        } catch (PingppException e) {
            e.printStackTrace();
        }

        return obj;
    }
}
