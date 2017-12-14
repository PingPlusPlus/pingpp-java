# Ping++ Java SDK 使用文档

#### apiKey 和 appId
SDK 需要 Ping++ 提供的 apiKey 和 AppID 作为凭证获取移动端支付所需的 Charge 对象。  
其中，apiKey 可以在 Ping++ 管理平台的【企业设置】->【开发设置】中得到。  
AppID 可以在 Ping++ 管理平台应用卡片下方得到。

#### 依赖
- gons-2.6.2
- commons-codec-1.10

#### 设置 apiKey
``` java
Pingpp.apiKey = "YOUR-KEY";
```
在创建 Charge 前，请设置 apiKey。

#### 设置请求签名密钥
密钥需要你自己生成，公钥请填写到 [Ping++ Dashboard](https://dashboard.pingxx.com)。  
建议使用 PKCS\#8 编码的私钥文件。openssl 命令如下：
```shell
openssl pkcs8 -topk8 -inform PEM -in pkcs1.pem -outform PEM -nocrypt -out pkcs8.pem
```

设置你的私钥
```java    
Pingpp.privateKey = "<PRIVATE-KEY-CONTENT>";
```

#### 设置 App ID
当你使用账户系统的接口时，需要设置 App ID。比如，充值（recharge）、提现（withdrawal）等。
```java
Pingpp.appId = "<APP_ID>";
```

#### 创建 Charge
```java
Map<String, Object> chargeMap = new HashMap<String, Object>();
// 某些渠道需要添加extra参数，具体参数详见接口文档
chargeMap.put("amount", 100);
chargeMap.put("currency", "cny");
chargeMap.put("subject", "Your Subject");
chargeMap.put("body", "Your Body");
chargeMap.put("order_no", "123456789");
chargeMap.put("channel", "alipay");
chargeMap.put("client_ip", "127.0.0.1");
Map<String, String> app = new HashMap<String, String>();
app.put("id", "YOUR_APP_ID");
chargeMap.put("app", app);
try {
    //发起交易请求
    Charge charge = Charge.create(chargeMap);
    System.out.println(charge.toString());
} catch (PingppException e) {
    e.printStackTrace();
}
```

##### 备注

    获得 Charge 对象，必须的参数有 amount、currency、subject、body、order_no、channel、client_ip、app 这 8 个参数。
    其中 amount、order_no、channel 三个参数由客户端的 post 请求中获得。
    client_ip 从客户端的 request 请求中解析。
    currency 为交易的货币代码，目前仅支持人民币 cny。
    app 参数为一个包含 appId 的 map 对象。
    subject 和 body 参数用来在用户付款、以及在第三方支付软件的账单显示。

#### 返回 Charge
请用 JSON 格式把 Charge 对象返回给客户端。

##### servlet 返回 Charge 时注意配置
```java
response.setContentType("application/json;charset=UTF-8");
```

##### struct2 获得 POST 请求参数，建议使用 struct2-json-pligun.jar。返回的 result 的 type 设置为 json
struct2.xml 配置如下：
```xml
<package name="default" namespace="/" extends="json-default">
    <action name="ActionName" class="ActionCalss" method="Method">
        <interceptor-ref name="json"/>
        <result name="success" type="json">
            <param name="root">charge</param>
        </result>
    </action>
</package>
```

#### 补充   
SDK 根目录下面的 example 目录下提供了一个 gradle 工程，里面含有部分操作的示例程序，供开发者参考。
