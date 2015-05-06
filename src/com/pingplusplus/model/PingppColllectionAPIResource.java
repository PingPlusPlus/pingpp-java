package com.pingplusplus.model;

import com.pingplusplus.net.APIResource;

import java.util.List;

public abstract class PingppColllectionAPIResource<T> extends APIResource {
    String object;
    String url;
    Boolean hasMore;
    List<T> data;

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public Boolean getHasMore() {
        return hasMore;
    }

    public void setHasMore(Boolean hasMore) {
        this.hasMore = hasMore;
    }

    public String getURL() {
        return url;
    }

    public void setURL(String url) {
        this.url = url;
    }

}
