package com.pingxx.example;

import com.pingplusplus.exception.PingppException;
import com.pingplusplus.model.AgreementNotify;

import java.util.HashMap;
import java.util.Map;

public class AgreementNotifyExample {
    private String appId;

    AgreementNotifyExample(String appId) {
        this.appId = appId;
    }

    public static void runDemos(String appId) {
        AgreementNotifyExample example = new AgreementNotifyExample(appId);
        System.out.println("------- 创建 charge -------");
        example.create("agr_123456");
    }

    public AgreementNotify create(String id) {
        AgreementNotify agreementNotify = null;
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("amount", 100);
        try {
            agreementNotify = AgreementNotify.create(id, params);
        } catch (PingppException e) {
            e.printStackTrace();
        }
        return agreementNotify;
    }
}
