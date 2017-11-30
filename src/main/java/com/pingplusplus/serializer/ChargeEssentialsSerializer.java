package com.pingplusplus.serializer;

import com.google.gson.*;
import com.pingplusplus.model.ChargeEssentials;

import java.lang.reflect.Type;

/**
 * Created by afon on 16/11/06.
 */
public class ChargeEssentialsSerializer implements JsonSerializer<ChargeEssentials> {

    @Override
    public JsonElement serialize(ChargeEssentials chargeEssentials, Type type, JsonSerializationContext jsonSerializationContext) {
        GsonBuilder gsonBuilder = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .registerTypeAdapter(Double.class, new DoubleTypeSerializer())
                .disableHtmlEscaping();

        if (chargeEssentials.getChannel() != null) {
            gsonBuilder.serializeNulls();
        }

        return gsonBuilder.create().toJsonTree(chargeEssentials, type);
    }
}
