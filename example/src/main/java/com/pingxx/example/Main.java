package com.pingxx.example;

import com.pingplusplus.Pingpp;

import java.math.BigInteger;
import java.security.SecureRandom;

/**
 * Created by Afon on 16/4/26.
 */
public class Main {

    /**
     * Pingpp 管理平台对应的 API Key，api_key 获取方式：登录 [Dashboard](https://dashboard.pingxx.com)->点击管理平台右上角公司名称->开发信息-> Secret Key
     */
    private final static String apiKey = "sk_test_ibbTe5jLGCi5rzfH4OqPW9KC";

    /**
     * Pingpp 管理平台对应的应用 ID，app_id 获取方式：登录 [Dashboard](https://dashboard.pingxx.com)->点击你创建的应用->应用首页->应用 ID(App ID)
     */
    private final static String appId = "app_1Gqj58ynP0mHeX1q";

    /**
   * 设置请求签名密钥，密钥对需要你自己用 openssl 工具生成，如何生成可以参考帮助中心：https://help.pingxx.com/article/123161；
   * 生成密钥后，需要在代码中设置请求签名的私钥(rsa_private_key.pem)；
   * 然后登录 [Dashboard](https://dashboard.pingxx.com)->点击右上角公司名称->开发信息->商户公钥（用于商户身份验证）
   * 将你的公钥复制粘贴进去并且保存->先启用 Test 模式进行测试->测试通过后启用 Live 模式
   */

    // 你生成的私钥路径
    private final static String privateKeyFilePath = "res/your_rsa_private_key_pkcs8.pem";

    public static void main(String[] args) throws Exception {

        // 设置 API Key
        Pingpp.apiKey = apiKey;

        // 设置私钥路径，用于请求签名
//        Pingpp.privateKeyPath = privateKeyFilePath;

        /**
         * 或者直接设置私钥内容
         Pingpp.privateKey = "-----BEGIN RSA PRIVATE KEY-----\n" +
         "... 私钥内容字符串 ...\n" +
         "-----END RSA PRIVATE KEY-----\n";
         */
        Pingpp.privateKey = "-----BEGIN PRIVATE KEY-----\n" +
                "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQDHYyS3FwoESp1h\n" +
                "GLYiBhy6k9Ag3lzGCIEvm50IIEkE0Ftc9qq44TWqyl+EHUpTMdcBOcI42JLO5stw\n" +
                "FOfCLa3PQStEJ4llIRFEKlsrHh67pvWd5RNaSBrvGlnFY40S+SZmjk2WF/h9dE9R\n" +
                "ic79t0YI0alD8dIl9Yu3OaEKo7VonBWFwOYMxjPhtORlq+EUF1XJd//yftQrKWTT\n" +
                "d7KaUonWzBCl4VzFop/OyTWYlTuZz3eYJaNpH5VaQ1vDgBAcPIeBvMf7NgBHMKW6\n" +
                "LLmFd2LEYQ/6I7hkGTjysSzWEpO8bPWT6OEsJ2R2kFGOrSkr+G2MDcJ7ykXYAmz5\n" +
                "+A3plS6ZAgMBAAECggEAVrgwR9GlcahiOtDcpn+yDxQq+aC9CQS561LrQZWJLKbS\n" +
                "leRS7IZHKTlLwdJbeUO8F7RfXQoVEBghc2YkRrhHWFUn1ES95VY0hElHzcET7Nn5\n" +
                "CeuQNzwVOtljIg7iVNY4dXJ/HEDguu/Tb8tYU9FajItj60FJ/WiGk/JksJPzWsOC\n" +
                "VPVniy9fTbTLy1e+dCpCI6OXirtm7hvbodRNDjree0wSEzm7vL0wVzEZFo6kX+AB\n" +
                "GUwaoO7pPyH+hgyI5Iuhc65NHsHzTJpf8yNFl9QGhkxvm2Ff2oEtDt1idOTBrHB6\n" +
                "tg+ti9Ctb2+2yzBnk14hsSYJnKitR7wM6ZCFPX4eYQKBgQD+JAREeFkodec/SC+G\n" +
                "X+4Q4Y68uMPkfUPrMKXM4cyY5wgXk64RBvRVxIxX7x6Y3tIKn9v8tWAprbsyVr15\n" +
                "eb4RcAFEVwjuoZixhd9sIPsRhfdNolKn/fSPIsHL4ywcJMSIt7KVKHuQeqBNHy0o\n" +
                "0PxQjNej1ozsmrAWqV55cbKHswKBgQDI2JQRTPIEC/2y6LdmBVhGJW9OKWTYdVNj\n" +
                "q7rX+Yw4uxOtfd5hBqpvgZEklKEk72aazFdEcERlAm9SqoX09qk6zK/wcq4Xn5Q/\n" +
                "qy8ecmjuyf2AK9X+HUdMerMVxhK9RpeevKYP/RO2F/wIN64anlQVYygVkXXgdOvW\n" +
                "hBE4YABKgwKBgDRtmbPGYB5ItHwJmERQZfx1i8zDESaB8RED6DBsJJkmkDTM8ovw\n" +
                "s1c+RPWfDuDalto6QFfR0xTGEmhAHLaCtwNB6AEBM4aHL8jvpTfZVfI3gN0zL3oY\n" +
                "mestcG1vYBouO504yE6dG2Ci6479b4OMGYFEjPfvuwLUpp8GMcc7/WihAoGANCp8\n" +
                "mtm/ammq5VMof2kX+nAyrrx1ovsmQ5cRGpOIZhvBCqjMn6rZjci7aCLqj+tWXRKC\n" +
                "ABagzROK0o/T50JBxjHv6KYArcYW/Up7HI9ezdbM7wNzu2LjZ+veo+MkbuDs9J/P\n" +
                "CgwTmJI2NfQwVl2VPVDZ0nBLi5cSwk7fIiNdL/0CgYEAtECmC1QDs53Di2MIsa/F\n" +
                "e4sWfJGSDqEWqhcA/aPwf1skM6VJJXBBMV1qFtwgO1AlLnu9dQYra6ylsUoubVYI\n" +
                "XM9XK7EMhbqi57+Q75jHFTc0DnzOTyho5Gp4Ddi8dztmZGNWdWTGdeMqh+svqMXk\n" +
                "D6VdJeddyGu/Zlgj7Wk6whU=\n" +
                "-----END PRIVATE KEY-----\n";


        // Charge 示例
        ChargeExample.runDemos(appId);

        // Refund 示例
        RefundExample.runDemos();

        // RedEnvelope 示例
        RedEnvelopeExample.runDemos(appId);

        // Transfer 示例
        TransferExample.runDemos(appId);

        // Event 示例
        EventExample.runDemos();

        // Webhooks 验证示例
        WebhooksVerifyExample.runDemos();

        // 微信公众号 openid 相关示例
        WxPubOAuthExample.runDemos(appId);

        // 身份证银行卡信息认证接口
        // 请使用 live key 调用该接口
        // IdentificationExample.runDemos(appId);

        // 批量付款示例
        BatchTransferExample.runDemos(appId);

        // 报关
        // 请使用 live key 调用该接口
        CustomsExample.runDemos(appId);
    }

    private static SecureRandom random = new SecureRandom();

    public static String randomString(int length) {
        String str = new BigInteger(130, random).toString(32);
        return str.substring(0, length);
    }

    public static int currentTimeSeconds() {
        return (int)(System.currentTimeMillis() / 1000);
    }
}
