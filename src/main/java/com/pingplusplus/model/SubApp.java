package com.pingplusplus.model;

import com.pingplusplus.exception.PingppException;
import com.pingplusplus.net.APIResource;
import com.pingplusplus.net.AppBasedResource;
import com.pingplusplus.net.RequestOptions;

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
    Object user;
    Integer level;
    String parentApp;
    Map<String, Object> metadata;
    Map<String, Object> extra;

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

    public Object getUser() {
        return user;
    }

    public void setUser(Object user) {
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

    public Map<String, Object> getExtra() {
        return extra;
    }

    public void setExtra(Map<String, Object> extra) {
        this.extra = extra;
    }

    /**
     * 创建 sub_app
     *
     * @param params
     * @return SubApp
     * @throws PingppException
     */
    public static SubApp create(Map<String, Object>params)
            throws PingppException {
        return create(params, null);
    }

    /**
     * 创建 sub_app
     *
     * @param params
     * @param options the specific options
     * @return SubApp
     * @throws PingppException
     */
    public static SubApp create(Map<String, Object>params, RequestOptions options)
            throws PingppException {
        return APIResource.request(APIResource.RequestMethod.POST, classURL(SubApp.class), params, SubApp.class, options);
    }

    /**
     * 查询 sub_app
     *
     * @param id
     * @return SubApp
     * @throws PingppException
     */
    public static SubApp retrieve(String id)
            throws PingppException {
        return retrieve(id, null, null);
    }

    /**
     * 查询 sub_app
     *
     * @param id SubApp ID
     * @param params 参数
     * @return SubApp
     * @throws PingppException
     */
    public static SubApp retrieve(String id, Map<String, Object> params)
            throws PingppException {
        return retrieve(id, params, null);
    }

    /**
     * 查询 sub_app
     *
     * @param id
     * @param options the specific options
     * @return SubApp
     * @throws PingppException
     */
    public static SubApp retrieve(String id, RequestOptions options)
            throws PingppException {
        return retrieve(id, null, options);
    }

    /**
     * 查询 sub_app
     *
     * @param id SubApp ID
     * @param params 参数
     * @param options the specific options
     * @return SubApp
     * @throws PingppException
     */
    public static SubApp retrieve(String id, Map<String, Object> params, RequestOptions options)
            throws PingppException {
        return APIResource.request(APIResource.RequestMethod.GET, instanceURL(SubApp.class, id), params, SubApp.class, options);
    }

    /**
     * 查询 sub_app 列表
     *
     * @param params
     * @return SubApp
     * @throws PingppException
     */
    public static SubAppCollection list(Map<String, Object> params)
            throws PingppException {
        return list(params, null);
    }

    /**
     * 查询 sub_app 列表
     *
     * @param params
     * @param options the specific options
     * @return SubApp
     * @throws PingppException
     */
    public static SubAppCollection list(Map<String, Object> params, RequestOptions options)
            throws PingppException {
        return APIResource.request(APIResource.RequestMethod.GET, classURL(SubApp.class), params, SubAppCollection.class, options);
    }

    /**
     * 更新 sub_app
     *
     * @param id
     * @param params
     * @return SubApp
     * @throws PingppException
     */
    public static SubApp update(String id, Map<String, Object>params)
            throws PingppException {
        return update(id, params, null);
    }

    /**
     * 更新 sub_app
     *
     * @param id
     * @param params
     * @param options the specific options
     * @return SubApp
     * @throws PingppException
     */
    public static SubApp update(String id, Map<String, Object>params, RequestOptions options)
            throws PingppException {
        return APIResource.request(APIResource.RequestMethod.PUT, instanceURL(SubApp.class, id), params, SubApp.class, options);
    }

    /**
     * 删除 sub_app
     *
     * @param id
     * @return DeletedSubApp
     * @throws PingppException
     */
    public static DeletedSubApp delete(String id)
            throws PingppException {
        return delete(id, null);
    }

    /**
     * 删除 sub_app
     *
     * @param id
     * @param options the specific options
     * @return DeletedSubApp
     * @throws PingppException
     */
    public static DeletedSubApp delete(String id, RequestOptions options)
            throws PingppException {
        return APIResource.request(APIResource.RequestMethod.DELETE, instanceURL(SubApp.class, id), null, DeletedSubApp.class, options);
    }
}
