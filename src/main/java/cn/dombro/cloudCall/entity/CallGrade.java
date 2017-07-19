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

    public CallGrade() {
    }

    @Override
    public String toString() {
        return "CallGrade{" +
                "mId=" + mId +
                ", csId=" + csId +
                ", pGrade=" + pGrade +
                ", pRemark='" + pRemark + '\'' +
                ", cGrade=" + cGrade +
                ", cRemark='" + cRemark + '\'' +
                ", grade=" + grade +
                '}';
    }


    public CallGrade(Integer mId, Integer csId, Integer pGrade, String pRemark, Integer cGrade, String cRemark, Integer grade) {
        this.mId = mId;
        this.csId = csId;
        this.pGrade = pGrade;
        this.pRemark = pRemark;
        this.cGrade = cGrade;
        this.cRemark = cRemark;
        this.grade = grade;
    }
}