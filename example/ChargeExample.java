
import java.util.HashMap;
import java.util.Map;

import com.pingplusplus.Pingpp;
import com.pingplusplus.exception.PingppException;
import com.pingplusplus.model.Charge;
import com.pingplusplus.model.RedEnvelope;

public class ChargeExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pingpp.apiKey = "YOUR-KEY";		
        ChargeExample ce = new ChargeExample();
        ce.charge();
	}
	
	public void charge() {
        Map<String, Object> chargeMap = new HashMap<String, Object>();
        //某些渠道需要添加extra参数，具体参数详见接口文档
        chargeMap.put("amount", 100);
        chargeMap.put("currency", "cny");
        chargeMap.put("subject",  "Your Subject");
        chargeMap.put("body",  "Your Body");
        chargeMap.put("order_no",  "123456789");
        chargeMap.put("channel",  "alipay");
        chargeMap.put("client_ip",  "127.0.0.1");
        Map<String, String> app = new HashMap<String, String>();
        app.put("id", "YOUR-APP-ID");
        chargeMap.put("app", app);
        try {
        	//发起交易请求
            Charge charge = Charge.create(chargeMap);
            System.out.println(charge);
        } catch (PingppException e) {
            e.printStackTrace();
        }
    }

	public void retrieve(String id){ 	
    	try {
    		//查询单笔交易
            Charge charge = Charge.retrieve(id);
            System.out.println(charge);

        } catch (PingppException e) {
            e.printStackTrace();
        }
    }
}
