package com.pingplusplus.balance;

import com.pingplusplus.PingppAccountTestBase;
import com.pingplusplus.exception.*;
import com.pingplusplus.model.BalanceBonus;
import com.pingplusplus.model.BalanceBonusCollection;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class BalanceBonusTest extends PingppAccountTestBase {
    /**
     * 余额赠送 balance-bonus
     */
    @Test
    public void testBalanceBonusCreate() throws RateLimitException,
            APIException, ChannelException, InvalidRequestException,
            APIConnectionException, AuthenticationException {
        Map<String, Object> params = new HashMap<>();
        params.put("user", "user_test_02");  // 受赠的用户 ID, 必传
        params.put("amount", 10);            // 支付受赠余额，单位：分, 必传
        params.put("order_no", "2017" + System.currentTimeMillis()); // 商户订单号，必须在商户系统内唯一, 必传
        params.put("description", "Balance bonus description."); // 描述, 可选
        // 创建 balance-bonus 方法
        // 参数: params
        BalanceBonus obj = BalanceBonus.create(params);

        assertEquals("object should be balance_bonus", "balance_bonus", obj.getObject());
    }

    /**
     * 查询单个 balance-bonus
     */
    @Test public void testBalanceBonusRetrieve() throws RateLimitException,
            APIException, ChannelException, InvalidRequestException,
            APIConnectionException, AuthenticationException {
        // 查询单个 balance-bonus 方法
        // 参数: balance-bonus id
        BalanceBonus obj = BalanceBonus.retrieve("650170821521710018560001");

        assertEquals("object should be balance_bonus", "balance_bonus", obj.getObject());
    }

    /**
     * 查询 balance-bonus 列表
     */
    @Test public void testBalanceBonusList() throws RateLimitException,
            APIException, ChannelException, InvalidRequestException,
            APIConnectionException, AuthenticationException {
        Map<String, Object> params = new HashMap<>();
        params.put("page", 1);
        params.put("per_page", 10);

        // 查询 balance-bonus 列表方法
        // 参数: params
        BalanceBonusCollection objs = BalanceBonus.list(params);

        assertEquals("object should be list", "list", objs.getObject());
    }
}
