package com.pingplusplus.util;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.lang.String;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**
 * 用于微信公众号OAuth2.0鉴权，用户授权后获取授权用户唯一标识openid
 * WxpubOAuth中的方法都是可选的，开发者也可根据实际情况自行开发相关功能，
 * 详细内容可参考http://mp.weixin.qq.com/wiki/17/c0f37d5704f0b64713d5d2c37b468d75.html
 */
public class WxpubOAuth {
    /**
     * 获取微信公众号授权用户唯一标识
     *
     * @param appId     微信公众号应用唯一标识
     * @param appSecret 微信公众号应用密钥（注意保密）
     * @param code      授权code, 通过调用WxpubOAuth.createOauthUrlForCode来获取
     * @return openid   微信公众号授权用户唯一标识, 可用于微信网页内支付
     */
    public static String getOpenId(String appId, String appSecret, String code)
            throws UnsupportedEncodingException {
        String url = WxpubOAuth.createOauthUrlForOpenid(appId, appSecret, code);

        String ret = WxpubOAuth.httpGet(url);
        OAuthResult oAuthResult = new Gson().fromJson(ret, OAuthResult.class);

        return oAuthResult.getOpenid();
    }

    /**
     * 用于获取授权code的URL地址，此地址用于用户身份鉴权，获取用户身份信息，同时重定向到$redirect_url
     *
     * @param appId       微信公众号应用唯一标识
     * @param redirectUrl 授权后重定向的回调链接地址，重定向后此地址将带有授权code参数，
     *                    该地址的域名需在微信公众号平台上进行设置，
     *                    步骤为：登陆微信公众号平台 => 开发者中心 => 网页授权获取用户基本信息 => 修改
     * @param moreInfo    FALSE 不弹出授权页面,直接跳转,这个只能拿到用户openid
     *                    TRUE 弹出授权页面,这个可以通过 openid 拿到昵称、性别、所在地，
     * @return            用于获取授权code的URL地址
     */
    public static String createOauthUrlForCode(String appId, String redirectUrl, boolean moreInfo)
            throws UnsupportedEncodingException {
        Map<String, String> data = new HashMap<String, String>();
        data.put("appid", appId);
        data.put("redirect_uri", redirectUrl);
        data.put("response_type", "code");
        data.put("scope", moreInfo ? "snsapi_userinfo" : "snsapi_base");
        data.put("state", "STATE#wechat_redirect");
        String queryString = WxpubOAuth.httpBuildQuery(data);

        return "https://open.weixin.qq.com/connect/oauth2/authorize?" + queryString;
    }

    /**
     * 获取openid的URL地址
     *
     * @param appId     微信公众号应用唯一标识
     * @param appSecret 微信公众号应用密钥（注意保密）
     * @param code      授权code, 通过调用WxpubOAuth.createOauthUrlForCode来获取
     * @return          获取openid的URL地址
     */
    private static String createOauthUrlForOpenid(String appId, String appSecret, String code)
            throws UnsupportedEncodingException  {
        Map<String, String> data = new HashMap<String, String>();
        data.put("appid", appId);
        data.put("secret", appSecret);
        data.put("code", code);
        data.put("grant_type", "authorization_code");
        String queryString = WxpubOAuth.httpBuildQuery(data);

        return "https://api.weixin.qq.com/sns/oauth2/access_token?" + queryString;
    }

    private static String httpBuildQuery(Map<String, String> queryString) throws UnsupportedEncodingException {
        StringBuilder sb = new StringBuilder();
        for(Map.Entry<String, String> e : queryString.entrySet()){
            if(sb.length() > 0){
                sb.append('&');
            }
            sb.append(URLEncoder.encode(e.getKey(), "UTF-8")).append('=').append(URLEncoder.encode(e.getValue(), "UTF-8"));
        }

        return sb.toString();
    }

    private static String httpGet(String urlString) {
        String result = "";
        try {
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = rd.readLine()) != null) {
                result += line;
            }
            rd.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    class OAuthResult {
        String access_token;
        int expires_in;
        String refresh_token;
        String openid;
        String scope;

        public String getAccess_token() {
            return access_token;
        }

        public int getExpires_in() {
            return expires_in;
        }

        public String getRefresh_token() {
            return refresh_token;
        }

        public String getOpenid() {
            return openid;
        }

        public String getScope() {
            return scope;
        }
    }

}