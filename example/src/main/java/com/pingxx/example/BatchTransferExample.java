/* *
 * Ping++ Server SDK
 * 说明：
 * 以下代码只是为了方便商户测试而提供的样例代码，商户可根据自己网站需求按照技术文档编写, 并非一定要使用该代码。
 * 接入企业付款流程参考开发者中心：https://www.pingxx.com/docs/server/transfer ，文档可筛选后端语言和接入渠道。
 * 该代码仅供学习和研究 Ping++ SDK 使用，仅供参考。
*/
package com.pingxx.example;

import com.pingplusplus.exception.*;
import com.pingplusplus.model.BatchTransfer;
import com.pingplusplus.model.BatchTransferCollection;
import com.pingplusplus.model.Transfer;
import com.pingplusplus.model.TransferCollection;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 *
 * 该实例演示如何使用 Ping++ 进行批量转账。
 *
 * 开发者需要填写 apiKey 和 appId ,
 *
 * apiKey 有 TestKey 和 LiveKey 两种。
 *
 * TestKey 模式下不会产生真实的交易。
 **
 */
public class BatchTransferExample {

    private String appId;

    public static void runDemos(String appId) {

        BatchTransferExample batchTransferExample = new BatchTransferExample(appId);
        System.out.println("------- 创建 BatchTransfer -------");
        BatchTransfer batchTransfer = batchTransferExample.create();
        System.out.println("------- 查询 BatchTransfer -------");
        batchTransferExample.retrieve(batchTransfer.getId());
        System.out.println("------- 查询 BatchTransfer 列表 -------");
        batchTransferExample.list();

    }

    BatchTransferExample(String appId) {
        this.appId = appId;
    }

    /**
     * 创建批量转账
     *
     * 创建企业转账需要传递一个 map 给 BatchTransfer.create();
     * map 填写的具体介绍可以参考：https://www.pingxx.com/api
     *
     * @return
     */
    public BatchTransfer create() {
        String channel = "alipay";

        BatchTransfer obj = null;
        String batchNo = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date()) + Main.randomString(7);
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("app", appId);
        params.put("channel", channel); // 目前支持 alipay、 unionpay、wx_pub、allinpay、jdpay
        params.put("batch_no", batchNo); // 企业转账使用的商户内部订单号。
        params.put("amount", 5000); // 订单总金额, 人民币单位：分（如订单总金额为 1 元，此处请填 100,企业付款最小发送金额为 1 元）
        params.put("type", "b2c"); // 付款类型，wx_pub 仅支持 b2c，alipay、 unionpay、allinpay、jdpay 支持 b2b
        params.put("currency", "cny");
        params.put("description", "your description");
        List<Map<String, Object>> recipients = new ArrayList<Map<String, Object>>();

        recipients.add(channelRecipient(channel));
        // recipients.add(channelRecipient(channel));
        // recipients.add(channelRecipient(channel));

        params.put("recipients", recipients);


        try {
            obj = BatchTransfer.create(params);
            System.out.println(obj);
        } catch (AuthenticationException e) {
            e.printStackTrace();
        } catch (InvalidRequestException e) {
            e.printStackTrace();
        } catch (APIConnectionException e) {
            e.printStackTrace();
        } catch (APIException e) {
            e.printStackTrace();
        } catch (ChannelException e) {
            e.printStackTrace();
        } catch (RateLimitException e) {
            e.printStackTrace();
        }
        return obj;
    }

    /**
     * 根据 ID 查询
     *
     * 根据 ID 查询批量转账记录。
     * 参考文档：https://www.pingxx.com/api
     * @param id
     */
    public void retrieve(String id) {
        try {
            BatchTransfer obj = BatchTransfer.retrieve(id);
            System.out.println(obj);
        } catch (AuthenticationException e) {
            e.printStackTrace();
        } catch (InvalidRequestException e) {
            e.printStackTrace();
        } catch (APIConnectionException e) {
            e.printStackTrace();
        } catch (APIException e) {
            e.printStackTrace();
        } catch (ChannelException e) {
            e.printStackTrace();
        } catch (RateLimitException e) {
            e.printStackTrace();
        }
    }

    /**
     * 查询列表
     *
     * 查询批量转账记录列表，默认一次查询 10 条，用户可以使用 per_page 自定义查询数目，但是最多不超过 20 条。
     */
    public void list() {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("per_page", 3);
        param.put("app", appId);

        try {
            BatchTransferCollection objs = BatchTransfer.list(param);
            System.out.println(objs);
        } catch (AuthenticationException e) {
            e.printStackTrace();
        } catch (InvalidRequestException e) {
            e.printStackTrace();
        } catch (APIConnectionException e) {
            e.printStackTrace();
        } catch (APIException e) {
            e.printStackTrace();
        } catch (ChannelException e) {
            e.printStackTrace();
        } catch (RateLimitException e) {
            e.printStackTrace();
        }
    }

    private Map<String, Object> channelRecipient(String channel) {
        Map<String, Object> recipient = new HashMap<String, Object>();

        switch (channel) {
            case "alipay":
                recipient = alipayRecipient();
                break;
            case "wx_pub":
                recipient = wxPubRecipient();
                break;
            case "unionpay":
                recipient = unionpayRecipient();
                break;
            case "allinpay":
                recipient = allinpayRecipient();
                break;
            case "jdpay":
                recipient = jdpayRecipient();
                break;
        }

        return recipient;
    }

    private Map<String, Object> alipayRecipient() {
        Map<String, Object> extra = new HashMap<>();

        // 必须，金额，单位为分。
        extra.put("amount", 5000);

        // 必须，接收者支付宝账号。
        extra.put("account", "alipayaccount@gmail.com");

        // 必须，收款人姓名，1~50位。
        extra.put("name", "张三");

        // 可选，收款方账户类型。可取值：1、 ALIPAY_USERID ：支付宝账号对应的支付宝唯一用户号。以2088开头的16位纯数字组成。 2、 ALIPAY_LOGONID （默认值）：支付宝登录号，支持邮箱和手机号格式。
        // extra.put("account_type", "ALIPAY_LOGONID");

        // 可选，批量企业付款描述，最多 200 字节。
        // extra.put("description", "描述");

        // 可选，订单号，1 ~ 64 位不能重复的数字字母组合。
        // extra.put("order_no", "1234567890123456");

        return extra;
    }

    private Map<String, Object> wxPubRecipient() {
        Map<String, Object> extra = new HashMap<>();
        // 必须，金额，单位为分。
        extra.put("amount", 5000);

        // 必须，接收者 id，为用户在 wx_pub 下的 open_id。
        extra.put("open_id", "o7xEMsySBFG3MVHI-9VsAJX-j50W");

        // 可选，收款人姓名。当该参数为空，则不校验收款人姓名。
        // extra.put("name", "张三");

        // 可选，是否强制校验收款人姓名。仅当  user_name 参数不为空时该参数生效。
        // extra.put("force_check", true);

        // 可选，批量企业付款描述，最多 99 个英文和数字的组合或最多 33 个中文字符，不可以包含特殊字符。不填默认使用外层参数中的 description。
        // extra.put("description", "描述");

        // 可选，订单号，1 ~ 32 位不能重复的数字字母组合。
        // extra.put("order_no", "1234567890123456");

        return extra;
    }

    private Map<String, Object> unionpayRecipient() {
        Map<String, Object> extra = new HashMap<>();
        // 必须，金额，单位为分。
        extra.put("amount", 5000);

        // 必须，1~32位，收款人银行卡号或者存折号。
        extra.put("account", "6228480402564890011");

        // 必须，1~100位，收款人姓名。
        extra.put("name", "张三");

        /**
         * open_bank_code 和 open_bank 两个参数必传一个，建议使用 open_bank_code ，若都传参则优先使用 open_bank_code 读取规则；prov 和 city 均为可选参数，如果不传参，则使用默认值 "上海" 给渠道接口。
         */
        // 条件可选，4位，开户银行编号，详情请参考 企业付款（银行卡）银行编号说明：https://www.pingxx.com/api#%E9%93%B6%E8%A1%8C%E7%BC%96%E5%8F%B7%E8%AF%B4%E6%98%8E。
        extra.put("open_bank_code", "0103");

        // 条件可选，1~50位，开户银行，详情请参考 企业付款（银行卡）银行编号说明：https://www.pingxx.com/api#%E9%93%B6%E8%A1%8C%E7%BC%96%E5%8F%B7%E8%AF%B4%E6%98%8E。
        extra.put("open_bank", "农业银行");

        // 可选，订单号，1 ~ 16 位数字。
        // extra.put("order_no", "1234567890123456");

        // 可选，批量企业付款描述，最多 200 字节。
        // extra.put("description", "描述");

        return extra;
    }

    private Map<String, Object> allinpayRecipient() {
        Map<String, Object> extra = new HashMap<>();
        // 必须，金额，单位为分。
        extra.put("amount", 5000);

        // 必须，接收者银行卡账号。
        extra.put("account", "6228480402564890011");

        // 必须，收款人姓名。
        extra.put("name", "张三");

        // 必须，4位，开户银行编号，详情请参考 企业付款（银行卡）银行编号说明：https://www.pingxx.com/api#%E9%93%B6%E8%A1%8C%E7%BC%96%E5%8F%B7%E8%AF%B4%E6%98%8E。
        extra.put("open_bank_code", "0103");

        // 可选，5位，业务代码，根据通联业务人员提供，不填使用通联提供默认值09900。
        // extra.put("business_code", "09900");

        // 可选，1位，银行卡号类型，0：银行卡、1：存折，不填默认使用银行卡。
        // extra.put("card_type", 0);

        // 可选，批量付款描述，最多 30 个 Unicode 字符。
        // extra.put("description", "描述");

        // 可选，订单号， 20 ~ 40 位不能重复的数字字母组合（必须以通联的商户号开头，建议组合格式：通联商户号 + 时间戳 + 固定位数顺序流水号，不包含+号），这里不传的话程序会调用商户的通联商户号加上随机数自动生成 order_no。
        // extra.put("order_no", "331301234554321098765432112");

        return extra;
    }

    private Map<String, Object> jdpayRecipient() {
        Map<String, Object> extra = new HashMap<>();
        // 必须，金额，单位为分。
        extra.put("amount", 5000);

        // 必须，1~32位，收款人银行卡号或者存折号。
        extra.put("account", "6228480402564890011");

        // 必须，1~100位，收款人姓名。
        extra.put("name", "张三");

        // 必须，4位，开户银行编号，详情请参考 企业付款（银行卡）银行编号说明：https://www.pingxx.com/api#%E9%93%B6%E8%A1%8C%E7%BC%96%E5%8F%B7%E8%AF%B4%E6%98%8E。
        extra.put("open_bank_code", "0103");

        // 可选，批量付款描述，最多 100 个 Unicode 字符。
        // extra.put("description", "描述");

        // 可选，订单号，jdpay 限长 1~64 位不能重复的数字字母组合。
        // extra.put("order_no", "1234567890123456");

        return extra;
    }
}
