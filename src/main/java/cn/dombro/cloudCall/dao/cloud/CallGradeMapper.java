package cn.dombro.cloudCall.dao.cloud;

import cn.dombro.cloudCall.entity.CallGrade;
import cn.dombro.cloudCall.entity.CustomerService;


import java.io.IOException;


/**
 * Author Caole
 * CreateDate: 2017/7/16
 * CreateTime: 11:40
 */
public interface CallGradeMapper {

    public CallGrade selectByPrimaryKey(Integer mId) throws IOException;

    public void deleteByPrimaryKey(Integer mId) throws IOException;

    public void insert(CallGrade callGrade) throws IOException;


    public void insertSelective(CallGrade callGrade) throws IOException;


    public void updateByPrimaryKeySelective(Integer mId) throws IOException;

    public void updateByPrimaryKey(Integer mId) throws IOException;
}
