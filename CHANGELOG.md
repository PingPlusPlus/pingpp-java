# ChangeLog

## 2.3.4 (2018-01-10)
#### 修改
- 移除已废弃接口
- 移除 transfer、batch_transfer 取消接口
- 更新示例
- 移除 order user_from 字段
- settle_account 字段更新

## 2.3.3 (2017-12-27)
#### 修正
- 修正 javadoc

## 2.3.2 (2017-12-21)
#### 修正
- 兼容 JDK 1.7

## 2.3.1 (2017-12-08)
#### 修正
- Event 解析修正

## 2.3.0 (2017-12-01)
#### 更改
- 合并账户系统相关接口

## 2.2.5 (2017-10-10)
#### 新增
- 新增重试机制

#### 修改
- 优化 SDK

## 2.2.4 (2017-06-19)
#### 修改
- Charge 增加字段 reversed，表示是否已撤销
- 针对渠道 isv_scan, isv_qr_isv_wap 增加撤销方法，`Charge.reverse(CHARGE_ID)`
- Refund 增加 extra 字段

## 2.2.3 (2017-03-27)
#### 修改
- BatchTransfer 增加字段

## 2.2.2 (2017-03-21)
#### 修正
- alipay_pc_direct/alipay_wap 渠道 credential 字段类型的修正

## 2.2.1 (2017-01-13)
#### 新增
- 添加 gradle 相关文件
- 添加部分测试文件
- batch_transfer 更新/取消接口

#### 修改
- 更改签名私钥获取方式
- Charge.list app[id] 参数改为必传
- 红包去除多余的参数
- batch_refund charges 字段格式修改

#### 修正
- Webhooks 解析对象 batch_refund、batch_transfer、customs 对应事件错误

## 2.2.0
#### 新增
- 添加 BatchRefund、BatchTransfer、Customs

#### 修改
- 签名生成规则变更
- 列表查询接口换成 `list` 方法，代替 `all` 方法
- 退款接口调用方式变更，直接使用 Refund 对象
- Refund 对象添加 charge_order_no, transaction_no 属性

## 2.1.9
#### 修改
- 添加 RateLimitException  
- 兼容 http 地址，仅为方便测试

## 2.1.8
#### 新增
- Identification 身份证银行卡接口

## 2.1.7
#### 修正
- RedEnvelope、Transfer 添加字段

## 2.1.6
#### 修正
- 签名内容编码问题

## 2.1.5
#### 修改
- 补充 RedEnvelope、Transfer 缺少字段

## 2.1.4
#### 修改
- 更改 content-type 为 application/json

## 2.1.3
- 兼容两种微信公众号接入方式

## 2.1.2
- 补全确实字段
- 修正 Event 解析
- 修正部分字符 JSON 序列化问题
- 添加请求签名

## 2.1.1
- 修正 extra 类型
- 兼容 jdk 1.6

## 2.1.0
- 添加应用内快捷支付对应接口

## 2.0.10
- 增加 Refund 对象 status 字段

## 2.0.8
- 增加 ChannelException

## 2.0.6
- 增加企业转账、修改红包接口

## 2.0.5
- 增加 event sdk

## 2.0.4
- 更改 sdk 目录格式，修复wx_pub渠道timeStamp 类型问题。

## 2.0.3
- 增加 apple pay ，重写 getcredential 方法。

## 2.0.2
- 增加微信红包

## 2.0.1
#### 更改
修改 wx credential 里的 timeStamp 类型为字符串，防止变成科学计数法

## 2.0.0
#### 更改
添加新渠道支持：百付宝、百付宝WAP、微信公众平台

## 1.0.4
#### 更改：
添加 `Expanding` 机制
