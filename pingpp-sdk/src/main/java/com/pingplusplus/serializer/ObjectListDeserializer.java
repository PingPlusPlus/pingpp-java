package com.pingplusplus.serializer;

import com.google.gson.*;
import com.pingplusplus.util.GsonUtils;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ObjectListDeserializer implements JsonDeserializer<List<Object>> {

    @Override
    public List<Object> deserialize(JsonElement elem,
            Type type,
            JsonDeserializationContext context) {
        List<Object> list = new ArrayList<>();
        JsonArray jsonArray = elem.getAsJsonArray();

        for (JsonElement element : jsonArray) {
            if (element.isJsonNull()) {
                list.add(null);
            } else if (element.isJsonPrimitive()) {
                JsonPrimitive primitive = element.getAsJsonPrimitive();
                if (primitive.isNumber()) {
                    String numStr = primitive.getAsString();
                    if (numStr.contains(".")) {
                        list.add(primitive.getAsDouble());
                    } else {
                        try {
                            list.add(primitive.getAsLong());
                        } catch (NumberFormatException e) {
                            list.add(primitive.getAsBigDecimal());
                        }
                    }
                } else if (primitive.isString()) {
                    list.add(primitive.getAsString());
                } else if (primitive.isBoolean()) {
                    list.add(primitive.getAsBoolean());
                }
            } else if (element.isJsonArray()) {
                list.add(context.deserialize(element, GsonUtils.LIST_OBJ));
            } else if (element.isJsonObject()) {
                list.add(context.deserialize(element, GsonUtils.MAP_STR_OBJ));
            }
        }

        return list;
    }
}