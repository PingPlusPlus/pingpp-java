package com.pingplusplus.model;

import com.pingplusplus.exception.*;
import com.pingplusplus.net.APIResource;

import java.util.List;
import java.util.Map;

public class CardBin extends APIResource {
    String app;
    String cardBin;
    Integer cardType;
    String openBankCode;
    String openBank;
    List<String> supportChannels;

    public String getApp() {
        return app;
    }

    public void setApp(String app) {
        this.app = app;
    }

    public String getCardBin() {
        return cardBin;
    }

    public void setCardBin(String cardBin) {
        this.cardBin = cardBin;
    }

    public Integer getCardType() {
        return cardType;
    }

    public void setCardType(Integer cardType) {
        this.cardType = cardType;
    }

    public String getOpenBankCode() {
        return openBankCode;
    }

    public void setOpenBankCode(String openBankCode) {
        this.openBankCode = openBankCode;
    }

    public String getOpenBank() {
        return openBank;
    }

    public void setOpenBank(String openBank) {
        this.openBank = openBank;
    }

    public List<String> getSupportChannels() {
        return supportChannels;
    }

    public void setSupportChannels(List<String> supportChannels) {
        this.supportChannels = supportChannels;
    }

    /**
     * 银行卡信息查询
     *
     * @param params 卡号等信息
     * @return CardBin
     * @throws AuthenticationException
     * @throws InvalidRequestException
     * @throws APIConnectionException
     * @throws APIException
     * @throws ChannelException
     */
    public static CardBin query(Map<String, Object> params)
            throws AuthenticationException, InvalidRequestException,
            APIConnectionException, APIException, ChannelException, RateLimitException {
        return query(params, null);
    }

    /**
     * 银行卡信息查询
     *
     * @param params 卡号等信息
     * @param apiKey  Ping++ ApiKey
     * @return CardBin
     * @throws AuthenticationException
     * @throws InvalidRequestException
     * @throws APIConnectionException
     * @throws APIException
     * @throws ChannelException
     * @throws RateLimitException
     */
    public static CardBin query(Map<String, Object> params, String apiKey)
            throws AuthenticationException, InvalidRequestException,
            APIConnectionException, APIException, ChannelException, RateLimitException {
        return request(RequestMethod.POST, singleClassURL(CardBin.class), apiKey, params, CardBin.class);
    }
}
