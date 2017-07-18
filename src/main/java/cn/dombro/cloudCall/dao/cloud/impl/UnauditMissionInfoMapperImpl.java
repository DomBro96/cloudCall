package cn.dombro.cloudCall.dao.cloud.impl;

import cn.dombro.cloudCall.dao.cloud.UnauditMissionInfoMapper;
import cn.dombro.cloudCall.entity.UnauditMissionInfo;
import cn.dombro.cloudCall.utils.MySqlSessionFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.io.IOException;

/**
 * Author Caole
 * CreateDate: 2017/7/17
 * CreateTime: 12:35
 */
public class UnauditMissionInfoMapperImpl implements UnauditMissionInfoMapper {

    private static UnauditMissionInfoMapper missionInfoMapper = null;
    public static UnauditMissionInfoMapper getMissionInfoMapper(){
        missionInfoMapper = new UnauditMissionInfoMapperImpl();
        return missionInfoMapper;
    }

    @Override
    public UnauditMissionInfo selectByPrimaryKey(Integer mId) throws IOException {
        SqlSessionFactory sqlSessionFactory = MySqlSessionFactory.getSqlSessionFactory();
        SqlSession session = sqlSessionFactory.openSession();
        try{
            UnauditMissionInfoMapper mapper = session.getMapper(UnauditMissionInfoMapper.class);
            return mapper.selectByPrimaryKey(mId);
        } finally {
            session.close();
        }
    }

    @Override
    public void deleteByPrimaryKey(Integer mId) throws IOException {
        SqlSessionFactory sqlSessionFactory = MySqlSessionFactory.getSqlSessionFactory();
        SqlSession session = sqlSessionFactory.openSession();
        try{
            UnauditMissionInfoMapper mapper = session.getMapper(UnauditMissionInfoMapper.class);
            mapper.deleteByPrimaryKey(mId);
            session.commit();
        } finally {
            session.close();
        }
    }

    @Override
    public void insert(UnauditMissionInfo unauditMissionInfo) throws IOException {
        SqlSessionFactory sqlSessionFactory = MySqlSessionFactory.getSqlSessionFactory();
        SqlSession session = sqlSessionFactory.openSession();
        try{
            UnauditMissionInfoMapper mapper = session.getMapper(UnauditMissionInfoMapper.class);
            mapper.insert(unauditMissionInfo);
            session.commit();
        } finally {
            session.close();
        }
    }

    @Override
    public void insertSelective(UnauditMissionInfo unauditMissionInfo) throws IOException {
        SqlSessionFactory sqlSessionFactory = MySqlSessionFactory.getSqlSessionFactory();
        SqlSession session = sqlSessionFactory.openSession();
        try{
            UnauditMissionInfoMapper mapper = session.getMapper(UnauditMissionInfoMapper.class);
            mapper.insertSelective(unauditMissionInfo);
            session.commit();
        } finally {
            session.close();
        }
    }

    @Override
    public void updateByPrimaryKeySelective(Integer mId) throws IOException {
        SqlSessionFactory sqlSessionFactory = MySqlSessionFactory.getSqlSessionFactory();
        SqlSession session = sqlSessionFactory.openSession();
        try{
            UnauditMissionInfoMapper mapper = session.getMapper(UnauditMissionInfoMapper.class);
            mapper.updateByPrimaryKeySelective(mId);
            session.commit();
        } finally {
            session.close();
        }
    }

    @Override
    public void updateByPrimaryKey(Integer mId) throws IOException {
        SqlSessionFactory sqlSessionFactory = MySqlSessionFactory.getSqlSessionFactory();
        SqlSession session = sqlSessionFactory.openSession();
        try{
            UnauditMissionInfoMapper mapper = session.getMapper(UnauditMissionInfoMapper.class);
            mapper.updateByPrimaryKey(mId);
            session.commit();
        } finally {
            session.close();
        }
    }
}
