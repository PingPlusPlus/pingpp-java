package com.pingplusplus.serializer;

import com.google.gson.*;
import com.pingplusplus.model.*;
import com.pingplusplus.net.APIResource;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by Afon on 15/12/30.
 */
public class EventDataDeserializer implements JsonDeserializer<EventData> {

    @SuppressWarnings("rawtypes")
    static final Map<String, Class> objectMap = new HashMap<String, Class>();
    static {
        objectMap.put("charge", Charge.class);
        objectMap.put("transfer", Transfer.class);
        objectMap.put("refund", Refund.class);
        objectMap.put("red_envelope", RedEnvelope.class);
        objectMap.put("account_daily_summary", Summary.class);
        objectMap.put("account_weekly_summary", Summary.class);
        objectMap.put("account_monthly_summary", Summary.class);
        objectMap.put("app_monthly_summary", Summary.class);
        objectMap.put("app_daily_summary", Summary.class);
        objectMap.put("app_weekly_summary", Summary.class);
        objectMap.put("batch_transfer", BatchTransfer.class);
        objectMap.put("batch_refund", BatchRefund.class);
        objectMap.put("customs", Customs.class);
    }

    private Object deserializeJsonPrimitive(JsonPrimitive element) {
        if (element.isBoolean()) {
            return element.getAsBoolean();
        } else if (element.isNumber()) {
            return element.getAsNumber();
        } else {
            return element.getAsString();
        }
    }

    private Object[] deserializeJsonArray(JsonArray arr) {
        Object[] elems = new Object[arr.size()];
        Iterator<JsonElement> elemIter = arr.iterator();
        int i = 0;
        while (elemIter.hasNext()) {
            JsonElement elem = elemIter.next();
            elems[i++] = deserializeJsonElement(elem);
        }
        return elems;
    }

    private Object deserializeJsonElement(JsonElement element) {
        if (element.isJsonNull()) {
            return null;
        } else if (element.isJsonObject()) {
            Map<String, Object> valueMap = new HashMap<String, Object>();
            populateMapFromJSONObject(valueMap, element.getAsJsonObject());
            return valueMap;
        } else if (element.isJsonPrimitive()) {
            return deserializeJsonPrimitive(element.getAsJsonPrimitive());
        } else if (element.isJsonArray()) {
            return deserializeJsonArray(element.getAsJsonArray());
        } else {
            System.err.println("Unknown JSON element type for element " + element + ".");
            return null;
        }
    }

    private void populateMapFromJSONObject(Map<String, Object> objMap, JsonObject jsonObject) {
        for(Map.Entry<String, JsonElement> entry: jsonObject.entrySet()) {
            String key = entry.getKey();
            JsonElement element = entry.getValue();
            objMap.put(key, deserializeJsonElement(element));
        }
    }

    @SuppressWarnings("unchecked")
    public EventData deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
            throws JsonParseException {
        EventData eventData = new EventData();
        if (json.isJsonObject()) {
            JsonObject jsonObject = json.getAsJsonObject();
            for(Map.Entry<String, JsonElement> entry: jsonObject.entrySet()) {
                String key = entry.getKey();
                JsonElement element = entry.getValue();
                if ("object".equals(key)) {
                    String type = element.getAsJsonObject().get("object").getAsString();
                    Class<PingppObject> cl = objectMap.get(type);
                    PingppObject object = APIResource.GSON.fromJson(entry.getValue(), cl != null ? cl : PingppRawJsonObject.class);
                    eventData.setObject(object);
                }
            }
        }
        return eventData;
    }
}
