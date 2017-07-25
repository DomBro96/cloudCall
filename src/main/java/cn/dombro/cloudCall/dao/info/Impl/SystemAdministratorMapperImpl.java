package cn.dombro.cloudCall.dao.info.Impl;

import cn.dombro.cloudCall.dao.info.CustomerServiceMapper;
import cn.dombro.cloudCall.dao.info.SystemAdministratorMapper;
import cn.dombro.cloudCall.entity.CustomerService;
import cn.dombro.cloudCall.entity.SystemAdministrator;
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
    public void updateByPrimaryKeySelective(SystemAdministrator systemAdministrator) throws IOException {
        SqlSessionFactory sqlSessionFactory = MySqlSessionFactory.getSqlSessionFactory();
        SqlSession session = sqlSessionFactory.openSession();
        try {
            SystemAdministratorMapper mapper = session.getMapper(SystemAdministratorMapper.class);
            mapper.updateByPrimaryKeySelective(systemAdministrator);
            session.commit();
        } finally {
            session.close();
        }
    }

    @Override
    public void updateByPrimaryKey(SystemAdministrator systemAdministrator) throws IOException {
        SqlSessionFactory sqlSessionFactory = MySqlSessionFactory.getSqlSessionFactory();
        SqlSession session = sqlSessionFactory.openSession();
        try {
            SystemAdministratorMapper mapper = session.getMapper(SystemAdministratorMapper.class);
            mapper.updateByPrimaryKey(systemAdministrator);
            session.commit();
        } finally {
            session.close();
        }
    }

    @Override
    public List<SystemAdministrator> getAll() throws IOException {
        SqlSessionFactory sqlSessionFactory = MySqlSessionFactory.getSqlSessionFactory();
        SqlSession session = sqlSessionFactory.openSession();
        try {
            SystemAdministratorMapper mapper = session.getMapper(SystemAdministratorMapper.class);
            return mapper.getAll();
        } finally {
            session.close();
        }
    }

    public String selectPswByUser(String username) throws IOException {
        SqlSessionFactory sqlSessionFactory = MySqlSessionFactory.getSqlSessionFactory();
        SqlSession session = sqlSessionFactory.openSession();
        try {
            SystemAdministratorMapper mapper = session.getMapper(SystemAdministratorMapper.class);
            return mapper.selectPswByUser(username);
        } finally {
            session.close();
        }
    }

    public SystemAdministrator selectByUser(String username) throws IOException {
        SqlSessionFactory sqlSessionFactory = MySqlSessionFactory.getSqlSessionFactory();
        SqlSession session = sqlSessionFactory.openSession();
        try {
            SystemAdministratorMapper mapper = session.getMapper(SystemAdministratorMapper.class);
            return mapper.selectByUser(username);
        } finally {
            session.close();
        }
    }
}
