package com.pingplusplus.model;

import com.pingplusplus.exception.*;
import com.pingplusplus.net.APIResource;
import com.pingplusplus.net.AppBasedResource;

import java.util.List;
import java.util.Map;

public class SubApp extends AppBasedResource {
    String id;
    String object;
    Long created;
    String account;
    String description;
    String displayName;
    List<String> availableMethods;
    String user;
    Integer level;
    String parentApp;
    Map<String, Object> metadata;


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

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public List<String> getAvailableMethods() {
        return availableMethods;
    }

    public void setAvailableMethods(List<String> availableMethods) {
        this.availableMethods = availableMethods;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Map<String, Object> getMetadata() {
        return metadata;
    }

    public void setMetadata(Map<String, Object> metadata) {
        this.metadata = metadata;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getParentApp() {
        return parentApp;
    }

    public void setParentApp(String parentApp) {
        this.parentApp = parentApp;
    }

    /**
     * 创建 sub_app
     *
     * @param params
     * @return SubApp
     * @throws AuthenticationException
     * @throws InvalidRequestException
     * @throws APIConnectionException
     * @throws APIException
     * @throws ChannelException
     * @throws RateLimitException
     */
    public static SubApp create(Map<String, Object>params)
            throws AuthenticationException, InvalidRequestException,
            APIConnectionException, APIException, ChannelException, RateLimitException {
        return request(APIResource.RequestMethod.POST, classURL(SubApp.class), params, SubApp.class);
    }

    /**
     * 查询 sub_app
     *
     * @param id
     * @return SubApp
     * @throws AuthenticationException
     * @throws InvalidRequestException
     * @throws APIConnectionException
     * @throws APIException
     * @throws ChannelException
     * @throws RateLimitException
     */
    public static SubApp retrieve(String id)
            throws AuthenticationException, InvalidRequestException,
            APIConnectionException, APIException, ChannelException, RateLimitException {
        return request(APIResource.RequestMethod.GET, instanceURL(SubApp.class, id), null, SubApp.class);
    }

    /**
     * 查询 sub_app 列表
     *
     * @param params
     * @return SubApp
     * @throws AuthenticationException
     * @throws InvalidRequestException
     * @throws APIConnectionException
     * @throws APIException
     * @throws ChannelException
     * @throws RateLimitException
     */
    public static SubAppCollection list(Map<String, Object> params)
            throws AuthenticationException, InvalidRequestException,
            APIConnectionException, APIException, ChannelException, RateLimitException {
        return request(APIResource.RequestMethod.GET, classURL(SubApp.class), params, SubAppCollection.class);
    }

    /**
     * 更新 sub_app
     *
     * @param id
     * @param params
     * @return SubApp
     * @throws AuthenticationException
     * @throws InvalidRequestException
     * @throws APIConnectionException
     * @throws APIException
     * @throws ChannelException
     * @throws RateLimitException
     */
    public static SubApp update(String id, Map<String, Object>params)
            throws AuthenticationException, InvalidRequestException,
            APIConnectionException, APIException, ChannelException, RateLimitException {
        return request(APIResource.RequestMethod.PUT, instanceURL(SubApp.class, id), params, SubApp.class);
    }

    /**
     * 删除 sub_app
     *
     * @param id
     * @return DeletedSubApp
     * @throws AuthenticationException
     * @throws InvalidRequestException
     * @throws APIConnectionException
     * @throws APIException
     * @throws ChannelException
     * @throws RateLimitException
     */
    public static DeletedSubApp delete(String id)
            throws AuthenticationException, InvalidRequestException,
            APIConnectionException, APIException, ChannelException, RateLimitException {
        return request(APIResource.RequestMethod.DELETE, instanceURL(SubApp.class, id), null, DeletedSubApp.class);
    }
}
