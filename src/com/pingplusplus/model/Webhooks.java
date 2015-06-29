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
     * 解析event 中的object
     *
     * @param eventStr
     * @return
     */
    public static Object parseEvnet(String eventStr) {
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();
        InnerObject innerObject = gson.fromJson(eventStr, InnerObject.class);
        if (null == innerObject) {
            return null;
        }
        JsonParser jsonParser = new JsonParser();
        JsonObject jsonObject = jsonParser.parse(eventStr).getAsJsonObject();
        String eventData = jsonObject.get("data").getAsJsonObject().get("object").getAsJsonObject().toString();
        if ("summary.daily.available".equals(innerObject.type)) {
            return gson.fromJson(eventData, Summary.class);
        } else if ("summary.weekly.available".equals(innerObject.type)) {
            return gson.fromJson(eventData, Summary.class);
        } else if ("summary.monthly.available".equals(innerObject.type)) {
            return gson.fromJson(eventData, Summary.class);
        } else if ("charge.succeeded".equals(innerObject.type)) {
            return APIResource.GSON.fromJson(eventData, Charge.class);
        } else if ("refund.succeeded".equals(innerObject.type)) {
            return gson.fromJson(eventData, Refund.class);
        }
        return null;
    }

    /**
     * 解析event，返回Event对象
     *
     * @param eventStr
     * @return
     */
    public static Event eventParse(String eventStr) {
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();
        InnerObject innerObject = gson.fromJson(eventStr, InnerObject.class);

        if (innerObject == null || innerObject.type == null || innerObject.type.isEmpty()) {
            return null;
        }

        return gson.fromJson(eventStr, Event.class);
    }
}
