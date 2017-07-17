package cn.dombro.cloudCall.dao.cloud.impl;

import cn.dombro.cloudCall.dao.cloud.CallGradeMapper;
import cn.dombro.cloudCall.dao.info.CustomerServiceMapper;
import cn.dombro.cloudCall.entity.CallGrade;
import cn.dombro.cloudCall.entity.CustomerService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * Author Caole
 * CreateDate: 2017/7/16
 * CreateTime: 16:12
 */
public class CallGradeMapperImpl implements CallGradeMapper {


    public CallGrade selectByPrimaryKey(Integer mId) {
        return null;
    }

    public void deleteByPrimaryKey(Integer mId) {

    }

    public void insert(CallGrade callGrade) {

    }

    public void insertSelective(CallGrade callGrade) throws IOException {
    }

    public void updateByPrimaryKeySelective(Integer mId) {

    }

    public void updateByPrimaryKey(Integer mId) {

    }
}
