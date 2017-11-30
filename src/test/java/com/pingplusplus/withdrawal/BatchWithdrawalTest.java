package com.pingplusplus.withdrawal;

import com.pingplusplus.PingppAccountTestBase;
import com.pingplusplus.PingppAccountTestData;
import com.pingplusplus.exception.*;
import com.pingplusplus.model.BatchWithdrawal;
import com.pingplusplus.model.BatchWithdrawalCollection;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class BatchWithdrawalTest extends PingppAccountTestBase {
    /**
     * 批量提现确认
     */
    @Test
    public void testBatchWithdrawalCreate() throws RateLimitException,
            APIException, ChannelException, InvalidRequestException,
            APIConnectionException, AuthenticationException {
        Map<String, Object> params = new HashMap<String, Object>();
        ArrayList<String> withdrawals = new ArrayList<>(); // withdrawal id 列表
        withdrawals.add("1701708221834035593");
        params.put("withdrawals", withdrawals);
        params.put("status", "pending"); // 状态值: 提现确认：pending，提现撤销：canceled。

        BatchWithdrawal obj = BatchWithdrawal.create(params);

        assertEquals("object should be batch_withdrawal", "batch_withdrawal", obj.getObject());
        assertNotNull("id should not be null", obj.getId());
        assertEquals("app", PingppAccountTestData.getAppID(), obj.getApp());
        assertNotNull("amount should not be null", obj.getAmount());
        assertTrue("created should be greater than 0", obj.getCreated() > 0);
        assertNotNull("status should not be null", obj.getStatus());
        if (params.get("status").equals("pending")) {
            assertNull("time_finished should be null when status is pending", obj.getTimeFinished());
        }
    }

    /**
     * 查询批量提现对象
     */
    @Test public void testBatchWithdrawalRetrieve() throws RateLimitException,
            APIException, ChannelException, InvalidRequestException,
            APIConnectionException, AuthenticationException {

        // 查询 BatchWithdrawal 对象方法
        // 参数: batch_withdrawal id
        BatchWithdrawal obj = BatchWithdrawal.retrieve("1901708221706050363");

        assertEquals("object should be batch_withdrawal", "batch_withdrawal", obj.getObject());
    }

    /**
     * 查询批量提现列表
     */
    @Test public void testBatchWithdrawalList() throws RateLimitException,
            APIException, ChannelException, InvalidRequestException,
            APIConnectionException, AuthenticationException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("per_page", 3);

        // 查询 BatchWithdrawal 列表方法
        // 参数: params
        BatchWithdrawalCollection obj = BatchWithdrawal.list(params);

        assertEquals("object should be list", "list", obj.getObject());
    }
}
