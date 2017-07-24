package cn.dombro.cloudCall.route;

import cn.dombro.cloudCall.controller.CustomerServiceController;
import com.jfinal.config.Routes;

public class CustomerServiceRoute extends Routes {
    @Override
    public void config() {
        add("/cs", CustomerServiceController.class,null);
    }
}
