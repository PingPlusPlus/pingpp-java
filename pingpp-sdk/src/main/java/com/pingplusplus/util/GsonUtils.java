package com.pingplusplus.util;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.pingplusplus.serializer.ObjectListDeserializer;
import com.pingplusplus.serializer.StringObjectMapDeserializer;

public final class GsonUtils {
    public static final Type MAP_STR_OBJ = new TypeToken<Map<String, Object>>() {}.getType();
    public static final Type LIST_OBJ = new TypeToken<List<Object>>() {}.getType();
    
    private GsonUtils() {}

    public static GsonBuilder baseGsonBuilder() {
        return new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .registerTypeAdapter(GsonUtils.MAP_STR_OBJ, new StringObjectMapDeserializer())
                .registerTypeAdapter(GsonUtils.LIST_OBJ, new ObjectListDeserializer());
    }
}
