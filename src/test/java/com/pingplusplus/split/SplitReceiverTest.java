package com.pingplusplus.split;

import com.pingplusplus.PingppTestBase;
import com.pingplusplus.PingppTestData;
import com.pingplusplus.exception.*;
import com.pingplusplus.model.DeletedSplitReceiver;
import com.pingplusplus.model.SplitReceiver;
import com.pingplusplus.model.SplitReceiverCollection;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class SplitReceiverTest extends PingppTestBase {
    @Test public void testCreate() throws PingppException {
        Map<String, Object> params = new HashMap<>();
        params.put("app", PingppTestData.getAppID());
        params.put("type", "MERCHANT_ID"); // 分账接收方类型
        params.put("name", "示例商户全称"); // 分账接收方全称
        params.put("account", "190001001"); // 分账接收方帐号
        params.put("channel", "wx_pub"); // 创建分账接收方使用的渠道(参数)
        SplitReceiver obj  = SplitReceiver.create(params);

        System.out.println(obj);

        assertEquals("split_receiver", obj.getObject());
    }

    @Test public void testListAll() throws PingppException {
        Map<String, Object> params = new HashMap<>();
        params.put("app", PingppTestData.getAppID());
        params.put("page", 1);
        params.put("per_page", 3);
        SplitReceiverCollection obj = SplitReceiver.list(params);

        System.out.println(obj);

        assertEquals("list", obj.getObject());
        assertEquals("split_receiver", obj.getData().get(0).getObject());
    }

    @Test public void testRetrieve() throws PingppException {
        SplitReceiver obj  = SplitReceiver.retrieve("recv_1fRc57XpIehmFI");

        System.out.println(obj);

        assertEquals("split_receiver", obj.getObject());
    }

    @Test public void testDelete() throws PingppException {
        DeletedSplitReceiver obj  = SplitReceiver.delete("recv_1fRc57XpIehmFI");

        System.out.println(obj);

        assertEquals(true, obj.getDeleted());
        assertEquals("recv_1fRc57XpIehmFI", obj.getId());
    }
}
