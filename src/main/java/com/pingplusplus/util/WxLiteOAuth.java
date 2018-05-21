package com.pingplusplus.util;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.GsonBuilder;
import com.pingplusplus.exception.ChannelException;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/**
 * 用于微信小程序用户授权后获取用户唯一标识 openid
 * WxLiteOAuth 中的方法都是可选的，开发者也可根据实际情况自行开发相关功能，
 * 详细内容可参考 https://developers.weixin.qq.com/miniprogram/dev/api/api-login.html
 */
public class WxLiteOAuth extends WxpubOAuth {
    /**
     * 获取微信小程序授权用户唯一标识
     *
     * @param appId     微信小程序应用唯一标识
     * @param appSecret 微信小程序应用密钥（注意保密）
     * @param code      授权 code, 登录时获取的 code
     * @return openid   微信小程序授权用户唯一标识
     * @throws UnsupportedEncodingException
     */
    public static String getOpenId(String appId, String appSecret, String code)
            throws UnsupportedEncodingException, ChannelException {

        AuthResult authResult = getSession(appId, appSecret, code);
        if (authResult.getErrmsg() != null) {
            throw new ChannelException(authResult.getErrmsg(), authResult.getErrcode().toString(), null);
        }

        return authResult.getOpenid();
    }

    /**
     * 获取微信小程序授权用户唯一标识
     *
     * @param appId     微信小程序应用唯一标识
     * @param appSecret 微信小程序应用密钥（注意保密）
     * @param code      授权 code, 登录时获取的 code
     * @return openid   微信小程序授权用户唯一标识
     * @throws UnsupportedEncodingException
     */
    public static AuthResult getSession(String appId, String appSecret, String code)
            throws UnsupportedEncodingException {
        Map<String, String> params = new HashMap<String, String>();
        params.put("appid", appId);
        params.put("secret", appSecret);
        params.put("js_code", code);
        params.put("grant_type", "authorization_code");
        String url = "https://api.weixin.qq.com/sns/jscode2session?" + httpBuildQuery(params);

        String ret = httpGet(url);
        AuthResult authResult = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create().fromJson(ret, AuthResult.class);

        return authResult;
    }

    class AuthResult {
        String sessionKey;
        String openid;
        String unionid;
        Integer errcode;
        String errmsg;

        public String getSessionKey() {
            return sessionKey;
        }

        public String getOpenid() {
            return openid;
        }

        public String getUnionid() {
            return unionid;
        }

        public Integer getErrcode() {
            return errcode;
        }

        public String getErrmsg() {
            return errmsg;
        }
    }
}
