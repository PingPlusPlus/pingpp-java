package com.pingplusplus.model;

import com.pingplusplus.Pingpp;
import com.pingplusplus.exception.APIConnectionException;
import com.pingplusplus.exception.APIException;
import com.pingplusplus.exception.AuthenticationException;
import com.pingplusplus.exception.ChannelException;
import com.pingplusplus.exception.InvalidRequestException;
import com.pingplusplus.net.APIResource;
import com.pingplusplus.net.DeleteResult;

import java.util.Map;

/**
 * Created by sunkai on 15/9/21.
 */
public class Card extends APIResource {
    private String id;
    private String object;
    private Long timestamp;
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

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
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


    public static Card create(String customerId, Map<String, Object> params)
            throws AuthenticationException, InvalidRequestException,
            APIConnectionException, APIException, ChannelException {
        String url = instanceURL(Customer.class, customerId) + "/sources";
        return request(APIResource.RequestMethod.POST, url, params, Card.class);
    }

    public static DeleteResult delete(String customerId, String id) throws ChannelException, APIException, AuthenticationException, InvalidRequestException, APIConnectionException {
        String url = instanceURL(Customer.class, customerId) + "/sources/" + id;
        return request(RequestMethod.DELETE, url, null, DeleteResult.class);
    }

    public static Card retrieve(String customerId, String id) throws AuthenticationException,
            InvalidRequestException, APIConnectionException,
            APIException, ChannelException {
        String url = instanceURL(Customer.class, customerId) + "/sources/" + id;
        return request(APIResource.RequestMethod.GET, url, null, Card.class);
    }

    public static CardCollection all(String customerId, Map<String, Object> params)
            throws AuthenticationException, InvalidRequestException,
            APIConnectionException, APIException, ChannelException {
        String url = instanceURL(Customer.class, customerId) + "/sources";
        return request(APIResource.RequestMethod.GET, url, params, CardCollection.class);
    }
}
