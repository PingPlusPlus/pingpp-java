package com.pingplusplus.model;

/**
 * Created by Afon on 17/03/27.
 */
public class DeletedChannel extends PingppObject {
    String channel;
    Boolean deleted;

    public String getChannel() {
        return channel;
    }
    public void setChannel(String channel) {
        this.channel = channel;
    }
    public Boolean getDeleted() {
        return deleted;
    }
    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }
}
