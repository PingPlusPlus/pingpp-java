package com.pingplusplus;

import com.pingplusplus.exception.PingppException;
import com.pingplusplus.model.*;
import com.pingplusplus.net.APIResource;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

/*
 * This Java source file was auto generated by running 'gradle init --type java-library'
 * by 'Afon' at '16-12-16 上午10:33' with Gradle 3.1
 *
 * @author Afon, @date 16-12-16 上午10:33
 */
public class PingppTest {

    @BeforeClass public static void initApiKey() {
        Pingpp.overrideApiBase(PingppTestData.getApiBase());
        Pingpp.apiKey = PingppTestData.getApiKey();
        // 建议使用 PKCS8 编码的私钥，可以用 openssl 将 PKCS1 转成 PKCS8
        Pingpp.privateKey = PingppTestData.getPKCS8PrivateKey();
        Pingpp.DEBUG = true;
    }

    @Test public void testDeserialize() {
        String jsonStr = "{\n" +
                "    \"id\": \"ch_1234567890\",\n" +
                "    \"object\": \"charge\",\n" +
                "    \"livemode\": true,\n" +
                "    \"paid\": true,\n" +
                "    \"refunded\": true,\n" +
                "    \"extra\": {\n" +
                "        \"discount_code\": \"ABCD\",\n" +
                "        \"discount_amount\": 20,\n" +
                "        \"score\": 60.12\n" +
                "    },\n" +
                "    \"time_paid\": 1732609210,\n" +
                "    \"time_expire\": 1732610502,\n" +
                "    \"time_settle\": null,\n" +
                "    \"transaction_no\": \"6523236536624\",\n" +
                "    \"amount_refunded\": 0,\n" +
                "    \"failure_code\": null,\n" +
                "    \"failure_msg\": null,\n" +
                "    \"metadata\": {\n" +
                "        \"code\": \"10000\",\n" +
                "        \"type\": \"PAYMENT\",\n" +
                "        \"list\": [10, 100, 1000]" +
                "    },\n" +
                "    \"credential\": {},\n" +
                "    \"description\": \"DESC\"\n" +
                "}";
        Charge ch = APIResource.getGson().fromJson(jsonStr, Charge.class);
        Object discountAmount = ch.getExtra().get("discount_amount");
        assertEquals(Long.class, discountAmount.getClass());
        assertEquals(20L, discountAmount);
        Object score = ch.getExtra().get("score");
        assertEquals(Double.class, score.getClass());
        System.out.println("score value: " + score);

        Object metaCode = ch.getMetadata().get("code");
        assertEquals(String.class, metaCode.getClass());
        Object metaList = ch.getMetadata().get("list");
        assertEquals(ArrayList.class, metaList.getClass());
        Object metaListEle = ((ArrayList<Object>) metaList).get(0);
        assertEquals(Long.class, metaListEle.getClass());
    }

    @Test public void testSetApiKey() {
        assertEquals("apiKey should be set", "sk_test_ibbTe5jLGCi5rzfH4OqPW9KC", Pingpp.apiKey);
    }

    @Test public void testVerifyVersions() {
        assertEquals("Pingpp.VERSION should match", "2.5.0", Pingpp.VERSION);
    }

    @Test public void testCreateCharge() {
        String appId = PingppTestData.getAppID();

        Charge charge = null;
        Map<String, Object> chargeMap = new HashMap<String, Object>();
        chargeMap.put("amount", 100);//订单总金额, 人民币单位：分（如订单总金额为 1 元，此处请填 100）
        chargeMap.put("currency", "cny");
        chargeMap.put("subject", "Your Subject");
        chargeMap.put("body", "Your Body");
        String orderNo = "orderno" + new Date().getTime();
        chargeMap.put("order_no", orderNo);// 推荐使用 8-20 位，要求数字或字母，不允许其他字符
        chargeMap.put("channel", "alipay");// 支付使用的第三方支付渠道取值，请参考：https://www.pingxx.com/api#api-c-new
        chargeMap.put("client_ip", "192.168.1.132"); // 发起支付请求客户端的 IP 地址，格式为 IPV4，如: 127.0.0.1
        Map<String, String> app = new HashMap<String, String>();
        app.put("id", appId);
        chargeMap.put("app", app);

        Map<String, Object> extra = new HashMap<String, Object>();
//        extra.put("success_url", "http://127.0.0.1/succeeded");
        chargeMap.put("extra", extra);
        try {
            // 发起 charge 创建请求
            charge = Charge.create(chargeMap);
            // 传到客户端请先转成字符串 .toString(), 调该方法，会自动转成正确的 JSON 字符串
            String chargeString = charge.toString();
            System.out.println(chargeString);
        } catch (PingppException e) {
            e.printStackTrace();
        }

        assertNotNull(charge);
        assertEquals("charge object should be charge", "charge", charge.getObject());
        assertEquals("charge order_no", orderNo, charge.getOrderNo());
    }

    @Test public void testWebhooksParseCharge() {
        String webhookData = PingppTestData.getChargeWebhooksData();

        PingppObject obj = Webhooks.getObject(webhookData);

        assertTrue("object should be an instance of Charge", obj instanceof Charge);
        assertEquals("object should be charge", "charge", ((Charge)obj).getObject());
    }

    @Test public void testWebhooksParseBatchTransfer() {
        String webhookData = PingppTestData.getBatchTransferWebhooksData();

        PingppObject obj = Webhooks.getObject(webhookData);

        assertTrue("object should be an instance of BatchTransfer", obj instanceof BatchTransfer);
        assertEquals("object should be batch_transfer", "batch_transfer", ((BatchTransfer)obj).getObject());
    }

    @Test public void testGetChargeList() {
        try {
            Integer limit = 3;
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("app[id]", PingppTestData.getAppID());
            params.put("limit", limit);
            ChargeCollection chs = Charge.list(params);

            System.out.println(chs);
            assertEquals("object should be list", "list", chs.getObject());
            assertEquals("data count should be same with limit", limit.intValue(), chs.getData().size());
        } catch (PingppException e) {
            e.printStackTrace();
        }
    }

    @Test public void testGetBatchRefundList() {
        try {
            Integer limit = 3;
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("per_page", limit);
            BatchRefundCollection objs = BatchRefund.list(params);

            assertEquals("object should be list", "list", objs.getObject());
            assertEquals("data count should be same with per_page", limit.intValue(), objs.getData().size());
        } catch (PingppException e) {
            e.printStackTrace();
        }
    }

    @Test public void testCreateTransfer() {
        try {
            String orderNo = "2017" + new Date().getTime();
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("amount", 1010);
            params.put("currency", "cny");
            params.put("type",  "b2c");
            params.put("order_no",  orderNo);
            params.put("channel",  "wx_pub");
            params.put("recipient", "openid-kaoshrbgafsnrxxcsds");

//            params.put("channel",  "unionpay");
//            Map<String, String> extra = new HashMap<String, String>();
//            extra.put("open_bank_code", "0105");
//            extra.put("card_number", "6222001022020034");
//            extra.put("user_name", "USER NAME");
//            params.put("extra", extra);

            params.put("description", "Your description.");
            Map<String, String> app = new HashMap<String, String>();
            app.put("id", PingppTestData.getAppID());
            params.put("app", app);
            Transfer obj = Transfer.create(params);

            assertEquals("object should be transfer", "transfer", obj.getObject());
            assertEquals("amount should be same", params.get("amount"), obj.getAmount());
            assertEquals("order_no should be same", params.get("order_no"), obj.getOrderNo());
            assertEquals("description should be same", params.get("description"), obj.getDescription());
            assertEquals("channel should be same", params.get("channel"), obj.getChannel());
        } catch (PingppException e) {
            e.printStackTrace();
        }
    }

    @Test public void testCreateBatchTransfer() throws PingppException {

        String batchNo = "2017" + new Date().getTime();
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("app", PingppTestData.getAppID());
        params.put("amount", 1000);
        params.put("currency", "cny");
        params.put("type",  "b2c");
        params.put("batch_no",  batchNo);
        params.put("channel",  "alipay");
        params.put("description", "Batch transfer description.");

        List<Map<String, Object>> recipients = new ArrayList<>();
        params.put("recipients", recipients);

        Map<String, Object> recipient1 = new HashMap<String, Object>();
        recipient1.put("account", "user001@gmail.com");
        recipient1.put("name", "user001");
        recipient1.put("amount", 600);
        recipient1.put("description", "Recipient 1 description.");
        recipients.add(recipient1);

        Map<String, Object> recipient2 = new HashMap<String, Object>();
        recipient2.put("account", "user002@gmail.com");
        recipient2.put("name", "user002");
        recipient2.put("amount", 400);
        recipient2.put("description", "Recipient 2 description.");
        recipients.add(recipient2);

        BatchTransfer obj = BatchTransfer.create(params);

        assertEquals("object should be batch_transfer", "batch_transfer", obj.getObject());
        assertEquals("amount should be same", params.get("amount"), obj.getAmount());
        assertEquals("batch_no should be same", params.get("batch_no"), obj.getBatchNo());
        assertEquals("description should be same", params.get("description"), obj.getDescription());
        assertEquals("channel should be same", params.get("channel"), obj.getChannel());
        for (int i = 0; i < obj.getRecipients().size(); i++) {
            assertNotNull("order_no should not be null", obj.getRecipients().get(i).getOrderNo());
            assertNull("failure_msg should be null", obj.getRecipients().get(i).getFailureMsg());
            assertNull("transaction_no should be null", obj.getRecipients().get(i).getTransactionNo());
            assertTrue("fee should be greater than or equal to 0", obj.getRecipients().get(i).getFee() >= 0);
        }
    }

    @Test public void testReverseCharge() {
        String appId = PingppTestData.getAppID();

        String chargeId = "ch_Py5SC89OyT00W5K4uHPmLCSC";

        Charge charge = null;
        try {
            // 发起 charge 撤销请求
            charge = Charge.reverse(chargeId);
            System.out.println(charge);

            assertEquals("charge object should be charge", "charge", charge.getObject());
            assertNotNull("charge reversed not null", charge.getReversed());
        } catch (PingppException e) {
            e.printStackTrace();
        }
    }

    @Test public void testRetrieveRefund() {
        String chargeId = "ch_Ti1eD0WP08eDPSSqnTOmLWHK";
        String refundId = "re_8avPmLWrPaH8TKmXDK5KubrL";

        Refund refund = null;
        try {
            refund = Refund.retrieve(chargeId, refundId);
            System.out.println(refund);
        } catch (PingppException e) {
            e.printStackTrace();
        }

        assertEquals("refund object should be charge", "refund", refund.getObject());
        assertNotNull("refund extra not null", refund.getExtra());
    }
}
