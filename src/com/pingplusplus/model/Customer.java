package com.pingplusplus.model;

import com.pingplusplus.exception.APIConnectionException;
import com.pingplusplus.exception.APIException;
import com.pingplusplus.exception.AuthenticationException;
import com.pingplusplus.exception.ChannelException;
import com.pingplusplus.exception.InvalidRequestException;
import com.pingplusplus.net.APIResource;

import java.util.Map;

/**
 * Created by sunkai on 15/9/21.
 */
public class Customer extends APIResource {
    private String id;
    private String object;
    private Long created;
    private Boolean livemode;
    private Object app;
    private String name;
    private String email;
    private String currency;
    private String description;
    private Map<String, String> metadata;
    private CardCollection sources;
    private String defaultSource;

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

    public Boolean getLivemode() {
        return livemode;
    }

    public void setLivemode(Boolean livemode) {
        this.livemode = livemode;
    }

    public Object getApp() {
        return app;
    }

    public void setApp(Object app) {
        this.app = app;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Map<String, String> getMetadata() {
        return metadata;
    }

    public void setMetadata(Map<String, String> metadata) {
        this.metadata = metadata;
    }

    public CardCollection getSources() {
        return sources;
    }

    public void setSources(CardCollection sources) {
        this.sources = sources;
    }

    public String getDefaultSource() {
        return defaultSource;
    }

    public void setDefaultSource(String defaultSource) {
        this.defaultSource = defaultSource;
    }

    public static Customer create(Map<String, Object> params)
            throws AuthenticationException, InvalidRequestException,
            APIConnectionException, APIException, ChannelException {
        return request(RequestMethod.POST, classURL(Customer.class), params, Customer.class);
    }

    public Customer update(Map<String, Object> params) throws ChannelException, APIException, AuthenticationException, InvalidRequestException, APIConnectionException {
        return request(RequestMethod.PUT, instanceURL(Customer.class, this.id), params, Customer.class);
    }

    public DeletedCustomer delete() throws ChannelException, APIException, AuthenticationException, InvalidRequestException, APIConnectionException {
        return request(RequestMethod.DELETE, instanceURL(Customer.class, this.id), null, DeletedCustomer.class);
    }

    public static Customer retrieve(String id) throws AuthenticationException,
            InvalidRequestException, APIConnectionException,
            APIException, ChannelException {
        return request(RequestMethod.GET, instanceURL(Customer.class, id), null, Customer.class);
    }

    public static CustomerCollection all(Map<String, Object> params)
            throws AuthenticationException, InvalidRequestException,
            APIConnectionException, APIException, ChannelException {
        return request(RequestMethod.GET, classURL(Customer.class), params, CustomerCollection.class);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
