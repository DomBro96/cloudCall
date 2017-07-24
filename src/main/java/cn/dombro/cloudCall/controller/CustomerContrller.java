package cn.dombro.cloudCall.controller;

import cn.dombro.cloudCall.dao.info.Impl.CustomerServiceMapperImpl;
import cn.dombro.cloudCall.dao.info.Impl.EnterpriseCustomerMapperImpl;
import cn.dombro.cloudCall.dao.info.Impl.SystemAdministratorMapperImpl;
import cn.dombro.cloudCall.entity.CustomerService;
import cn.dombro.cloudCall.entity.EnterpriseCustomer;
import cn.dombro.cloudCall.util.ClaimUtil;
import cn.dombro.cloudCall.util.WebTokenUtil;
import com.jfinal.core.Controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CustomerContrller extends Controller {


    //企业用户注册接口
    public void enterprisecustomer() throws IOException {
       String code = "S001";
       String msg = "该账号已经注册";
       String authorization = "T001";
       Map<String,Object>  jsonMap = new HashMap<>();
       String username = getPara("username");
       String password = getPara("password");
       String companyNmae = getPara("companyNmae");
       String license = getPara("license");
       Long phoneNumber = Long.parseLong(getPara("phoneNumber"));
       String ecpassword = EnterpriseCustomerMapperImpl.getCustomerMapper().selectPswByUser(username);
       if (ecpassword == null){
           EnterpriseCustomer enterpriseCustomer = new EnterpriseCustomer();
           enterpriseCustomer.setUsername(username);
           enterpriseCustomer.setPassword(password);
           enterpriseCustomer.setCompanyName(companyNmae);
           enterpriseCustomer.setPhoneNumber(phoneNumber);
           enterpriseCustomer.setLicense(license);
           EnterpriseCustomerMapperImpl.getCustomerMapper().insertSelective(enterpriseCustomer);
           code = "S000";
           msg = "注册成功";
           jsonMap.put("code",code);
           jsonMap.put("msg",msg);
           jsonMap.put("authorization",authorization);
       }else{
           jsonMap.put("code",code);
           jsonMap.put("msg",msg);
           jsonMap.put("authorization",authorization);
       }
           renderJson(jsonMap);
    }
    //客服注册接口
    public void customerservice() throws IOException {
        String code = "S001";
        String msg = "该账号已经注册";
        String authorization = "T001";
        Map<String,Object>  jsonMap = new HashMap<>();
        String username = getPara("username");
        String password = getPara("password");
        String name = getPara("name");
        String IDNumber = getPara("IDNumber");
        Long phoneNumber = Long.parseLong(getPara("phoneNumber"));
        String cspassword = CustomerServiceMapperImpl.getServiceMapper().selectPswByUser(username);
        if (cspassword == null){
            CustomerService customerService = new CustomerService();
            customerService.setUsername(username);
            customerService.setPassword(password);
            customerService.setName(name);
            customerService.setIdNumber(IDNumber);
            customerService.setPhoneNumber(phoneNumber);
            CustomerServiceMapperImpl.getServiceMapper().insertSelective(customerService);
            code = "S000";
            msg = "注册成功";
            jsonMap.put("code",code);
            jsonMap.put("msg",msg);
            jsonMap.put("authorization",authorization);
        }else {
            jsonMap.put("code",code);
            jsonMap.put("msg",msg);
            jsonMap.put("authorization",authorization);
        }
            renderJson(jsonMap);
    }


    public void session() throws IOException {
        //获取请求方式，如果是 POST 则代表是 登录请求
        String method = getRequest().getMethod();
        Map<String,Object> jsonMap = new HashMap<>();
        String authorization = "T001";
        if ("POST".equals(method)){
           String code = "L002";
           String msg = "不存在该账号";
           String token = "";
           Map<String,Object> claimMap = new HashMap<>();
           String group =  getPara("group");
           String username = getPara("username");
           String password = getPara("password");
           switch (group)  {

               case "cs":
                   String cspassword = CustomerServiceMapperImpl.getServiceMapper().selectPswByUser(username);
                   //账号没有对应密码
                   if (cspassword == null){
                        jsonMap.put("code",code);
                        jsonMap.put("msg",msg);
                        jsonMap.put("authorization",authorization);
                        jsonMap.put("token",token);
                        renderJson(jsonMap);
                   }else{
                     if (password.equals(cspassword)){
                         int csId = CustomerServiceMapperImpl.getServiceMapper().selectByUser(username).getCsId();
                         claimMap.put("id",csId);
                         claimMap.put("group","cs");
                         token = WebTokenUtil.createJavaWebToken(claimMap);
                         WebTokenUtil.addToTokenList(token);
                         code = "L000";
                         msg = "登陆成功";
                         authorization = "T000";
                         jsonMap.put("code",code);
                         jsonMap.put("msg",msg);
                         jsonMap.put("authorization",authorization);
                         jsonMap.put("token",token);
                         renderJson(jsonMap);
                       }else {
                           code = "L001";
                           msg = "密码错误";
                           authorization = "T001";
                           token = "";
                         jsonMap.put("code",code);
                         jsonMap.put("msg",msg);
                         jsonMap.put("authorization",authorization);
                         jsonMap.put("token",token);
                         renderJson(jsonMap);
                     }
                   }
                   break;

               case "ec" :
                   String ecpassword = EnterpriseCustomerMapperImpl.getCustomerMapper().selectPswByUser(username);
                   //账号没有对应密码
                   if (ecpassword == null){
                       jsonMap.put("code",code);
                       jsonMap.put("msg",msg);
                       jsonMap.put("token",token);
                       jsonMap.put("authorization",authorization);
                       renderJson(jsonMap);
                   }else {
                       if (password.equals(ecpassword)) {
                           int ecId = EnterpriseCustomerMapperImpl.getCustomerMapper().selectByUser(username).getEcId();
                           claimMap.put("id", ecId);
                           claimMap.put("group", "ec");
                           token = WebTokenUtil.createJavaWebToken(claimMap);
                           WebTokenUtil.addToTokenList(token);
                           code = "L000";
                           msg = "登陆成功";
                           authorization = "T000";
                           jsonMap.put("code", code);
                           jsonMap.put("msg", msg);
                           jsonMap.put("authorization", authorization);
                           jsonMap.put("token", token);
                           renderJson(jsonMap);
                       } else {
                           code = "L001";
                           msg = "密码错误";
                           authorization = "T001";
                           token = "";
                           jsonMap.put("code", code);
                           jsonMap.put("authorization", authorization);
                           jsonMap.put("msg", msg);
                           jsonMap.put("token", token);
                           renderJson(jsonMap);
                       }
                   }
                   break;

               case "sa" :
                   String  aspassword = SystemAdministratorMapperImpl.getAdministratorMapper().selectPswByUser(username);
                   //账号没有对应密码
                   if (aspassword == null){
                       jsonMap.put("code",code);
                       jsonMap.put("token",token);
                       jsonMap.put("msg",msg);
                       jsonMap.put("authorization",authorization);
                       renderJson(jsonMap);
                   }else {
                       if (password.equals(aspassword)) {
                           int saId = SystemAdministratorMapperImpl.getAdministratorMapper().selectByUser(username).getSaId();
                           claimMap.put("id", saId);
                           claimMap.put("group", "sa");
                           token = WebTokenUtil.createJavaWebToken(claimMap);
                           WebTokenUtil.addToTokenList(token);
                           code = "L000";
                           msg = "登陆成功";
                           authorization = "T000";
                           jsonMap.put("code", code);
                           jsonMap.put("msg", msg);
                           jsonMap.put("authorization", authorization);
                           jsonMap.put("token", token);
                           renderJson(jsonMap);
                       } else {
                           code = "L001";
                           msg = "密码错误";
                           authorization = "T001";
                           token = "";
                           jsonMap.put("code", code);
                           jsonMap.put("authorization", authorization);
                           jsonMap.put("token", token);
                           jsonMap.put("msg", msg);
                           renderJson(jsonMap);
                       }
                   }
                   break;
               }

        }else {
        //如果发送过来的是 GET 请求，说明 是注销用户
        String token = getPara("token");
        if (WebTokenUtil.getTokenList().contains(token)){
            WebTokenUtil.getTokenList().remove(token);
            }
            jsonMap.put("authorization",authorization);
            renderJson(jsonMap);
            }
        }
    }

