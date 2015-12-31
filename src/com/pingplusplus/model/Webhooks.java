package com.pingplusplus.model;

import com.pingplusplus.net.APIResource;


/**
 * Created by sunkai on 15/5/11.
 */
public class Webhooks {

    /**
     * 解析 event 中的 object
     *
     * @param eventStr
     * @return Object
     */
    @Deprecated
    public static Object parseEvnet(String eventStr) {
        return getObject(eventStr);
    }

    /**
     * 解析 event 中的 object
     *
     * @param eventStr
     * @return Object
     */
    public static Object getObject(String eventStr) {
        return eventParse(eventStr).getData().getObject();
    }

    /**
     * 解析event，返回Event对象
     *
     * @param eventStr
     * @return Event
     */
    public static Event eventParse(String eventStr) {
        return APIResource.GSON.fromJson(eventStr, Event.class);
    }
}
