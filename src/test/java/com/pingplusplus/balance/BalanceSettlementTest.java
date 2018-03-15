package com.pingplusplus.balance;

import com.pingplusplus.PingppTestBase;
import com.pingplusplus.exception.*;
import com.pingplusplus.model.BalanceSettlement;
import com.pingplusplus.model.BalanceSettlementCollection;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class BalanceSettlementTest extends PingppTestBase {
    /**
     * 查询单个结算到余额
     */
    @Test
    public void testRetrieve() throws APIException,
            RateLimitException, InvalidRequestException,
            ChannelException, AuthenticationException, APIConnectionException {

        // 查询单个 balance_settlement 方法
        // 参数: balance_settlement id
        BalanceSettlement obj = BalanceSettlement.retrieve("670180130750711562240001");

        assertEquals("object should be balance_settlement", "balance_settlement", obj.getObject());
    }

    /**
     * 查询结算到余额列表
     */
    @Test
    public void testList() throws APIException,
            RateLimitException, InvalidRequestException,
            ChannelException, AuthenticationException, APIConnectionException {
        Map<String, Object> params = new HashMap<>();
        params.put("page", 1);
        params.put("per_page", 3);
        params.put("user", "user_test_01");
        // 查询 balance_settlement 列表方法
        // 参数: params
        BalanceSettlementCollection objs = BalanceSettlement.list(params);

        assertEquals("object should be list", "list", objs.getObject());
    }
}
