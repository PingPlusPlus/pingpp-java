package com.pingplusplus;

import com.pingplusplus.exception.PingppException;
import com.pingplusplus.model.SubBank;
import com.pingplusplus.model.SubBankCollection;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class SubBankTest extends PingppTestBase {
    /**
     * 银行支行列表查询
     */
    @Test public void testSubBankQuery() throws PingppException {
        Map<String, Object> params = new HashMap<>();
        params.put("app", PingppTestData.getAppID());
        params.put("open_bank_code", "0308"); // 银行开户行编号
        params.put("prov", "浙江省"); // 省份
        params.put("city", "宁波市"); // 城市
        params.put("channel", "chanpay"); // 相关 transfer 渠道

        SubBankCollection obj = SubBank.query(params);

        System.out.println(obj);

        SubBank subBank = obj.getData().get(0);

        assertEquals("list", obj.getObject());
        assertEquals("sub_bank", subBank.getObject());
        assertEquals("浙江省", subBank.getProv());
        assertEquals("宁波市", subBank.getCity());
    }
}
