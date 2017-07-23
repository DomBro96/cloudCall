package cn.dombro.cloudCall.controller;

import cn.dombro.cloudCall.dao.cloud.impl.MessageMapperImpl;
import cn.dombro.cloudCall.entity.Message;
import cn.dombro.cloudCall.util.ClaimUtil;
import com.jfinal.core.Controller;

import java.io.IOException;
import java.util.List;

public class MessageController extends Controller {

    public void message() throws IOException {
     int receiverId = (int) ClaimUtil.getValueByPara(getRequest(),"token","id");
     String group = (String) ClaimUtil.getValueByPara(getRequest(),"token","group");
     String part = getPara("part");
     switch (part){
         case "all" :
             List<Message> allMessages = MessageMapperImpl.getMessageMapper().getOnly2ByIdGroup(receiverId,group);
             renderJson(allMessages);
             break;

         case "read" :
             List<Message> readedMessages =  MessageMapperImpl.getMessageMapper().getListByIdGroupAndRead(receiverId,part,1);
             renderJson(readedMessages);
             break;

         case "unread" :
             List<Message> unreadedMessages = MessageMapperImpl.getMessageMapper().getListByIdGroupAndRead(receiverId,part,0);
             renderJson(unreadedMessages);
             break;
     }
    }
}
