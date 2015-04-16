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

		JsonObject chargeJson = jsonElement.getAsJsonObject();
		if (null != chargeJson.getAsJsonObject("credential")) {
			JsonObject credentialJson = chargeJson.getAsJsonObject("credential");
			if (null != credentialJson.getAsJsonObject("wx")) {
				JsonObject wx = credentialJson.getAsJsonObject("wx");
				Long timeStamp = wx.get("timeStamp").getAsLong();
				wx.addProperty("timeStamp", "" + timeStamp);
			}
		}
		
		Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).registerTypeAdapter(ChargeRefundCollection.class, new ChargeRefundCollectionDeserializer())
				.registerTypeAdapter(PingppRawJsonObject.class, new PingppRawJsonObjectDeserializer()).create();
		Charge charge = gson.fromJson(jsonElement, Charge.class);
		return charge;
	}
}
