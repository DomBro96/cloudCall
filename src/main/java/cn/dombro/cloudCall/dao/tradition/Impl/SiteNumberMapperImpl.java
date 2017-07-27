package cn.dombro.cloudCall.dao.tradition.Impl;

import cn.dombro.cloudCall.dao.cloud.MissionInfoMapper;
import cn.dombro.cloudCall.dao.tradition.SiteNumberMapper;
import cn.dombro.cloudCall.entity.SiteNumber;
import cn.dombro.cloudCall.utils.MySqlSessionFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.io.IOException;
import java.util.List;

/**
 * Author Caole
 * CreateDate: 2017/7/17
 * CreateTime: 12:37
 */
public class SiteNumberMapperImpl implements SiteNumberMapper{

    private static SiteNumberMapper numberMapper = null;
    public static SiteNumberMapper getNumberMapper(){
        numberMapper = new SiteNumberMapperImpl();
        return numberMapper;
    }

    @Override
    public SiteNumber selectByPrimaryKey(Integer mId) throws IOException {
        SqlSessionFactory sqlSessionFactory = MySqlSessionFactory.getSqlSessionFactory();
        SqlSession session = sqlSessionFactory.openSession();
        try {
            SiteNumberMapper siteNumberMapper = session.getMapper(SiteNumberMapper.class);
            return siteNumberMapper.selectByPrimaryKey(mId);
        }finally {
            session.close();
        }
    }

    @Override
    public void deleteByPrimaryKey(Integer mId) throws IOException {
        SqlSessionFactory sqlSessionFactory = MySqlSessionFactory.getSqlSessionFactory();
        SqlSession session = sqlSessionFactory.openSession();
        try {
            SiteNumberMapper siteNumberMapper = session.getMapper(SiteNumberMapper.class);
            siteNumberMapper.deleteByPrimaryKey(mId);
            session.commit();
        }finally {
            session.close();
        }
    }

    @Override
    public void insert(SiteNumber siteNumber) throws IOException {
        SqlSessionFactory sqlSessionFactory = MySqlSessionFactory.getSqlSessionFactory();
        SqlSession session = sqlSessionFactory.openSession();
        try {
            SiteNumberMapper siteNumberMapper = session.getMapper(SiteNumberMapper.class);
            siteNumberMapper.insert(siteNumber);
            session.commit();
        }finally {
            session.close();
        }
    }

    @Override
    public void insertSelective(SiteNumber siteNumber) throws IOException {
        SqlSessionFactory sqlSessionFactory = MySqlSessionFactory.getSqlSessionFactory();
        SqlSession session = sqlSessionFactory.openSession();
        try {
            SiteNumberMapper siteNumberMapper = session.getMapper(SiteNumberMapper.class);
            siteNumberMapper.insertSelective(siteNumber);
            session.commit();
        }finally {
            session.close();
        }
    }

    @Override
    public void updateByPrimaryKeySelective(SiteNumber siteNumber) throws IOException {
        SqlSessionFactory sqlSessionFactory = MySqlSessionFactory.getSqlSessionFactory();
        SqlSession session = sqlSessionFactory.openSession();
        try {
            SiteNumberMapper siteNumberMapper = session.getMapper(SiteNumberMapper.class);
            siteNumberMapper.updateByPrimaryKeySelective(siteNumber);
            session.commit();
        }finally {
            session.close();
        }
    }

    @Override
    public void updateByPrimaryKey(SiteNumber siteNumber) throws IOException {
        SqlSessionFactory sqlSessionFactory = MySqlSessionFactory.getSqlSessionFactory();
        SqlSession session = sqlSessionFactory.openSession();
        try {
            SiteNumberMapper siteNumberMapper = session.getMapper(SiteNumberMapper.class);
            siteNumberMapper.updateByPrimaryKey(siteNumber);
            session.commit();
        }finally {
            session.close();
        }
    }

    @Override
    public List<SiteNumber> getAll() throws IOException {
        SqlSessionFactory sqlSessionFactory = MySqlSessionFactory.getSqlSessionFactory();
        SqlSession session = sqlSessionFactory.openSession();
        try {
            return session.selectList("cn.dombro.cloudCall.dao.tradition.SiteNumberMapper.getAll");
        } finally {
            session.close();
        }
    }

    @Override
    public SiteNumber getListByPswAndUser(String username,String password) throws IOException {
        SqlSessionFactory sqlSessionFactory = MySqlSessionFactory.getSqlSessionFactory();
        SqlSession session = sqlSessionFactory.openSession();
        try {
            SiteNumberMapper siteNumberMapper = session.getMapper(SiteNumberMapper.class);
            return siteNumberMapper.getListByPswAndUser(username,password);
        }finally {
            session.close();
        }
    }
}
