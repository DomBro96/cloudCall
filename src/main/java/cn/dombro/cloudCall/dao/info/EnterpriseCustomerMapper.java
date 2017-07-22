package cn.dombro.cloudCall.dao.info;

import cn.dombro.cloudCall.entity.CustomerService;
import cn.dombro.cloudCall.entity.EnterpriseCustomer;

import java.io.IOException;
import java.util.List;

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

    public List<EnterpriseCustomer> getAll() throws IOException;

    public String selectPswByUser(String username) throws IOException;

    public EnterpriseCustomer selectByUser(String username) throws IOException;

    public String getComNameById(Integer ecId) throws IOException;
}
