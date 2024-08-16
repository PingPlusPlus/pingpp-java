/* *
 * Ping++ Server SDK
 * 说明：
 * 以下代码只是为了方便商户测试而提供的样例代码，商户可根据自己网站需求按照技术文档编写, 并非一定要使用该代码。
 * 接入 webhooks 流程参考开发者中心：https://www.pingxx.com/docs/webhooks/webhooks
 * 该代码仅供学习和研究 Ping++ SDK 使用，仅供参考。
 */
package com.pingxx.example;

import com.pingplusplus.Pingpp;
import com.pingplusplus.net.APIResource;
import com.pingplusplus.util.PingppSignature;

/**
 * webhooks 验证签名示例
 * <p>
 * 该实例演示如何对 Ping++ webhooks 通知进行验证。
 * 验证是为了让开发者确认该通知来自 Ping++ ，防止恶意伪造通知。用户如果有别的验证机制，可以不进行验证签名。
 * <p>
 * 验证签名需要 签名、公钥、验证信息，该实例采用文件存储方式进行演示。
 * 实际项目中，需要用户从异步通知的 HTTP header 中读取签名，从 HTTP body 中读取验证信息。公钥的存储方式也需要用户自行设定。
 * <p>
 * 该实例仅供演示如何验证签名，请务必不要直接 copy 到实际项目中使用。
 */
public class WebhooksVerifyExample {
    /**
     * 验证 webhooks 签名，仅供参考
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        runDemos();
    }

    public static void runDemos() throws Exception {
        String verifyPublicKey = Pingpp.verifyPublicKey;
        // 该数据请从 request 中获取原始 POST 请求数据, 以下仅作为示例
        String webhooksRawPostData = "{\"id\":\"evt_400240816160755820469807\",\"created\":1723795675,\"livemode\":false,\"type\":\"charge.succeeded\",\"data\":{\"object\":{\"id\":\"ch_100240816592822384640019\",\"object\":\"charge\",\"created\":1723795492,\"livemode\":false,\"paid\":true,\"refunded\":false,\"reversed\":false,\"app\":\"app_eTC8yLuj9GSSL0yv\",\"channel\":\"wx_pub\",\"order_no\":\"1723795491985uqclqj7\",\"client_ip\":\"127.0.0.1\",\"amount\":100,\"amount_settle\":100,\"currency\":\"cny\",\"subject\":\"Your Subject\",\"body\":\"Your Body\",\"extra\":{\"open_id\":\"o7xEMsySBFG3MVHI-9VsAJX-j50W\",\"limit_pay\":\"no_credit\",\"bank_type\":\"your bank type\"},\"time_paid\":1723795675,\"time_expire\":1723802692,\"time_settle\":null,\"transaction_no\":\"1290362656202408163243920572\",\"refunds\":{\"object\":\"list\",\"url\":\"/v1/charges/ch_100240816592822384640019/refunds\",\"has_more\":false,\"data\":[]},\"amount_refunded\":0,\"failure_code\":null,\"failure_msg\":null,\"metadata\":{},\"credential\":{},\"description\":null}},\"object\":\"event\",\"request\":\"iar_mrrvj9ivPOaHPOi9aLPWPqvT\",\"pending_webhooks\":0}";
        System.out.println("------- POST 原始数据 -------");
        System.out.println(webhooksRawPostData);
        // 签名数据请从 request 的 header 中获取, key 为 X-Pingplusplus-Signature (请忽略大小写, 建议自己做格式化)
        String signature = "Ju5ItDM9Hblkm6Pbb/r3G9iM58oCtAUJlJDrOud0E23TUtGBxKYJSMcuTFbPgLGLKy5QHYovJJojjMjM1CMGCp82F+SOY1U2zuwzkAk0lVqhfQk+CWGpcyUzOtLOOblKidyuIb+axZDTIg4kK/JoOR2xMH3+cJD9BN6rtfzEDbHqyZIfv6n3y/LdZNhsXfQq+qoIRuLdHrFexk1USgk7SXFvH1pCOIt8o2+dryp/ixlNj1vGq57eE8sbEzPo72vxLtzPazlgR+67cS1bUxjzObh7YFbSSTJxkHDEIi3ipTpoiI7Kc5ng7EzsWgp3cAl7on5HztfFLfT8+Bjpdvtr6w==";
        System.out.println("------- 签名 -------");
        System.out.println(signature);

        boolean result = PingppSignature.verify(signature, webhooksRawPostData, verifyPublicKey, APIResource.CHARSET.name());
        System.out.println("验签结果：" + (result ? "通过" : "失败"));
    }
}
