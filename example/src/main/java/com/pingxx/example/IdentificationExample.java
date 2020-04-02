package com.pingxx.example;

import com.pingplusplus.exception.PingppException;
import com.pingplusplus.model.Identification;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * 身份证银行卡信息认证接口参考文档：https://www.pingxx.com/api#身份证银行卡信息认证接口
 *
 * 该实例演示如何调用身份证银行卡信息认证接口
 *
 */
public class IdentificationExample {

    private String appId;

    IdentificationExample(String appId) {
        this.appId = appId;
    }

    public static void runDemos(String appId) {
        IdentificationExample eventExample = new IdentificationExample(appId);
        System.out.println("------- 认证身份证信息 -------");
        eventExample.identifyIdCard();

        System.out.println("------- 认证银行卡信息 -------");
        eventExample.identifyBankCard();
    }

    /**
     * 认证身份证信息
     *
     * 参考文档：https://www.pingxx.com/api#请求认证接口
     */
    public void identifyIdCard() {
        try {
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("app", appId);
            params.put("type", "id_card"); // 身份证信息或者银行卡信息串，取值范围: "id_card"（身份证信息串）；"bank_card"（银行卡信息串）。
            Map<String, String> data = new HashMap<String, String>();
            data.put("id_name", "张三");
            data.put("id_number", "320291198811110000");
            params.put("data", data);
            Identification result = Identification.identify(params);
            if (result.getResultCode() == 0) {
                System.out.println("身份认证通过");
            } else {
                System.out.println(result.getResultCode());
                System.out.println(result.getMessage());
            }
            System.out.println(result);
        } catch (PingppException e) {
            e.printStackTrace();
        }
    }

    /**
     * 认证银行卡信息
     *
     * 参考文档：https://www.pingxx.com/api#请求认证接口
     */
    public void identifyBankCard() {
        try {
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("app", appId);
            params.put("type", "bank_card"); // 身份证信息或者银行卡信息串，取值范围: "id_card"（身份证信息串）；"bank_card"（银行卡信息串）。
            Map<String, String> data = new HashMap<String, String>();
            data.put("id_name", "张三");
            data.put("id_number", "320291198811110000");
            data.put("card_number", "6201111122223333");
            params.put("data", data);
            Identification result = Identification.identify(params);
            if (result.getResultCode() == 0) {
                System.out.println("银行卡信息认证通过");
            } else {
                System.out.println(result.getResultCode());
                System.out.println(result.getMessage());
            }
            System.out.println(result);
        } catch (PingppException e) {
            e.printStackTrace();
        }
    }
}
