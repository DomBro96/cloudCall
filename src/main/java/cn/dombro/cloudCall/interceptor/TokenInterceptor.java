package cn.dombro.cloudCall.interceptor;

import cn.dombro.cloudCall.util.WebTokenUtil;
import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;
import com.jfinal.core.Controller;
import com.jfinal.kit.HttpKit;
import com.jfinal.upload.UploadFile;

/**
 * Token 拦截器
 */
public class TokenInterceptor implements Interceptor {
    @Override
    public void intercept(Invocation invocation) {
        Controller controller = invocation.getController();
        String token =  controller.getPara("token");
        System.out.println(token);
       if (WebTokenUtil.getTokenList().contains(token)){
           invocation.invoke();
       }
       else {
           controller.renderJson("authorization","T001");
       }
    }
}
