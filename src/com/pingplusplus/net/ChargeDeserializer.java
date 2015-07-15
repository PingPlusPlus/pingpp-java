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
import com.pingplusplus.model.Charge;
import com.pingplusplus.model.ChargeRefundCollection;

import java.lang.reflect.Type;

/**
 * Created by afon on 14/11/25.
 */
public class ChargeDeserializer implements JsonDeserializer<Charge> {

    @Override
    public Charge deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {

        JsonObject chargeJson = jsonElement.getAsJsonObject();
        if (null != chargeJson.getAsJsonObject("credential")) {
            JsonObject credentialJson = chargeJson.getAsJsonObject("credential");
            if (null != credentialJson.getAsJsonObject("wx")) {
                JsonObject wx = credentialJson.getAsJsonObject("wx");
                Long timeStamp = wx.get("timeStamp").getAsLong();
                wx.addProperty("timeStamp", "" + timeStamp);
            } else if (null != credentialJson.getAsJsonObject("wx_pub")) {
                JsonObject wx = credentialJson.getAsJsonObject("wx_pub");
                Long timeStamp = wx.get("timeStamp").getAsLong();
                wx.addProperty("timeStamp", "" + timeStamp);
            } else if (null != credentialJson.getAsJsonObject("bfb")) {
                JsonObject bfb = credentialJson.getAsJsonObject("bfb");
                Long total_amount = bfb.get("total_amount").getAsLong();
                bfb.addProperty("total_amount", total_amount + "");
            }

        }

        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).
                registerTypeAdapter(ChargeRefundCollection.class, new ChargeRefundCollectionDeserializer())
                .create();
        JsonElement appElement = chargeJson.get("app");
        Charge charge = gson.fromJson(jsonElement, Charge.class);

        if (null != appElement && appElement.isJsonObject()) {
            App app = gson.fromJson(appElement, App.class);
            charge.setApp(app);
        }
        return charge;
    }
}
