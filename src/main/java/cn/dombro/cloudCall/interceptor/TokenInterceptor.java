package cn.dombro.cloudCall.interceptor;

import cn.dombro.cloudCall.util.WebTokenUtil;
import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;
import com.jfinal.core.Controller;

/**
 * Token 拦截器
 */
public class TokenInterceptor implements Interceptor {
    @Override
    public void intercept(Invocation invocation) {
       Controller controller = invocation.getController();
       String token =  controller.getRequest().getParameter("token");
       if (WebTokenUtil.getTokenList().contains(token)){
           invocation.invoke();
       }
       else {
           controller.renderJson("该账号已过期，请重新登录");
       }
    }
}
