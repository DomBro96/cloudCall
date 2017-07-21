package cn.dombro.cloudCall.route;

import cn.dombro.cloudCall.controller.CustomerContrller;
import com.jfinal.config.Routes;

public class LoginRoute extends Routes {
    @Override
    public void config() {
        add("/lg", CustomerContrller.class,null);
    }
}
