
import java.util.HashMap;
import java.util.Map;

import com.pingplusplus.Pingpp;
import com.pingplusplus.exception.PingppException;
import com.pingplusplus.model.RedEnvelope;


public class RedEnvelopeExample {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pingpp.apiKey = "YOUR-KEY";
        RedEnvelopeExample example = new RedEnvelopeExample();
        example.redEnvelope();
	}
	
	public void redEnvelope() {
        Map<String, Object> redenvelope = new HashMap<String, Object>();
        redenvelope.put("amount", 100);
        redenvelope.put("currency", "cny");
        redenvelope.put("subject",  "Your Subject");
        redenvelope.put("body",  "Your Body");
        redenvelope.put("order_no",  "123456789");
        redenvelope.put("channel",  "wx_pub");
        redenvelope.put("recipient", "Openid");
        redenvelope.put("description", "Your Description");
        Map<String, String> app = new HashMap<String, String>();
        app.put("id", "YOUR-APP-ID");
        redenvelope.put("app", app);
        Map<String, String> extra = new HashMap<String, String>();
        extra.put("nick_name", "Nick Name");
        extra.put("send_name", "Send Name");
        redenvelope.put("extra", extra);
        try {
        	//发送红包
            RedEnvelope red = RedEnvelope.create(redenvelope);
            System.out.println(red);

        } catch (PingppException e) {
            e.printStackTrace();
        }
    }


    public void retrieve(String id){
    	
    	try {
    		//查询指定红包
            RedEnvelope red = RedEnvelope.retrieve(id);
            System.out.println(red);

        } catch (PingppException e) {
            e.printStackTrace();
        }
    }
    
}
