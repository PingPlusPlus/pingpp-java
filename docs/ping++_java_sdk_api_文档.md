## Ping++ Java SDK 文档
#### 概述
本文档简要概述 Ping++ Java SDK 部分常用类的使用方法，详细使用方法开发者可阅读源码以及示例程序
- Charge
- Refund
- RedEnvelope
- Webhooks
- Identification
- 账户系统相关接口请查看 [Ping++ API 文档](https://www.pingxx.com/api) 或参考[测试示例](/src/test/java/com/pingplusplus)

#### Charge
##### 创建 Charge
``` java
create(Map<String, Object> params)
```
方法名：create  
类型：静态方法  
参数：Map  
返回：Charge  
示例：
``` java
Map<String, Object> chargeMap = new HashMap<String, Object>();
chargeMap.put("amount", 100); // 金额，单位为分，例 100 表示 1.00 元，233 表示 2.33 元
chargeMap.put("currency", "cny");
chargeMap.put("subject", "Your Subject");
chargeMap.put("body", "Your Body");
chargeMap.put("order_no", "orderNo"); // 订单号，请参考官网文档格式说明
chargeMap.put("channel", "alipay"); // 渠道字段
chargeMap.put("client_ip", "127.0.0.1"); // 客户端的 IP 地址
Map<String, String> app = new HashMap<String, String>();
app.put("id", APP_ID);
chargeMap.put("app", app);
Charge charge = Charge.create(chargeMap);
System.out.println(charge);
```

##### 查询 Charge
``` java
retrieve(String id)
```
方法名：retrieve  
类型：静态方法  
参数：String 类型的 Charge ID  
返回：Charge  
示例：  
``` java
Charge charge = Charge.retrieve(CHARGE_ID);
```

##### 查询 Charge 列表
``` java
list(Map<String, Object> params)
```
方法名：list  
类型：静态方法  
参数：Map  
返回：ChargeCollection  
示例：
``` java
Map<String, Object> chargeParams = new HashMap<String, Object>();
app.put("id", APP_ID);
chargeParams.put("app", app);
chargeParams.put("limit", 3);
Map<String, String> app = new HashMap<String, String>();
ChargeCollection charges = Charge.list(chargeParams);
System.out.println(charges);
```

##### 撤销 Charge
``` java
reverse(String id)
```
方法名：reverse
类型：静态方法
参数：String 类型的 Charge ID
返回：Charge
示例：
``` java
Charge charge = Charge.reverse(CHARGE_ID);
```

#### Refund
##### 创建 Refund
``` java
create(Map<String, Object> params)
```
方法名：create  
类型：实例方法  
参数：Map  
返回：Refund  
示例：
``` java
Map<String, Object> params = new HashMap<String, Object>();
params.put("description", "Refund Description");
Charge ch = Charge.retrieve(CHARGE_ID);
Refund re = ch.getRefunds().create(params);
```

##### 查询 Refund
``` java
retrieve(String id)
```
方法名：retrieve
类型：实例方法  
参数：String 类型的 Refund ID  
返回：Refund  
示例：
``` java
Charge ch = Charge.retrieve(CHARGE_ID);
Refund re = ch.getRefunds().retrieve(REFUND_ID);
```

##### 查询 Refund 列表
``` java
list(Map<String, Object> params)
```
方法名：list
类型：实例方法  
参数：Map  
返回：RefundCollection  
示例：
``` java
Charge ch = Charge.retrieve(CHARGE_ID);
Map<String, Object> refundParams = new HashMap<String, Object>();
refundParams.put("limit", 3);
Refund re = ch.getRefunds().list(refundParams);
```

#### RedEnvelope
##### 创建 RedEnvelope
``` java
create(Map<String, Object> params)
```
方法名：create  
类型：静态方法  
参数：Map  
返回：RedEnvelope  
示例：
``` java
Map<String, Object> redenvelope = new HashMap<String, Object>();
redenvelope.put("amount", 100);
redenvelope.put("currency", "cny");
redenvelope.put("subject",  "Your Subject");
redenvelope.put("body",  "Your Body");
redenvelope.put("order_no",  "orderNo");
redenvelope.put("channel",  "wx_pub");
redenvelope.put("recipient", OPENID);
redenvelope.put("description", "Your Description");
Map<String, String> app = new HashMap<String, String>();
app.put("id", APP_ID);
redenvelope.put("app", app);
Map<String, String> extra = new HashMap<String, String>();
extra.put("nick_name", "Nick Name");
extra.put("send_name", "Send Name");
redenvelope.put("extra", extra);
RedEnvelope red = RedEnvelope.create(redenvelope);
```

##### 查询 RedEnvelope
``` java
retrieve(String id)
```
方法名：create  
类型：静态方法  
参数：String 类型的 RedEnvelope ID  
返回：RedEnvelope  
示例：
``` java
RedEnvelope redEnvelope = RedEnvelope.retrieve(RED_ID);
```

##### 查询 RedEnvelope 列表
``` java
list(Map<String, Object> params)
```
方法名：list  
类型：静态方法  
参数：Map  
返回：RedEnvelopeCollection  
示例：
``` java
RedEnvelopeCollection redEnvelopeCollection = null;
Map<String, Object> chargeParams = new HashMap<String, Object>();
chargeParams.put("limit", 3);
RedEnvelopeCollection redEnvelopeCollection = RedEnvelope.list(chargeParams);
```

#### Webhooks
##### 解析 Event 中的 Object
``` java
getObject(String eventStr)
```
方法名：getObject   
类型：静态方法   
参数：JSON 格式的 Event 字符串   
返回：Object   
示例：
``` java
Object obj = Webhooks.getObject(eventString);
if (obj instanceof Charge) {
    System.out.println("webhooks 发送了 Charge");
    Charge charge = (Charge) obj;
    System.out.println("付款状态：" + charge.getPaid() + " 订单号：" + charge.getOrderNo());
} else if (obj instanceof Refund) {
    System.out.println("webhooks 发送了 Refund");
} else if (obj instanceof Summary) {
    System.out.println("webhooks 发送了 Summary");
}
```

##### 解析 Event 对象
``` java
eventParse(String eventStr)
```
方法名：eventParse  
类型：静态方法  
参数：JSON 格式的 Event 字符串  
返回：Event  
示例：
``` java
Event eventobj = Webhooks.eventParse(eventString);
```

#### Identification
##### 身份证银行卡信息认证接口
``` java
identify(Map<String, Object> params)
```
方法名：identify  
类型：静态方法  
参数：Map  
返回：Identification 结果  
示例：
``` java
Map<String, Object> params = new HashMap<String, Object>();
params.put("app", APP_ID);
params.put("type", "bank_card");
Map<String, String> data = new HashMap<String, String>();
data.put("id_name", "张三");
data.put("id_number", "320291198811110000");
data.put("card_number", "6201111122223333");
params.put("data", data);
Identification result = Identification.identify(params);
System.out.println(result.getResultCode());
System.out.println(result.getMessage());
```
