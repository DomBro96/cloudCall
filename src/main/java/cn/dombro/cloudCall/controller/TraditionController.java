package cn.dombro.cloudCall.controller;

import cn.dombro.cloudCall.dao.tradition.Impl.CallResultMapperImpl;
import cn.dombro.cloudCall.dao.tradition.Impl.SiteNumberMapperImpl;
import cn.dombro.cloudCall.entity.CallMission;
import cn.dombro.cloudCall.entity.CallResult;
import cn.dombro.cloudCall.entity.SiteNumber;
import cn.dombro.cloudCall.util.GeneratorUtil;
import cn.dombro.cloudCall.util.WebTokenUtil;
import cn.dombro.cloudCall.viewobject.MissionDetail;
import com.jfinal.core.Controller;


import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TraditionController extends Controller{

    public void call_result() throws IOException {
       List<CallMission> callMissionList = getAttr("callMissionList");
       List<MissionDetail> missionDetails = new ArrayList<>();
       for (CallMission callMission:callMissionList){
          long runningId =  callMission.getRunningId();
        CallResult callResult = CallResultMapperImpl.getResultMapper().getRemarkAndResultByRunningId(runningId);
        MissionDetail missionDetail = new MissionDetail(callMission.getName(),callMission.getCallNumber().toString(),
                callResult.getCallResult().toString(),callMission.getCallMission(),callResult.getRemark());
        missionDetails.add(missionDetail);
       }
        String authorization = "T000";
        Map<String,Object> jsonMap = new HashMap<>();
        jsonMap.put("authorization", authorization);
        jsonMap.put("missionDetails",missionDetails);
        renderJson(jsonMap);
    }

    public void callresult() throws IOException {
       String method = getRequest().getMethod();
       switch (method){
           case "POST" :
               long runningId = getParaToLong("runningId");
               int callResult = getParaToInt("callResult");
               String remark = getPara("remark");
               CallResult callResult1 = CallResultMapperImpl.getResultMapper().selectByPrimaryKey(runningId);
               callResult1.setCallResult(callResult);
               callResult1.setRemark(remark);
               CallResultMapperImpl.getResultMapper().updateByPrimaryKey(callResult1);
               renderJson("authorization","T000");
               break;
           case "GET" :
               int mId = getParaToInt("mId");
               List<CallResult> callResultList = CallResultMapperImpl.getResultMapper().getListByMid(mId);
               renderJson("results",callResultList);
       }

    }

    public void session() throws IOException {
      String username = getPara("username");
      String password = getPara("password");
      SiteNumber siteNumber = SiteNumberMapperImpl.getNumberMapper().getListByPswAndUser(username,password);
      if ( siteNumber != null){
          //setAttr("siteNumber",siteNumber);
          renderJson("登陆成功");
      }else {
          //setAttr("message","登录失败");
          renderJson("登陆失败");
      }
    }


    public void sitnumber() throws IOException {
         int mId = getAttr("mId");
         List<Long> runningIdList = getAttr("runningIdList");
         for (Long runningId : runningIdList){
             CallResult callResult = new CallResult();
             callResult.setRunningId(runningId);
             callResult.setmId(mId);
             CallResultMapperImpl.getResultMapper().insert(callResult);
         }
         String username = GeneratorUtil.creatAccount();
         String password = GeneratorUtil.creatPassword();
         SiteNumber siteNumber = new SiteNumber();
         siteNumber.setmId(mId);
         siteNumber.setUsername(username);
         siteNumber.setPassword(password);
         SiteNumberMapperImpl.getNumberMapper().insert(siteNumber);
         setAttr("siteNumber",siteNumber);
         forwardAction("/sa/sitnumber");
    }


}
