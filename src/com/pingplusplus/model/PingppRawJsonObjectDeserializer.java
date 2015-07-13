package com.pingplusplus.model;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

public class PingppRawJsonObjectDeserializer implements JsonDeserializer<PingppRawJsonObject> {
	public PingppRawJsonObject deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
			throws JsonParseException {
		PingppRawJsonObject object = new PingppRawJsonObject();
		object.json = json.getAsJsonObject();
		return object;
	}

}
