package com.pingplusplus.serializer;

import com.google.gson.*;
import com.pingplusplus.model.CouponTemplateExpiration;

import java.lang.reflect.Type;

/**
 * Created by afon on 16/11/07.
 */
public class CouponTemplateExpirationSerializer implements JsonSerializer<CouponTemplateExpiration> {

    @Override
    public JsonElement serialize(CouponTemplateExpiration couponTemplateExpiration, Type type, JsonSerializationContext jsonSerializationContext) {
        GsonBuilder gsonBuilder = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .disableHtmlEscaping();

        return gsonBuilder.create().toJsonTree(couponTemplateExpiration, type);
    }
}
