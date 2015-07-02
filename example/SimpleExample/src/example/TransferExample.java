package example;



import com.pingplusplus.Pingpp;
import com.pingplusplus.exception.APIConnectionException;
import com.pingplusplus.exception.APIException;
import com.pingplusplus.exception.AuthenticationException;
import com.pingplusplus.exception.InvalidRequestException;
import com.pingplusplus.model.App;
import com.pingplusplus.model.Transfer;
import com.pingplusplus.model.TransferCollection;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by sunkai on 15/5/11.
 */
public class TransferExample {

	/**
	 * pingpp 管理平台对应的API key
	 */
	public static String apiKey = "YOUR-KEY";
	/**
	 * pingpp 管理平台对应的应用ID
	 */
	public static String appId = "YOUR-APPID";

    public static void main(String args[]) {

        Pingpp.apiKey = apiKey;
        TransferExample transferExample = new TransferExample();
        System.out.println("---------创建Transfer");
        Transfer transfer = transferExample.transfer();
        System.out.println("---------查询Transfer");
        transferExample.retrieve(transfer.getId());
        System.out.println("---------查询Transfer列表");
        transferExample.all();

    }

    /**
     * 创建企业转账
     * @return
     */
    public Transfer transfer() {
        Transfer transfer = null;
        String orderNo = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        Map<String, Object> transferMap = new HashMap<String, Object>();
        transferMap.put("channel", "wx_pub");
        transferMap.put("order_no", orderNo);
        transferMap.put("amount", "10");
        transferMap.put("type", "b2c");
        transferMap.put("currency", "cny");
        transferMap.put("recipient", "o9zpMs5MW2-62GAy5hRrjdYVCktU");
        transferMap.put("description", "your description");
        Map<String, String> app = new HashMap<String, String>();
        app.put("id", appId);
        transferMap.put("app", app);

        try {
            transfer = Transfer.create(transferMap);
            System.out.println(transfer);
        } catch (AuthenticationException e) {
            e.printStackTrace();
        } catch (InvalidRequestException e) {
            e.printStackTrace();
        } catch (APIConnectionException e) {
            e.printStackTrace();
        } catch (APIException e) {
            e.printStackTrace();
        }
        return transfer;
    }

    /**
     * 根据 ID 查询
     * @param id
     */
    public void retrieve(String id) {
        Map<String, Object> param = new HashMap<String, Object>();
        List<String> expande = new ArrayList<String>();
        expande.add("app");
        param.put("expand", expande);
        try {
            Transfer transfer = Transfer.retrieve(id, param);
            //Transfer transfer = Transfer.retrieve(id);
            //if you expand app properties  transfer.getApp() will return a App Object.
            if (transfer.getApp() instanceof App) {
                App app = (App) transfer.getApp();
                System.out.println("App Object ,appId = " + app.getId());
            } else {
                System.out.println("String ,appId = " + transfer.getApp());
            }
            System.out.println(transfer);
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
     *批量查询 
     */
    public void all() {
        Map<String, Object> parm = new HashMap<String, Object>();
        parm.put("limit", 3);
//        List<String> expande = new ArrayList<String>();
//        expande.add("app");
//        parm.put("expand", expande);

        try {
            TransferCollection transferCollection = Transfer.all(parm);
            System.out.println(transferCollection);
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
