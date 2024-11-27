# Ping++ Java SDK

## 简介

1. [docs](/docs) 目录下为 Ping++ Java SDK 的使用文档。
2. example 目录下面为一个 Eclipse IDE 的示例工程。
3. libs 为 Ping++ Java SDK 的 jar 包和 Ping++ Java SDK 所依赖的Gson 包。
4. src 为 Ping++ Java SDK 的源代码，可以关联到 pingpp-java-x.x.x.jar 文件。或者直接把源代码引入到工程之中。

## 版本要求

Java 要求 JDK 8 及以上。

## 安装

### 手动安装

JAR 下载地址: [pingpp-java](https://mvnrepository.com/artifact/com.pingxx/pingpp-java)

请根据版本号下载相应的 JAR 文件并导入至工程。

#### 依赖库

- com.google.code.gson:gson
- commons-codec:commons-codec

### maven 安装

maven 远程仓库

``` xml
mavenCentral
```

安装 Ping++ SDK

``` xml
<dependency>
    <groupId>com.pingxx</groupId>
    <artifactId>pingpp-java</artifactId>
    <version>2.5.2</version>
    <type>jar</type>
</dependency>
```

### gradle 安装

gradle 远程仓库

```
repositories {
    mavenCentral()
}
```

安装 Ping++ SDK

```
implementation 'com.pingxx:pingpp-java:2.5.2'
```

## 初始化

```
Pingpp.apiKey = "YOUR_API_KEY";
```

## 使用示例

- 参考 [example](/example) 示例项目工程。该工程提供了付款、退款、微信公共号付款相关的 demo。
- 以及 [test](/src/test/java/com/pingplusplus) 目录下的示例。
- 原有旧版本的用户请查看[升级文档](/docs/update/)进行相应调整。
