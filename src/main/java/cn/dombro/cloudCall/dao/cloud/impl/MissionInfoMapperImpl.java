package cn.dombro.cloudCall.dao.cloud.impl;

import cn.dombro.cloudCall.dao.cloud.MissionInfoMapper;
import cn.dombro.cloudCall.entity.MissionInfo;
import cn.dombro.cloudCall.utils.MySqlSessionFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.io.IOException;
import java.util.List;

/**
 * Author Caole
 * CreateDate: 2017/7/17
 * CreateTime: 12:35
 */
public class MissionInfoMapperImpl implements MissionInfoMapper{

    private static MissionInfoMapper infoMapper = null;
    public static MissionInfoMapper getInfoMapper(){
        infoMapper = new MissionInfoMapperImpl();
        return infoMapper;
    }

    @Override
    public MissionInfo selectByPrimaryKey(Integer mId) throws IOException {
        SqlSessionFactory sqlSessionFactory = MySqlSessionFactory.getSqlSessionFactory();
        SqlSession session = sqlSessionFactory.openSession();
        try {
            MissionInfoMapper missionInfoMapper = session.getMapper(MissionInfoMapper.class);
            return missionInfoMapper.selectByPrimaryKey(mId);
        }finally {
            session.close();
        }
    }

    @Override
    public void deleteByPrimaryKey(Integer mId) throws IOException {
        SqlSessionFactory sqlSessionFactory = MySqlSessionFactory.getSqlSessionFactory();
        SqlSession session = sqlSessionFactory.openSession();
        try {
            MissionInfoMapper missionInfoMapper = session.getMapper(MissionInfoMapper.class);
            missionInfoMapper.deleteByPrimaryKey(mId);
            session.commit();
        }finally {
            session.close();
        }
    }

    @Override
    public void insert(MissionInfo missionInfo) throws IOException {
        SqlSessionFactory sqlSessionFactory = MySqlSessionFactory.getSqlSessionFactory();
        SqlSession session = sqlSessionFactory.openSession();
        try {
            MissionInfoMapper missionInfoMapper = session.getMapper(MissionInfoMapper.class);
            missionInfoMapper.insert(missionInfo);
            session.commit();
        }finally {
            session.close();
        }
    }

    @Override
    public void insertSelective(MissionInfo missionInfo) throws IOException {
        SqlSessionFactory sqlSessionFactory = MySqlSessionFactory.getSqlSessionFactory();
        SqlSession session = sqlSessionFactory.openSession();
        try {
            MissionInfoMapper missionInfoMapper = session.getMapper(MissionInfoMapper.class);
            missionInfoMapper.insertSelective(missionInfo);
            session.commit();
        }finally {
            session.close();
        }
    }

    @Override
    public void updateByPrimaryKeySelective(Integer mId) throws IOException {
        SqlSessionFactory sqlSessionFactory = MySqlSessionFactory.getSqlSessionFactory();
        SqlSession session = sqlSessionFactory.openSession();
        try {
            MissionInfoMapper missionInfoMapper = session.getMapper(MissionInfoMapper.class);
            missionInfoMapper.updateByPrimaryKeySelective(mId);
            session.commit();
        }finally {
            session.close();
        }
    }

    @Override
    public void updateByPrimaryKey(Integer mId) throws IOException {
        SqlSessionFactory sqlSessionFactory = MySqlSessionFactory.getSqlSessionFactory();
        SqlSession session = sqlSessionFactory.openSession();
        try {
            MissionInfoMapper missionInfoMapper = session.getMapper(MissionInfoMapper.class);
            missionInfoMapper.updateByPrimaryKey(mId);
            session.commit();
        }finally {
            session.close();
        }
    }

    @Override
    public List<MissionInfo> getAll() throws IOException {
        SqlSessionFactory sqlSessionFactory = MySqlSessionFactory.getSqlSessionFactory();
        SqlSession session = sqlSessionFactory.openSession();
        try {
            return session.selectList("cn.dombro.cloudCall.dao.cloud.MissionInfoMapper.getAll");
        } finally {
            session.close();
        }
    }
}
