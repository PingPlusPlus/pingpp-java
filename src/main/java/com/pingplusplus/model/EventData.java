package com.pingplusplus.model;

/**
 * Created by Afon on 15/12/30.
 */
public class EventData extends PingppObject {
    PingppObject object;

    public PingppObject getObject() {
        return object;
    }

    public void setObject(PingppObject object) {
        this.object = object;
    }
}
