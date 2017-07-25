package cn.dombro.cloudCall.controller;

import cn.dombro.cloudCall.dao.cloud.impl.MessageMapperImpl;
import cn.dombro.cloudCall.entity.Message;
import cn.dombro.cloudCall.util.ClaimUtil;
import cn.dombro.cloudCall.viewobject.Msg;
import com.jfinal.core.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MessageController extends Controller {

    public void message() throws IOException {
     Map<String,Object> jsonMap = null;
     String method = getRequest().getMethod();
     int receiverId = (int) ClaimUtil.getValueByPara(getRequest(),"token","id");
     String group = (String) ClaimUtil.getValueByPara(getRequest(),"token","group");
     switch (method){
         case "POST" :
             int msgId = getParaToInt("msgId");
             Message message1 = MessageMapperImpl.getMessageMapper().selectByPrimaryKey(msgId);
             message1.setReadd(1);
             MessageMapperImpl.getMessageMapper().updateByPrimaryKey(message1);
             renderJson("authorization","T000");
             break;
         case "GET" :
             String part = getPara("part");
             List<Msg> msgList = new ArrayList<>();
             switch (part){
                 case "all" :
                     List<Message> allMessages = MessageMapperImpl.getMessageMapper().getListByIdGroup(receiverId,group);
                     for (Message message:allMessages){
                         System.out.println(message);
                     Msg msg = new Msg(message.getMessage(),message.getReadd().toString(),message.getMsgId().toString());
                     msgList.add(msg);
                 }
                     jsonMap = new HashMap<>();
                     jsonMap.put("authorization","T000");
                     jsonMap.put("msg",msgList);
                     renderJson(jsonMap);
                     break;

                 case "read" :
                     List<Message> readedMessages =  MessageMapperImpl.getMessageMapper().getListByIdGroupAndRead(receiverId,part,1);
                     for (Message message:readedMessages){
                         System.out.println(message);
                         Msg msg = new Msg(message.getMessage(),message.getReadd().toString(),message.getMsgId().toString());
                         msgList.add(msg);
                     }
                     jsonMap = new HashMap<>();
                     jsonMap.put("authorization","T000");
                     jsonMap.put("msg",msgList);
                     renderJson(jsonMap);
                     break;

                 case "unread" :
                     List<Message> unreadedMessages = MessageMapperImpl.getMessageMapper().getListByIdGroupAndRead(receiverId,part,0);
                     for (Message message:unreadedMessages){
                         System.out.println(message);
                         Msg msg = new Msg(message.getMessage(),message.getReadd().toString(),message.getMsgId().toString());
                         msgList.add(msg);
                     }
                     jsonMap = new HashMap<>();
                     jsonMap.put("authorization","T000");
                     jsonMap.put("msg",msgList);
                     renderJson(jsonMap);
                     break;
             }
             break;
     }

    }
}
