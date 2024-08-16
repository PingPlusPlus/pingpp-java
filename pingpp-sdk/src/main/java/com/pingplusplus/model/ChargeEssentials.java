package com.pingplusplus.model;

import java.util.Map;

/**
 * Created by Afon on 16/11/04.
 */
public class ChargeEssentials extends PingppObject {
    String channel;
    String transactionNo;
    Map<String, Object> credential;
    Map<String, Object> extra;

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getTransactionNo() {
        return transactionNo;
    }

    public void setTransactionNo(String transactionNo) {
        this.transactionNo = transactionNo;
    }

    public Map<String, Object> getCredential() {
        return credential;
    }

    public void setCredential(Map<String, Object> credential) {
        this.credential = credential;
    }

    public Map<String, Object> getExtra() {
        return extra;
    }

    public void setExtra(Map<String, Object> extra) {
        this.extra = extra;
    }
}
