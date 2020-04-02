package com.pingplusplus;

import com.pingplusplus.exception.PingppException;
import com.pingplusplus.model.User;
import com.pingplusplus.net.RequestOptions;
import com.pingplusplus.net.RequestOptions.RequestOptionsBuilder;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class RequestOptionsTest {

    @Before
    public void clearConfigs() {
        Pingpp.apiKey = null;
        Pingpp.appId = null;
        Pingpp.privateKey = null;
    }

    @Test
    public void testRequestOptionsBuild() {
        String apiKey = "sk_test_ibbTe5jLGCi5rzfH4OqnzhGs";
        String appId = "app_1Gqj58ynP0mNgKsc";
        String privateKey = "-----BEGIN......END-----".trim();
        RequestOptions options = new RequestOptionsBuilder()
                .setApiKey(apiKey)
                .setAppId(appId)
                .setPrivateKey(privateKey)
                .setConnectTimeout(5000)
                .setReadTimeout(20000)
                .setAcceptLanguage("zh-CN")
                .setMaxNetworkRetries(2)
                .build();

        assertEquals("API Key should be", apiKey, options.getApiKey());
        assertEquals("App ID should be", appId, options.getAppId());
        assertEquals("Private key should be", privateKey, options.getPrivateKey());
        assertEquals("Connect timeout should be", 5000, options.getConnectTimeout());
        assertEquals("Read timeout should be", 20000, options.getReadTimeout());
    }

    @Test
    public void testDefaultRequestOptionsBuilder() {
        Pingpp.apiKey = PingppTestData.getApiKey();
        Pingpp.appId = PingppTestData.getAppID();
        Pingpp.privateKey = PingppTestData.getPKCS8PrivateKey();

        RequestOptions options = new RequestOptionsBuilder().build();

        assertEquals("API Key should be", PingppTestData.getApiKey(), options.getApiKey());
        assertEquals("App ID should be", PingppTestData.getAppID(), options.getAppId());
        assertEquals("Private key should be", PingppTestData.getPKCS8PrivateKey(), options.getPrivateKey());
    }

    @Test
    public void testDefaultRequestOptions() {
        Pingpp.apiKey = PingppTestData.getApiKey();
        Pingpp.appId = PingppTestData.getAppID();
        Pingpp.privateKey = PingppTestData.getPKCS8PrivateKey();

        RequestOptions options = RequestOptions.getDefault();

        assertEquals("API Key should be", PingppTestData.getApiKey(), options.getApiKey());
        assertEquals("App ID should be", PingppTestData.getAppID(), options.getAppId());
        assertEquals("Private key should be", PingppTestData.getPKCS8PrivateKey(), options.getPrivateKey());
    }

    @Test
    public void testRequestOptionsRequest() throws PingppException {
        RequestOptions options = new RequestOptionsBuilder()
                .setApiKey(PingppTestData.getApiKey())
                .setAppId(PingppTestData.getAppID())
                .setPrivateKey(PingppTestData.getPKCS8PrivateKey())
                .build();

        String userId = "test_user_001";
        User obj = User.retrieve(userId, options);

        assertNull("Pingpp.apiKey should be null", Pingpp.apiKey);
        assertNull("Pingpp.appId should be null", Pingpp.appId);
        assertEquals("object should be user", "user", obj.getObject());
        assertEquals("id", userId, obj.getId());
        assertEquals("app", PingppTestData.getAppID(), obj.getApp());
    }
}
