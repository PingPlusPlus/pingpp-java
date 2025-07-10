package com.pingxx.example;

import com.pingplusplus.exception.PingppException;
import com.pingplusplus.model.Agreement;

import java.util.HashMap;
import java.util.Map;

public class AgreementExample {

    private String appId;

    public AgreementExample(String appId) {
        this.appId = appId;
    }

    public static void runDemos(String appId) throws PingppException {
        AgreementExample example = new AgreementExample(appId);
        Agreement agrModify =  example.modify();
    }

    public Agreement modify() throws PingppException {
        String agreementId = "agr_123456";
        Map<String, Object> params = new HashMap<>();
        params.put("deduct_time", "2025-07-10");
        params.put("memo", "扣款失败,需延期扣款时间");

        return Agreement.modify(agreementId, params);
    }
}
