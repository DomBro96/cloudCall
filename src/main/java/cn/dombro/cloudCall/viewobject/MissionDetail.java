package cn.dombro.cloudCall.viewobject;

public class MissionDetail {

    String name;

    String phoneNumber;

    String callResult;

    String callmission;

    String remark;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCallResult() {
        return callResult;
    }

    public void setCallResult(String callResult) {
        this.callResult = callResult;
    }

    public String getCallmission() {
        return callmission;
    }

    public void setCallmission(String callmission) {
        this.callmission = callmission;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public MissionDetail(String name, String phoneNumber, String callResult, String callmission, String remark) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.callResult = callResult;
        this.callmission = callmission;
        this.remark = remark;
    }
}
