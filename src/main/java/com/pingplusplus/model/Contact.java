package com.pingplusplus.model;

import com.pingplusplus.exception.*;
import com.pingplusplus.net.AppBasedResource;

import java.util.Map;

public class Contact extends AppBasedResource {
    String user;
    Boolean livemode;
    String accNo;
    String contactNo;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getAccNo() {
        return accNo;
    }

    public void setAccNo(String accNo) {
        this.accNo = accNo;
    }

    public Boolean getLivemode() {
        return livemode;
    }

    public void setLivemode(Boolean livemode) {
        this.livemode = livemode;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    /**
     * 新增联系人
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
    public static Contact create(Map<String, Object> params)
            throws AuthenticationException, InvalidRequestException,
            APIConnectionException, APIException, ChannelException, RateLimitException {
        return create(params, null);
    }

    /**
     * 新增联系人
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
    public static Contact create(Map<String, Object> params, String apiKey)
            throws AuthenticationException, InvalidRequestException,
            APIConnectionException, APIException, ChannelException, RateLimitException {
        return request(RequestMethod.POST, singleClassURL(Contact.class), apiKey, params, Contact.class);
    }
}
