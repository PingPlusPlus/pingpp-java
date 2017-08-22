package com.pingplusplus.model;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.pingplusplus.serializer.BatchRefundChargesSerializer;
import com.pingplusplus.serializer.BatchTransferRecipientSerializer;
import com.pingplusplus.serializer.DoubleTypeSerializer;

import java.lang.reflect.Field;

public abstract class PingppObject {

    public static final Gson PRETTY_PRINT_GSON = new GsonBuilder()
            .setPrettyPrinting()
            .serializeNulls()
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .disableHtmlEscaping()
            .registerTypeAdapter(BatchTransferRecipientSerializer.class, new BatchTransferRecipientSerializer())
            .registerTypeAdapter(BatchRefundCharges.class, new BatchRefundChargesSerializer())
            .registerTypeAdapter(Double.class, new DoubleTypeSerializer())
            .create();

    public static Gson getPrettyPrintGson() {
        try {
            Class<?> klass = Class.forName("com.pingplusplus.net.AppBasedResource");
            Field field = klass.getField("PRETTY_PRINT_GSON");
            return (Gson) field.get(klass);
        } catch (ClassNotFoundException e) {
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

        return PRETTY_PRINT_GSON;
    }

    @Override
    public String toString() {
        return getPrettyPrintGson().toJson(this);
    }
}
