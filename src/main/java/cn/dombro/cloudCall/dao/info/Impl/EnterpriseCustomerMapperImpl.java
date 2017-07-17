package cn.dombro.cloudCall.dao.info.Impl;

import cn.dombro.cloudCall.dao.info.EnterpriseCustomerMapper;
import cn.dombro.cloudCall.entity.EnterpriseCustomer;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

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

    public SqlSessionFactory getSqlSessionFactory() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        return new SqlSessionFactoryBuilder().build(inputStream);
    }

    public EnterpriseCustomer selectByPrimaryKey(Integer ecId) throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession session = sqlSessionFactory.openSession();
        try {

        }finally {
        }
        return null;
    }

    public void deleteByPrimaryKey(Integer ecId) {

    }

    public void insert(EnterpriseCustomer enterpriseCustomer) {

    }

    public void insertSelective(EnterpriseCustomer enterpriseCustomer) {

    }

    public void updateByPrimaryKeySelective(Integer ecId) {

    }

    public void updateByPrimaryKey(Integer ecId) {

    }
}
