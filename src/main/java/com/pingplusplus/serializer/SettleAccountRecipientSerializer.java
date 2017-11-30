package com.pingplusplus.serializer;

import com.google.gson.*;
import com.pingplusplus.model.SettleAccountRecipient;

import java.lang.reflect.Type;

/**
 * Created by afon on 17/03/27.
 */
public class SettleAccountRecipientSerializer implements JsonSerializer<SettleAccountRecipient> {

    @Override
    public JsonElement serialize(SettleAccountRecipient recipient, Type type, JsonSerializationContext jsonSerializationContext) {
        GsonBuilder gsonBuilder = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .disableHtmlEscaping();

        return gsonBuilder.create().toJsonTree(recipient, type);
    }
}
