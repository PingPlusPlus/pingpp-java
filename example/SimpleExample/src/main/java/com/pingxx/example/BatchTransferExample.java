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
        BatchTransfer obj = null;
        String orderNo = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date()) + Main.randomString(7);
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("app", appId);
        params.put("channel", "alipay"); // 目前支持 wx(新渠道)、 wx_pub
        params.put("batch_no", orderNo); // 企业转账使用的商户内部订单号。wx(新渠道)、wx_pub 规定为 1 ~ 50 位不能重复的数字字母组合
        params.put("amount", 2000); // 订单总金额, 人民币单位：分（如订单总金额为 1 元，此处请填 100,企业付款最小发送金额为 1 元）
        params.put("type", "b2c"); // 付款类型，当前仅支持 b2c 企业付款
        params.put("currency", "cny");
        params.put("description", "your description");
        List<Map<String, Object>> recipients = new ArrayList<Map<String, Object>>();

        Map<String, Object> recipient = new HashMap<String, Object>();
        recipient.put("account", "user001@gmail.com");
        recipient.put("amount", 2000);
        recipient.put("name", "NAME");
        recipients.add(recipient);

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
        Map<String, Object> parm = new HashMap<String, Object>();
        parm.put("per_page", 3);

        try {
            BatchTransferCollection objs = BatchTransfer.list(parm);
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
}
