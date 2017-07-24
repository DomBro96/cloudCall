package cn.dombro.cloudCall.route;

import cn.dombro.cloudCall.controller.SystemAdminController;
import com.jfinal.config.Routes;

public class SystemAdminRoute extends Routes {
    @Override
    public void config() {
        add("/sa", SystemAdminController.class,null);
    }
}
