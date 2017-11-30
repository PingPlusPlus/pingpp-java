package com.pingplusplus.sub_app;

import com.pingplusplus.PingppAccountTestBase;
import com.pingplusplus.exception.*;
import com.pingplusplus.model.Channel;
import com.pingplusplus.model.DeletedChannel;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class SubAppChannelTest extends PingppAccountTestBase {
    /**
     * 配置子商户 app 渠道参数
     */
    @Test
    public void testSubAppChannelCreate() throws RateLimitException,
            APIException, ChannelException, InvalidRequestException,
            APIConnectionException, AuthenticationException {
        String subAppId = "app_rbDmXLHmLqbTLKm9";

        Map<String, Object> params = new HashMap<>();
        params.put("channel", "bfb");
        params.put("description", "Channel params description.");
        Map<String, Object> channelParams = new HashMap<>();
        channelParams.put("fee_rate", 60);
        channelParams.put("bfb_sp", "1600200213");
        channelParams.put("bfb_key", "A9lUEVtdrrQobDHgzkzM2rThSNpXVELt");
        params.put("params", channelParams);

        // 创建子商户 channel 对象
        // 参数一: SubApp id
        // 参数二: params
        Channel obj = Channel.create(subAppId, params);

        assertEquals("object should be channel", "channel", obj.getObject());
        assertEquals("description", params.get("description"), obj.getDescription());
    }

    /**
     * 查询子商户 app 渠道参数
     */
    @Test public void testSubAppChannelRetrieve() throws RateLimitException,
            APIException, ChannelException, InvalidRequestException,
            APIConnectionException, AuthenticationException {
        String subAppId = "app_rbDmXLHmLqbTLKm9";
        String channel = "bfb";

        // 查询子商户 app 渠道参数方法
        // 参数一: subAppId
        // 参数二: channel 需要查询的渠道名
        Channel obj = Channel.retrieve(subAppId, channel);

        assertEquals("object should be channel", "channel", obj.getObject());
    }

    /**
     * 更新子商户 app 渠道参数
     */
    @Test public void testSubAppChannelUpdate() throws RateLimitException,
            APIException, ChannelException, InvalidRequestException,
            APIConnectionException, AuthenticationException {
        String subAppId = "app_rbDmXLHmLqbTLKm9";
        String channel = "bfb";

        Map<String, Object> params = new HashMap<>();
        params.put("description", "Channel params update description.");
        Map<String, Object> channelParams = new HashMap<>(); // 需要更新的渠道参数
        channelParams.put("fee_rate", 60);
        channelParams.put("bfb_sp", "1600200213");
        channelParams.put("bfb_key", "A9lUEVtdrrQobDHgzkzM2rThSNpXVELt");
        params.put("params", channelParams);

        // 更新子商户 app 渠道参数方法
        // 参数一: SubApp id
        // 参数二: channel 需要更新的渠道
        // 参数三: params
        Channel obj = Channel.update(subAppId, channel, params);

        assertEquals("object should be channel", "channel", obj.getObject());
    }

    /**
     * 删除子商户 app 渠道参数
     */
    @Test public void testSubAppChannelDelete() throws RateLimitException,
            APIException, ChannelException, InvalidRequestException,
            APIConnectionException, AuthenticationException {
        String subAppId = "app_rbDmXLHmLqbTLKm9";
        String channel = "bfb";

        // 删除子商户 app 渠道参数方法
        // 参数一: subAppId
        // 参数二: channel 需要删除的渠道名
        DeletedChannel obj = Channel.delete(subAppId, channel);

        assertEquals("channel", channel, obj.getChannel());
    }
}
