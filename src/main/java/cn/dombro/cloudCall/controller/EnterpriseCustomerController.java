package cn.dombro.cloudCall.controller;

import cn.dombro.cloudCall.dao.cloud.impl.*;
import cn.dombro.cloudCall.dao.info.Impl.EnterpriseCustomerMapperImpl;
import cn.dombro.cloudCall.dao.info.Impl.SystemAdministratorMapperImpl;
import cn.dombro.cloudCall.entity.*;
import cn.dombro.cloudCall.interceptor.TokenInterceptor;
import cn.dombro.cloudCall.util.ClaimUtil;
import cn.dombro.cloudCall.util.FileUtil;
import cn.dombro.cloudCall.util.MessageUtil;
import cn.dombro.cloudCall.util.WebTokenUtil;
import cn.dombro.cloudCall.viewobject.Mission;
import cn.dombro.cloudCall.viewobject.UnMission;
import com.jfinal.aop.Before;
import com.jfinal.aop.Clear;
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

@Before(TokenInterceptor.class)
public class EnterpriseCustomerController extends Controller {

    private Map<String, Object> jsonMap = null;

    @Clear
    public void unauditmissioninfo() throws IOException {
        String authorization = "T001";
        String code = "N001";
        String msg = "发布失败";
        String method = getRequest().getMethod();
        Map<String, String[]> paraMap = getParaMap();
        switch (method) {
            case "GET":
                String token = getPara("token");
                if (!WebTokenUtil.getTokenList().contains(token)){
                    renderJson("authorization",authorization);
                    break;
                }
                // 删除待审核
                if (paraMap.containsKey("delete")) {
                    //获取前台传递过来的 mid 数组
                    String[] mIds = getRequest().getParameterValues("mId");
                    for (String id : mIds) {
                        int mId = Integer.parseInt(id);
                        UnauditMissionInfoMapperImpl.getMissionInfoMapper().deleteByPrimaryKey(mId);
                    }
                    authorization = "T000";
                    jsonMap = new HashMap<>();
                    jsonMap.put("authorization", authorization);
                    renderJson(jsonMap);
                    // 获取需求详情
                }
                if (paraMap.size() == 2 && paraMap.containsKey("mId")) {
                    int mId = getParaToInt("mId");
                    UnauditMissionInfo unauditMissionInfo = UnauditMissionInfoMapperImpl.getMissionInfoMapper().selectByPrimaryKey(mId);
                    authorization = "T000";
                    jsonMap = new HashMap<>();
                    jsonMap.put("authorization", authorization);
                    jsonMap.put("mId", mId);
                    jsonMap.put("missionName", unauditMissionInfo.getMissionName());
                    jsonMap.put("prepay", unauditMissionInfo.getPrepay());
                    jsonMap.put("endDate", unauditMissionInfo.getEndDate().toString());
                    jsonMap.put("missionClassify", unauditMissionInfo.getMissionClassify());
                    jsonMap.put("mainInfo", unauditMissionInfo.getMainInfo());
                    renderJson(jsonMap);
                    //获取需求列表
                } else if (!paraMap.containsKey("delete")) {
                    int ecId = (int) ClaimUtil.getValueByPara(getRequest(), "token", "id");
                    List<UnauditMissionInfo> unauditMissionInfoList = UnauditMissionInfoMapperImpl.getMissionInfoMapper().getListByEcId(ecId);
                    List<UnMission> unMissionList = new ArrayList<>();
                    for (int i = 0; i < unauditMissionInfoList.size(); i++) {
                        UnauditMissionInfo unauditMissionInfo = unauditMissionInfoList.get(i);
                        UnMission unMission = new UnMission();
                        unMission.setmId(unauditMissionInfo.getmId());
                        unMission.setMissionName(unauditMissionInfo.getMissionName());
                        unMission.setIssueDate(unauditMissionInfo.getIssueDate());
                        unMission.setMissionClassify(unauditMissionInfo.getMissionClassify());
                        unMission.setEndDate(unauditMissionInfo.getEndDate());
                        unMission.setAuditStatus(unauditMissionInfo.getAuditStatus());
                        unMission.setPrepay(unauditMissionInfo.getPrepay());
                        unMission.setNumber(i + 1);
                        unMissionList.add(unMission);
                    }
                    jsonMap = new HashMap<>();
                    authorization = "T000";
                    jsonMap.put("authorization", authorization);
                    jsonMap.put("missionList", unMissionList);
                    renderJson(jsonMap);
                }
                break;
            case "POST":
                UploadFile uploadFile = getFile("excelFile");
                File sourcefile = uploadFile.getFile();
                String uploadName = sourcefile.getName();
                String token1 = getPara("token");
                System.out.println(token1);
                if (!WebTokenUtil.getTokenList().contains(token1)){
                    System.out.println(WebTokenUtil.getTokenList());
                    renderJson("authorization",authorization);
                    break;
                }
                String extension = uploadName.substring(uploadName.lastIndexOf("."));
                if (!".xlsx".equals(extension)) {
                    jsonMap = new HashMap<>();
                    jsonMap.put("authorization", authorization);
                    jsonMap.put("msg", msg);
                    jsonMap.put("code", code);
                    renderJson(jsonMap);
                }

                int ecId = (int) ClaimUtil.getValueByPara(getRequest(), "token", "id");
                String companyName = EnterpriseCustomerMapperImpl.getCustomerMapper().getComNameById(ecId);
                String missionName = getPara("missionName");
                LocalDate today = LocalDate.now();
                String fileName = companyName + "-" + missionName + "-" + today.toString();
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
                unauditMissionInfo.setAuditStatus(1);
                unauditMissionInfo.setMissionClassify(missionClassify);
                unauditMissionInfo.setMainInfo(mainInfo);
                unauditMissionInfo.setExcelUrl(excleUrl);
                UnauditMissionInfoMapperImpl.getMissionInfoMapper().insertSelective(unauditMissionInfo);
                List<SystemAdministrator> administratorList = SystemAdministratorMapperImpl.getAdministratorMapper().getAll();

                //向 message 表中插入
                for (SystemAdministrator administrator : administratorList) {
                    int saId = administrator.getSaId();
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
                jsonMap.put("authorization", authorization);
                jsonMap.put("msg", msg);
                jsonMap.put("code", code);
                renderJson(jsonMap);
                break;
        }
    }

    public void missioninfo() throws IOException {
        String authorization = "T000";
        Map<String, String[]> paraMap = getParaMap();
        int ecId = (int) ClaimUtil.getValueByPara(getRequest(), "token", "id");
        if (paraMap.containsKey("delete")) {
            String[] mIds = getRequest().getParameterValues("mId");
            for (String mId : mIds) {
                int deleteId = Integer.parseInt(mId);
                MissionInfoMapperImpl.getInfoMapper().deleteByMidAndAccept(deleteId);
            }
            jsonMap = new HashMap<>();
            jsonMap.put("authorization", authorization);
            renderJson(jsonMap);
        } else if (paraMap.containsKey("done")) {
            List<MissionInfo> missionInfoList = null;
            List<Mission> missionList = new ArrayList<>();
            int done = getParaToInt("done");

            switch (done) {
                case 1:
                    missionInfoList = MissionInfoMapperImpl.getInfoMapper().getListByEcIdAndAccept(ecId, 2);
                    break;

                case 0:
                    missionInfoList = MissionInfoMapperImpl.getInfoMapper().getListByEcId(ecId);
                    break;
            }

            for (int i = 0; i < missionInfoList.size(); i++) {
                MissionInfo missionInfo = missionInfoList.get(i);
                System.out.println(missionInfo.getEndDate().toString());
                Mission mission = new Mission();
                mission.setmId(missionInfo.getmId());
                mission.setMissionName(missionInfo.getMissionName());
                mission.setIssueDate(missionInfo.getIssueDate().toString());
                mission.setEndDate(missionInfo.getEndDate().toString());
                mission.setAcceptStatus(missionInfo.getAcceptStatus());
                mission.setMissionClassify(missionInfo.getMissionClassify());
                mission.setPrepay(missionInfo.getPrepay());
                mission.setNumber(i + 1);
                missionList.add(mission);
            }
            jsonMap = new HashMap<>();
            jsonMap.put("authorization", authorization);
            jsonMap.put("missionList", missionList);
            renderJson(jsonMap);

        } else {
            int mId = getParaToInt("mId");
            MissionInfo missionInfo = MissionInfoMapperImpl.getInfoMapper().selectByPrimaryKey(mId);
            jsonMap = new HashMap<>();
            jsonMap.put("authorization", authorization);
            jsonMap.put("mId", mId);
            jsonMap.put("missionName", missionInfo.getMissionName());
            jsonMap.put("prepay", missionInfo.getPrepay());
            jsonMap.put("finishDate", missionInfo.getFinishDate().toString());
            jsonMap.put("missionClassify", missionInfo.getMissionClassify());
            jsonMap.put("mainInfo", missionInfo.getMainInfo());
            renderJson(jsonMap);
        }

    }

    public void callgrade() throws IOException {
        int mId = getParaToInt("mId");
        int cGrade = getParaToInt("cGrade");
        String cRemark = getPara("cRemark");
        CallGrade callGrade = CallGradeMapperImpl.getGradeMapper().selectByPrimaryKey(mId);
        callGrade.setcGrade(cGrade);
        callGrade.setcRemark(cRemark);
        CallGradeMapperImpl.getGradeMapper().updateByPrimaryKey(callGrade);
        renderJson("authorization", "T000");

    }

    public void calllist() throws IOException {
        String authorization = "T000";
        int ecId = (int) ClaimUtil.getValueByPara(getRequest(), "token", "id");
        int b = UnauditMissionInfoMapperImpl.getMissionInfoMapper().getAuditStatusNumByEcId(ecId);
        int a = MissionInfoMapperImpl.getInfoMapper().getAcceptStatusNumByEcIdAndAccept(ecId,0);
        int c = MissionInfoMapperImpl.getInfoMapper().getAcceptStatusNumByEcIdAndAccept(ecId,4);
        int d = MissionInfoMapperImpl.getInfoMapper().getAcceptStatusNumByEcIdAndAccept(ecId,1);
        int e = MissionInfoMapperImpl.getInfoMapper().getAcceptStatusNumByEcIdAndAccept(ecId,2);
        jsonMap = new HashMap<>();
        jsonMap.put("authorization", authorization);
        jsonMap.put("a", a);
        jsonMap.put("b", b);
        jsonMap.put("c", c);
        jsonMap.put("d", d);
        jsonMap.put("e", e);
        renderJson(jsonMap);
    }

    public void enterprisecustomer() throws IOException {
        int ecId = (int) ClaimUtil.getValueByPara(getRequest(), "token", "id");
        String method = getRequest().getMethod();
        String authorization = "T000";
        EnterpriseCustomer enterpriseCustomer = EnterpriseCustomerMapperImpl.getCustomerMapper().selectByPrimaryKey(ecId);
        switch (method) {
            case "POST":
                String password = getPara("password");
                String email = getPara("email");
                String phoneNumber = getPara("phoneNumber");
                String account = getPara("account");
                enterpriseCustomer.setPassword(password);
                enterpriseCustomer.setPhoneNumber(Long.parseLong(phoneNumber));
                enterpriseCustomer.setEmail(email);
                enterpriseCustomer.setAccount(account);
                EnterpriseCustomerMapperImpl.getCustomerMapper().updateByPrimaryKey(enterpriseCustomer);
                renderJson("authorization", authorization);
                break;

            case "GET":
                int all = getParaToInt("all");
                String username = enterpriseCustomer.getUsername();
                String companyName = enterpriseCustomer.getCompanyName();
                long phoneNumber1 = enterpriseCustomer.getPhoneNumber();
                String account1 = enterpriseCustomer.getAccount();
                String password1 = enterpriseCustomer.getPassword();
                String email1 = enterpriseCustomer.getEmail();
                String license = enterpriseCustomer.getLicense();
                jsonMap = new HashMap<>();
                jsonMap.put("authorization", authorization);
                jsonMap.put("username", username);
                jsonMap.put("companyName", companyName);
                jsonMap.put("phoneNumber", phoneNumber1);
                jsonMap.put("account", account1);
                if (all == 0) {
                    renderJson(jsonMap);
                } else {
                    jsonMap.put("password", password1);
                    jsonMap.put("email", email1);
                    jsonMap.put("license", license);
                    renderJson(jsonMap);
                }
                break;
        }
    }

    public void callmission_callresult() throws IOException {
        int mId = getParaToInt("mId");
        List<CallMission> callMissionList = CallMissionMapperImpl.getMissionMapper().getByMid(mId);
        setAttr("callMissionList", callMissionList);
        forwardAction("/tr/call_result");
    }

}

