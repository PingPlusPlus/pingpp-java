package com.pingplusplus.model;

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
}
