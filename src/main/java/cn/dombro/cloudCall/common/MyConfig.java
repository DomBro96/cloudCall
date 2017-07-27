package cn.dombro.cloudCall.common;

import cn.dombro.cloudCall.route.*;
import cn.dombro.cloudCall.util.WebTokenUtil;
import com.jfinal.config.*;
import com.jfinal.core.JFinal;
import com.jfinal.template.Engine;

/**
 * Created by 18246 on 2017/7/16.
 */
public class MyConfig extends JFinalConfig {
    public void configConstant(Constants constants) {

    }

    public void configRoute(Routes routes) {
        routes.add(new MessageRoute());
        routes.add(new LoginRoute());
        routes.add(new EnterpriseCustomerRoute());
        routes.add(new SystemAdminRoute());
        routes.add(new CustomerServiceRoute());
        routes.add(new TraditionRoute());
    }

    public void configEngine(Engine engine) {

    }

    public void configPlugin(Plugins plugins) {

    }

    public void configInterceptor(Interceptors interceptors) {

    }

    public void configHandler(Handlers handlers) {

    }

    //在项目启动之后 在内存中 生成一个存放已发出Token的List
    public void afterJFinalStart() {
        System.out.println("JFinal start");
        WebTokenUtil.creatTokenList();
    }
    //在项目关闭之前 清除 在内存中的TokenList
     public void beforeJFinalStop() {


        WebTokenUtil.getTokenList().clear();
    }

    public static void main(String[] args) {
        JFinal.start("src/main/webapp",8080,"/");
    }
}
