package cn.dombro.cloudCall.dao.cloud;

import cn.dombro.cloudCall.entity.CallGrade;


import java.io.IOException;
import java.util.List;


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

    public List<CallGrade> getAll() throws IOException;
}
