Pingpp Java SDK 
=================


## 简介

src/main/java/com/pingplusplus 文件夹下是 Java SDK 文件，<br>
lib 文件夹下是此 SDK 所依赖的 gson 包， <br>
example 文件夹里面是简单的接入示例，该示例仅供参考。

## 版本要求

Java SDK 要求 JDK 1.6 及以上版本

##安装
```
将 src 文件夹下所有文件导入到工程里
```

## 接入方法

### 初始化
```java
Pingpp.apiKey = "YOUR-KEY";	
```

### 支付
```java
Charge.create(paramsMap);
```

### 查询
```java
Charge.retrieve({CHARGE_ID});
```

```java
Charge.all(Map options);
```

### 退款
``` java
Map params = new HashMap();
Charge ch = Charge.retrieve({CHARGE_ID});
Refund re = ch.getRefunds().create(params);
```

### 退款查询
``` java
Charge ch = Charge.retrieve({CHARGE_ID});
Refund re = ch.refunds->retrieve({REFUND_ID});
```
``` java
Charge.retrieve({CHARGE_ID}).getRefunds().all();
```

### 微信红包
``` java
RedEnvelope.create();
```

### 查询
```java
RedEnvelope.retrieve({CHARGE_ID});
```

```java
RedEnvelope.all(Map options);
```


**详细信息请参考 [API 文档](https://pingxx.com/document/api?java)。**


