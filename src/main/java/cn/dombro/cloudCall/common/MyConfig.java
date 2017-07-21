package cn.dombro.cloudCall.common;

import cn.dombro.cloudCall.route.LoginRoute;
import cn.dombro.cloudCall.route.MessageRoute;
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
    }

    public void configEngine(Engine engine) {

    }

    public void configPlugin(Plugins plugins) {

    }

    public void configInterceptor(Interceptors interceptors) {

    }

    public void configHandler(Handlers handlers) {

    }

    public static void main(String[] args) {
        JFinal.start("src/main/webapp",8080,"/");
    }
}
