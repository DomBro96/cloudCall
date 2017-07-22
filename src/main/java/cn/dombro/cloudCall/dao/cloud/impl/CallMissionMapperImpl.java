package cn.dombro.cloudCall.dao.cloud.impl;

import cn.dombro.cloudCall.dao.cloud.CallMissionMapper;
import cn.dombro.cloudCall.entity.CallMission;
import cn.dombro.cloudCall.utils.MySqlSessionFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.io.IOException;
import java.util.List;

/**
 * Author Caole
 * CreateDate: 2017/7/17
 * CreateTime: 12:34
 */
public class CallMissionMapperImpl implements CallMissionMapper{

    private static CallMissionMapper missionMapper = null;
    public static CallMissionMapper getMissionMapper(){
        missionMapper = new CallMissionMapperImpl();
        return  missionMapper;
    }
    @Override
    public CallMission selectByPrimaryKey(Long runningId) throws IOException {
        SqlSessionFactory sqlSessionFactory = MySqlSessionFactory.getSqlSessionFactory();
        SqlSession session = sqlSessionFactory.openSession();
        try{
            CallMissionMapper mapper = session.getMapper(CallMissionMapper.class);
            return mapper.selectByPrimaryKey(runningId);
        }finally {
            session.close();
        }
    }

    @Override
    public void deleteByPrimaryKey(Long runningId) throws IOException {
        SqlSessionFactory sqlSessionFactory = MySqlSessionFactory.getSqlSessionFactory();
        SqlSession session = sqlSessionFactory.openSession();
        try{
            CallMissionMapper mapper = session.getMapper(CallMissionMapper.class);
            mapper.deleteByPrimaryKey(runningId);
            session.commit();
        }finally {
            session.close();
        }
    }

    @Override
    public void insert(CallMission callMission) throws IOException {
        SqlSessionFactory sqlSessionFactory = MySqlSessionFactory.getSqlSessionFactory();
        SqlSession session = sqlSessionFactory.openSession();
        try{
            CallMissionMapper mapper = session.getMapper(CallMissionMapper.class);
            mapper.insert(callMission);
            session.commit();
        }finally {
            session.close();
        }
    }

    @Override
    public void insertSelective(CallMission callMission) throws IOException {
        SqlSessionFactory sqlSessionFactory = MySqlSessionFactory.getSqlSessionFactory();
        SqlSession session = sqlSessionFactory.openSession();
        try{
            CallMissionMapper mapper = session.getMapper(CallMissionMapper.class);
            mapper.insertSelective(callMission);
            session.commit();
        }finally {
            session.close();
        }
    }

    @Override
    public void updateByPrimaryKeySelective(Long runningId) throws IOException {
        SqlSessionFactory sqlSessionFactory = MySqlSessionFactory.getSqlSessionFactory();
        SqlSession session = sqlSessionFactory.openSession();
        try{
            CallMissionMapper mapper = session.getMapper(CallMissionMapper.class);
            mapper.updateByPrimaryKeySelective(runningId);
            session.commit();
        }finally {
            session.close();
        }
    }

    @Override
    public void updateByPrimaryKey(Long runningId) throws IOException {
        SqlSessionFactory sqlSessionFactory = MySqlSessionFactory.getSqlSessionFactory();
        SqlSession session = sqlSessionFactory.openSession();
        try{
            CallMissionMapper mapper = session.getMapper(CallMissionMapper.class);
            mapper.updateByPrimaryKey(runningId);
            session.commit();
        }finally {
            session.close();
        }
    }

    @Override
    public List<CallMission> getAll() throws IOException {
        SqlSessionFactory sqlSessionFactory = MySqlSessionFactory.getSqlSessionFactory();
        SqlSession session = sqlSessionFactory.openSession();
        try {
            CallMissionMapper mapper = session.getMapper(CallMissionMapper.class);
            return mapper.getAll();
        } finally {
            session.close();
        }
    }

    @Override
    public List<CallMission> getListRunningIdByMid(Integer mId) throws IOException {
        SqlSessionFactory sqlSessionFactory = MySqlSessionFactory.getSqlSessionFactory();
        SqlSession session = sqlSessionFactory.openSession();
        try {
            CallMissionMapper mapper = session.getMapper(CallMissionMapper.class);
            return mapper.getListRunningIdByMid(mId);
        } finally {
            session.close();
        }
    }

    @Override
    public CallMission getByMid(Integer mId) throws IOException {
        SqlSessionFactory sqlSessionFactory = MySqlSessionFactory.getSqlSessionFactory();
        SqlSession session = sqlSessionFactory.openSession();
        try {
            CallMissionMapper mapper = session.getMapper(CallMissionMapper.class);
            return mapper.getByMid(mId);
        } finally {
            session.close();
        }
    }
}
