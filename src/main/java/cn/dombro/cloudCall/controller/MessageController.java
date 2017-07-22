package cn.dombro.cloudCall.controller;

import cn.dombro.cloudCall.dao.cloud.impl.MessageMapperImpl;
import cn.dombro.cloudCall.util.ClaimUtil;
import com.jfinal.core.Controller;

import java.io.IOException;

public class MessageController extends Controller {

    public void message() throws IOException {
     int receiverId = (int) ClaimUtil.getValueByPara(getRequest(),"token","id");
     String group = (String) ClaimUtil.getValueByPara(getRequest(),"token","group");
     String part = getPara("part");
     switch (part){
         case "all" :

     }
    }
}
