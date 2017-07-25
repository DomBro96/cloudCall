package cn.dombro.cloudCall.controller;

import cn.dombro.cloudCall.dao.cloud.impl.CallMissionMapperImpl;
import cn.dombro.cloudCall.dao.cloud.impl.MessageMapperImpl;
import cn.dombro.cloudCall.dao.cloud.impl.MissionInfoMapperImpl;
import cn.dombro.cloudCall.dao.info.Impl.CustomerServiceMapperImpl;
import cn.dombro.cloudCall.dao.info.Impl.EnterpriseCustomerMapperImpl;
import cn.dombro.cloudCall.entity.CallMission;
import cn.dombro.cloudCall.entity.CustomerService;
import cn.dombro.cloudCall.entity.Message;
import cn.dombro.cloudCall.entity.MissionInfo;
import cn.dombro.cloudCall.util.ClaimUtil;
import cn.dombro.cloudCall.util.MessageUtil;
import cn.dombro.cloudCall.viewobject.Mission;
import com.jfinal.core.Controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerServiceController extends Controller {

    private Map<String,Object> jsonMap = null;

    public void countlist() throws IOException {
        String authorization = "T000";
        int csId = (int) ClaimUtil.getValueByPara(getRequest(),"token","id");
        System.out.println(csId);
        int a = MissionInfoMapperImpl.getInfoMapper().getAcceptStatusNumByAcceptStatus(0);
        int b = MissionInfoMapperImpl.getInfoMapper().getAcceptStatusNumByCsIdAndAccept(csId,1);
        int c = MissionInfoMapperImpl.getInfoMapper().getAcceptStatusNumByCsIdAndAccept(csId,2);
        int d = MissionInfoMapperImpl.getInfoMapper().getAcceptStatusNumByCsIdAndAccept(csId,4);
        jsonMap = new HashMap<>();
        jsonMap.put("authorization",authorization);
        jsonMap.put("a",a);
        jsonMap.put("b",b);
        jsonMap.put("c",c);
        jsonMap.put("d",d);
        renderJson(jsonMap);
    }

    public void missioninfo() throws IOException {
      String method = getRequest().getMethod();
      String authorization = "T000";
      switch (method){
          case "GET" :
              Map<String,String[]> paraMap = getParaMap();
              jsonMap = new HashMap<>();
              if (paraMap.containsKey("mId")){
                int mId = getParaToInt("mId");
                MissionInfo missionInfo = MissionInfoMapperImpl.getInfoMapper().selectByPrimaryKey(mId);
                int ecId = missionInfo.getEcId();
                String companyName = EnterpriseCustomerMapperImpl.getCustomerMapper().getComNameById(ecId);
                jsonMap.put("authorization",authorization);
                jsonMap.put("missionName",missionInfo.getMissionName());
                jsonMap.put("prepay", missionInfo.getPrepay());
                jsonMap.put("endDate", missionInfo.getEndDate().toString());
                jsonMap.put("missionClassify", missionInfo.getMissionClassify());
                jsonMap.put("mainInfo", missionInfo.getMainInfo());
                jsonMap.put("susername",missionInfo.getUsername());
                jsonMap.put("companyName",companyName);
                jsonMap.put("traditionalPlatform","www.callyourmother.com");
                renderJson(jsonMap);
              }else {
               jsonMap = new HashMap<>();
               String queryStatement = getPara("queryStatement");
               List<MissionInfo> missionInfoList
                       = MissionInfoMapperImpl.getInfoMapper().getClassAndClassifyAndInfoByQueryStamLiKe(queryStatement);
               List<Mission> missionList = new ArrayList<>();
                  for (int i = 0;i<missionInfoList.size();i++){
                      MissionInfo missionInfo = missionInfoList.get(i);
                      System.out.println(missionInfo.getEndDate().toString());
                      Mission mission = new Mission();
                      mission.setMissionName(missionInfo.getMissionName());
                      mission.setmId(missionInfo.getmId());
                      mission.setIssueDate(missionInfo.getIssueDate().toString());
                      mission.setEndDate(missionInfo.getEndDate().toString());
                      mission.setAcceptStatus(missionInfo.getAcceptStatus());
                      mission.setPrepay(missionInfo.getPrepay());
                      mission.setNumber(i + 1);
                      missionList.add(mission);
               }
               jsonMap.put("authorization",authorization);
               jsonMap.put("missionList",missionList);
               renderJson(jsonMap);
              }
              break;
          case "POST" :
              int csId = (int) ClaimUtil.getValueByPara(getRequest(),"token","id");
              int mId = getParaToInt("mId");
              MissionInfo missionInfo = MissionInfoMapperImpl.getInfoMapper().selectByPrimaryKey(mId);
              missionInfo.setCsId(csId);
              missionInfo.setAcceptStatus(1);
              setAttr("mId",mId);
              forwardAction("/tr/sitnumber");
              break;
      }
    }

    public void sitnumber() throws IOException {
       int mId = getAttr("mId");
       String username = getAttr("username");
       String password = getAttr("password");
       MissionInfo missionInfo = MissionInfoMapperImpl.getInfoMapper().selectByPrimaryKey(mId);
       String missionName = missionInfo.getMissionName();
       int ecId = missionInfo.getEcId();
       missionInfo.setUsername(username);
       missionInfo.setPassword(password);
       MissionInfoMapperImpl.getInfoMapper().updateByPrimaryKey(missionInfo);
       String messageText = MessageUtil.missionAcceptBySa(missionName);
       Message message = new Message();
       message.setReceiverId(ecId);
       message.setReGroup("ec");
       message.setSender(0);
       message.setMessage(messageText);
       message.setSendDateTime(LocalDateTime.now());
       message.setReadd(0);
       MessageMapperImpl.getMessageMapper().insertSelective(message);
       jsonMap = new HashMap<>();
       jsonMap.put("authorization","T000");
       jsonMap.put("code","M000");
       jsonMap.put("msg","接取任务成功");
       renderJson(jsonMap);
    }

    public void callmission_callresult() throws IOException {
       int mId = getParaToInt("mId");
       List<CallMission> callMissionList = CallMissionMapperImpl.getMissionMapper().getByMid(mId);
       setAttr("callMissionList", callMissionList);
       forwardAction("/tr/callresult");
    }

    public void customerservice() throws IOException {
        int csId = (int) ClaimUtil.getValueByPara(getRequest(),"token","id");
        String method = getRequest().getMethod();
        String authorization = "T000";
        CustomerService customerService = CustomerServiceMapperImpl.getServiceMapper().selectByPrimaryKey(csId);
        switch (method){
            case "POST":
                String password = getPara("password");
                String email = getPara("email");
                long phoneNumber = getParaToLong("phoneNumber");
                String account = getPara("account");
                customerService.setPhoneNumber(phoneNumber);
                customerService.setPassword(password);
                customerService.setEmail(email);
                customerService.setAccount(account);
                CustomerServiceMapperImpl.getServiceMapper().updateByPrimaryKey(customerService);
                renderJson("authorization",authorization);
                break;
            case "GET" :
                int all = getParaToInt("all");
                String username = customerService.getUsername();
                String email2 = customerService.getEmail();
                long phoneNumber2 = customerService.getPhoneNumber();
                String password2 = customerService.getPassword();
                String account2 = customerService.getAccount();
                String name = customerService.getName();
                String IDNumber = customerService.getIdNumber();
                int balance = customerService.getBalance();
                jsonMap = new HashMap<>();
                jsonMap.put("username",username);
                jsonMap.put("email",email2);
                jsonMap.put("phoneNumber",phoneNumber2);
                jsonMap.put("authorization",authorization);
                if (all == 0){
                    renderJson(jsonMap);
                }else {
                    jsonMap.put("password",password2);
                    jsonMap.put("account",account2);
                    jsonMap.put("name",name);
                    jsonMap.put("IDNumber",IDNumber);
                    jsonMap.put("balance",balance);
                    renderJson(jsonMap);
                }
                break;
        }
    }

}
