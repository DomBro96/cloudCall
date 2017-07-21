package cn.dombro.cloudCall.dao.info.Impl;


import cn.dombro.cloudCall.dao.cloud.impl.CallGradeMapperImpl;
import cn.dombro.cloudCall.dao.info.CustomerServiceMapper;
import cn.dombro.cloudCall.entity.CustomerService;
import cn.dombro.cloudCall.utils.PageHelper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

/**
 * Author Caole
 * CreateDate: 2017/7/16
 * CreateTime: 16:27
 */

public class CustomerServiceMapperImplTest {
    @Test
    public void insertTest() throws Exception {
        CustomerService customerService = new CustomerService(null,"12","123456","曹乐",
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

    @Test
    public void getAllTest() throws IOException {
        PageHelper.startPage(5,3);
        List<CustomerService> list = CustomerServiceMapperImpl.getServiceMapper().getAll();
        for (CustomerService service : list){
            System.out.println(service);
        }
        PageInfo<CustomerService> pageInfo = new PageInfo<CustomerService>(list);
        System.out.println(pageInfo.getTotal());
    }

    @Test
    public void selectPswByUserTest() throws IOException {
        String password = CustomerServiceMapperImpl.getServiceMapper().selectPswByUser("曹乐");
        System.out.println(password);
    }

    @Test
    public void selectByUser() throws IOException {
        CustomerService customerService = CustomerServiceMapperImpl.getServiceMapper().selectByUser("曹乐");
        System.out.println(customerService);
    }
}
