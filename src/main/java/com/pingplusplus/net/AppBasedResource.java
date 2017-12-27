package com.pingplusplus.net;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.pingplusplus.PingppAccount;
import com.pingplusplus.exception.InvalidRequestException;
import com.pingplusplus.model.*;
import com.pingplusplus.serializer.*;

import java.io.UnsupportedEncodingException;

public abstract class AppBasedResource extends APIResource {

    /**
     * Gson object use to transform json string to resource object
     */
    public static final Gson GSON = new GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .registerTypeAdapter(Charge.class, new ChargeDeserializer())
            .registerTypeAdapter(RedEnvelope.class, new RedEnvelopeDeserializer())
            .registerTypeAdapter(Transfer.class, new TransferDeserializer())
            .registerTypeAdapter(ChargeRefundCollection.class, new ChargeRefundCollectionDeserializer())
            .registerTypeAdapter(EventData.class, new AccountEventDataDeserializer())
            .registerTypeAdapter(PingppRawJsonObject.class, new PingppRawJsonObjectDeserializer())
            .create();

    public static final Gson PRETTY_PRINT_GSON = new GsonBuilder()
            .setPrettyPrinting()
            .serializeNulls()
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .disableHtmlEscaping()
            .registerTypeAdapter(BatchTransferRecipientSerializer.class, new BatchTransferRecipientSerializer())
            .registerTypeAdapter(BatchRefundCharges.class, new BatchRefundChargesSerializer())
            .registerTypeAdapter(Double.class, new DoubleTypeSerializer())
            .registerTypeAdapter(ChargeEssentials.class, new ChargeEssentialsSerializer())
            .registerTypeAdapter(CouponTemplateExpiration.class, new CouponTemplateExpirationSerializer())
            .registerTypeAdapter(SettleAccountRecipient.class, new SettleAccountRecipientSerializer())
            .create();

    protected static String className(Class<?> clazz) {
        String className = clazz.getSimpleName().toLowerCase().replace("$", " ");

        if (className.equals("assettransaction")) {
            return "asset_transaction";
        } else if (className.equals("balancebonus")) {
            return "balance_bonuse";
        } else if(className.equals("balancetransfer")){
            return "balance_transfer";
        } else if (className.equals("balancetransaction")) {
            return "balance_transaction";
        } else if (className.equals("coupontemplate")) {
            return "coupon_template";
        } else if (className.equals("batchwithdrawal")) {
            return "batch_withdrawal";
        } else if (className.equals("transactionstatistics")) {
            return "transaction_statistics";
        } if (className.equals("settleaccount")) {
            return "settle_account";
        } if (className.equals("subapp")) {
            return "sub_app";
        } if (className.equals("royalty")) {
            return "royaltie";
        } if (className.equals("royaltysettlement")) {
            return "royalty_settlement";
        } if (className.equals("royaltytransaction")) {
            return "royalty_transaction";
        } else {
            return className;
        }
    }

    /**
     * @param clazz
     * @return singleClassURL
     * @throws InvalidRequestException
     */
    protected static String singleClassURL(Class<?> clazz) throws InvalidRequestException {
        if (PingppAccount.appId == null) {
            throw new InvalidRequestException("Please set app_id using PingppAccount.appId = <APP_ID>", "app_id", null);
        }
        return String.format("%s/v1/apps/%s/%s", PingppAccount.getApiBase(), PingppAccount.appId, className(clazz));
    }

    /**
     * @param clazz
     * @return classURL
     * @throws InvalidRequestException
     */
    protected static String classURL(Class<?> clazz) throws InvalidRequestException {
        return String.format("%ss", singleClassURL(clazz));
    }

    /**
     * @param clazz
     * @param id
     * @return instanceURL
     * @throws InvalidRequestException
     */
    protected static String instanceURL(Class<?> clazz, String id) throws InvalidRequestException {
        try {
            return String.format("%s/%s", classURL(clazz), urlEncode(id));
        } catch (UnsupportedEncodingException e) {
            throw new InvalidRequestException("Unable to encode parameters to " + CHARSET, null, e);
        }
    }

    /**
     * @param objectName
     * @return customURL
     * @throws InvalidRequestException
     */
    protected static String customURL(String objectName) throws InvalidRequestException {
        if (PingppAccount.appId == null) {
            throw new InvalidRequestException("Please set app_id using PingppAccount.appId = <APP_ID>", "app_id", null);
        }
        return String.format("%s/v1/apps/%s/%s", PingppAccount.getApiBase(), PingppAccount.appId, objectName);
    }
}
