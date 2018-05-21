package com.pingplusplus;

import com.pingplusplus.exception.ChannelException;
import com.pingplusplus.util.WxLiteOAuth;
import com.pingplusplus.util.WxpubOAuth;
import org.junit.Test;

import java.io.UnsupportedEncodingException;

public class WeixinOpenidTest extends PingppTestBase {
    /**
     * 通过 appId, secret, code 获取微信公众号 openid 信息。
     */
    @Test
    public void testWxPubOpenid() throws UnsupportedEncodingException {
        try {
            String openid  = WxpubOAuth.getOpenId("wx262681902838", "piOgk852569gKXpRLjhh38J6O14H7ejb", "ZkJfiPkzQAFCxc4vxRE4");
            System.out.println(openid);
        } catch (ChannelException e) {
            System.out.println(e.getMessage());
            System.out.println(e.getParam());
        }
    }

    /**
     * 通过 appId, secret, code 获取微信小程序 openid 信息。
     */
    @Test
    public void testWxLiteOpenid() throws UnsupportedEncodingException {
        try {
            String openid = WxLiteOAuth.getOpenId("wx283881926260", "piOgk852569gKXpRLjhh38J6O14H7ejb", "vNnPjvqD0BT3snbxVLjY");
            System.out.println(openid);
        } catch (ChannelException e) {
            System.out.println(e.getMessage());
            System.out.println(e.getParam());
        }
    }
}
