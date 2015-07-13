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
 * 
 * 该实例演示如何使用 ping++ 进行企业转账。
 * 
 * 开发者需要填写 apiKey ，openId 和 appId , apiKey 可以在 ping++ 管理平台【应用信息里面查看】
 * 
 * apiKey 有 TestKey 和 LiveKey 两种。 
 * 
 * TestKey 模式下不会产生真实的交易。
 * 
 * openId 是发送红包的对象在公共平台下的openId ,获得 openId 的方法可以参考微信文档：http://mp.weixin.qq.com/wiki/17/c0f37d5704f0b64713d5d2c37b468d75.html
 * 
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
	
	/**
	 * 接收者的 openId
	 */
	public static String openId ="OPEN_ID";

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
     * 
     * 创建企业转账需要传递一个 map 给 Transfer.create();
     * map 填写的具体介绍可以参考：https://pingxx.com/document/api#api-t-new
     * 
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
        transferMap.put("recipient", openId);
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
     * 
     * 根据 ID 查询企业转账记录。
     * 参考文档：https://pingxx.com/document/api#api-t-inquiry
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
     *
     *批量查询企业转账记录，默认一次查询 10 条，用户可以使用 limit 自定义查询数目，但是最多不超过 100 条。
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
