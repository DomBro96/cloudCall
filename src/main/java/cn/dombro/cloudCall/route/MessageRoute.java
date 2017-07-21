package cn.dombro.cloudCall.route;

import cn.dombro.cloudCall.controller.MessageController;
import com.jfinal.config.Routes;

public class MessageRoute extends Routes{

    @Override
    public void config() {
        add("/no", MessageController.class,null);
    }
}
