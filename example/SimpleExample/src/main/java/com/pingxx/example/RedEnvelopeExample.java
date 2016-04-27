package com.pingxx.example;

import com.pingplusplus.exception.APIConnectionException;
import com.pingplusplus.exception.APIException;
import com.pingplusplus.exception.AuthenticationException;
import com.pingplusplus.exception.ChannelException;
import com.pingplusplus.exception.InvalidRequestException;
import com.pingplusplus.model.RedEnvelope;
import com.pingplusplus.model.RedEnvelopeCollection;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * 该实例演示如何操作微信红包
 *
 * 开发者需要填写 apiKey 、appId 和 openid 。 apiKey 可以在 Ping++ 管理平台【应用信息里面查看】
 *
 * apiKey 有 TestKey 和 LiveKey 两种。
 *
 * TestKey 模式下不会产生真实的交易。
 *
 * openid 是发送红包的对象在公共平台下的 openid ,获得 openid 的方法可以参考微信文档：http://mp.weixin.qq.com/wiki/17/c0f37d5704f0b64713d5d2c37b468d75.html
 *
 */
public class RedEnvelopeExample {

	private String appId;
	/**
	 * 微信用户在微信公共号的 openid
	 */
	public static String openid = "USER_OPENID";

	RedEnvelopeExample(String appId) {
		this.appId = appId;
	}

	public static void runDemos(String appId) {

		RedEnvelopeExample redEnvelopeExample = new RedEnvelopeExample(appId);
		System.out.println("------- 创建 RedEnvelope -------");
		RedEnvelope redEnvelope = redEnvelopeExample.create();
		System.out.println("------- 查询 RedEnvelope -------");
		redEnvelopeExample.retrieve(redEnvelope.getId());
		System.out.println("------- 查询 RedEnvelope 列表 -------");
		redEnvelopeExample.all();
	}

	/**
	 * 创建红包
	 *
	 * 创建红包需要传递一个 map 到 RedEnvelope.create(redenvelope)
	 * map 里面的具体参数参考：https://pingxx.com/document/api#api-e-new
	 * @return
	 */
	public RedEnvelope create() {
		Map<String, Object> redenvelope = new HashMap<String, Object>();
		redenvelope.put("amount", 100);
		redenvelope.put("currency", "cny");
		redenvelope.put("subject", "Your Subject");
		redenvelope.put("body", "Your Body");
		String orderNo = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		redenvelope.put("order_no", orderNo);
		redenvelope.put("channel", "wx_pub");
		redenvelope.put("recipient", openid);
		redenvelope.put("description", "Your Description");
		Map<String, String> app = new HashMap<String, String>();
		app.put("id", appId);
		redenvelope.put("app", app);
		Map<String, String> extra = new HashMap<String, String>();
		extra.put("nick_name", "Nick Name");
		extra.put("send_name", "Send Name");
		redenvelope.put("extra", extra);
		RedEnvelope red = null;
		try {
			red = RedEnvelope.create(redenvelope);
			System.out.println(red);
		} catch (AuthenticationException e) {
			e.printStackTrace();
		} catch (InvalidRequestException e) {
			e.printStackTrace();
		} catch (APIConnectionException e) {
			e.printStackTrace();
		} catch (APIException e) {
			e.printStackTrace();
		} catch (ChannelException e) {
			e.printStackTrace();
		}
		return red;

	}

	/**
	 * 查询红包
	 *
	 * 根据红包的 ID 查询红包。
	 * 参考文档：https://pingxx.com/document/api#api-e-inquiry
	 * @param id
	 */
	public void retrieve(String id) {
		try {
			RedEnvelope redEnvelope = RedEnvelope.retrieve(id);
			System.out.println(redEnvelope);
		} catch (AuthenticationException e) {
			e.printStackTrace();
		} catch (InvalidRequestException e) {
			e.printStackTrace();
		} catch (APIConnectionException e) {
			e.printStackTrace();
		} catch (APIException e) {
			e.printStackTrace();
		} catch (ChannelException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 批量查询红包
	 *
	 * 批量查询接口，默认一次查询 10 条。用户可以通过 limit 自定义查询数目，最多不超过 100 条。
	 */
	public void all() {
		RedEnvelopeCollection redEnvelopeCollection = null;
		Map<String, Object> chargeParams = new HashMap<String, Object>();
		chargeParams.put("limit", 3);
		try {
			redEnvelopeCollection = RedEnvelope.all(chargeParams);
			System.out.println(redEnvelopeCollection);
		} catch (AuthenticationException e) {
			e.printStackTrace();
		} catch (InvalidRequestException e) {
			e.printStackTrace();
		} catch (APIConnectionException e) {
			e.printStackTrace();
		} catch (APIException e) {
			e.printStackTrace();
		} catch (ChannelException e) {
			e.printStackTrace();
		}

	}
}
