package com.pingplusplus.net;

import com.pingplusplus.Pingpp;
import com.pingplusplus.model.PingppObject;

/**
 * Created by sunkai on 15/9/21.
 */
public class DeleteResult extends PingppObject{
    private Boolean deleted;
    private String id;

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
