package com.pingplusplus.serializer;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.pingplusplus.model.App;
import com.pingplusplus.model.ChargeRefundCollection;
import com.pingplusplus.model.RedEnvelope;
import com.pingplusplus.util.GsonUtils;

import java.lang.reflect.Type;

/**
 * Created by sunkai on 15/5/14.
 */
public class RedEnvelopeDeserializer implements JsonDeserializer<RedEnvelope> {
    @Override
    public RedEnvelope deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject transFerJson = json.getAsJsonObject();
        Gson gson = GsonUtils.baseGsonBuilder()
                .registerTypeAdapter(ChargeRefundCollection.class, new ChargeRefundCollectionDeserializer())
                .create();
        JsonElement appElement = transFerJson.get("app");
        RedEnvelope redEnvelope = gson.fromJson(json, RedEnvelope.class);

        if (null != appElement && appElement.isJsonObject()) {
            App app = gson.fromJson(appElement, App.class);
            redEnvelope.setApp(app);
        }
        return redEnvelope;
    }
}
