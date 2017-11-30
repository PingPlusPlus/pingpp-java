package com.pingplusplus.transfer;

import com.pingplusplus.PingppAccountTestBase;
import com.pingplusplus.PingppAccountTestData;
import com.pingplusplus.exception.*;
import com.pingplusplus.model.Transfer;
import com.pingplusplus.model.TransferCollection;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Transfers 企业付款 示例
 */
public class TransferTest extends PingppAccountTestBase {
    /**
     * 创建 Transfer 对象- alipay 渠道
     */
    @Test public void testAlipayTransferCreate() throws AuthenticationException, InvalidRequestException,
            APIConnectionException, APIException, ChannelException, RateLimitException {

        Map<String, Object> params = new HashMap<>();
        // 付款使用的商户内部订单号。 alipay 为 1 ~ 64 位不能重复的数字字母组合;
        params.put("order_no", "2017" + System.currentTimeMillis());
        // 订单总金额, 人民币单位：分（如订单总金额为 1 元，此处请填 100,企业付款最小发送金额为1 元）
        params.put("amount", 100);
        // 目前支持 支付宝：alipay，银联：unionpay，微信公众号：wx_pub，通联：allinpay，京东：jdpay 余额：balance
        params.put("channel", "alipay");
        params.put("currency", "cny");
        // 付款类型，支持 b2c 、b2b
        params.put("type", "b2c");
        // 接收者 id， 渠道为 alipay 时，若 type 为 b2c，为个人支付宝账号，若 type 为 b2b，为企业支付宝账号。
        params.put("recipient", "13000000001");
        // 备注信息。渠道为 alipay 时，最多 100 个 Unicode 字符。
        params.put("description", "alipay transfer description");

        Map<String, Object> app = new HashMap<>();
        app.put("id", PingppAccountTestData.getAppID());
        params.put("app", app);

        Map<String, Object> extra = new HashMap<>();
        // 必须，收款人姓名，1~50位。
        extra.put("recipient_name", "张三");
        // 可选，收款方账户类型。可取值：1、 ALIPAY_USERID ：支付宝账号对应的支付宝唯一用户号。以2088开头的16位纯数字组成。
        //                           2、 ALIPAY_LOGONID （默认值）：支付宝登录号，支持邮箱和手机号格式。
        extra.put("recipient_account_type", "ALIPAY_LOGONID");
        params.put("extra", extra);

        Transfer obj = Transfer.create(params);
        assertEquals("object should be transfer", "transfer", obj.getObject());
    }

    /**
     * 创建 Transfer 对象- allinpay 渠道
     */
    @Test public void testAllinpayTransferCreate() throws AuthenticationException, InvalidRequestException,
            APIConnectionException, APIException, ChannelException, RateLimitException {
        Map<String, Object> params = new HashMap<>();
        // 付款使用的商户内部订单号。 allinpay 限长20-40位不能重复的数字字母组合，必须以签约的通联的商户号开头（建议组合格式：通联商户号 + 时间戳 + 固定位数顺序流水号，不包含+号）
        params.put("order_no", "099002017" + System.currentTimeMillis());
        // 订单总金额, 人民币单位：分（如订单总金额为 1 元，此处请填 100,企业付款最小发送金额为1 元）
        params.put("amount", 100);
        // 目前支持 支付宝：alipay，银联：unionpay，微信公众号：wx_pub，通联：allinpay，京东：jdpay 余额：balance
        params.put("channel", "allinpay");
        params.put("currency", "cny");
        // 付款类型，支持 b2c 、b2b
        params.put("type", "b2c");
        params.put("description", "allinpay transfer description");

        Map<String, Object> app = new HashMap<>();
        app.put("id", PingppAccountTestData.getAppID());
        params.put("app", app);

        Map<String, Object> extra = new HashMap<>();
        // 必须，1~32位，收款人银行卡号或者存折号。
        extra.put("card_number", "6220888888888888");
        // 必须，1~100位，收款人姓名。
        extra.put("user_name", "张三");
        // 必须，4位，开户银行编号，详情请参考 企业付款（银行卡）银行编号说明：必须，4位，开户银行编号，详情请参考 企业付款（银行卡）银行编号说明：https://www.pingxx.com/api#银行编号说明
        extra.put("open_bank_code", "0103");
        // 可选，5位，业务代码，根据通联业务人员提供，不填使用通联提供默认值09900。
        // extra.put("business_code", "09900");
        // 可选，1位，银行卡号类型，0：银行卡、1：存折，不填默认使用银行卡。
        // extra.put("card_type", 0);

        params.put("extra", extra);

        Transfer obj = Transfer.create(params);
        assertEquals("object should be transfer", "transfer", obj.getObject());
    }

    /**
     * 创建 Transfer 对象- jdpay 渠道
     */
    @Test public void testJdpayTransferCreate() throws AuthenticationException, InvalidRequestException,
            APIConnectionException, APIException, ChannelException, RateLimitException {
        Map<String, Object> params = new HashMap<>();
        // 付款使用的商户内部订单号。 jdpay 限长1-64位不能重复的数字字母组合；
        params.put("order_no", "2017" + System.currentTimeMillis());
        // 订单总金额, 人民币单位：分（如订单总金额为 1 元，此处请填 100,企业付款最小发送金额为1 元）
        params.put("amount", 100);
        // 目前支持 支付宝：alipay，银联：unionpay，微信公众号：wx_pub，通联：allinpay，京东：jdpay 余额：balance
        params.put("channel", "jdpay");
        params.put("currency", "cny");
        // 付款类型，支持 b2c 、b2b
        params.put("type", "b2c");
        params.put("description", "jdpay transfer description");

        Map<String, Object> app = new HashMap<>();
        app.put("id", PingppAccountTestData.getAppID());
        params.put("app", app);

        Map<String, Object> extra = new HashMap<>();
        // 必须，1~32位，收款人银行卡号或者存折号。
        extra.put("card_number", "6220888888888888");
        // 必须，1~100位，收款人姓名。
        extra.put("user_name", "张三");
        // 必须，4位，开户银行编号，详情请参考 企业付款（银行卡）银行编号说明：必须，4位，开户银行编号，详情请参考 企业付款（银行卡）银行编号说明：https://www.pingxx.com/api#银行编号说明
        extra.put("open_bank_code", "0103");
        params.put("extra", extra);

        Transfer obj = Transfer.create(params);
        assertEquals("object should be transfer", "transfer", obj.getObject());
    }

    /**
     * 创建 Transfer 对象- unionpay 渠道
     */
    @Test public void testUnionpayTransferCreate() throws AuthenticationException, InvalidRequestException,
            APIConnectionException, APIException, ChannelException, RateLimitException {
        Map<String, Object> params = new HashMap<>();
        // 付款使用的商户内部订单号。 unionpay 为1~16位的纯数字。
        params.put("order_no", "17" + System.currentTimeMillis());
        // 订单总金额, 人民币单位：分（如订单总金额为 1 元，此处请填 100,企业付款最小发送金额为1 元）
        params.put("amount", 100);
        // 目前支持 支付宝：alipay，银联：unionpay，微信公众号：wx_pub，通联：allinpay，京东：jdpay 余额：balance
        params.put("channel", "unionpay");
        params.put("currency", "cny");
        // 付款类型，支持 b2c 、b2b
        params.put("type", "b2c");
        // 备注信息。渠道为 unionpay 时，最多 99 个 Unicode 字符
        params.put("description", "unionpay transfer description");

        Map<String, Object> app = new HashMap<>();
        app.put("id", PingppAccountTestData.getAppID());
        params.put("app", app);

        Map<String, Object> extra = new HashMap<>();
        // 必须，1~32位，收款人银行卡号或者存折号。
        extra.put("card_number", "6220888888888888");
        // 必须，1~100位，收款人姓名。
        extra.put("user_name", "张三");
        // open_bank_code 和 open_bank 两个参数必传一个，建议使用 open_bank_code ，
        /// 若都传参则优先使用 open_bank_code 读取规则；
        /// prov 和 city 均为可选参数，如果不传参，则使用默认值 "上海" 给渠道接口。
        // 条件可选，4位，开户银行编号，详情请参考 企业付款（银行卡）银行编号说明：必须，4位，开户银行编号，详情请参考 企业付款（银行卡）银行编号说明：https://www.pingxx.com/api#银行编号说明
        extra.put("open_bank_code", "0103");
        // 条件可选，1~50位，开户银行
        extra.put("open_bank", "农业银行");
        // 可选，1～20位，省份。
        // extra.put("prov", "上海");
        // 可选，1～40位，城市。
        // extra.put("city", "上海");
        // 可选，1～80位，开户支行名称。
        // extra.put("sub_bank", "上海沪东支行");
        params.put("extra", extra);

        Transfer obj = Transfer.create(params);
        assertEquals("object should be transfer", "transfer", obj.getObject());
    }

    /**
     * 创建 Transfer 对象- wx_pub 渠道
     */
    @Test public void testWxPubTransferCreate() throws AuthenticationException, InvalidRequestException,
            APIConnectionException, APIException, ChannelException, RateLimitException {
        Map<String, Object> params = new HashMap<>();
        // 付款使用的商户内部订单号。 wx_pub 规定为 1 ~ 50 位不能重复的数字字母组合;
        params.put("order_no", "2017" + System.currentTimeMillis());
        // 订单总金额, 人民币单位：分（如订单总金额为 1 元，此处请填 100,企业付款最小发送金额为1 元）
        params.put("amount", 100);
        // 目前支持 支付宝：alipay，银联：unionpay，微信公众号：wx_pub，通联：allinpay，京东：jdpay 余额：balance
        params.put("channel", "wx_pub");
        params.put("currency", "cny");
        // 付款类型，支持 b2c 、b2b
        params.put("type", "b2c");
        // 备注信息。渠道为 wx_pub 时，最多 99 个英文和数字的组合或最多 33 个中文字符，不可以包含特殊字符；
        params.put("description", "wx_pub transfer description");
        // 接收者 id， 微信企业付款时为用户在 wx_pub 下的 open_id ;
        params.put("recipient", "o9zPms1OLVHU1r701mOHP0s-uK9c");

        Map<String, Object> app = new HashMap<>();
        app.put("id", PingppAccountTestData.getAppID());
        params.put("app", app);

        Map<String, Object> extra = new HashMap<>();
        // 可选，收款人姓名。当该参数为空，则不校验收款人姓名。
        extra.put("user_name", "张三");
        // 可选，是否强制校验收款人姓名。仅当  user_name 参数不为空时该参数生效。
        extra.put("force_check", true);
        params.put("extra", extra);

        Transfer obj = Transfer.create(params);
        assertEquals("object should be transfer", "transfer", obj.getObject());
    }

    /**
     * 创建 Transfer 对象- balance 渠道
     */
    @Test public void testBalanceTransferCreate() throws AuthenticationException, InvalidRequestException,
            APIConnectionException, APIException, ChannelException, RateLimitException {
        Map<String, Object> params = new HashMap<>();
        // 付款使用的商户内部订单号。 wx_pub 规定为 1 ~ 50 位不能重复的数字字母组合;
        params.put("order_no", "2017" + System.currentTimeMillis());
        // 订单总金额, 人民币单位：分（如订单总金额为 1 元，此处请填 100,企业付款最小发送金额为1 元）
        params.put("amount", 100);
        // 目前支持 支付宝：alipay，银联：unionpay，微信公众号：wx_pub，通联：allinpay，京东：jdpay 余额：balance
        params.put("channel", "balance");
        params.put("currency", "cny");
        // 付款类型，支持 b2c 、b2b
        params.put("type", "b2c");
        params.put("description", "wx_pub transfer description");
        // 接收者 id， 渠道为 balance 时，为用户在当前 app 下的用户 id。
        params.put("recipient", "user_test_02");

        Map<String, Object> app = new HashMap<>();
        app.put("id", PingppAccountTestData.getAppID());
        params.put("app", app);

        Transfer obj = Transfer.create(params);
        assertEquals("object should be transfer", "transfer", obj.getObject());
    }

    /**
     * 查询指定 Transfer 对象
     */
    @Test public void testTransferRetrieve() throws AuthenticationException, InvalidRequestException,
            APIConnectionException, APIException, ChannelException, RateLimitException {
        // 参数: transfer id
        Transfer obj = Transfer.retrieve("tr_WTarz1Ga9q90X1O4q91Oevv1");
        assertEquals("object should be transfer", "transfer", obj.getObject());
    }

    /**
     * 查询 Transfer 对象列表
     */
    @Test public void testTransferList() throws AuthenticationException, InvalidRequestException,
            APIConnectionException, APIException, ChannelException, RateLimitException {
        Map<String, Object> params = new HashMap<>();
        params.put("limit", 5);
        Map<String, Object> app = new HashMap<>();
        app.put("id", PingppAccountTestData.getAppID());
        params.put("app", app);

        TransferCollection objs = Transfer.list(params);
        assertEquals("object should be list", "list", objs.getObject());
    }

}
