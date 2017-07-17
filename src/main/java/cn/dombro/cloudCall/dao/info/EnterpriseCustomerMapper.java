package cn.dombro.cloudCall.dao.info;

import cn.dombro.cloudCall.entity.CustomerService;
import cn.dombro.cloudCall.entity.EnterpriseCustomer;

<<<<<<< HEAD
import java.io.IOException;

=======
>>>>>>> 623a63babb5d940ee9425adac86e7094fb497b2f
/**
 * Author Caole
 * CreateDate: 2017/7/16
 * CreateTime: 11:41
 */
public interface EnterpriseCustomerMapper {

<<<<<<< HEAD
    public EnterpriseCustomer selectByPrimaryKey(Integer ecId) throws IOException;
=======
    public EnterpriseCustomer selectByPrimaryKey(Integer ecId) throws IOException;
>>>>>>> 623a63babb5d940ee9425adac86e7094fb497b2f

    public void deleteByPrimaryKey(Integer ecId);

    public void insert(EnterpriseCustomer enterpriseCustomer);

    public void insertSelective(EnterpriseCustomer enterpriseCustomer);

    public void updateByPrimaryKeySelective(Integer ecId);

    public void updateByPrimaryKey(Integer ecId);
}
