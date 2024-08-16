package com.pingplusplus.model;

import java.util.Map;

/**
 * Created by Afon on 17/03/27.
 */
public class SettleAccountRecipient extends PingppObject {
    String account;
    String name;
    String type;
    String openBankCode;
    String openBank;
    Boolean forceCheck;
    String accountType;
    Integer cardType;
    String prov;
    String city;
    String subBank;
    String subBankCode;
    String mobile;
    String useof;
    String senderCardNumber;
    String senderSubBankCode;
    Map<String, Object> extra;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public Boolean getForceCheck() {
        return forceCheck;
    }

    public void setForceCheck(Boolean forceCheck) {
        this.forceCheck = forceCheck;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public Integer getCardType() {
        return cardType;
    }

    public void setCardType(Integer cardType) {
        this.cardType = cardType;
    }

    public String getProv() {
        return prov;
    }

    public void setProv(String prov) {
        this.prov = prov;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getSubBank() {
        return subBank;
    }

    public void setSubBank(String subBank) {
        this.subBank = subBank;
    }

    public String getSubBankCode() {
        return subBankCode;
    }

    public void setSubBankCode(String subBankCode) {
        this.subBankCode = subBankCode;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getUseof() {
        return useof;
    }

    public void setUseof(String useof) {
        this.useof = useof;
    }

    public String getSenderCardNumber() {
        return senderCardNumber;
    }

    public void setSenderCardNumber(String senderCardNumber) {
        this.senderCardNumber = senderCardNumber;
    }

    public String getSenderSubBankCode() {
        return senderSubBankCode;
    }

    public void setSenderSubBankCode(String senderSubBankCode) {
        this.senderSubBankCode = senderSubBankCode;
    }

    public Map<String, Object> getExtra() {
        return extra;
    }

    public void setExtra(Map<String, Object> extra) {
        this.extra = extra;
    }
}
