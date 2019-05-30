package com.pingplusplus.settle_account;

import com.pingplusplus.PingppTestBase;
import com.pingplusplus.exception.*;
import com.pingplusplus.model.DeletedSettleAccount;
import com.pingplusplus.model.SettleAccount;
import com.pingplusplus.model.SettleAccountCollection;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SettleAccountTest extends PingppTestBase {
    /**
     * 创建结算账户 SettleAccount
     */
    @Test
    public void testSettleAccountCreate() throws RateLimitException,
            APIException, ChannelException, InvalidRequestException,
            APIConnectionException, AuthenticationException {
        String userId = "U2019053010510001";
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("channel", "bank_account"); // [wx_pub, wx, alipay, bank_account] 其中一种
        Map<String, Object> recipient = new HashMap<String, Object>(); // recipient 参数请参考各个渠道,以下是 alipay 参数
        recipient.put("account", "6222987656770001"); // 接收者银行账号/卡号
        recipient.put("name", "USER NAME"); // 接收者姓名
        recipient.put("type", "b2c"); // 转账类型
        recipient.put("open_bank_code", "0102"); // 户银行编号
        recipient.put("open_bank", "工商银行");
        recipient.put("card_type", 0);
        recipient.put("sub_bank", "招商银行股份有限公司上海陆家嘴支行");
        recipient.put("sub_bank_code", "308290003773");
        recipient.put("prov", "上海市");
        recipient.put("city", "上海市");

        params.put("recipient", recipient);

        SettleAccount obj = SettleAccount.create(userId, params); // 创建 SettleAccount 方法

        System.out.println(obj);
        assertEquals("object should be settle_account", "settle_account", obj.getObject());
        assertEquals("channel", params.get("channel"), obj.getChannel());
        assertEquals("type", recipient.get("type"), obj.getRecipient().getType());
        assertEquals("open_bank_code", recipient.get("open_bank_code"), obj.getRecipient().getOpenBankCode());
        assertEquals("sub_bank_code", recipient.get("sub_bank_code"), obj.getRecipient().getSubBankCode());
    }

    /**
     * 查询结算账户
     */
    @Test public void testSettleAccountRetrieve() throws
            RateLimitException, APIException, ChannelException,
            InvalidRequestException, APIConnectionException, AuthenticationException {
        String userId = "U2019053010510001";
        Map<String, Object> params = new HashMap<>();
        params.put("page", 1);
        params.put("per_page", 3);
        SettleAccountCollection list = SettleAccount.list(userId, params);
        if (list.getData().size() > 0) {
            String settleAccountId = list.getData().get(0).getId(); // 结算账户对象 ID

            SettleAccount obj = SettleAccount.retrieve(userId, settleAccountId); // 查询结算账户方法

            assertEquals("object should be settle_account", "settle_account", obj.getObject());
            assertEquals("id should be same", settleAccountId, obj.getId());
        } else {
            System.out.println("结算账户列表为空");
        }
    }

    /**
     * 查询结算账户列表
     */
    @Test public void testSettleAccountList() throws RateLimitException,
            APIException, ChannelException, InvalidRequestException,
            APIConnectionException, AuthenticationException {
        String userId = "U2019053010510001";
        Map<String, Object> params = new HashMap<>();
        params.put("page", 1);
        params.put("per_page", 3);
        SettleAccountCollection list = SettleAccount.list(userId, params); // 查询结算账户列表方法 userId:必传   params:可选

        System.out.println(list);
        assertEquals("object should be list", "list", list.getObject());
    }

    /**
     * 删除结算账户
     */
    @Test public void testSettleAccountDelete() throws RateLimitException,
            APIException, ChannelException, InvalidRequestException,
            APIConnectionException, AuthenticationException {
        String userId = "U2019053010510001";
        Map<String, Object> params = new HashMap<>();
        params.put("page", 1);
        params.put("per_page", 3);
        SettleAccountCollection list = SettleAccount.list(userId, params);
        if (list.getData().size() > 0) {
            String settleAccountId = list.getData().get(0).getId(); // 结算账户对象 ID

            DeletedSettleAccount deleted = SettleAccount.delete(userId, settleAccountId); // 删除结算账户方法

            assertTrue("deleted should be true", deleted.getDeleted());
            assertEquals("id should be same", settleAccountId, deleted.getId());
        } else {
            System.out.println("结算账户列表为空");
        }
    }
}
