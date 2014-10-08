package com.pingplusplus.model;

import com.google.gson.Gson;

public class Notify {
    class InnerObject {
        String object;
    }

    public static Object parseNotify(String notifyJson) {

        InnerObject innerObject;
        try {
            innerObject = new Gson().fromJson(notifyJson, InnerObject.class);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        if(innerObject == null || innerObject.object == null || innerObject.object.isEmpty())
            return null;

        if(innerObject.object.equals("charge")) {
            return new Gson().fromJson(notifyJson, Charge.class);
        } else if(innerObject.object.equals("refund")) {
            return new Gson().fromJson(notifyJson, Refund.class);
        }

        return null;
    }
}
