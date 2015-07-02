package example;

import com.pingplusplus.Pingpp;
import com.pingplusplus.exception.APIConnectionException;
import com.pingplusplus.exception.APIException;
import com.pingplusplus.exception.AuthenticationException;
import com.pingplusplus.exception.InvalidRequestException;
import com.pingplusplus.model.RedEnvelope;
import com.pingplusplus.model.RedEnvelopeCollection;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by sunkai on 15/7/2.
 */
public class RedEnvelopeExample {

	/**
	 * pingpp 管理平台对应的API key
	 */
	public static String apiKey = "YOUR-KEY";
	/**
	 * pingpp 管理平台对应的应用I
	 */
	public static String appId = "YOUR-APPID";
	/**
	 * 微信用户在微信公共号的openId
	 */
	public static String openId="YOUR-OPENID";

	public static void main(String[] args) {
		Pingpp.apiKey = apiKey;
		RedEnvelopeExample redEnvelopeExample = new RedEnvelopeExample();
		System.out.println("---------创建 RedEnvelope");
		RedEnvelope redEnvelope = redEnvelopeExample.create();
		System.out.println("---------查询 RedEnvelope");
		redEnvelopeExample.retrieve(redEnvelope.getId());
		System.out.println("---------查询 RedEnvelope 列表");
		redEnvelopeExample.all();

	}

	/**
	 * 创建红包
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
		redenvelope.put("recipient", openId);
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
		}
		return red;

	}

	/**
	 * 查询红包
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
		}
	}

	/**
	 * 批量查询红包
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
		}

	}
}
