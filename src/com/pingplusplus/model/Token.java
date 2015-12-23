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
public class Token extends APIResource {
    private String id;
    private String object;
    private Long created;
    private Boolean livemode;
    private Boolean used;
    private Long timeUsed;
    private String type;
    private Card card;
    private SMSCode smsCode;
    private Boolean attachable;

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

    public Boolean getUsed() {
        return used;
    }

    public void setUsed(Boolean used) {
        this.used = used;
    }

    public Long getTimeUsed() {
        return timeUsed;
    }

    public void setTimeUsed(Long timeUsed) {
        this.timeUsed = timeUsed;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public SMSCode getSmsCode() {
        return smsCode;
    }

    public void setSmsCode(SMSCode smsCode) {
        this.smsCode = smsCode;
    }

    public static Token create(Map<String, Object> params)
            throws AuthenticationException, InvalidRequestException,
            APIConnectionException, APIException, ChannelException {
        return request(APIResource.RequestMethod.POST, classURL(Token.class), params, Token.class);
    }

    public static Token retrieve(String id) throws AuthenticationException,
            InvalidRequestException, APIConnectionException,
            APIException, ChannelException {
        return request(RequestMethod.GET, instanceURL(Token.class, id), null, Token.class);
    }

    public Boolean getAttachable() {
        return attachable;
    }

    public void setAttachable(Boolean attachable) {
        this.attachable = attachable;
    }
}
