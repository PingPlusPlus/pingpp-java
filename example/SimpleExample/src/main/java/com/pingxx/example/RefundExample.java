package com.pingxx.example;

import com.pingplusplus.exception.APIConnectionException;
import com.pingplusplus.exception.APIException;
import com.pingplusplus.exception.AuthenticationException;
import com.pingplusplus.exception.ChannelException;
import com.pingplusplus.exception.InvalidRequestException;
import com.pingplusplus.model.Charge;
import com.pingplusplus.model.ChargeRefundCollection;
import com.pingplusplus.model.Refund;

import java.util.HashMap;
import java.util.Map;

/**
 * 退款相关示例
 *
 * 该实例程序演示了如何从 Ping++ 服务器进行退款操作。
 *
 * 开发者需要填写 apiKey 和 chargeId , apiKey 可以在 Ping++ 管理平台【应用信息里面查看】
 *
 * apiKey 有 TestKey 和 LiveKey 两种。
 *
 * TestKey 模式下不会产生真实的交易。
 */
public class RefundExample {

    private Charge charge;

    RefundExample(String chargeId) {
        try {
            this.charge = Charge.retrieve(chargeId);
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
        }
    }

    public static void runDemos() {

        String chargeId = "ch_5CWrz5rnz9GS84arXHLiPOqL";

        RefundExample refundExample = new RefundExample(chargeId);
        System.out.println("------- 创建 refund -------");
        Refund refund = refundExample.refund(1);
        System.out.println("------- 查询 refund -------");
        refundExample.retrieve(refund.getId());
        System.out.println("------- 查询 refund 列表 -------");
        refundExample.all();
    }

    /**
     * 退款
     *
     * 创建退款，需要先获得 charge ,然后调用 charge.getRefunds().create();
     * 参数具体说明参考：https://pingxx.com/document/api#api-r-new
     *
     * 可以一次退款，也可以分批退款。
     *
     * @param amount
     * @return
     */
    public Refund refund(Integer amount) {
        if (charge == null) {
            return null;
        }
        Refund refund = null;
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("description", "苹果被咬了一口。");
        params.put("amount", amount);

        try {
            refund = charge.getRefunds().create(params);
            System.out.println(refund);
        } catch (AuthenticationException e) {
            e.printStackTrace();
        } catch (InvalidRequestException e) {
            e.printStackTrace();
        } catch (APIConnectionException e) {
            e.printStackTrace();
        } catch (APIException e) {
            e.printStackTrace();
        } catch (ChannelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return refund;
    }

    /**
     * 查询退款
     *
     * 根据 Id 查询退款记录。需要传递 charge。
     * 参考文档：https://pingxx.com/document/api#api-r-inquiry
     *
     * @param id
     */
    public void retrieve(String id) {
        if (charge == null) {
            return;
        }
        try {
            Refund refund = charge.getRefunds().retrieve(id);
            System.out.println(refund);
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
		}
    }

    /**
     * 分页查询退款
     *
     * 批量查询退款。默认一次 10 条，用户可以通过 limit 自定义查询数目，但是最多不超过 100 条。
     * 参考文档：https://pingxx.com/document/api#api-r-list
     *
     */
    public void all() {
        if (charge == null) {
            return;
        }
        Map<String, Object> refundParams = new HashMap<String, Object>();
        refundParams.put("limit", 3);
        try {
            ChargeRefundCollection refunds = charge.getRefunds().all(refundParams);
            System.out.println(refunds);
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
		}
    }
}
