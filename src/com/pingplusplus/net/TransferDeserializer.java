package com.pingplusplus.net;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.pingplusplus.model.App;
import com.pingplusplus.model.ChargeRefundCollection;
import com.pingplusplus.model.Transfer;

import java.lang.reflect.Type;

/**
 * Created by sunkai on 15/5/14.
 */
public class TransferDeserializer implements JsonDeserializer<Transfer> {
    @Override
    public Transfer deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

        JsonObject transFerJson = json.getAsJsonObject();
        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .registerTypeAdapter(ChargeRefundCollection.class, new ChargeRefundCollectionDeserializer())
                .create();
        JsonElement appElement = transFerJson.get("app");
        Transfer transfer = gson.fromJson(json, Transfer.class);

        if (null != appElement && appElement.isJsonObject()) {
            App app = gson.fromJson(appElement, App.class);
            transfer.setApp(app);
        }
        return transfer;
    }
}
