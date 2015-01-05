package com.pingplusplus.model;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Map;

/**
 * Created by afon on 14/11/25.
 */
public class ChargeDeserializer implements JsonDeserializer<Charge> {

    @Override
    public Charge deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .registerTypeAdapter(ChargeRefundCollection.class, new ChargeRefundCollectionDeserializer())
                .registerTypeAdapter(PingppRawJsonObject.class, new PingppRawJsonObjectDeserializer())
                .create();
        Charge charge = gson.fromJson(jsonElement, Charge.class);
        final JsonObject obj = jsonElement.getAsJsonObject();
        final JsonElement appElement = obj.get("app");
        if (appElement != null && appElement.isJsonObject()) {
            App app = gson.fromJson(appElement, App.class);
            charge.setApp(app);
        }
        String creStr = charge.getCredential();
        Type hashMapType = new TypeToken<Map<String, Object>>(){}.getType();
        Map<String, Object> creMap = gson.fromJson(creStr, hashMapType);
        if (creMap.containsKey("wx")) {
            Map<String, Object> wx = (Map<String, Object>) creMap.get("wx");
            wx.put("timeStamp", String.valueOf(((Double)(wx.get("timeStamp"))).longValue()));
            charge.setCredential(creMap);
        }
        return charge;
    }
}
