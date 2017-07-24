package cn.dombro.cloudCall.controller;

import cn.dombro.cloudCall.dao.cloud.impl.MessageMapperImpl;
import cn.dombro.cloudCall.dao.cloud.impl.MissionInfoMapperImpl;
import cn.dombro.cloudCall.dao.cloud.impl.UnauditMissionInfoMapperImpl;
import cn.dombro.cloudCall.dao.info.Impl.EnterpriseCustomerMapperImpl;
import cn.dombro.cloudCall.dao.info.Impl.SystemAdministratorMapperImpl;
import cn.dombro.cloudCall.entity.Message;
import cn.dombro.cloudCall.entity.MissionInfo;
import cn.dombro.cloudCall.entity.SystemAdministrator;
import cn.dombro.cloudCall.entity.UnauditMissionInfo;
import cn.dombro.cloudCall.util.ClaimUtil;
import cn.dombro.cloudCall.util.FileUtil;
import cn.dombro.cloudCall.util.MessageUtil;
import cn.dombro.cloudCall.viewobject.Mission;
import cn.dombro.cloudCall.viewobject.UnMission;
import com.jfinal.core.Controller;
import com.jfinal.upload.UploadFile;

import java.io.IOException;
import java.io.File;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EnterpriseCustomerController extends Controller {

    private Map<String,Object> jsonMap = null;

    public void unauditmissioninfo() throws IOException {
        String authorization = "T001";
        String code = "N001";
        String msg = "发布失败";
        String method = getRequest().getMethod();
        Map<String, String[]> paraMap =getParaMap();
        switch (method){
            case "GET" :
                // 删除待审核
                if(paraMap.containsKey("delete")){
                    //获取前台传递过来的 mid 数组
                    String[] mIds =  getRequest().getParameterValues("mId");
                    for (String id:mIds){
                        int mId = Integer.parseInt(id);
                        UnauditMissionInfoMapperImpl.getMissionInfoMapper().deleteByPrimaryKey(mId);
                    }
                    authorization = "T000";
                    jsonMap = new HashMap<>();
                    jsonMap.put("authorization",authorization);
                    renderJson(jsonMap);
                // 获取需求详情
                }if (paraMap.size() == 2 && paraMap.containsKey("mId")){
                     int mId = getParaToInt("mId");
                     UnauditMissionInfo unauditMissionInfo = UnauditMissionInfoMapperImpl.getMissionInfoMapper().selectByPrimaryKey(mId);
                     authorization = "T000";
                     jsonMap = new HashMap<>();
                     jsonMap.put("authorization",authorization);
                     jsonMap.put("mId",mId);
                     jsonMap.put("missionName",unauditMissionInfo.getMissionName());
                     jsonMap.put("prepay",unauditMissionInfo.getPrepay());
                     jsonMap.put("endDate",unauditMissionInfo.getEndDate().toString());
                     jsonMap.put("missionClassify",unauditMissionInfo.getMissionClassify());
                     jsonMap.put("mainInfo",unauditMissionInfo.getMainInfo());
                     renderJson(jsonMap);
                //获取需求列表
                }else if(!paraMap.containsKey("delete")){
                     int ecId = (int) ClaimUtil.getValueByPara(getRequest(),"token","id");
                     List<UnauditMissionInfo> unauditMissionInfoList = UnauditMissionInfoMapperImpl.getMissionInfoMapper().getListByEcId(ecId);
                     List<UnMission> unMissionList = new ArrayList<>();
                     for (int i = 0;i<unauditMissionInfoList.size();i++){
                         UnauditMissionInfo unauditMissionInfo = unauditMissionInfoList.get(i);
                         UnMission unMission = new UnMission();
                         unMission.setmId(unauditMissionInfo.getmId());
                         unMission.setMissionName(unauditMissionInfo.getMissionName());
                         unMission.setIssueDate(unauditMissionInfo.getIssueDate());
                         unMission.setEndDate(unauditMissionInfo.getEndDate());
                         unMission.setAuditStatus(unauditMissionInfo.getAuditStatus());
                         unMission.setPrepay(unauditMissionInfo.getPrepay());
                         unMission.setNumber(i+1);
                         unMissionList.add(unMission);
                     }
                     jsonMap = new HashMap<>();
                     authorization = "T000";
                     jsonMap.put("authorization",authorization);
                     jsonMap.put("unMissionList", unMissionList);
                     renderJson(jsonMap);
                }
                break;
            case "POST" :
              UploadFile uploadFile = getFile("excleFile");
              String uploadName =  uploadFile.getFileName();
              String extension = uploadName.substring(uploadName.lastIndexOf("."));
              if (!".xlsx".equals(extension)){
                  jsonMap = new HashMap<>();
                  jsonMap.put("authorization",authorization);
                  jsonMap.put("msg",msg);
                  jsonMap.put("code",code);
                  renderJson(jsonMap);
              }

              int ecId = (int) ClaimUtil.getValueByPara(getRequest(),"token","id");
              String companyName = EnterpriseCustomerMapperImpl.getCustomerMapper().getComNameById(ecId);
              String missionName = getPara("missionName");
              LocalDate today = LocalDate.now();
              String fileName = companyName+"-"+missionName+"-"+today.toString();
              FileUtil.upload(uploadFile.getFile(),fileName);
              String excleUrl = FileUtil.getFilePath();
              int prapay = getParaToInt("prapay");
              LocalDate endDate = LocalDate.parse(getPara("endDate"));
              String missionClassify = getPara("missionClassify");
              String mainInfo = getPara("mainInfo");
              UnauditMissionInfo unauditMissionInfo = new UnauditMissionInfo();
              unauditMissionInfo.setEcId(ecId);
              unauditMissionInfo.setIssueDate(today);
              unauditMissionInfo.setEndDate(endDate);
              unauditMissionInfo.setPrepay(prapay);
              unauditMissionInfo.setMissionClassify(missionClassify);
              unauditMissionInfo.setMainInfo(mainInfo);
              unauditMissionInfo.setExcelUrl(excleUrl);
              UnauditMissionInfoMapperImpl.getMissionInfoMapper().insertSelective(unauditMissionInfo);
              List<SystemAdministrator> administratorList = SystemAdministratorMapperImpl.getAdministratorMapper().getAll();
              //向 message 表中插入
              for (SystemAdministrator administrator:administratorList){
                  int saId  = administrator.getSaId();
                  Message message = new Message();
                  message.setReceiverId(saId);
                  message.setReGroup("sa");
                  message.setSender(ecId);
                  message.setMessage(MessageUtil.toSaForMission(companyName));
                  message.setSendDateTime(LocalDateTime.now().withNano(0));
                  message.setReadd(0);
                  MessageMapperImpl.getMessageMapper().insertSelective(message);
              }
              File file = uploadFile.getFile();
              file.delete();
              code = "N000";
              msg = "发布成功";
              authorization = "T000";
              jsonMap = new HashMap<>();
              jsonMap.put("authorization",authorization);
              jsonMap.put("msg",msg);
              jsonMap.put("code",code);
              renderJson(jsonMap);
              break;
        }
    }

    public void missioninfo() throws IOException {
        String authorization = "T000";
        Map<String,String[]> paraMap = getParaMap();
        int ecId = (int) ClaimUtil.getValueByPara(getRequest(),"token","id");
        if (paraMap.containsKey("delete")){
            String[] mIds =  getRequest().getParameterValues("mId");
            for (String mId:mIds){

            }
        }else if (paraMap.containsKey("done")){
              int done = getParaToInt("done");
              List<MissionInfo> missionInfoList = MissionInfoMapperImpl.getInfoMapper().getListByEcIdAndAccept(ecId,done);
              List<Mission> missionList = new ArrayList<>();
              for (int i = 0;i<missionInfoList.size();i++){
                  MissionInfo missionInfo = missionInfoList.get(i);
                  Mission  mission = new Mission();
                  mission.setmId(missionInfo.getmId());
                  mission.setMissionName(missionInfo.getMissionName());
                  mission.setIssueDate(missionInfo.getIssueDate());
                  mission.setEndDate(missionInfo.getEndDate());
                  mission.setAcceptStatus(missionInfo.getAcceptStatus());
                  mission.setPrepay(missionInfo.getPrepay());
                  mission.setNumber(i+1);
                  missionList.add(mission);
              }
              jsonMap = new HashMap<>();

              jsonMap.put("authorization",authorization);
              jsonMap.put("missionList",missionInfoList);
              renderJson(jsonMap);

        }else {

        }

    }



}
