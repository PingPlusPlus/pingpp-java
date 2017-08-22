package com.pingplusplus.serializer;

import com.google.gson.*;
import com.pingplusplus.model.BatchTransferRecipient;

import java.lang.reflect.Type;

/**
 * Created by afon on 16/11/28.
 */
public class BatchTransferRecipientSerializer implements JsonSerializer<BatchTransferRecipient> {

    @Override
    public JsonElement serialize(BatchTransferRecipient batchTransferRecipient, Type type, JsonSerializationContext jsonSerializationContext) {
        GsonBuilder gsonBuilder = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .disableHtmlEscaping();

        return gsonBuilder.create().toJsonTree(batchTransferRecipient, type);
    }
}
