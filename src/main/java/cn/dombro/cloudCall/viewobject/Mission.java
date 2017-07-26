package cn.dombro.cloudCall.viewobject;

public class Mission {
    private int mId;

    private int number;

    private String missionName;

    private String issueDate;

    private String endDate;

    private Integer prepay;

    private String missionClassify;

    public String getMissionClassify() {
        return missionClassify;
    }

    public void setMissionClassify(String missionClassify) {
        this.missionClassify = missionClassify;
    }

    private Integer acceptStatus;

    public Mission() {
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

    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public void setPrepay(Integer prepay) {
        this.prepay = prepay;
    }

    public void setAcceptStatus(Integer acceptStatus) {
        this.acceptStatus = acceptStatus;
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
        return issueDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public Integer getPrepay() {
        return prepay;
    }

    public Integer getAcceptStatus() {
        return acceptStatus;
    }

    @Override
    public String toString() {
        return "Mission{" +
                "mId=" + mId +
                ", number=" + number +
                ", missionName='" + missionName + '\'' +
                ", issueDate='" + issueDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", prepay=" + prepay +
                ", missionClassify='" + missionClassify + '\'' +
                ", acceptStatus=" + acceptStatus +
                '}';
    }
}
