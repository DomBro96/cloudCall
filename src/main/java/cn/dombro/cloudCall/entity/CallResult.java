package cn.dombro.cloudCall.entity;

public class CallResult {
    private Long runningId;

    private Integer mId;

    private Integer callResult;

    private String remark;

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

    public Integer getCallResult() {
        return callResult;
    }

    public void setCallResult(Integer callResult) {
        this.callResult = callResult;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}