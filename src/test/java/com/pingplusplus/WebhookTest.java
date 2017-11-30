package com.pingplusplus;

import com.pingplusplus.model.PingppObject;
import com.pingplusplus.model.Webhooks;
import com.pingplusplus.model.Withdrawal;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/*
 * @author Afon, @date 17-03-28
 */
public class WebhookTest extends PingppAccountTestBase {
    /**
     * 解析 webhooks 消息 (withdrawal)
     */
    @Test public void testWebhooksParseWithdrawal() {
        String webhookData = PingppAccountTestData.getWithdrawalWebhooksData();

        PingppObject obj = Webhooks.getObject(webhookData);

        assertTrue("object should be an instance of Withdrawal", obj instanceof Withdrawal);
        assertEquals("object should be withdrawal", "withdrawal", ((Withdrawal)obj).getObject());
    }
}
