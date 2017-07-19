package cn.dombro.cloudCall.dao.info.Impl;


import cn.dombro.cloudCall.dao.cloud.impl.CallGradeMapperImpl;
import cn.dombro.cloudCall.entity.CustomerService;
import org.junit.Test;

import java.io.IOException;

/**
 * Author Caole
 * CreateDate: 2017/7/16
 * CreateTime: 16:27
 */

public class CustomerServiceMapperImplTest {
    @Test
    public void insertTest() throws Exception {
        CustomerService customerService = new CustomerService(null,"caole","123456","曹乐",
                "61032319961028211X",Long.parseLong("17607118701"),"cleeeee@qq.com","account",100);
        CustomerServiceMapperImpl.getServiceMapper().insertSelective(customerService);
    }

    @Test
    public void deleteByPrimaryKeyTest() throws IOException {
        CustomerServiceMapperImpl.getServiceMapper().deleteByPrimaryKey(7);
    }

    @Test
    public void selectByPrimaryKeyTest() throws IOException {
        CustomerService customerService = CustomerServiceMapperImpl.getServiceMapper().selectByPrimaryKey(8);
        System.out.println(customerService);
    }

    @Test
    public void updateByPrimaryKeyTest() throws IOException {
        CustomerService customerService = new CustomerService(6,"caole","123456","曹乐",
                "61032319961028211X",Long.parseLong("17607118701"),"cleeeee@qq.com","account",100);
        CustomerServiceMapperImpl.getServiceMapper().updateByPrimaryKey(customerService);
    }
}
