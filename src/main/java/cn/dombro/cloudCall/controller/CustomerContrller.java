package cn.dombro.cloudCall.controller;

import cn.dombro.cloudCall.util.WebTokenUtil;
import com.jfinal.core.Controller;

import java.util.HashMap;
import java.util.Map;

public class CustomerContrller extends Controller {


    //企业用户注册接口
    public void enterprisecustomer(){


    }
    //客服注册接口
    public void customerservice(){
       String togken = getPara("token");
       if (WebTokenUtil.getTokenList().contains(togken)){
           renderJson(1);
       }

    }

    // 登录 POST /退出 GET
    public void session(){
        String method = getRequest().getMethod();
        if ("POST".equals(method)){
            Map testToken = new HashMap();
            testToken.put("userId",1);
            String token  = WebTokenUtil.createJavaWebToken(testToken);
            WebTokenUtil.addToTokenList(token);
            System.out.println(getRequest().getMethod());
            renderJson(token);
        }else {
             //如果发送过来的是 GET 请求，说明 是注销用户
             String token = getPara("token");
             if (WebTokenUtil.getTokenList().contains(token)){
                 WebTokenUtil.getTokenList().remove(token);
                 renderJson(WebTokenUtil.getTokenList().size());
            }
        }


    }



}
