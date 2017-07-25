package cn.dombro.cloudCall.viewobject;

import java.time.LocalDate;


public class UnMission {

    private int mId;

    private int number;

    private String missionName;

    private LocalDate issueDate;

    private LocalDate endDate;

    private Integer prepay;

    private Integer auditStatus;

    public UnMission() {
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setMissionName(String missionName) {
        this.missionName = missionName;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public void setPrepay(Integer prepay) {
        this.prepay = prepay;
    }

    public void setAuditStatus(Integer auditStatus) {
        this.auditStatus = auditStatus;
    }

    public int getmId() {
        return mId;
    }

    public int getNumber() {
        return number;
    }

    public String getMissionName() {
        return missionName;
    }

    public String getIssueDate() {
        return issueDate.toString();
    }

    public String getEndDate() {
        return endDate.toString();
    }

    public Integer getPrepay() {
        return prepay;
    }

    public Integer getAuditStatus() {
        return auditStatus;
    }


}
