package cn.dombro.cloudCall.dao.info;

import cn.dombro.cloudCall.entity.CustomerService;

<<<<<<< HEAD
import java.io.IOException;

=======
>>>>>>> 623a63babb5d940ee9425adac86e7094fb497b2f
/**
 * Author Caole
 * CreateDate: 2017/7/16
 * CreateTime: 11:41
 */
public interface CustomerServiceMapper {

<<<<<<< HEAD
    public CustomerService selectByPrimaryKey(Integer csId) throws IOException;

    public void deleteByPrimaryKey(Integer csId) throws IOException;

    public void insert(CustomerService customerService) throws IOException;

    public void insertSelective(CustomerService customerService) throws IOException;

    public void updateByPrimaryKeySelective(CustomerService customerService) throws IOException;

    public void updateByPrimaryKey(CustomerService customerService) throws IOException;
=======
    public CustomerService selectByPrimaryKey(Integer csId);

    public void deleteByPrimaryKey(Integer csId);

    public void insert(CustomerService customerService);

    public void insertSelective(CustomerService customerService);

    public void updateByPrimaryKeySelective(CustomerService customerService);

    public void updateByPrimaryKey(CustomerService customerService);
>>>>>>> 623a63babb5d940ee9425adac86e7094fb497b2f
}
