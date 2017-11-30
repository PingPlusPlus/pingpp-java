package com.pingplusplus.order;

import com.pingplusplus.PingppAccountTestBase;
import com.pingplusplus.exception.*;
import com.pingplusplus.model.Royalty;
import com.pingplusplus.model.RoyaltyCollection;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class RoyaltyTest extends PingppAccountTestBase {
    /**
     * 批量更新 royalty
     */
    @Test
    public void testRoyaltyBatchUpdate() throws RateLimitException,
            APIException, ChannelException, InvalidRequestException,
            APIConnectionException, AuthenticationException {
        Map<String, Object> params = new HashMap<>();
        List<String> ids = new ArrayList<>(); // 分润 ID 列表, 必传
        ids.add("170301124238000111");
        params.put("ids", ids);
        params.put("method", "manual");     // 手动标记结算: manual 或 取消手动标记结算：null, 可选
        params.put("description", "royalty batch update description"); // 描述, 可选
        // 批量更新 royalty 方法
        // 参数: params
        RoyaltyCollection objs = Royalty.batchUpdate(params);

        assertEquals("object should be list", "list", objs.getObject());
    }

    /**
     * 查询 royalty
     */
    @Test public void testRoyaltyRetrieve() throws RateLimitException,
            APIException, ChannelException, InvalidRequestException,
            APIConnectionException, AuthenticationException {
        // 查询 royalty 方法
        // 参数: royalty id
        Royalty obj = Royalty.retrieve("421170321093600003");

        assertEquals("object should be royalty", "royalty", obj.getObject());
    }

    /**
     * 查询 royalty list
     */
    @Test public void testRoyaltyList() throws RateLimitException,
            APIException, ChannelException, InvalidRequestException,
            APIConnectionException, AuthenticationException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("per_page", 3);  // 可选
        params.put("page", 1);      // 可选
        params.put("royalty_settlement", null);  // 可选 关联的分润结算 ID
        params.put("royalty_transaction", null); // 可选 关联的分润结算明细 ID
        // 查询 royalty list 列表方法
        // 参数: params
        RoyaltyCollection objs = Royalty.list(params);

        assertEquals("object should be list", "list", objs.getObject());
    }
}
