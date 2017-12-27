package com.pingplusplus.model;

import com.pingplusplus.exception.*;
import com.pingplusplus.net.APIResource;
import com.pingplusplus.net.SubAppBasedResource;

import java.util.Map;

public class Channel extends SubAppBasedResource {
    String object;
    Long created;
    String channel;
    Boolean banned;
    String bannedMsg;
    String description;
    Map<String, Object> params;

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

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public Boolean getBanned() {
        return banned;
    }

    public void setBanned(Boolean banned) {
        this.banned = banned;
    }

    public String getBannedMsg() {
        return bannedMsg;
    }

    public void setBannedMsg(String bannedMsg) {
        this.bannedMsg = bannedMsg;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Map<String, Object> getParams() {
        return params;
    }

    public void setParams(Map<String, Object> params) {
        this.params = params;
    }

    /**
     * 创建渠道参数
     *
     * @param subAppId
     * @param params
     * @return Channel
     * @throws AuthenticationException
     * @throws InvalidRequestException
     * @throws APIConnectionException
     * @throws APIException
     * @throws ChannelException
     * @throws RateLimitException
     */
    public static Channel create(String subAppId, Map<String, Object>params)
            throws AuthenticationException, InvalidRequestException,
            APIConnectionException, APIException, ChannelException, RateLimitException {
        return request(APIResource.RequestMethod.POST, classURL(Channel.class, subAppId), params, Channel.class);
    }

    /**
     * 查询渠道参数
     *
     * @param subAppId
     * @param channel
     * @return Channel
     * @throws AuthenticationException
     * @throws InvalidRequestException
     * @throws APIConnectionException
     * @throws APIException
     * @throws ChannelException
     * @throws RateLimitException
     */
    public static Channel retrieve(String subAppId, String channel)
            throws AuthenticationException, InvalidRequestException,
            APIConnectionException, APIException, ChannelException, RateLimitException {
        return request(APIResource.RequestMethod.GET, instanceURL(Channel.class, subAppId, channel), null, Channel.class);
    }

    /**
     * 更新渠道参数
     *
     * @param subAppId
     * @param channel
     * @param params
     * @return Channel
     * @throws AuthenticationException
     * @throws InvalidRequestException
     * @throws APIConnectionException
     * @throws APIException
     * @throws ChannelException
     * @throws RateLimitException
     */
    public static Channel update(String subAppId, String channel, Map<String, Object>params)
            throws AuthenticationException, InvalidRequestException,
            APIConnectionException, APIException, ChannelException, RateLimitException {
        return request(APIResource.RequestMethod.PUT, instanceURL(Channel.class, subAppId, channel), params, Channel.class);
    }

    /**
     * 删除渠道参数
     *
     * @param subAppId
     * @param channel
     * @return DeletedChannel
     * @throws AuthenticationException
     * @throws InvalidRequestException
     * @throws APIConnectionException
     * @throws APIException
     * @throws ChannelException
     * @throws RateLimitException
     */
    public static DeletedChannel delete(String subAppId, String channel)
            throws AuthenticationException, InvalidRequestException,
            APIConnectionException, APIException, ChannelException, RateLimitException {
        return request(APIResource.RequestMethod.DELETE, instanceURL(Channel.class, subAppId, channel), null, DeletedChannel.class);
    }
}
