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

    public void insert(EnterpriseCustomer enterpriseCustomer);

    public void insertSelective(EnterpriseCustomer enterpriseCustomer);

    public void updateByPrimaryKeySelective(Integer ecId);

    public void updateByPrimaryKey(Integer ecId);
}
