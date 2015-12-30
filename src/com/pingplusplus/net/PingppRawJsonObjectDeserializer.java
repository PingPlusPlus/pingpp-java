package com.pingplusplus.net;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.pingplusplus.model.PingppRawJsonObject;

import java.lang.reflect.Type;

/**
 * Created by Afon on 15/12/30.
 */
public class PingppRawJsonObjectDeserializer implements JsonDeserializer<PingppRawJsonObject> {
    public PingppRawJsonObject deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
            throws JsonParseException {
        PingppRawJsonObject object = new PingppRawJsonObject();
        object.json = json.getAsJsonObject();
        return object;
    }
}
