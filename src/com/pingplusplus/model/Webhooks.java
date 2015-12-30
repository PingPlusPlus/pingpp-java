package com.pingplusplus.model;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.pingplusplus.net.APIResource;


/**
 * Created by sunkai on 15/5/11.
 */
public class Webhooks {

    class InnerObject {
        String type;
    }

    /**
     * 解析 event 中的 object
     *
     * @param eventStr
     * @return
     */
    @Deprecated
    public static Object parseEvnet(String eventStr) {
        return getObject(eventStr);
    }

    /**
     * 解析 event 中的 object
     *
     * @param eventStr
     * @return
     */
    public static Object getObject(String eventStr) {
        return eventParse(eventStr).getData().getObject();
    }

    /**
     * 解析event，返回Event对象
     *
     * @param eventStr
     * @return
     */
    public static Event eventParse(String eventStr) {
        return APIResource.GSON.fromJson(eventStr, Event.class);
    }
}
