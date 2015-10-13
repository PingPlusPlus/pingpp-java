package com.pingplusplus.model;

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
public class Customer extends APIResource {
    private String id;
    private String object;
    private Long created;
    private Boolean livemode;
    private Object app;
    private String email;
    private String currency;
    private String description;
    private Map<String, String> metadata;
    private CardCollection source;
    private Object defaultSource;

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

    public CardCollection getSource() {
        return source;
    }

    public void setSource(CardCollection source) {
        this.source = source;
    }

    public Object getDefaultSource() {
        return defaultSource;
    }

    public void setDefaultSource(Object defaultSource) {
        this.defaultSource = defaultSource;
    }

    public static Customer create(Map<String, Object> params)
            throws AuthenticationException, InvalidRequestException,
            APIConnectionException, APIException, ChannelException {
        return request(APIResource.RequestMethod.POST, classURL(Customer.class), params, Customer.class);
    }

    public static Customer update(String id, Map<String, Object> params) throws ChannelException, APIException, AuthenticationException, InvalidRequestException, APIConnectionException {
        return request(APIResource.RequestMethod.POST, instanceURL(Customer.class, id), params, Customer.class);
    }

    //TODO
    public static DeleteResult delete(String id) throws ChannelException, APIException, AuthenticationException, InvalidRequestException, APIConnectionException {
        return request(RequestMethod.DELETE, instanceURL(Customer.class, id), null, DeleteResult.class);
    }

    public static Customer retrieve(String id) throws AuthenticationException,
            InvalidRequestException, APIConnectionException,
            APIException, ChannelException {
        return request(APIResource.RequestMethod.GET, instanceURL(Customer.class, id), null, Customer.class);
    }

    public static CustomerCollection all(Map<String, Object> params)
            throws AuthenticationException, InvalidRequestException,
            APIConnectionException, APIException, ChannelException {
        return request(APIResource.RequestMethod.GET, classURL(Customer.class), params, CustomerCollection.class);
    }
}
