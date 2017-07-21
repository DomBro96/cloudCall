package cn.dombro.cloudCall.dao.info;

import cn.dombro.cloudCall.entity.CustomerService;
import cn.dombro.cloudCall.entity.EnterpriseCustomer;

import java.io.IOException;

/**
 * Author Caole
 * CreateDate: 2017/7/16
 * CreateTime: 11:41
 */
public interface EnterpriseCustomerMapper {

    public EnterpriseCustomer selectByPrimaryKey(Integer ecId) throws IOException;


    public void deleteByPrimaryKey(Integer ecId) throws IOException;

    public void insert(EnterpriseCustomer enterpriseCustomer) throws IOException;

    public void insertSelective(EnterpriseCustomer enterpriseCustomer) throws IOException;

    public void updateByPrimaryKeySelective(Integer ecId) throws IOException;

    public void updateByPrimaryKey(Integer ecId) throws IOException;
}
