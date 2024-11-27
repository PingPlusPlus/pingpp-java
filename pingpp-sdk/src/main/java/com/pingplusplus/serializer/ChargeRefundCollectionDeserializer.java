package com.pingplusplus.serializer;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.pingplusplus.model.ChargeRefundCollection;
import com.pingplusplus.util.GsonUtils;

import java.lang.reflect.Type;

public class ChargeRefundCollectionDeserializer implements JsonDeserializer<ChargeRefundCollection> {

    public ChargeRefundCollection deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
            throws JsonParseException {
        Gson gson = GsonUtils.baseGsonBuilder().create();

        return gson.fromJson(json, typeOfT);
    }
}
