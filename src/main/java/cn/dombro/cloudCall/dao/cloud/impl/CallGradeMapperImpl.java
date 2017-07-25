package cn.dombro.cloudCall.dao.cloud.impl;

import cn.dombro.cloudCall.dao.cloud.CallGradeMapper;
import cn.dombro.cloudCall.entity.CallGrade;
import cn.dombro.cloudCall.utils.MySqlSessionFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

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

    public void updateByPrimaryKeySelective(CallGrade callGrade) throws IOException {
        SqlSessionFactory sqlSessionFactory = MySqlSessionFactory.getSqlSessionFactory();
        SqlSession session = sqlSessionFactory.openSession();
        try {
            CallGradeMapper mapper = session.getMapper(CallGradeMapper.class);
            mapper.updateByPrimaryKeySelective(callGrade);
            session.commit();
        } finally {
            session.close();
        }
    }

    public void updateByPrimaryKey(CallGrade callGrade) throws IOException {
        SqlSessionFactory sqlSessionFactory = MySqlSessionFactory.getSqlSessionFactory();
        SqlSession session = sqlSessionFactory.openSession();
        try {
            CallGradeMapper mapper = session.getMapper(CallGradeMapper.class);
            mapper.updateByPrimaryKey(callGrade);
            session.commit();
        } finally {
            session.close();
        }
    }

    @Override
    public List<CallGrade> getAll() throws IOException {
        SqlSessionFactory sqlSessionFactory = MySqlSessionFactory.getSqlSessionFactory();
        SqlSession session = sqlSessionFactory.openSession();
        try {
            return session.selectList("cn.dombro.cloudCall.dao.cloud.CallGradeMapper.getAll");
        } finally {
            session.close();
        }
    }

}
