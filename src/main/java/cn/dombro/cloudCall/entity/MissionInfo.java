package cn.dombro.cloudCall.entity;

import java.util.Date;

public class MissionInfo {
    private Integer mId;

    private Integer ecId;

    private String missionName;

    private String missionClassify;

    private Date issueDate;

    private Date endDate;

    private Date finishDate;

    private String mainInfo;

    private Integer prepay;

    private String username;

    private String password;

    private Integer acceptStatus;

    private Integer csId;

    public Integer getmId() {
        return mId;
    }

    public void setmId(Integer mId) {
        this.mId = mId;
    }

    public Integer getEcId() {
        return ecId;
    }

    public void setEcId(Integer ecId) {
        this.ecId = ecId;
    }

    public String getMissionName() {
        return missionName;
    }

    public void setMissionName(String missionName) {
        this.missionName = missionName;
    }

    public String getMissionClassify() {
        return missionClassify;
    }

    public void setMissionClassify(String missionClassify) {
        this.missionClassify = missionClassify;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }

    public String getMainInfo() {
        return mainInfo;
    }

    public void setMainInfo(String mainInfo) {
        this.mainInfo = mainInfo;
    }

    public Integer getPrepay() {
        return prepay;
    }

    public void setPrepay(Integer prepay) {
        this.prepay = prepay;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAcceptStatus() {
        return acceptStatus;
    }

    public void setAcceptStatus(Integer acceptStatus) {
        this.acceptStatus = acceptStatus;
    }

    public Integer getCsId() {
        return csId;
    }

    public void setCsId(Integer csId) {
        this.csId = csId;
    }
}