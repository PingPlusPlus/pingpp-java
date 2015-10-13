package com.pingplusplus.model;

import com.pingplusplus.exception.APIConnectionException;
import com.pingplusplus.exception.APIException;
import com.pingplusplus.exception.AuthenticationException;
import com.pingplusplus.exception.ChannelException;
import com.pingplusplus.exception.InvalidRequestException;
import com.pingplusplus.net.APIResource;

/**
 * Created by sunkai on 15/9/21.
 */
public class SMSCode extends APIResource {
    private String id;
    private String object;
    private Long created;
    private Boolean validated;
    private String source;
    private String code;

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

    public Boolean getValidated() {
        return validated;
    }

    public void setValidated(Boolean validated) {
        this.validated = validated;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public static SMSCode retrieve(String id) throws AuthenticationException,
            InvalidRequestException, APIConnectionException,
            APIException, ChannelException {
        return request(APIResource.RequestMethod.GET, instanceURL(SMSCode.class, id), null, SMSCode.class);
    }
}
