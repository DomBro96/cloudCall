package cn.dombro.cloudCall.entity;

public class CallGrade {
    private Integer mId;

    private Integer csId;

    private Integer pGrade;

    private String pRemark;

    private Integer cGrade;

    private String cRemark;

    private Integer grade;

    public Integer getmId() {
        return mId;
    }

    public void setmId(Integer mId) {
        this.mId = mId;
    }

    public Integer getCsId() {
        return csId;
    }

    public void setCsId(Integer csId) {
        this.csId = csId;
    }

    public Integer getpGrade() {
        return pGrade;
    }

    public void setpGrade(Integer pGrade) {
        this.pGrade = pGrade;
    }

    public String getpRemark() {
        return pRemark;
    }

    public void setpRemark(String pRemark) {
        this.pRemark = pRemark;
    }

    public Integer getcGrade() {
        return cGrade;
    }

    public void setcGrade(Integer cGrade) {
        this.cGrade = cGrade;
    }

    public String getcRemark() {
        return cRemark;
    }

    public void setcRemark(String cRemark) {
        this.cRemark = cRemark;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }
}