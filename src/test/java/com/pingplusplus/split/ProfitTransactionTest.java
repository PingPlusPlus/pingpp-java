package com.pingplusplus.split;

import com.pingplusplus.PingppTestBase;
import com.pingplusplus.PingppTestData;
import com.pingplusplus.exception.PingppException;
import com.pingplusplus.model.ProfitTransaction;
import com.pingplusplus.model.ProfitTransactionCollection;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class ProfitTransactionTest extends PingppTestBase {

    @Test public void testListAll() throws PingppException {
        Map<String, Object> params = new HashMap<>();
        params.put("app", PingppTestData.getAppID());
        params.put("page", 1);
        params.put("per_page", 3);
        ProfitTransactionCollection obj = ProfitTransaction.list(params);

        System.out.println(obj);

        assertEquals("list", obj.getObject());
        assertEquals("profit_transaction", obj.getData().get(0).getObject());
    }

    @Test public void testRetrieve() throws PingppException {
        ProfitTransaction obj  = ProfitTransaction.retrieve("ptxn_1m3xtoBMRqu2qC");

        System.out.println(obj);

        assertEquals("profit_transaction", obj.getObject());
    }
}
