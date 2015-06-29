#### ping++_java_sdk API 文档

##### 概述

    本文档简要概述ping++ java sdk 部分常用类的使用方法，详细使用方法开发者可阅读源码以及示例程序
 
 1. Charge.java
 2. Event.java
 3. RedEnvelope.java
 4. ChargeRefundCollection.java
 5. Webhooks.java
 
 
##### Charge.java

###### 创建 Charge
    
 create(Map<String, Object> params)
  
    方法名：create
    类型：静态方法
    参数：Map  
    返回：Charge
    
    示例：
        Charge charge = null;
        Map<String, Object> chargeMap = new HashMap<String, Object>();
        chargeMap.put("amount", 100);
        chargeMap.put("currency", "cny");
        chargeMap.put("subject", "Your Subject");
        chargeMap.put("body", "Your Body");
        chargeMap.put("order_no", "orderNo");
        chargeMap.put("channel", "alipay");
        chargeMap.put("client_ip", "127.0.0.1");
        Map<String, String> app = new HashMap<String, String>();
        app.put("id",appId);
        chargeMap.put("app", app);
        try {
            //发起交易请求
            charge = Charge.create(chargeMap);
            System.out.println(charge);
        } catch (PingppException e) {
            e.printStackTrace();
        }
        
###### 查询 Charge
 retrieve(String id)
  
    方法名：retrieve
    类型：静态方法
    参数：String 类型的 Charge ID
    返回：Charge
    
    示例：
        try {
            Charge charge = Charge.retrieve(id);              
            System.out.println(charge);
        } catch (PingppException e) {
            e.printStackTrace();
        }
 retrieve(String id, Map<String, Object> params)

  
    方法名：retrieve
    类型：静态方法
    参数：String 类型的 Charge ID,Map
    返回：Charge
    
    示例：
        try {
            Map<String, Object> param = new HashMap<String, Object>();
            List<String> expande = new ArrayList<String>();
            expande.add("app");
            param.put("expand", expande);
            Charge charge = Charge.retrieve(id, param);
            System.out.println(charge);

        } catch (PingppException e) {
            e.printStackTrace();
        }

 all(Map<String, Object> params)

    方法名：all
    类型：静态方法
    参数：Map 
    返回：ChargeCollection
    
    示例：
        ChargeCollection chargeCollection = null;
        Map<String, Object> chargeParams = new HashMap<String, Object>();
        chargeParams.put("limit", 3);
        try {
            chargeCollection = Charge.all(chargeParams);
            System.out.println(chargeCollection);
        } catch (AuthenticationException e) {
            e.printStackTrace();
        } catch (InvalidRequestException e) {
            e.printStackTrace();
        } catch (APIConnectionException e) {
            e.printStackTrace();
        } catch (APIException e) {
            e.printStackTrace();
        }
##### Event.java

###### 查询 Event

 retrieve(String id)
 
    方法名：retrieve
    类型：静态方法
    参数：String 类型的 Event ID
    返回：Event
    
    示例：
       try {
            Event event = Event.retrieve(id);
        } catch (AuthenticationException e) {
            e.printStackTrace();
        } catch (InvalidRequestException e) {
            e.printStackTrace();
        } catch (APIConnectionException e) {
            e.printStackTrace();
        } catch (APIException e) {
            e.printStackTrace();
        }
        
all(Map<String, Object> params)
 
    方法名：all
    类型：静态方法
    参数：String 类型的 Event ID
    返回：EventCollection
    
    示例：
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("limit", 3);
        try {
            EventCollection eventCollection = Event.all(params);
            System.out.println(eventCollection);
        } catch (AuthenticationException e) {
            e.printStackTrace();
        } catch (InvalidRequestException e) {
            e.printStackTrace();
        } catch (APIConnectionException e) {
            e.printStackTrace();
        } catch (APIException e) {
            e.printStackTrace();
        }

##### RedEnvelope.java

###### 创建 RedEnvelope
create(Map<String, Object> params)
    
    方法名：create
    类型：静态方法
    参数：Map
    返回：RedEnvelope
    
    示例：
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
        app.put("id", "app_1234567890abcDEF");
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

###### 查询 RedEnvelope

retrieve(String id)
    
    方法名：create
    类型：静态方法
    参数：String 类型的 RedEnvelope ID
    返回：RedEnvelope
    
    示例：
        try {
            RedEnvelope redEnvelope = RedEnvelope.retrieve(id);              
            System.out.println(redEnvelope);
        } catch (PingppException e) {
            e.printStackTrace();
        }
all(Map<String, Object> params)
    
    方法名：all
    类型：静态方法
    参数：Map 
    返回：RedEnvelopeCollection
    
    示例：
        RedEnvelopeCollection redEnvelopeCollection = null;
        Map<String, Object> chargeParams = new HashMap<String, Object>();
        chargeParams.put("limit", 3);
        try {
            redEnvelopeCollection = RedEnvelopeCollection.all(chargeParams);
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


##### ChargeRefundCollection.java

###### 创建 Refund
create(Map<String, Object> params)
    
    方法名：create
    类型：静态方法
    参数：Map
    返回：Refund
    
    示例：
        Refund refund = null;
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("description", "苹果被咬了一口。");

        try {
            refund = charge.getRefunds().create(params);
            System.out.println(refund.getFailureMsg());
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
 
###### 查询 Refund.java
retrieve(String id)
    
    方法名：create
    类型：静态方法
    参数：String 类型的 Refund ID
    返回：Refund
    
    示例：
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
        
all(Map<String, Object> params)
    
    方法名：all
    类型：静态方法
    参数：Map
    返回：ChargeRefundCollection
    
    示例：
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
 
##### Webhooks.java

###### 解析 Webhooks

 parseEvnet(String eventStr)
 
    方法名：parseEvnet
    类型：静态方法
    参数：json 类型的 Event 字符串
    返回：Object
    
    示例：
        Object obj = Webhooks.parseEvnet(event);
        if (obj instanceof Charge) {
            System.out.println("webhooks 发送了 Charge");
            Charge charge = (Charge) obj;
            System.out.println("付款状态：" + charge.getPaid() + " 订单号：" + charge.getOrderNo());
        } else if (obj instanceof Refund) {
            System.out.println("webhooks 发送了 Refund");
        } else if (obj instanceof Summary) {
            System.out.println("webhooks 发送了 Summary");
        }
 eventParse(String eventStr)
  
    方法名：eventParse
    类型：静态方法
    参数：json 类型的 Event 字符串
    返回：Event
    
    示例：
        Event eventobj = Webhooks.eventParse(event.toString());
 

