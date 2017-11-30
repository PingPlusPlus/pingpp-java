package com.pingplusplus.settle_account;

import com.pingplusplus.PingppAccountTestBase;
import com.pingplusplus.exception.*;
import com.pingplusplus.model.DeletedSettleAccount;
import com.pingplusplus.model.SettleAccount;
import com.pingplusplus.model.SettleAccountCollection;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SettleAccountTest extends PingppAccountTestBase {
    /**
     * 创建结算账户 SettleAccount
     */
    @Test
    public void testSettleAccountCreate() throws RateLimitException,
            APIException, ChannelException, InvalidRequestException,
            APIConnectionException, AuthenticationException {
        String userId = "test_user_001";
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("channel", "alipay"); // [wx_pub, wx, alipay, bank_account] 其中一种
        Map<String, Object> recipient = new HashMap<String, Object>(); // recipient 参数请参考各个渠道,以下是 alipay 参数
        recipient.put("account", "13000000001"); // 接收者支付宝账号
        recipient.put("name", "USER NAME"); // 接收者姓名
        recipient.put("type", "b2c"); // 转账类型
        recipient.put("account_type", "ALIPAY_LOGONID"); // 收款方账户类型

        params.put("recipient", recipient);

        SettleAccount obj = SettleAccount.create(userId, params); // 创建 SettleAccount 方法

        assertEquals("object should be settle_account", "settle_account", obj.getObject());
        assertEquals("channel", params.get("channel"), obj.getChannel());
        assertEquals("type", recipient.get("type"), obj.getRecipient().getType());
        assertEquals("open_bank_code", recipient.get("open_bank_code"), obj.getRecipient().getOpenBankCode());
    }

    /**
     * 查询结算账户
     */
    @Test public void testSettleAccountRetrieve() throws
            RateLimitException, APIException, ChannelException,
            InvalidRequestException, APIConnectionException, AuthenticationException {
        String userId = "test_user_001";
        String settleAccountId = "320117082311291100001002"; // 结算账户对象 ID

        SettleAccount obj = SettleAccount.retrieve(userId, settleAccountId); // 查询结算账户方法

        assertEquals("object should be settle_account", "settle_account", obj.getObject());
        assertEquals("id should be same", settleAccountId, obj.getId());
    }

    /**
     * 查询结算账户列表
     */
    @Test public void testSettleAccountList() throws RateLimitException,
            APIException, ChannelException, InvalidRequestException,
            APIConnectionException, AuthenticationException {
        String userId = "test_user_001";
        Map<String, Object> params = new HashMap<>();
        params.put("page", 1);
        params.put("per_page", 3);
        SettleAccountCollection obj = SettleAccount.list(userId, params); // 查询结算账户列表方法 userId:必传   params:可选

        assertEquals("object should be list", "list", obj.getObject());
    }

    /**
     * 删除结算账户
     */
    @Test public void testSettleAccountDelete() throws RateLimitException,
            APIException, ChannelException, InvalidRequestException,
            APIConnectionException, AuthenticationException {
        String userId = "test_user_001";
        String settleAccountId = "320117082311291100001002"; // 结算账户对象 ID

        DeletedSettleAccount obj = SettleAccount.delete(userId, settleAccountId); // 删除结算账户方法

        assertTrue("deleted should be true", obj.getDeleted());
        assertEquals("id should be same", settleAccountId, obj.getId());
    }
}
