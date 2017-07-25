package cn.dombro.cloudCall.controller;

import cn.dombro.cloudCall.dao.tradition.Impl.CallResultMapperImpl;
import cn.dombro.cloudCall.dao.tradition.Impl.SiteNumberMapperImpl;
import cn.dombro.cloudCall.entity.CallMission;
import cn.dombro.cloudCall.entity.CallResult;
import cn.dombro.cloudCall.entity.SiteNumber;
import cn.dombro.cloudCall.viewobject.MissionDetail;
import com.jfinal.core.Controller;


import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TraditionController extends Controller{

    public void callresult() throws IOException {
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

    public void sitnumber() throws IOException {
       int mId = getAttr("mId");
       SiteNumber siteNumber = SiteNumberMapperImpl.getNumberMapper().selectByPrimaryKey(mId);
       String username = siteNumber.getUsername();
       String password = siteNumber.getPassword();
       setAttr("mId",mId);
       setAttr("username",username);
       setAttr("password",password);
       forwardAction("/cs/sitnumber");
    }
}
