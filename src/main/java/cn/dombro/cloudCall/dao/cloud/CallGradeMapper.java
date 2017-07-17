package cn.dombro.cloudCall.dao.cloud;

import cn.dombro.cloudCall.entity.CallGrade;
import cn.dombro.cloudCall.entity.CustomerService;

/**
 * Author Caole
 * CreateDate: 2017/7/16
 * CreateTime: 11:40
 */
public interface CallGradeMapper {

    public CallGrade selectByPrimaryKey(Integer mId);

    public void deleteByPrimaryKey(Integer mId);

    public void insert(CallGrade callGrade);

    public void insertSelective(CallGrade callGrade);

    public void updateByPrimaryKeySelective(Integer mId);

    public void updateByPrimaryKey(Integer mId);
}
