package com.cy;

import com.alibaba.fastjson.JSON;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;

@SpringBootTest
class AliSmsApplicationTests {

    @Test
    void contextLoads() {
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", "LTAI4G7sBvJQ5fVKn3f9gUiS", "C2uXEbREAn7FxSJnECbvTDJ0N8DLNS");
        IAcsClient client = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest();
        request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("SendSms");
        request.putQueryParameter("PhoneNumbers", "15583082980");
        request.putQueryParameter("SignName", "找房");
        request.putQueryParameter("TemplateCode", "SMS_173246892");

        HashMap<Object, Object> map = new HashMap<>();
        map.put("code", 2233);
        request.putQueryParameter("TemplateParam", JSON.toJSONString(map));

        try {
            CommonResponse response = client.getCommonResponse(request);
            System.out.println(response.getData());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
