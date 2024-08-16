package com.pingplusplus.sub_app;

import com.pingplusplus.PingppTestBase;
import com.pingplusplus.exception.PingppException;
import com.pingplusplus.model.Contact;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/*
 * @author Afon, @date 19-07-12
 */
public class ContactTest extends PingppTestBase {

    /**
     * 证件上传
     */
    @Test public void testAddContact() throws PingppException {
        Map<String, Object> params = new HashMap<>();
        params.put("user", "test_user_001"); // 用户 ID
        params.put("acc_no", "2019057929311601000631"); // 壹账通用户编号。此编号可在证件上传接口的返回获得
        params.put("contact_type", 1);    // 联系人类型，1:第一紧急联系人、2：第二紧急联系人、3：第三紧急联系人、4、法人、5、财务人员（4、5必传）
        params.put("contact_name", "杨真探");  // 联系人名称
        params.put("contact_cert_type", "01"); // 证件类型：01：身份证、02:企业营业执照、03：护照、04：港澳通行证、05：台湾往来通行证、06：临时身份证
        params.put("contact_cert_no", "310181201402149201"); // 联系人证件号
        params.put("contact_cert_valid_from", "2019-01-01"); // 联系人证件起始日，格式：“2018-12-21”
        params.put("contact_cert_valid_until", "2028-12-31"); // 联系人证件截止日，格式：“2019-12-21”，长期填写：“9999-12-31”
        params.put("contact_cert_mobile", "13500127654"); // 联系人手机号
        params.put("contact_job_type", 1); // 联系人工作类型，1:企业主 2：个体工商户 3：全职上班 4：兼职 5： 学生 6：退休 7：无固定职业 8：其他
//        params.put("contact_relation_ship", 1); // 联系人与本人关系，1:父母 2：配偶 3：子女 4：兄弟 5：姐妹 6：其他亲属 7：朋友 8：同事

        Contact obj = Contact.create(params);

        assertEquals("user should be same as param", params.get("user"), obj.getUser());
        assertEquals("acc_no should be same as param", params.get("acc_no"), obj.getAccNo());
    }
}
