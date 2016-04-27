package com.pingplusplus.model;

/**
 * Created by Afon on 15/12/23.
 */
public class DeletedCard extends PingppObject implements DeletedPingppObject {
    String id;
    Boolean deleted;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public Boolean getDeleted() {
        return deleted;
    }
    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }
}
