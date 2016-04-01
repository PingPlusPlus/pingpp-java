package example;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import com.pingplusplus.Pingpp;
import com.pingplusplus.exception.PingppException;
import com.pingplusplus.model.Charge;
import com.pingplusplus.util.WxpubOAuth;

/**
 * 微信公共账号，付款签名示例
 * @author sunkai
 *
 * 开发者需要填写 apiKey 、appId 、url 和 openId 。 apiKey 可以在 ping++ 管理平台【应用信息里面查看】
 * 
 * apiKey 有 TestKey 和 LiveKey 两种。 
 * 
 * TestKey 模式下不会产生真实的交易。
 * 
 * openId 是发送红包的对象在公共平台下的openId ,获得 openId 的方法可以参考微信文档：http://mp.weixin.qq.com/wiki/17/c0f37d5704f0b64713d5d2c37b468d75.html
 * 
 */
public class WxPubOAuthExample {

	/**
	 * pingpp 管理平台对应的API key
	 */
	public static String apiKey = "YOUR_KEY";
	/**
	 * pingpp 管理平台对应的应用I
	 */
	public static String appId = "YOUR_APPID";
	/**
	 * 微信用户在微信公共号的openId
	 */
	public static String openId="YOUR_OPENID";
	/**
	 * 微信公共号里面引导用户付款的网页url地址
	 * 该URL为付款当前网页地址
	 */
	public static String url = "YOUR_URL";
	/**
	 * 微信公共号的appId
	 */
	public static String wx_app_id="YOUR_WX_APPID";
	/**
	 * 微信公共号的secret
	 */
	public static String wx_app_secret ="YOUR_WX_SECRET";
	/**
	 * @param args
	 */

	public static void main(String args[]) {
		try {
			//获得ticket
			String ticket = WxpubOAuth.getJsapiTicket(wx_app_id, wx_app_secret);
			System.out.println("ticket " + ticket);
			// 创建Charge
			Pingpp.apiKey = apiKey;
			String chargeString = createCharge();
			//获得签名
			String signature = WxpubOAuth.getSignature(chargeString, ticket, url);
			System.out.println("signature " + signature);

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 创建Charge
	 * 
     * 创建 Charge 用户需要组装一个 map 对象作为参数传递给 Charge.create();
     * map 里面参数的具体说明请参考：https://pingxx.com/document/api#api-c-new
	 * @return
	 */
	public static String createCharge() {
		Charge charge = null;
		Map<String, Object> chargeMap = new HashMap<String, Object>();
		chargeMap.put("amount", 100);
		chargeMap.put("currency", "cny");
		chargeMap.put("subject", "Your Subject");
		chargeMap.put("body", "Your Body");
		chargeMap.put("order_no", "123456789");
		chargeMap.put("channel", "wx_pub");
		chargeMap.put("client_ip", "127.0.0.1");

		Map<String, String> extra = new HashMap<String, String>();
		extra.put("open_id", openId);
		chargeMap.put("extra", extra);
		Map<String, String> app = new HashMap<String, String>();
		app.put("id", appId);
		chargeMap.put("app", app);
		try {
			// 发起交易请求
			charge = Charge.create(chargeMap);
			// 传到客户端请先转成字符串 .toString()
			System.out.println(charge.toString());
		} catch (PingppException e) {
			e.printStackTrace();
		}
		return charge.toString();
	}
}
