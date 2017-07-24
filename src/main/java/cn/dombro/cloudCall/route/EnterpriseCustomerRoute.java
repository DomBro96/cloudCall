package cn.dombro.cloudCall.route;

import cn.dombro.cloudCall.controller.EnterpriseCustomerController;
import com.jfinal.config.Routes;

public class EnterpriseCustomerRoute extends Routes {
    @Override
    public void config() {
        add("/ec", EnterpriseCustomerController.class,null);
    }
}
