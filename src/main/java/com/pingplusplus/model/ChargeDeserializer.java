package com.pingplusplus.model;

import com.google.gson.*;

import java.lang.reflect.Type;

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
        return charge;
    }
}
