package cn.dombro.cloudCall.dao.info;

import cn.dombro.cloudCall.entity.CustomerService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;
import java.io.InputStream;

import static org.junit.Assert.*;

/**
 * Author Caole
 * CreateDate: 2017/7/16
 * CreateTime: 14:40
 */
public class CustomerServiceMapperTest {

    public SqlSessionFactory getSqlSessionFactory() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        return new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void insert() throws IOException {
        //获取sqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        //获取 sqlSession 对象
        SqlSession session = sqlSessionFactory.openSession(true);
        try {
            //获取接口的实现类对象
            //回味接口自动的创建一个代理对象，代理对象去执行增删改查的方法
            CustomerServiceMapper mapper = session.getMapper(CustomerServiceMapper.class);
            //调用接口的方法
            CustomerService service = new CustomerService(null,"Caole","123456","曹乐",
                    "61032319961028211X",Long.parseLong("17607118701"),"cleeeee@qq.com","account",100);
            mapper.insertSelective(service);
            System.out.println(service);
            //session.commit();
        } finally {
            session.close();
        }
    }

    @Test
    public void update() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession session = sqlSessionFactory.openSession(true);
        try {
            CustomerServiceMapper mapper = session.getMapper(CustomerServiceMapper.class);
            //CustomerService service = new CustomerService(6,"DongBo","5345345","董博",
            //        "61032319961028211X",Long.parseLong("17607118701"),"cleeeee@qq.com","account",100);
            mapper.deleteByPrimaryKey(5);
            //System.out.println(service);
        } finally {
            session.close();
        }
    }

}
