package com.pingplusplus.serializer;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;
import com.pingplusplus.model.ChargeRefundCollection;
import com.pingplusplus.model.Refund;

import java.lang.reflect.Type;
import java.util.List;

public class ChargeRefundCollectionDeserializer implements JsonDeserializer<ChargeRefundCollection> {

    public ChargeRefundCollection deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
            throws JsonParseException {
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();

        return gson.fromJson(json, typeOfT);
    }
}
