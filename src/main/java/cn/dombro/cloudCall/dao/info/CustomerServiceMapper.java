package cn.dombro.cloudCall.dao.info;

import cn.dombro.cloudCall.entity.CustomerService;

/**
 * Author Caole
 * CreateDate: 2017/7/16
 * CreateTime: 11:41
 */
public interface CustomerServiceMapper {

    public CustomerService selectByPrimaryKey(Integer csId);

    public void deleteByPrimaryKey(Integer csId);

    public void insert(CustomerService customerService);

    public void insertSelective(CustomerService customerService);

    public void updateByPrimaryKeySelective(CustomerService customerService);

    public void updateByPrimaryKey(CustomerService customerService);
}
