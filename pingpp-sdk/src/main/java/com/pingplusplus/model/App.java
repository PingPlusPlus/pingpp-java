package com.pingplusplus.model;

import java.util.List;

/**
 * Created by afon on 14/11/24.
 */
public class App extends PingppObject {
    String id;
    String object;
    Long created;
    String displayName;
    String notifyUrl;
    Integer goodsType;
    List<String> channelsSupported;

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

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }

    public Integer getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(Integer goodsType) {
        this.goodsType = goodsType;
    }

    public List<String> getChannelsSupported() {
        return channelsSupported;
    }

    public void setChannelsSupported(List<String> channelsSupported) {
        this.channelsSupported = channelsSupported;
    }
}
