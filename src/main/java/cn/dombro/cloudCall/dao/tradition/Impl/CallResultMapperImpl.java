package cn.dombro.cloudCall.dao.tradition.Impl;

import cn.dombro.cloudCall.dao.cloud.CallMissionMapper;
import cn.dombro.cloudCall.dao.cloud.impl.CallMissionMapperImpl;
import cn.dombro.cloudCall.dao.tradition.CallResultMapper;
import cn.dombro.cloudCall.entity.CallResult;
import cn.dombro.cloudCall.utils.MySqlSessionFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.io.IOException;
import java.util.List;

/**
 * Author Caole
 * CreateDate: 2017/7/17
 * CreateTime: 12:36
 */
public class CallResultMapperImpl implements CallResultMapper{

    private static CallResultMapper resultMapper = null;
    public static CallResultMapper getResultMapper(){
        resultMapper = new CallResultMapperImpl();
        return resultMapper;
    }

    @Override
    public CallResult selectByPrimaryKey(Long runningId) throws IOException {
        SqlSessionFactory sqlSessionFactory = MySqlSessionFactory.getSqlSessionFactory();
        SqlSession session = sqlSessionFactory.openSession();
        try {
            CallResultMapper mapper = session.getMapper(CallResultMapper.class);
            return mapper.selectByPrimaryKey(runningId);
        }finally {
            session.close();
        }
    }

    @Override
    public void deleteByPrimaryKey(Long runningId) throws IOException {
        SqlSessionFactory sqlSessionFactory = MySqlSessionFactory.getSqlSessionFactory();
        SqlSession session = sqlSessionFactory.openSession();
        try {
            CallResultMapper mapper = session.getMapper(CallResultMapper.class);
            mapper.deleteByPrimaryKey(runningId);
            session.commit();
        }finally {
            session.close();
        }
    }

    @Override
    public void insert(CallResult callResult) throws IOException {
        SqlSessionFactory sqlSessionFactory = MySqlSessionFactory.getSqlSessionFactory();
        SqlSession session = sqlSessionFactory.openSession();
        try {
            CallResultMapper mapper = session.getMapper(CallResultMapper.class);
            mapper.insert(callResult);
            session.commit();
        }finally {
            session.close();
        }
    }

    @Override
    public void insertSelective(CallResult callResult) throws IOException {
        SqlSessionFactory sqlSessionFactory = MySqlSessionFactory.getSqlSessionFactory();
        SqlSession session = sqlSessionFactory.openSession();
        try {
            CallResultMapper mapper = session.getMapper(CallResultMapper.class);
            mapper.insertSelective(callResult);
            session.commit();
        }finally {
            session.close();
        }
    }

    @Override
    public void updateByPrimaryKeySelective(CallResult callResult) throws IOException {
        SqlSessionFactory sqlSessionFactory = MySqlSessionFactory.getSqlSessionFactory();
        SqlSession session = sqlSessionFactory.openSession();
        try {
            CallResultMapper mapper = session.getMapper(CallResultMapper.class);
            mapper.updateByPrimaryKeySelective(callResult);
            session.commit();
        }finally {
            session.close();
        }
    }

    @Override
    public void updateByPrimaryKey(CallResult callResult) throws IOException {
        SqlSessionFactory sqlSessionFactory = MySqlSessionFactory.getSqlSessionFactory();
        SqlSession session = sqlSessionFactory.openSession();
        try {
            CallResultMapper mapper = session.getMapper(CallResultMapper.class);
            mapper.updateByPrimaryKey(callResult);
            session.commit();
        }finally {
            session.close();
        }
    }

    @Override
    public List<CallResult> getAll() throws IOException {
        SqlSessionFactory sqlSessionFactory = MySqlSessionFactory.getSqlSessionFactory();
        SqlSession session = sqlSessionFactory.openSession();
        try {
            return session.selectList("cn.dombro.cloudCall.dao.tradition.CallResultMapper.getAll");
        } finally {
            session.close();
        }
    }

    @Override
    public CallResult getRemarkAndResultByRunningId(Long runningId) throws IOException {
        SqlSessionFactory sqlSessionFactory = MySqlSessionFactory.getSqlSessionFactory();
        SqlSession session = sqlSessionFactory.openSession();
        try {
            CallResultMapper mapper = session.getMapper(CallResultMapper.class);
            return mapper.getRemarkAndResultByRunningId(runningId);
        } finally {
            session.close();
        }
    }
}
