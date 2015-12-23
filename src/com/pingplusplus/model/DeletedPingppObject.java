package com.pingplusplus.model;

/**
 * Created by Afon on 15/12/23.
 */
public interface DeletedPingppObject {
    public String getId();
    public void setId(String id);
    public Boolean getDeleted();
    public void setDeleted(Boolean deleted);
}