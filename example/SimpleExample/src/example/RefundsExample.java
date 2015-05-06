package example;

import com.pingplusplus.Pingpp;
import com.pingplusplus.exception.APIConnectionException;
import com.pingplusplus.exception.APIException;
import com.pingplusplus.exception.AuthenticationException;
import com.pingplusplus.exception.InvalidRequestException;
import com.pingplusplus.model.Charge;
import com.pingplusplus.model.ChargeRefundCollection;
import com.pingplusplus.model.Refund;

import java.util.HashMap;
import java.util.Map;

/**
 * 退款相关示例
 * Created by sunkai on 15/4/22.
 */
public class RefundsExample {
	
	/**
	 * pingpp 管理平台对应的API key
	 */
	public static String apiKey = "YOUR-KEY";
	/**
	 * 退款的chargeId
	 */
	public static String chargeId = "YOUR-CHARGEID";
    public static void main(String args[]) {
        Pingpp.apiKey = apiKey;
        RefundsExample refundsExample = new RefundsExample();

        Charge ch = null;
        try {
            ch = Charge.retrieve(chargeId);
        } catch (AuthenticationException e) {
            e.printStackTrace();
        } catch (InvalidRequestException e) {
            e.printStackTrace();
        } catch (APIConnectionException e) {
            e.printStackTrace();
        } catch (APIException e) {
            e.printStackTrace();
        }

       //退款的时候注意，已经退完款无法继续推
       // System.out.println("---------创建refund");
       // Refund refund = refundsExample.refund(ch);
       // System.out.println("---------查询refund");
       // refundsExample.retrieve(refund.getId(), ch);
        System.out.println("---------查询refund列表");
        refundsExample.all(ch);
    }

    /**
     * 退款
     * @param charge
     * @return
     */
    public Refund refund(Charge charge) {
        Refund refund = null;
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("description", "苹果被咬了一口。");

        try {
            refund = charge.getRefunds().create(params);
            System.out.println(refund);
        } catch (AuthenticationException e) {
            e.printStackTrace();
        } catch (InvalidRequestException e) {
            e.printStackTrace();
        } catch (APIConnectionException e) {
            e.printStackTrace();
        } catch (APIException e) {
            e.printStackTrace();
        }
        return refund;
    }

    /**
     * 查询退款
     * @param id
     * @param charge
     */
    public void retrieve(String id, Charge charge) {

        try {
            Refund refund = charge.getRefunds().retrieve(id);
            System.out.println(refund);
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
     * 分页查询退款
     * @param charge
     */
    public void all(Charge charge) {
        Map<String, Object> refundParams = new HashMap<String, Object>();
        refundParams.put("limit", 3);
        try {
            ChargeRefundCollection refunds = charge.getRefunds().all(refundParams);
            System.out.println(refunds);
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
