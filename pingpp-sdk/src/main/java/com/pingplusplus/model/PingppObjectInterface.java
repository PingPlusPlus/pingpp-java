package com.pingplusplus.model;

import com.pingplusplus.net.PingppResponse;

public interface PingppObjectInterface {
    public PingppResponse getLastResponse();

    public void setLastResponse(PingppResponse response);
}
