package com.pingplusplus.serializer;

import com.google.gson.*;
import com.pingplusplus.util.GsonUtils;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

public class StringObjectMapDeserializer implements JsonDeserializer<Map<String, Object>> {

    @Override
    public Map<String, Object> deserialize(JsonElement elem,
            Type type,
            JsonDeserializationContext context) {
        Map<String, Object> map = new HashMap<>();
        JsonObject jsonObject = elem.getAsJsonObject();

        for (Map.Entry<String, JsonElement> entry : jsonObject.entrySet()) {
            String key = entry.getKey();
            JsonElement value = entry.getValue();

            if (value.isJsonNull()) {
                map.put(key, null);
            } else if (value.isJsonPrimitive()) {
                JsonPrimitive primitive = value.getAsJsonPrimitive();
                if (primitive.isNumber()) {
                    String numStr = primitive.getAsString();
                    if (numStr.contains(".")) {
                        map.put(key, primitive.getAsDouble());
                    } else {
                        try {
                            map.put(key, primitive.getAsLong());
                        } catch (NumberFormatException e) {
                            map.put(key, primitive.getAsBigDecimal());
                        }
                    }
                } else if (primitive.isString()) {
                    map.put(key, primitive.getAsString());
                } else if (primitive.isBoolean()) {
                    map.put(key, primitive.getAsBoolean());
                }
            } else if (value.isJsonArray()) {
                map.put(key, context.deserialize(value, GsonUtils.LIST_OBJ));
            } else if (value.isJsonObject()) {
                map.put(key, context.deserialize(value, GsonUtils.MAP_STR_OBJ));
            }
        }

        return map;
    }
}