package com.pingplusplus.model;

/**
 * Created by Afon on 16/11/07.
 */
public class CouponTemplateExpiration extends PingppObject {
    Long timeStart;
    Long timeEnd;
    Long duration;

    public Long getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(Long timeStart) {
        this.timeStart = timeStart;
    }

    public Long getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(Long timeEnd) {
        this.timeEnd = timeEnd;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }
}
