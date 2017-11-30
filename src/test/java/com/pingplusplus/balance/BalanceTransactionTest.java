package com.pingplusplus.balance;

import com.pingplusplus.PingppAccountTestBase;
import com.pingplusplus.exception.*;
import com.pingplusplus.model.BalanceTransaction;
import com.pingplusplus.model.BalanceTransactionCollection;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class BalanceTransactionTest extends PingppAccountTestBase {
    /**
     * 查询单个余额明细 (balance_transaction)
     */
    @Test
    public void testBalanceTransactionRetrieve() throws APIException,
            RateLimitException, InvalidRequestException,
            ChannelException, AuthenticationException, APIConnectionException {

        // 查询单个 balance_transaction 方法
        // 参数: balance_transaction id
        BalanceTransaction obj = BalanceTransaction.retrieve("600170822661998110720001");

        assertEquals("object should be balance_transaction", "balance_transaction", obj.getObject());
    }

    /**
     * 查询余额明细 (balance_transaction) 列表
     */
    @Test public void testBalanceTransactionList() throws APIException,
            RateLimitException, InvalidRequestException,
            ChannelException, AuthenticationException, APIConnectionException {
        Map<String, Object> params = new HashMap<>();
        params.put("page", 1);
        params.put("per_page", 3);
        // 查询 balance_transaction 列表方法
        // 参数: params
        BalanceTransactionCollection objs = BalanceTransaction.list(params);

        assertEquals("object should be list", "list", objs.getObject());
    }
}
