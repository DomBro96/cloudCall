package cn.dombro.cloudCall.dao.info.Impl;

import cn.dombro.cloudCall.dao.info.SystemAdministratorMapper;
import cn.dombro.cloudCall.entity.SystemAdministrator;
import cn.dombro.cloudCall.utils.MySqlSessionFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.io.IOException;

/**
 * Author Caole
 * CreateDate: 2017/7/17
 * CreateTime: 12:34
 */
public class SystemAdministratorMapperImpl implements SystemAdministratorMapper{

    private static SystemAdministratorMapper administratorMapper = null;
    public static SystemAdministratorMapper getAdministratorMapper(){
        administratorMapper = new SystemAdministratorMapperImpl();
        return  administratorMapper;
    }
    @Override
    public SystemAdministrator selectByPrimaryKey(Integer saId) throws IOException {
        SqlSessionFactory sqlSessionFactory = MySqlSessionFactory.getSqlSessionFactory();
        SqlSession session = sqlSessionFactory.openSession();
        try {
            SystemAdministratorMapper mapper = session.getMapper(SystemAdministratorMapper.class);
            return mapper.selectByPrimaryKey(saId);
        } finally {
            session.close();
        }
    }

    @Override
    public void deleteByPrimaryKey(Integer saId) throws IOException {
        SqlSessionFactory sqlSessionFactory = MySqlSessionFactory.getSqlSessionFactory();
        SqlSession session = sqlSessionFactory.openSession();
        try {
            SystemAdministratorMapper mapper = session.getMapper(SystemAdministratorMapper.class);
            mapper.deleteByPrimaryKey(saId);
            session.commit();
        } finally {
            session.close();
        }
    }

    @Override
    public void insert(SystemAdministrator systemAdministrator) throws IOException {
        SqlSessionFactory sqlSessionFactory = MySqlSessionFactory.getSqlSessionFactory();
        SqlSession session = sqlSessionFactory.openSession();
        try {
            SystemAdministratorMapper mapper = session.getMapper(SystemAdministratorMapper.class);
            mapper.insert(systemAdministrator);
            session.commit();
        } finally {
            session.close();
        }
    }

    @Override
    public void insertSelective(SystemAdministrator systemAdministrator) throws IOException {
        SqlSessionFactory sqlSessionFactory = MySqlSessionFactory.getSqlSessionFactory();
        SqlSession session = sqlSessionFactory.openSession();
        try {
            SystemAdministratorMapper mapper = session.getMapper(SystemAdministratorMapper.class);
            mapper.insertSelective(systemAdministrator);
            session.commit();
        } finally {
            session.close();
        }
    }

    @Override
    public void updateByPrimaryKeySelective(Integer saId) throws IOException {
        SqlSessionFactory sqlSessionFactory = MySqlSessionFactory.getSqlSessionFactory();
        SqlSession session = sqlSessionFactory.openSession();
        try {
            SystemAdministratorMapper mapper = session.getMapper(SystemAdministratorMapper.class);
            mapper.updateByPrimaryKeySelective(saId);
            session.commit();
        } finally {
            session.close();
        }
    }

    @Override
    public void updateByPrimaryKey(Integer saId) throws IOException {
        SqlSessionFactory sqlSessionFactory = MySqlSessionFactory.getSqlSessionFactory();
        SqlSession session = sqlSessionFactory.openSession();
        try {
            SystemAdministratorMapper mapper = session.getMapper(SystemAdministratorMapper.class);
            mapper.updateByPrimaryKey(saId);
            session.commit();
        } finally {
            session.close();
        }
    }
}
