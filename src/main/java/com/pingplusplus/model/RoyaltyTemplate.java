package com.pingplusplus.model;

import com.pingplusplus.exception.*;
import com.pingplusplus.net.APIResource;
import com.pingplusplus.net.AccountAPIResource;

import java.util.Map;

public class RoyaltyTemplate extends AccountAPIResource {
    String id;
    String object;
    Boolean livemode;
    String app;
    String name;
    Long created;
    String description;
    Map<String, Object> rule;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getApp() {
        return app;
    }

    public void setApp(String app) {
        this.app = app;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCreated() {
        return created;
    }

    public void setCreated(Long created) {
        this.created = created;
    }

    public Map<String, Object> getRule() {
        return rule;
    }

    public void setRule(Map<String, Object> rule) {
        this.rule = rule;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 创建 royalty_template
     *
     * @param params
     * @return RoyaltyTemplate
     * @throws AuthenticationException
     * @throws InvalidRequestException
     * @throws APIConnectionException
     * @throws APIException
     * @throws ChannelException
     * @throws RateLimitException
     */
    public static RoyaltyTemplate create(Map<String, Object> params) throws AuthenticationException,
            InvalidRequestException, APIConnectionException,
            APIException, ChannelException, RateLimitException {
        return request(APIResource.RequestMethod.POST, classURL(RoyaltyTemplate.class), params, RoyaltyTemplate.class);
    }

    /**
     * 查询 royalty_template
     *
     * @param id
     * @return RoyaltyTemplate
     * @throws AuthenticationException
     * @throws InvalidRequestException
     * @throws APIConnectionException
     * @throws APIException
     * @throws ChannelException
     * @throws RateLimitException
     */
    public static RoyaltyTemplate retrieve(String id) throws AuthenticationException,
            InvalidRequestException, APIConnectionException,
            APIException, ChannelException, RateLimitException {
        return request(APIResource.RequestMethod.GET, instanceURL(RoyaltyTemplate.class, id), null, RoyaltyTemplate.class);
    }

    /**
     * 查询 royalty_template 列表
     *
     * @param params
     * @return RoyaltyTemplateCollection
     * @throws AuthenticationException
     * @throws InvalidRequestException
     * @throws APIConnectionException
     * @throws APIException
     * @throws ChannelException
     * @throws RateLimitException
     */
    public static RoyaltyTemplateCollection list(Map<String, Object> params)
            throws AuthenticationException, InvalidRequestException,
            APIConnectionException, APIException, ChannelException, RateLimitException {
        return request(APIResource.RequestMethod.GET, classURL(RoyaltyTemplate.class), params, RoyaltyTemplateCollection.class);
    }

    /**
     * 删除 royalty_template
     *
     * @param id
     * @return DeleteRoyaltyTemplate
     * @throws AuthenticationException
     * @throws InvalidRequestException
     * @throws APIConnectionException
     * @throws APIException
     * @throws ChannelException
     * @throws RateLimitException
     */
    public static DeleteRoyaltyTemplate delete(String id)
            throws AuthenticationException, InvalidRequestException,
            APIConnectionException, APIException, ChannelException, RateLimitException {
        return request(APIResource.RequestMethod.DELETE, instanceURL(RoyaltyTemplate.class, id), null, DeleteRoyaltyTemplate.class);
    }

    /**
     *  更新 royalty_template
     *
     * @param id
     * @return RoyaltyTemplate
     * @throws AuthenticationException
     * @throws InvalidRequestException
     * @throws APIConnectionException
     * @throws APIException
     * @throws ChannelException
     * @throws RateLimitException
     */
    public static RoyaltyTemplate update(String id, Map<String, Object> params)
            throws AuthenticationException, InvalidRequestException,
            APIConnectionException, APIException, ChannelException, RateLimitException {
        return request(APIResource.RequestMethod.PUT, instanceURL(RoyaltyTemplate.class, id), params, RoyaltyTemplate.class);
    }
}
