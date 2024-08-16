package com.pingplusplus.order;

import com.pingplusplus.PingppTestBase;
import com.pingplusplus.exception.PingppException;
import com.pingplusplus.model.RoyaltyTransaction;
import com.pingplusplus.model.RoyaltyTransactionCollection;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class RoyaltyTransactionTest extends PingppTestBase {
    /**
     * 查询单个 royalty_transaction
     */
    @Test
    public void testRoyaltyTransactionRetrieve() throws PingppException {
        // 查询单个 royalty_transaction 方法
        // 参数: royalty_transaction id
        RoyaltyTransaction obj = RoyaltyTransaction.retrieve("170302171104000011");

        assertEquals("object should be royalty_transaction", "royalty_transaction", obj.getObject());
    }

    /**
     * 查询 royalty_transaction list
     */
    @Test public void testRoyaltyTransactionList() throws PingppException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("per_page", 3);
        params.put("page", 1);

        // 查询 royalty_transaction list 列表方法
        // 参数: params
        RoyaltyTransactionCollection objs = RoyaltyTransaction.list(params);

        assertEquals("object should be list", "list", objs.getObject());
    }
}
