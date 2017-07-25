package cn.dombro.cloudCall.route;

import cn.dombro.cloudCall.controller.TraditionController;
import com.jfinal.config.Routes;

public class TraditionRoute extends Routes {
    @Override
    public void config() {
        add("/tr", TraditionController.class,null);
    }
}
