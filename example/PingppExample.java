package com.pingplusplus;

import java.util.HashMap;
import java.util.Map;

import com.pingplusplus.exception.PingppException;
import com.pingplusplus.model.Charge;
import com.pingplusplus.model.Channel;

public class PingppExample {

    private String chargeID;

    public static void main(String[] args) {
        Pingpp.apiKey = "YOUR-SECRET-KEY";
        PingppExample example = new PingppExample();
        example.charge();
    }

    public void charge() {
        Map<String, Object> chargeMap = new HashMap<String, Object>();
        chargeMap.put("amount", 100);
        chargeMap.put("currency", "cny");
        chargeMap.put("subject",  "苹果");
        chargeMap.put("body",  "一个又大又红的红富士苹果");
        chargeMap.put("order_no",  "1234567890ab");
        chargeMap.put("channel",  Channel.WECHAT);
        chargeMap.put("client_ip",  "127.0.0.1");
        Map<String, String> app = new HashMap<String, String>();
        app.put("id", "YOUR-APP-ID");
        chargeMap.put("app", app);
        try {
            Charge charge = Charge.create(chargeMap);
            chargeID = charge.getId();
            System.out.println(chargeID);
            System.out.println(charge);
            String credential = charge.getCredential();
            System.out.println(credential);
        } catch (PingppException e) {
            e.printStackTrace();
        }
    }

    public void refund() {
        try {
            Charge charge = Charge.retrieve("CHARGE-ID");
            Map<String, Object> refundMap = new HashMap<String, Object>();
            refundMap.put("amount", 100);
            refundMap.put("description", "小苹果");
            Refund re = charge.getRefunds().create(refundMap);
            System.out.println(re);
        } catch (PingppException e) {
            e.printStackTrace();
        }
    }
}
