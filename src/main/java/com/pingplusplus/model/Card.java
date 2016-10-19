package com.pingplusplus.model;

import com.pingplusplus.exception.*;
import com.pingplusplus.net.APIResource;

import java.util.Map;

/**
 * Created by sunkai on 15/9/21.
 */
public class Card extends APIResource {
    private String id;
    private String object;
    private Long created;
    private String last4;
    private String funding;
    private String brand;
    private String bank;
    private String customer;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public Long getCreated() {
        return created;
    }

    public void setCreated(Long created) {
        this.created = created;
    }

    public String getLast4() {
        return last4;
    }

    public void setLast4(String last4) {
        this.last4 = last4;
    }

    public String getFunding() {
        return funding;
    }

    public void setFunding(String funding) {
        this.funding = funding;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public DeletedCard delete() throws ChannelException, APIException,
            AuthenticationException, InvalidRequestException,
            APIConnectionException, RateLimitException {
        return request(RequestMethod.DELETE, this.getInstanceURL(), null, DeletedCard.class);
    }

    public static Card retrieve(String customerId, String id) throws AuthenticationException,
            InvalidRequestException, APIConnectionException,
            APIException, ChannelException, RateLimitException {
        String url = instanceURL(Customer.class, customerId) + "/sources/" + id;
        return request(APIResource.RequestMethod.GET, url, null, Card.class);
    }

    public String getInstanceURL() {
        if (this.getCustomer() != null) {
            return String.format("%s/%s/sources/%s", classURL(Customer.class), this.getCustomer(), this.getId());
        } else {
            return null;
        }
    }
}
