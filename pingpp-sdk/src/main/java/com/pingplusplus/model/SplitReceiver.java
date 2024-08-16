package com.pingplusplus.model;

import com.pingplusplus.exception.PingppException;
import com.pingplusplus.net.APIResource;
import com.pingplusplus.net.RequestOptions;

import java.util.HashMap;
import java.util.Map;

/**
 * 分账接收方
 */
public class SplitReceiver extends APIResource {
    String id;
    String object;
    Boolean livemode;
    String app;
    Long created;
    String channel;
    String type;
    String account;
    String name;
    Map<String, Object> extra;
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

    public Boolean getLivemode() {
        return livemode;
    }

    public void setLivemode(Boolean livemode) {
        this.livemode = livemode;
    }

    public String getApp() {
        return app;
    }

    public void setApp(String app) {
        this.app = app;
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

    public Map<String, Object> getExtra() {
        return extra;
    }

    public void setExtra(Map<String, Object> extra) {
        this.extra = extra;
    }

    public Map<String, Object> getMetadata() {
        return metadata;
    }

    public void setMetadata(Map<String, Object> metadata) {
        this.metadata = metadata;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * 创建分账接收方
     *
     * @param params  参数
     * @return SplitReceiver
     * @throws PingppException
     */
    public static SplitReceiver create(Map<String, Object> params)
            throws PingppException {
        return create(params, null);
    }

    /**
     * 创建分账接收方
     *
     * @param params  参数
     * @param options the specific options
     * @return SplitReceiver
     * @throws PingppException
     */
    public static SplitReceiver create(Map<String, Object> params, RequestOptions options)
            throws PingppException {
        return request(RequestMethod.POST, classURL(SplitReceiver.class), params, SplitReceiver.class, options);
    }

    /**
     * 查询分账接收方
     *
     * @param id  id
     * @return SplitReceiver
     * @throws PingppException
     */
    public static SplitReceiver retrieve(String id) throws PingppException {
        return retrieve(id, null);
    }

    /**
     * 查询分账接收方
     *
     * @param id  id
     * @param options the specific options
     * @return SplitReceiver
     * @throws PingppException
     */
    public static SplitReceiver retrieve(String id, RequestOptions options) throws PingppException {
        return request(RequestMethod.GET, instanceURL(SplitReceiver.class, id), null, SplitReceiver.class, options);
    }

    /**
     * 查询分账接收方列表
     *
     * @param params  分页参数等
     * @return SplitReceiverCollection
     * @throws PingppException
     */
    public static SplitReceiverCollection list(Map<String, Object> params)
            throws PingppException {
        return list(params, null);
    }

    /**
     * 查询分账接收方列表
     *
     * @param params 分页参数等
     * @param options the specific options
     * @return SplitReceiverCollection
     * @throws PingppException
     */
    public static SplitReceiverCollection list(Map<String, Object> params, RequestOptions options)
            throws PingppException {
        return request(RequestMethod.GET, classURL(SplitReceiver.class), params, SplitReceiverCollection.class, options);
    }

    /**
     * 删除分账接收方
     *
     * @param id  id
     * @return DeletedSplitReceiver
     * @throws PingppException
     */
    public static DeletedSplitReceiver delete(String id) throws PingppException {
        return delete(id, null);
    }

    /**
     * 删除分账接收方
     *
     * @param id  id
     * @param options the specific options
     * @return DeletedSplitReceiver
     * @throws PingppException
     */
    public static DeletedSplitReceiver delete(String id, RequestOptions options) throws PingppException {
        return request(RequestMethod.DELETE, instanceURL(SplitReceiver.class, id), null, DeletedSplitReceiver.class, options);
    }
}
