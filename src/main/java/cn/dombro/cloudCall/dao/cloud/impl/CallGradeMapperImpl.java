package cn.dombro.cloudCall.dao.cloud.impl;

import cn.dombro.cloudCall.dao.cloud.CallGradeMapper;
import cn.dombro.cloudCall.dao.info.CustomerServiceMapper;
import cn.dombro.cloudCall.entity.CallGrade;
import cn.dombro.cloudCall.entity.CustomerService;
import cn.dombro.cloudCall.utils.MySqlSessionFactory;
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

    private static CallGradeMapper gradeMapper = null;
    public static CallGradeMapper getGradeMapper(){
        gradeMapper = new CallGradeMapperImpl();
        return gradeMapper;
    }

    public CallGrade selectByPrimaryKey(Integer mId) throws IOException {
        SqlSessionFactory sqlSessionFactory = MySqlSessionFactory.getSqlSessionFactory();
        SqlSession session = sqlSessionFactory.openSession();
        try {
            CallGradeMapper mapper = session.getMapper(CallGradeMapper.class);
            return mapper.selectByPrimaryKey(mId);
        } finally {
            session.close();
        }
    }

    public void deleteByPrimaryKey(Integer mId) throws IOException {
        SqlSessionFactory sqlSessionFactory = MySqlSessionFactory.getSqlSessionFactory();
        SqlSession session = sqlSessionFactory.openSession();
        try {
            CallGradeMapper mapper = session.getMapper(CallGradeMapper.class);
            mapper.deleteByPrimaryKey(mId);
            session.commit();
        } finally {
            session.close();
        }
    }

    public void insert(CallGrade callGrade) throws IOException {
        SqlSessionFactory sqlSessionFactory = MySqlSessionFactory.getSqlSessionFactory();
        SqlSession session = sqlSessionFactory.openSession();
        try {
            CallGradeMapper mapper = session.getMapper(CallGradeMapper.class);
            mapper.insert(callGrade);
            session.commit();
        } finally {
            session.close();
        }
    }

    public void insertSelective(CallGrade callGrade) throws IOException {
        SqlSessionFactory sqlSessionFactory = MySqlSessionFactory.getSqlSessionFactory();
        SqlSession session = sqlSessionFactory.openSession();
        try {
            CallGradeMapper mapper = session.getMapper(CallGradeMapper.class);
            mapper.insertSelective(callGrade);
            session.commit();
        } finally {
            session.close();
        }
    }

    public void updateByPrimaryKeySelective(Integer mId) throws IOException {
        SqlSessionFactory sqlSessionFactory = MySqlSessionFactory.getSqlSessionFactory();
        SqlSession session = sqlSessionFactory.openSession();
        try {
            CallGradeMapper mapper = session.getMapper(CallGradeMapper.class);
            mapper.updateByPrimaryKeySelective(mId);
            session.commit();
        } finally {
            session.close();
        }
    }

    public void updateByPrimaryKey(Integer mId) throws IOException {
        SqlSessionFactory sqlSessionFactory = MySqlSessionFactory.getSqlSessionFactory();
        SqlSession session = sqlSessionFactory.openSession();
        try {
            CallGradeMapper mapper = session.getMapper(CallGradeMapper.class);
            mapper.updateByPrimaryKey(mId);
            session.commit();
        } finally {
            session.close();
        }
    }
}
