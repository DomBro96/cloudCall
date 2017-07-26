package cn.dombro.cloudCall.controller;


import cn.dombro.cloudCall.dao.cloud.impl.*;
import cn.dombro.cloudCall.dao.info.Impl.SystemAdministratorMapperImpl;
import cn.dombro.cloudCall.entity.*;
import cn.dombro.cloudCall.interceptor.TokenInterceptor;
import cn.dombro.cloudCall.util.ClaimUtil;
import cn.dombro.cloudCall.util.GeneratorUtil;
import cn.dombro.cloudCall.util.MessageUtil;
import cn.dombro.cloudCall.util.PoiUtil;
import cn.dombro.cloudCall.viewobject.Mission;
import cn.dombro.cloudCall.viewobject.UnMission;
import com.jfinal.aop.Before;
import com.jfinal.aop.Clear;
import com.jfinal.core.Controller;


import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Before(TokenInterceptor.class)
public class SystemAdminController extends Controller {

    private Map<String,Object> jsonMap;

    public void countlist() throws IOException {
        String authorization = "T000";
        int a = MissionInfoMapperImpl.getInfoMapper().getAcceptStatusNumByAcceptStatus(0);
        int b = UnauditMissionInfoMapperImpl.getMissionInfoMapper().getAuditStatusNumByAuditStatus(1);
        int c = MissionInfoMapperImpl.getInfoMapper().getAcceptStatusNumByAcceptStatus(4);
        int d = MissionInfoMapperImpl.getInfoMapper().getAcceptStatusNumByAcceptStatus(1);
        int e = MissionInfoMapperImpl.getInfoMapper().getAcceptStatusNumByAcceptStatus(2);
        jsonMap = new HashMap<>();
        jsonMap.put("authorization", authorization);
        jsonMap.put("a", a);
        jsonMap.put("b", b);
        jsonMap.put("c", c);
        jsonMap.put("d", d);
        jsonMap.put("e", e);
        renderJson(jsonMap);
    }

    public void unauditmissioninfo() throws IOException {
        String method =  getRequest().getMethod();
        String authorization = "T000";
        int saId = (int) ClaimUtil.getValueByPara(getRequest(),"token","id");
        switch (method){
            case "POST" :
                int mId = getParaToInt("mId");
                int pass = getParaToInt("pass");
                UnauditMissionInfo unauditMissionInfo = UnauditMissionInfoMapperImpl.getMissionInfoMapper().selectByPrimaryKey(mId);
                int ecId = unauditMissionInfo.getEcId();
                String missionName = unauditMissionInfo.getMissionName();
                if (pass == 1){
                    MissionInfo missionInfo = new MissionInfo();
                    missionInfo.setmId(unauditMissionInfo.getmId());
                    missionInfo.setEcId(ecId);
                    missionInfo.setMissionName(missionName);
                    missionInfo.setMissionClassify(unauditMissionInfo.getMissionClassify());
                    missionInfo.setIssueDate(unauditMissionInfo.getIssueDate());
                    missionInfo.setEndDate(unauditMissionInfo.getEndDate());
                    missionInfo.setMainInfo(unauditMissionInfo.getMainInfo());
                    missionInfo.setAcceptStatus(0);
                    MissionInfoMapperImpl.getInfoMapper().insert(missionInfo);
                    String excleUrl = unauditMissionInfo.getExcelUrl();
                    PoiUtil.readSheet(new File(excleUrl),0);
                    List<String> cellList = PoiUtil.getCellList();
                    List<Long> runningIdList = new ArrayList<>();
                    for (String cell:cellList){
                        String[] cellArray = cell.split("/");
                        String name = cellArray[1];
                        String callNumber = cellArray[0];
                        String mission  = cellArray[2];
                        long runningId = GeneratorUtil.createRunningId(mId);
                        CallMission callMission = new CallMission();
                        callMission.setRunningId(runningId);
                        callMission.setCallMission(mission);
                        callMission.setCallNumber(Long.parseLong(callNumber));
                        callMission.setmId(mId);
                        callMission.setName(name);
                        runningIdList.add(runningId);
                        CallMissionMapperImpl.getMissionMapper().insert(callMission);
                    }
                    UnauditMissionInfoMapperImpl.getMissionInfoMapper().deleteByPrimaryKey(mId);
                    Message message = new Message();
                    message.setReceiverId(ecId);
                    message.setReGroup("ec");
                    message.setSender(saId);
                    message.setMessage(MessageUtil.passMissionBySa(missionName));
                    message.setSendDateTime(LocalDateTime.now());
                    message.setReadd(0);
                    MessageMapperImpl.getMessageMapper().insertSelective(message);
                    setAttr("runningIdList",runningIdList);
                    setAttr("mId",mId);
                    forwardAction("/tr/sitnumber");
                }else {
                    unauditMissionInfo.setAuditStatus(0);
                    UnauditMissionInfoMapperImpl.getMissionInfoMapper().updateByPrimaryKey(unauditMissionInfo);
                    Message message = new Message();
                    message.setReceiverId(ecId);
                    message.setReGroup("ec");
                    message.setSender(0);
                    message.setMessage(MessageUtil.unPassMissionBySa(missionName));
                    message.setSendDateTime(LocalDateTime.now());
                    message.setReadd(0);
                    MessageMapperImpl.getMessageMapper().insertSelective(message);
                    jsonMap = new HashMap<>();
                    jsonMap.put("authorization",authorization);
                    jsonMap.put("code","A001");
                    renderJson(jsonMap);
                }
                break;
            case "GET" :
                 Map<String,String[]> paraMap = getParaMap();
                  if (paraMap.containsKey("queryStatement")){
                     String queryStatement = getPara("queryStatement");
                     List<UnauditMissionInfo> unauditMissionInfoList =
                             UnauditMissionInfoMapperImpl.getMissionInfoMapper().getListByNameAndClassLike(queryStatement);
                     List<UnMission> unMissionList = new ArrayList<>();
                     for (int i = 0;i<unauditMissionInfoList.size();i++){
                          UnauditMissionInfo unauditMissionInfo1= unauditMissionInfoList.get(i);
                          UnMission unMission = new UnMission();
                          unMission.setNumber(i+1);
                          unMission.setMissionName(unauditMissionInfo1.getMissionName());
                          unMission.setIssueDate(unauditMissionInfo1.getIssueDate());
                          unMission.setMissionClassify(unauditMissionInfo1.getMissionClassify());
                          unMission.setEndDate(unauditMissionInfo1.getEndDate());
                          unMission.setAuditStatus(unauditMissionInfo1.getAuditStatus());
                          unMission.setPrepay(unauditMissionInfo1.getPrepay());
                          unMission.setmId(unauditMissionInfo1.getmId());
                          unMissionList.add(unMission);
                     }
                      jsonMap = new HashMap<>();
                      jsonMap.put("authorization", authorization);
                      jsonMap.put("missionList", unMissionList);
                      renderJson(jsonMap);
                  }else {
                      int mId2 = getParaToInt("mId");
                      UnauditMissionInfo unauditMissionInfo2 = UnauditMissionInfoMapperImpl.getMissionInfoMapper().selectByPrimaryKey(mId2);
                      jsonMap = new HashMap<>();
                      jsonMap.put("authorization",authorization);
                      jsonMap.put("mId", mId2);
                      jsonMap.put("missionName", unauditMissionInfo2.getMissionName());
                      jsonMap.put("prepay", unauditMissionInfo2.getPrepay());
                      jsonMap.put("endDate", unauditMissionInfo2.getEndDate().toString());
                      jsonMap.put("missionClassify", unauditMissionInfo2.getMissionClassify());
                      jsonMap.put("mainInfo", unauditMissionInfo2.getMainInfo());
                      renderJson(jsonMap);
                  }
                break;
        }
    }

    @Clear
    public void sitnumber() throws IOException {
       SiteNumber siteNumber =  getAttr("siteNumber");
       String username = siteNumber.getUsername();
       String password = siteNumber.getPassword();
       int mId = siteNumber.getmId();
       MissionInfo missionInfo = MissionInfoMapperImpl.getInfoMapper().selectByPrimaryKey(mId);
       missionInfo.setUsername(username);
       missionInfo.setPassword(password);
       MissionInfoMapperImpl.getInfoMapper().updateByPrimaryKey(missionInfo);
       jsonMap = new HashMap<>();
       jsonMap.put("authorization", "T000");
       jsonMap.put("code","A000");
       renderJson(jsonMap);
    }

    public void mission() throws IOException {
        String authorization = "T000";
        Map<String,String[]> paraMap = getParaMap();
        if (paraMap.containsKey("queryStatement")){
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
                mission.setMissionClassify(missionInfo.getMissionClassify());
                mission.setAcceptStatus(missionInfo.getAcceptStatus());
                mission.setPrepay(missionInfo.getPrepay());
                mission.setNumber(i + 1);
                missionList.add(mission);
            }
            jsonMap = new HashMap<>();
            jsonMap.put("authorization",authorization);
            jsonMap.put("missionList",missionList);
            renderJson(jsonMap);
        }else {
            int mId = getParaToInt("mId");
            MissionInfo missionInfo = MissionInfoMapperImpl.getInfoMapper().selectByPrimaryKey(mId);
            jsonMap = new HashMap<>();
            jsonMap.put("mId",mId);
            jsonMap.put("authorization",authorization);
            jsonMap.put("missionName",missionInfo.getMissionName());
            jsonMap.put("prepay", missionInfo.getPrepay());
            jsonMap.put("missionClassify", missionInfo.getMissionClassify());
            jsonMap.put("finishDate", missionInfo.getFinishDate().toString());
            jsonMap.put("mainInfo", missionInfo.getMainInfo());
            renderJson(jsonMap);
        }
    }

    public void callgrade() throws IOException {
        int mId = getParaToInt("mId");
        int pGrade = getParaToInt("pGrade");
        String pRemark = getPara("pRemark");
        CallGrade callGrade = CallGradeMapperImpl.getGradeMapper().selectByPrimaryKey(mId);
        callGrade.setpGrade(pGrade);
        callGrade.setpRemark(pRemark);
        callGrade.setGrade((int) (callGrade.getpGrade()*0.4+callGrade.getcGrade()*0.6));
        CallGradeMapperImpl.getGradeMapper().updateByPrimaryKey(callGrade);
        renderJson("authorization", "T000");
    }

    public void callmission_callresult() throws IOException {
        int mId = getParaToInt("mId");
        List<CallMission> callMissionList = CallMissionMapperImpl.getMissionMapper().getByMid(mId);
        setAttr("callMissionList", callMissionList);
        forwardAction("/tr/call_result");
    }

    public void systemadministrator() throws IOException {
        String method = getRequest().getMethod();
        int saId = (int) ClaimUtil.getValueByPara(getRequest(),"token","id");
        SystemAdministrator administrator = SystemAdministratorMapperImpl.getAdministratorMapper().selectByPrimaryKey(saId);
        String authorization = "T000";
        jsonMap = new HashMap<>();
        switch (method){
            case "POST" :
             String password = getPara("password");
             String phoneNumber = getPara("phoneNumber");
             administrator.setPassword(password);
             administrator.setPhoneNumber(Long.parseLong(phoneNumber));
             SystemAdministratorMapperImpl.getAdministratorMapper().updateByPrimaryKey(administrator);
             renderJson("authorization",authorization);
                break;
            case "GET"  :
             int all = getParaToInt("all");
             jsonMap.put("username",administrator.getPhoneNumber());
             jsonMap.put("saId",administrator.getSaId());
             jsonMap.put("phoneNumber",administrator.getPhoneNumber());
             jsonMap.put("authorization",authorization);
             if (all == 0){
                 renderJson(jsonMap);
             }else {
                 jsonMap.put("password",administrator.getPassword());
                 renderJson(jsonMap);
             }
                break;
        }
    }

 }
