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
    public void updateByPrimaryKeySelective(MissionInfo missionInfo) throws IOException {
        SqlSessionFactory sqlSessionFactory = MySqlSessionFactory.getSqlSessionFactory();
        SqlSession session = sqlSessionFactory.openSession();
        try {
            MissionInfoMapper missionInfoMapper = session.getMapper(MissionInfoMapper.class);
            missionInfoMapper.updateByPrimaryKeySelective(missionInfo);
            session.commit();
        }finally {
            session.close();
        }
    }

    @Override
    public void updateByPrimaryKey(MissionInfo missionInfo) throws IOException {
        SqlSessionFactory sqlSessionFactory = MySqlSessionFactory.getSqlSessionFactory();
        SqlSession session = sqlSessionFactory.openSession();
        try {
            MissionInfoMapper missionInfoMapper = session.getMapper(MissionInfoMapper.class);
            missionInfoMapper.updateByPrimaryKey(missionInfo);
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
            MissionInfoMapper missionInfoMapper = session.getMapper(MissionInfoMapper.class);
            return missionInfoMapper.getAll();
        } finally {
            session.close();
        }
    }

    @Override
    public List<MissionInfo> getListByEcId(Integer ecId) throws IOException {
        SqlSessionFactory sqlSessionFactory = MySqlSessionFactory.getSqlSessionFactory();
        SqlSession session = sqlSessionFactory.openSession();
        try {
            MissionInfoMapper missionInfoMapper = session.getMapper(MissionInfoMapper.class);
            return missionInfoMapper.getListByEcId(ecId);
        } finally {
            session.close();
        }
    }

    @Override
    public List<MissionInfo> getListByEcIdAndAccept(Integer ecId, Integer acceptStatus) throws IOException {
        SqlSessionFactory sqlSessionFactory = MySqlSessionFactory.getSqlSessionFactory();
        SqlSession session = sqlSessionFactory.openSession();
        try {
            MissionInfoMapper missionInfoMapper = session.getMapper(MissionInfoMapper.class);
            return missionInfoMapper.getListByEcIdAndAccept(ecId,acceptStatus);
        } finally {
            session.close();
        }

    }

    @Override
    public void deleteByMidAndAccept(Integer mId) throws IOException {
        SqlSessionFactory sqlSessionFactory = MySqlSessionFactory.getSqlSessionFactory();
        SqlSession session = sqlSessionFactory.openSession();
        try {
            MissionInfoMapper missionInfoMapper = session.getMapper(MissionInfoMapper.class);
            missionInfoMapper.deleteByMidAndAccept(mId);
            session.commit();
        }finally {
            session.close();
        }
    }

    @Override
    public List<MissionInfo> getClassAndClassifyAndInfoByQueryStamLiKe(String queryStatement) throws IOException {
        SqlSessionFactory sqlSessionFactory = MySqlSessionFactory.getSqlSessionFactory();
        SqlSession session = sqlSessionFactory.openSession();
        try {
            MissionInfoMapper missionInfoMapper = session.getMapper(MissionInfoMapper.class);
            return missionInfoMapper.getClassAndClassifyAndInfoByQueryStamLiKe(queryStatement);
        } finally {
            session.close();
        }
    }

    @Override
    public List<MissionInfo> getClassAndClassifyAndInfoByQueryStamAllLike(String queryStatement) throws IOException {
        SqlSessionFactory sqlSessionFactory = MySqlSessionFactory.getSqlSessionFactory();
        SqlSession session = sqlSessionFactory.openSession();
        try {
            MissionInfoMapper missionInfoMapper = session.getMapper(MissionInfoMapper.class);
            return missionInfoMapper.getClassAndClassifyAndInfoByQueryStamAllLike(queryStatement);
        } finally {
            session.close();
        }
    }

    @Override
    public int getAcceptStatusByMid(Integer mId) throws IOException {
        SqlSessionFactory sqlSessionFactory = MySqlSessionFactory.getSqlSessionFactory();
        SqlSession session = sqlSessionFactory.openSession();
        try {
            MissionInfoMapper missionInfoMapper = session.getMapper(MissionInfoMapper.class);
            return missionInfoMapper.getAcceptStatusByMid(mId);
        } finally {
            session.close();
        }
    }

    @Override
    public int getAcceptStatusNumByEcIdAndAccept(Integer ecId, Integer acceptStatus) throws IOException {
        SqlSessionFactory sqlSessionFactory = MySqlSessionFactory.getSqlSessionFactory();
        SqlSession session = sqlSessionFactory.openSession();
        try {
            MissionInfoMapper missionInfoMapper = session.getMapper(MissionInfoMapper.class);
            return missionInfoMapper.getAcceptStatusNumByEcIdAndAccept(ecId,acceptStatus);
        }finally {
            session.close();
        }
    }

    @Override
    public int getAcceptStatusNumByCsIdAndAccept(Integer csId, Integer acceptStatus) throws IOException {
        SqlSessionFactory sqlSessionFactory = MySqlSessionFactory.getSqlSessionFactory();
        SqlSession session = sqlSessionFactory.openSession();
        try {
            MissionInfoMapper missionInfoMapper = session.getMapper(MissionInfoMapper.class);
            return missionInfoMapper.getAcceptStatusNumByCsIdAndAccept(csId,acceptStatus);
        }finally {
            session.close();
        }
    }

    @Override
    public int getAcceptStatusNumByCsId(Integer csId) throws IOException {
        SqlSessionFactory sqlSessionFactory = MySqlSessionFactory.getSqlSessionFactory();
        SqlSession session = sqlSessionFactory.openSession();
        try {
            MissionInfoMapper missionInfoMapper = session.getMapper(MissionInfoMapper.class);
            return missionInfoMapper.getAcceptStatusNumByCsId(csId);
        }finally {
            session.close();
        }
    }

    @Override
    public int getAcceptStatusNumByAcceptStatus(Integer acceptStatus) throws IOException {
        SqlSessionFactory sqlSessionFactory = MySqlSessionFactory.getSqlSessionFactory();
        SqlSession session = sqlSessionFactory.openSession();
        try {
            MissionInfoMapper missionInfoMapper = session.getMapper(MissionInfoMapper.class);
            return missionInfoMapper.getAcceptStatusNumByAcceptStatus(acceptStatus);
        }finally {
            session.close();
        }
    }

    @Override
    public List<MissionInfo> getAllByQueryStatementLike(String queryStatement) throws IOException {
        SqlSessionFactory sqlSessionFactory = MySqlSessionFactory.getSqlSessionFactory();
        SqlSession session = sqlSessionFactory.openSession();
        try {
            MissionInfoMapper missionInfoMapper = session.getMapper(MissionInfoMapper.class);
            return missionInfoMapper.getAllByQueryStatementLike(queryStatement);
        } finally {
            session.close();
        }
    }
}
