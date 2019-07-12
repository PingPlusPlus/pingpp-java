package com.pingplusplus.model;

import com.pingplusplus.exception.*;
import com.pingplusplus.net.AppBasedResource;

import java.util.Map;

public class UserPic extends AppBasedResource {
    String user;
    Boolean livemode;
    String type;
    String operateType;
    String picFmt;
    String picType;
    String accNo;
    String picExternalId;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Boolean getLivemode() {
        return livemode;
    }

    public void setLivemode(Boolean livemode) {
        this.livemode = livemode;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getOperateType() {
        return operateType;
    }

    public void setOperateType(String operateType) {
        this.operateType = operateType;
    }

    public String getPicFmt() {
        return picFmt;
    }

    public void setPicFmt(String picFmt) {
        this.picFmt = picFmt;
    }

    public String getPicType() {
        return picType;
    }

    public void setPicType(String picType) {
        this.picType = picType;
    }

    public String getAccNo() {
        return accNo;
    }

    public void setAccNo(String accNo) {
        this.accNo = accNo;
    }

    public String getPicExternalId() {
        return picExternalId;
    }

    public void setPicExternalId(String picExternalId) {
        this.picExternalId = picExternalId;
    }

    /**
     * 证件上传
     *
     * @param params 请求参数
     * @return Contact
     * @throws AuthenticationException 认证异常
     * @throws InvalidRequestException 错误请求
     * @throws APIConnectionException 连接异常
     * @throws APIException 系统异常
     * @throws ChannelException 渠道异常
     * @throws RateLimitException 请求超限
     */
    public static UserPic upload(Map<String, Object> params)
            throws AuthenticationException, InvalidRequestException,
            APIConnectionException, APIException, ChannelException, RateLimitException {
        return upload(params, null);
    }

    /**
     * 证件上传
     *
     * @param params 请求参数
     * @param apiKey API key
     * @return Contact
     * @throws AuthenticationException 认证异常
     * @throws InvalidRequestException 错误请求
     * @throws APIConnectionException 连接异常
     * @throws APIException 系统异常
     * @throws ChannelException 渠道异常
     * @throws RateLimitException 请求超限
     */
    public static UserPic upload(Map<String, Object> params, String apiKey)
            throws AuthenticationException, InvalidRequestException,
            APIConnectionException, APIException, ChannelException, RateLimitException {
        return request(RequestMethod.POST, singleClassURL(UserPic.class), apiKey, params, UserPic.class);
    }
}
