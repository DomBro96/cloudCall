package cn.dombro.cloudCall.dao.info.Impl;

import cn.dombro.cloudCall.dao.info.CustomerServiceMapper;
import cn.dombro.cloudCall.dao.info.EnterpriseCustomerMapper;
import cn.dombro.cloudCall.entity.CustomerService;
import cn.dombro.cloudCall.entity.EnterpriseCustomer;
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
public class EnterpriseCustomerMapperImpl implements EnterpriseCustomerMapper{

    private static EnterpriseCustomerMapper customerMapper = null;
    public static EnterpriseCustomerMapper getCustomerMapper(){
        customerMapper = new EnterpriseCustomerMapperImpl();
        return customerMapper;
    }

    public EnterpriseCustomer selectByPrimaryKey(Integer ecId) throws IOException {
        SqlSessionFactory sqlSessionFactory = MySqlSessionFactory.getSqlSessionFactory();
        SqlSession session = sqlSessionFactory.openSession();
        try {
            EnterpriseCustomerMapper mapper = session.getMapper(EnterpriseCustomerMapper.class);
            return mapper.selectByPrimaryKey(ecId);
        }finally {
            session.close();
        }
    }

    public void deleteByPrimaryKey(Integer ecId) throws IOException {
        SqlSessionFactory sqlSessionFactory = MySqlSessionFactory.getSqlSessionFactory();
        SqlSession session = sqlSessionFactory.openSession();
        try {
            EnterpriseCustomerMapper mapper = session.getMapper(EnterpriseCustomerMapper.class);
            mapper.deleteByPrimaryKey(ecId);
            session.commit();
        }finally {
            session.close();
        }
    }

    public void insert(EnterpriseCustomer enterpriseCustomer) throws IOException {
        SqlSessionFactory sqlSessionFactory = MySqlSessionFactory.getSqlSessionFactory();
        SqlSession session = sqlSessionFactory.openSession();
        try {
            EnterpriseCustomerMapper mapper = session.getMapper(EnterpriseCustomerMapper.class);
            mapper.insert(enterpriseCustomer);
            session.commit();
        } finally {
            session.close();
        }
    }

    public void insertSelective(EnterpriseCustomer enterpriseCustomer) throws IOException {
        SqlSessionFactory sqlSessionFactory = MySqlSessionFactory.getSqlSessionFactory();
        SqlSession session = sqlSessionFactory.openSession();
        try {
            EnterpriseCustomerMapper mapper = session.getMapper(EnterpriseCustomerMapper.class);
            mapper.insertSelective(enterpriseCustomer);
            session.commit();
        } finally {
            session.close();
        }
    }

    public void updateByPrimaryKeySelective(EnterpriseCustomer enterpriseCustomer) throws IOException {
        SqlSessionFactory sqlSessionFactory = MySqlSessionFactory.getSqlSessionFactory();
        SqlSession session = sqlSessionFactory.openSession();
        try {
            EnterpriseCustomerMapper mapper = session.getMapper(EnterpriseCustomerMapper.class);
            mapper.updateByPrimaryKeySelective(enterpriseCustomer);
            session.commit();
        } finally {
            session.close();
        }
    }

    public void updateByPrimaryKey(EnterpriseCustomer enterpriseCustomer) throws IOException {
        SqlSessionFactory sqlSessionFactory = MySqlSessionFactory.getSqlSessionFactory();
        SqlSession session = sqlSessionFactory.openSession();
        try {
            EnterpriseCustomerMapper mapper = session.getMapper(EnterpriseCustomerMapper.class);
            mapper.updateByPrimaryKey(enterpriseCustomer);
            session.commit();
        } finally {
            session.close();
        }
    }

    @Override
    public List<EnterpriseCustomer> getAll() throws IOException {
        SqlSessionFactory sqlSessionFactory = MySqlSessionFactory.getSqlSessionFactory();
        SqlSession session = sqlSessionFactory.openSession();
        try {
            return session.selectList("cn.dombro.cloudCall.dao.info.EnterpriseCustomerMapper.getAll");
        } finally {
            session.close();
        }
    }

    public String selectPswByUser(String username) throws IOException {
        SqlSessionFactory sqlSessionFactory = MySqlSessionFactory.getSqlSessionFactory();
        SqlSession session = sqlSessionFactory.openSession();
        try {
            EnterpriseCustomerMapper mapper = session.getMapper(EnterpriseCustomerMapper.class);
            return mapper.selectPswByUser(username);
        } finally {
            session.close();
        }
    }

    public EnterpriseCustomer selectByUser(String username) throws IOException {
        SqlSessionFactory sqlSessionFactory = MySqlSessionFactory.getSqlSessionFactory();
        SqlSession session = sqlSessionFactory.openSession();
        try {
            EnterpriseCustomerMapper mapper = session.getMapper(EnterpriseCustomerMapper.class);
            return mapper.selectByUser(username);
        } finally {
            session.close();
        }
    }

    @Override
    public String getComNameById(Integer ecId) throws IOException {
        SqlSessionFactory sqlSessionFactory = MySqlSessionFactory.getSqlSessionFactory();
        SqlSession session = sqlSessionFactory.openSession();
        try {
            EnterpriseCustomerMapper mapper = session.getMapper(EnterpriseCustomerMapper.class);
            return mapper.getComNameById(ecId);
        } finally {
            session.close();
        }
    }
}
