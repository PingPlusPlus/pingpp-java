package com.pingplusplus.model;

/**
 * 分账的接收方数据
 */
public class SplitProfitRecipient extends PingppObject {
    String splitReceiver;
    Integer amount;
    String name;
    String description;
    String status;
    String currency;
    Long timeFinished;

    public String getSplitReceiver() {
        return splitReceiver;
    }

    public void setSplitReceiver(String splitReceiver) {
        this.splitReceiver = splitReceiver;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Long getTimeFinished() {
        return timeFinished;
    }

    public void setTimeFinished(Long timeFinished) {
        this.timeFinished = timeFinished;
    }
}
