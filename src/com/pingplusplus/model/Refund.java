package com.pingplusplus.model;

import com.pingplusplus.exception.APIConnectionException;
import com.pingplusplus.exception.APIException;
import com.pingplusplus.exception.AuthenticationException;
import com.pingplusplus.exception.ChannelException;
import com.pingplusplus.exception.InvalidRequestException;
import com.pingplusplus.net.APIResource;

import java.util.Map;

public class Refund extends APIResource /*implements MetadataStore<Charge>*/ {
    String id;
    String object;
    String orderNo;
    Integer amount;
    Long created;
    Boolean succeed;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setId(String id) {
        this.id = id;
    }

    String status;
    Long timeSucceed;
    String description;
    String failureCode;
    String failureMsg;
    Map<String, String> metadata;
    String charge;

    public Refund update(Map<String, Object> params)
            throws AuthenticationException, InvalidRequestException,
            APIConnectionException, APIException, ChannelException {
        return update(params, null);
    }

    public Refund update(Map<String, Object> params, String apiKey)
            throws AuthenticationException, InvalidRequestException,
            APIConnectionException, APIException, ChannelException {
        return request(RequestMethod.POST, this.getInstanceURL(), params, Refund.class);
    }

    public String getInstanceURL() {
        if (this.charge != null) {
            return String.format("%s/%s/refunds/%s", classURL(Charge.class), this.charge, this.getId());
        }
        return null;
    }

    public String getId() {
        return id;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Long getCreated() {
        return created;
    }

    public void setCreated(Long created) {
        this.created = created;
    }

    public String getCharge() {
        return charge;
    }

    public void setCharge(String charge) {
        this.charge = charge;
    }

    public Boolean getSucceed() {
        return succeed;
    }

    public void setSucceed(Boolean succeed) {
        this.succeed = succeed;
    }

    public Long getTimeSucceed() {
        return timeSucceed;
    }

    public void setTimeSucceed(Long timeSucceed) {
        this.timeSucceed = timeSucceed;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFailureMsg() {
        return failureMsg;
    }

    public void setFailureMsg(String failureMsg) {
        this.failureMsg = failureMsg;
    }

    public String getFailureCode() {
        return failureCode;
    }

    public void setFailureCode(String failureCode) {
        this.failureCode = failureCode;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public Map<String, String> getMetadata() {
        return metadata;
    }

    public void setMetadata(Map<String, String> metadata) {
        this.metadata = metadata;
    }
}
