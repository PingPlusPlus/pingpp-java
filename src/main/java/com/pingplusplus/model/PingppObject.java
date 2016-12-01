package com.pingplusplus.model;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.pingplusplus.serializer.BatchTransferRecipientSerializer;

public abstract class PingppObject {

    public static final Gson PRETTY_PRINT_GSON = new GsonBuilder()
            .setPrettyPrinting()
            .serializeNulls()
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .disableHtmlEscaping()
            .registerTypeAdapter(BatchTransferRecipientSerializer.class, new BatchTransferRecipientSerializer())
            .create();

    @Override
    public String toString() {
        return PRETTY_PRINT_GSON.toJson(this);
    }
}
