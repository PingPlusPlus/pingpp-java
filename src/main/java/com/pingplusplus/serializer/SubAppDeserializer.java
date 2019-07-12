package com.pingplusplus.serializer;

import com.google.gson.*;
import com.pingplusplus.model.*;

import java.lang.reflect.Type;

/**
 * Created by afon on 19/07/12.
 */
public class SubAppDeserializer implements JsonDeserializer<SubApp> {

    @Override
    public SubApp deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {

        JsonObject subAppJson = jsonElement.getAsJsonObject();


        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();
        JsonElement userElement = subAppJson.get("user");
        SubApp subApp = gson.fromJson(jsonElement, SubApp.class);

        if (null != userElement && userElement.isJsonObject()) {
            User user = gson.fromJson(userElement, User.class);
            subApp.setUser(user);
        }

        return subApp;
    }
}
