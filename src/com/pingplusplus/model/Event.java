package com.pingplusplus.model;

import com.pingplusplus.exception.APIConnectionException;
import com.pingplusplus.exception.APIException;
import com.pingplusplus.exception.AuthenticationException;
import com.pingplusplus.exception.InvalidRequestException;
import com.pingplusplus.net.APIResource;

import java.util.Map;
import java.util.Objects;

/**
 * Created by sunkai on 15/5/11.
 */
public class Event extends APIResource{
    private String id;
    private String object;
    private Boolean livemode;
    private Long created;
    private Map<String,Object>  data;
    private Integer pendingWebhooks;
    private String type;
    private String request;

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

    public Boolean getLivemode() {
        return livemode;
    }

    public void setLivemode(Boolean livemode) {
        this.livemode = livemode;
    }

    public Long getCreated() {
        return created;
    }

    public void setCreated(Long created) {
        this.created = created;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    public Integer getPendingWebhooks() {
        return pendingWebhooks;
    }

    public void setPendingWebhooks(Integer pendingWebhooks) {
        this.pendingWebhooks = pendingWebhooks;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }


    public static Event retrieve(String id) throws AuthenticationException,
            InvalidRequestException, APIConnectionException,
            APIException {
        return retrieve(id, null, null);
    }

    public static Event retrieve(String id, Map<String, Object> params) throws AuthenticationException,
            InvalidRequestException, APIConnectionException,
            APIException {
        return retrieve(id, params, null);
    }

    public static EventCollection all(Map<String, Object> params)
            throws AuthenticationException, InvalidRequestException,
            APIConnectionException, APIException {
        return all(params, null);
    }

    public static Event retrieve(String id, Map<String, Object> params, String apiKey)
            throws AuthenticationException, InvalidRequestException,
            APIConnectionException, APIException {
        return request(APIResource.RequestMethod.GET, instanceURL(Event.class, id), params,
                Event.class, apiKey);
    }

    public static EventCollection all(Map<String, Object> params, String apiKey)
            throws AuthenticationException, InvalidRequestException,
            APIConnectionException, APIException {
        return request(APIResource.RequestMethod.GET, classURL(Event.class), params,
                EventCollection.class, apiKey);
    }
}
