package cn.dombro.cloudCall.dao.info.Impl;

import cn.dombro.cloudCall.dao.info.CustomerServiceMapper;
import cn.dombro.cloudCall.entity.CustomerService;
import cn.dombro.cloudCall.utils.MySqlSessionFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.io.IOException;
import java.util.List;

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
    public CustomerServiceMapper mapper = null;

    public CustomerService selectByPrimaryKey(Integer csId) throws IOException {
        SqlSessionFactory sqlSessionFactory = MySqlSessionFactory.getSqlSessionFactory();
        SqlSession session = sqlSessionFactory.openSession();
        try {
            CustomerServiceMapper mapper = session.getMapper(CustomerServiceMapper.class);
            return mapper.selectByPrimaryKey(csId);
        } finally {
            session.close();
        }
    }

    public void deleteByPrimaryKey(Integer csId) throws IOException {
        SqlSessionFactory sqlSessionFactory = MySqlSessionFactory.getSqlSessionFactory();
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
        SqlSessionFactory sqlSessionFactory = MySqlSessionFactory.getSqlSessionFactory();
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
        SqlSessionFactory sqlSessionFactory = MySqlSessionFactory.getSqlSessionFactory();
        SqlSession session = sqlSessionFactory.openSession();
        try {
            mapper = session.getMapper(CustomerServiceMapper.class);
            mapper.insertSelective(customerService);
            session.commit();
        } finally {
            session.close();
        }
    }

    public void updateByPrimaryKeySelective(CustomerService customerService) throws IOException {
        SqlSessionFactory sqlSessionFactory = MySqlSessionFactory.getSqlSessionFactory();
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
        SqlSessionFactory sqlSessionFactory = MySqlSessionFactory.getSqlSessionFactory();
        SqlSession session = sqlSessionFactory.openSession();
        try {
            CustomerServiceMapper mapper = session.getMapper(CustomerServiceMapper.class);
            mapper.updateByPrimaryKey(customerService);
            session.commit();
        } finally {
            session.close();
        }
    }

    @Override
    public List<CustomerService> getAll() throws IOException {
        SqlSessionFactory sqlSessionFactory = MySqlSessionFactory.getSqlSessionFactory();
        SqlSession session = sqlSessionFactory.openSession();
        try {
            CustomerServiceMapper mapper = session.getMapper(CustomerServiceMapper.class);
            return mapper.getAll();

            //return session.selectList("cn.dombro.cloudCall.dao.info.CustomerServiceMapper.getAll");
        } finally {
            session.close();
        }
    }

    public String selectPswByUser(String username) throws IOException {
        SqlSessionFactory sqlSessionFactory = MySqlSessionFactory.getSqlSessionFactory();
        SqlSession session = sqlSessionFactory.openSession();
        try {
            CustomerServiceMapper mapper = session.getMapper(CustomerServiceMapper.class);
            return mapper.selectPswByUser(username);
        } finally {
            session.close();
        }
    }

    public CustomerService selectByUser(String username) throws IOException {
        SqlSessionFactory sqlSessionFactory = MySqlSessionFactory.getSqlSessionFactory();
        SqlSession session = sqlSessionFactory.openSession();
        try {
            CustomerServiceMapper mapper = session.getMapper(CustomerServiceMapper.class);
            return mapper.selectByUser(username);
        } finally {
            session.close();
        }
    }
}
