package cn.dombro.cloudCall.entity;

public class CallMission {
    private Long runningId;

    private Integer mId;

    private Long callNumber;

    private String name;

    private String callMission;

    public Long getRunningId() {
        return runningId;
    }

    public void setRunningId(Long runningId) {
        this.runningId = runningId;
    }

    public Integer getmId() {
        return mId;
    }

    public void setmId(Integer mId) {
        this.mId = mId;
    }

    public Long getCallNumber() {
        return callNumber;
    }

    public void setCallNumber(Long callNumber) {
        this.callNumber = callNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCallMission() {
        return callMission;
    }

    public void setCallMission(String callMission) {
        this.callMission = callMission;
    }

    @Override
    public String toString() {
        return "CallMission{" +
                "runningId=" + runningId +
                ", mId=" + mId +
                ", callNumber=" + callNumber +
                ", name='" + name + '\'' +
                ", callMission='" + callMission + '\'' +
                '}';
    }
}