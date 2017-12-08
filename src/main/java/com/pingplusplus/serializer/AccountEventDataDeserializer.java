package com.pingplusplus.serializer;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.pingplusplus.model.*;
import com.pingplusplus.net.AppBasedResource;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Afon on 16/12/27.
 */
public class AccountEventDataDeserializer extends EventDataDeserializer {

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

        objectMap.put("order", Order.class);
        objectMap.put("order_refund", OrderRefund.class);
        objectMap.put("user", User.class);
        objectMap.put("settle_account", SettleAccount.class);
        objectMap.put("withdrawal", Withdrawal.class);
        objectMap.put("batch_withdrawal", BatchWithdrawal.class);
        objectMap.put("balance_bonus", BalanceBonus.class);
        objectMap.put("balance_transfer", BalanceTransfer.class);
        objectMap.put("recharge", Recharge.class);
        objectMap.put("balance_transaction", BalanceTransaction.class);

        objectMap.put("coupon", Coupon.class);
        objectMap.put("coupon_template", CouponTemplate.class);

        objectMap.put("royalty", Royalty.class);
        objectMap.put("royalty_settlement", RoyaltySettlement.class);
        objectMap.put("royalty_transaction", RoyaltyTransaction.class);

        objectMap.put("sub_app", SubApp.class);
        objectMap.put("channel", Channel.class);
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
                    PingppObject object = AppBasedResource.GSON.fromJson(entry.getValue(), cl != null ? cl : PingppRawJsonObject.class);
                    eventData.setObject(object);
                }
            }
        }
        return eventData;
    }
}
