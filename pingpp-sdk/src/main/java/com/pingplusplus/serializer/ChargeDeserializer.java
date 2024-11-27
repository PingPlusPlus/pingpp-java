package com.pingplusplus.serializer;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.pingplusplus.model.App;
import com.pingplusplus.model.Charge;
import com.pingplusplus.model.ChargeRefundCollection;
import com.pingplusplus.util.GsonUtils;

import java.lang.reflect.Type;

/**
 * Created by afon on 14/11/25.
 */
public class ChargeDeserializer implements JsonDeserializer<Charge> {

    @Override
    public Charge deserialize(JsonElement jsonElement,
                              Type type,
                              JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject chargeJson = jsonElement.getAsJsonObject();
        if (null != chargeJson.getAsJsonObject("credential")) {
            JsonObject credentialJson = chargeJson.getAsJsonObject("credential");
            JsonObject channelCredential;
            if (credentialJson.getAsJsonObject("wx") != null) {
                JsonObject wx = credentialJson.getAsJsonObject("wx");
                long timeStamp = wx.get("timeStamp").getAsLong();
                wx.addProperty("timeStamp", Long.toString(timeStamp));
            } else if (credentialJson.getAsJsonObject("wx_pub") != null) {
                JsonObject wxPub = credentialJson.getAsJsonObject("wx_pub");
                if (null == wxPub.get("signed_data") && wxPub.get("timeStamp") != null) {
                    long timeStamp = wxPub.get("timeStamp").getAsLong();
                    wxPub.addProperty("timeStamp", Long.toString(timeStamp));
                }
            } else if ((channelCredential = credentialJson.getAsJsonObject("bfb")) != null
                    || (channelCredential = credentialJson.getAsJsonObject("bfb_wap")) != null) {
                if (channelCredential.has("total_amount")) {
                    long total_amount = channelCredential.get("total_amount").getAsLong();
                    channelCredential.addProperty("total_amount", Long.toString(total_amount));
                }
            } else if ((channelCredential = credentialJson.getAsJsonObject("alipay")) != null
                    || (channelCredential = credentialJson.getAsJsonObject("alipay_wap")) != null
                    || (channelCredential = credentialJson.getAsJsonObject("alipay_pc_direct")) != null) {
                if (channelCredential.has("payment_type")) {
                    long paymentType = channelCredential.get("payment_type").getAsLong();
                    channelCredential.addProperty("payment_type", Long.toString(paymentType));
                }
            }
        }

        Gson gson = GsonUtils.baseGsonBuilder()
                .registerTypeAdapter(ChargeRefundCollection.class, new ChargeRefundCollectionDeserializer())
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
