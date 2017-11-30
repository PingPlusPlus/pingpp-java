package com.pingplusplus.order;

import com.pingplusplus.PingppAccountTestBase;
import com.pingplusplus.PingppAccountTestData;
import com.pingplusplus.exception.*;
import com.pingplusplus.model.RoyaltySettlement;
import com.pingplusplus.model.RoyaltySettlementCollection;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class RoyaltySettlementTest extends PingppAccountTestBase {
    /**
     * 创建 royalty_settlement
     */
    @Test
    public void testRoyaltySettlementCreate() throws RateLimitException,
            APIException, ChannelException, InvalidRequestException,
            APIConnectionException, AuthenticationException {
        Map<String, Object> params = new HashMap<>();
        params.put("payer_app", PingppAccountTestData.getAppID());  // 分润发起方所在应用的 id, 必传
        params.put("method", "alipay");     // 分润的方式，余额 balance 或渠道名称，例如 alipay, 必传
        params.put("recipient_app", PingppAccountTestData.getAppID()); // 分润接收方的应用 id，即分润用户关联的应用 id。可选
        params.put("is_preview", false); // 是否预览，选择预览不会真实创建分润结算对象，也不会修改分润对象的状态, 可选
        // 创建 royalty_settlement 方法
        // 参数: params
        RoyaltySettlement obj = RoyaltySettlement.create(params);

        assertEquals("object should be royalty_settlement", "royalty_settlement", obj.getObject());
    }

    /**
     * 查询单个 royalty_settlement
     */
    @Test public void testRoyaltySettlementRetrieve() throws RateLimitException,
            APIException, ChannelException, InvalidRequestException,
            APIConnectionException, AuthenticationException {
        // 查询单个 royalty_settlement 方法
        // 参数: royalty_settlement id
        RoyaltySettlement obj = RoyaltySettlement.retrieve("170302171104000011");

        assertEquals("object should be royalty_settlement", "royalty_settlement", obj.getObject());
    }

    /**
     * 查询 royalty_settlement list
     */
    @Test public void testRoyaltySettlementList() throws RateLimitException,
            APIException, ChannelException, InvalidRequestException,
            APIConnectionException, AuthenticationException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("payer_app", PingppAccountTestData.getAppID());
        params.put("per_page", 3);
        params.put("page", 1);
        // 查询 royalty_settlement list 列表方法
        // 参数: params
        RoyaltySettlementCollection objs = RoyaltySettlement.list(params);

        assertEquals("object should be list", "list", objs.getObject());
    }

    /**
     * 更新 royalty_settlement
     */
    @Test public void testRoyaltySettlementUpdate() throws RateLimitException,
            APIException, ChannelException, InvalidRequestException,
            APIConnectionException, AuthenticationException {
        Map<String, Object> params = new HashMap<>();
        params.put("status", "canceled"); // 需要更新的状态  [pending, canceled]
        // 更新 royalty_settlement 方法
        // 参数: params
        RoyaltySettlement.update("170302171104000011", params);
    }
}
