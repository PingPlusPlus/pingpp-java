package com.pingxx.example;

import java.util.HashMap;
import java.util.Map;

import com.pingplusplus.exception.APIConnectionException;
import com.pingplusplus.exception.APIException;
import com.pingplusplus.exception.AuthenticationException;
import com.pingplusplus.exception.ChannelException;
import com.pingplusplus.exception.InvalidRequestException;
import com.pingplusplus.model.Charge;
import com.pingplusplus.model.Event;
import com.pingplusplus.model.EventCollection;
import com.pingplusplus.model.Refund;
import com.pingplusplus.model.Summary;
import com.pingplusplus.model.Webhooks;


/**
 *
 * Event 事件参考文档：https://pingxx.com/document/api#api-event
 *
 * 该实例演示如何查询 Event
 *
 * apiKey 有 TestKey 和 LiveKey 两种。
 *
 * TestKey 模式下不会产生真实的交易。
 *
 */
public class EventExample {

    public static void runDemos() {
        EventExample eventExample = new EventExample();
        System.out.println("------- 查询 event -------");

        String eventId = "evt_vTmGHwcHc842hWLRWNS4bwFM";
        eventExample.retrieve(eventId);
        System.out.println("------- 查询 event 列表 -------");
        eventExample.all();
    }

    /**
     * 根据 ID 查询 Evnet
     *
     * 传递 Event 的 Id 查询 Event。
     * 参考文档：https://pingxx.com/document/api#api-event-inquiry
     * @param id
     */
    public void retrieve(String id) {
        try {
            Event event = Event.retrieve(id);
            System.out.println(event);

            // 解析 webhooks 可以采用如下方法
//            Object obj = Webhooks.getObject(event.toString());
//            if (obj instanceof Charge) {
//                System.out.println("webhooks 发送了 Charge");
//            } else if (obj instanceof Refund) {
//                System.out.println("webhooks 发送了 Refund");
//            } else if (obj instanceof Summary) {
//                System.out.println("webhooks 发送了 Summary");
//            }
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
     * 批量查询
     *
     * 该接口为批量查询接口，默认一次查询10条。
     * 用户可以通过添加 limit 参数自行设置查询数目，最多一次不能超过 100 条。
     *
     */
    public void all() {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("limit", 3);
//        params.put("type", "charge.succeeded");
//        params.put("type", "refund.succeeded");
//        ...
        try {
            EventCollection eventCollection = Event.all(params);
            System.out.println(eventCollection);
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
