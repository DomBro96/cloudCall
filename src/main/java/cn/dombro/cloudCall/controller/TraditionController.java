package cn.dombro.cloudCall.controller;

import cn.dombro.cloudCall.dao.tradition.Impl.CallResultMapperImpl;
import cn.dombro.cloudCall.entity.CallMission;
import cn.dombro.cloudCall.entity.CallResult;
import cn.dombro.cloudCall.viewobject.MissionDetail;
import com.jfinal.core.Controller;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
       setAttr("missionDetails",missionDetails);
       forwardAction("/ec/missiondetail");
    }
}
