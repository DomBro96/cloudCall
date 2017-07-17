package cn.dombro.cloudCall.dao.info.Impl;

import cn.dombro.cloudCall.dao.info.CustomerServiceMapper;
import cn.dombro.cloudCall.entity.CustomerService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * Author Caole
 * CreateDate: 2017/7/16
 * CreateTime: 16:21
 */
public class CustomerServiceMapperImpl implements CustomerServiceMapper {

    private  static  CustomerServiceMapper serviceMapper = null;
    public static CustomerServiceMapper getServiceMapper(){
        serviceMapper = new CustomerServiceMapperImpl();
        return serviceMapper;
    }

    public SqlSessionFactory getSqlSessionFactory() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        return new SqlSessionFactoryBuilder().build(inputStream);
    }

    public CustomerService selectByPrimaryKey(Integer csId) throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession session = sqlSessionFactory.openSession();
        try {
            CustomerServiceMapper mapper = session.getMapper(CustomerServiceMapper.class);
            return mapper.selectByPrimaryKey(csId);
        } finally {
            session.close();
        }
    }

    public void deleteByPrimaryKey(Integer csId) throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession session = sqlSessionFactory.openSession();
        try {
            CustomerServiceMapper mapper = session.getMapper(CustomerServiceMapper.class);
            mapper.deleteByPrimaryKey(csId);
            session.commit();
        } finally {
            session.close();
        }
    }

    public void insert(CustomerService customerService) throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession session = sqlSessionFactory.openSession();
        try {
            CustomerServiceMapper mapper = session.getMapper(CustomerServiceMapper.class);
            mapper.insert(customerService);
            session.commit();
        } finally {
            session.close();
        }
    }

    public void insertSelective(CustomerService customerService) throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession session = sqlSessionFactory.openSession();
        try {
            CustomerServiceMapper mapper = session.getMapper(CustomerServiceMapper.class);
            mapper.insertSelective(customerService);
            session.commit();
        } finally {
            session.close();
        }
    }

    public void updateByPrimaryKeySelective(CustomerService customerService) throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession session = sqlSessionFactory.openSession();
        try {
            CustomerServiceMapper mapper = session.getMapper(CustomerServiceMapper.class);
            mapper.updateByPrimaryKeySelective(customerService);
            session.commit();
        } finally {
            session.close();
        }
    }

    public void updateByPrimaryKey(CustomerService customerService) throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession session = sqlSessionFactory.openSession();
        try {
            CustomerServiceMapper mapper = session.getMapper(CustomerServiceMapper.class);
            mapper.updateByPrimaryKey(customerService);
            session.commit();
        } finally {
            session.close();
        }
    }
}
