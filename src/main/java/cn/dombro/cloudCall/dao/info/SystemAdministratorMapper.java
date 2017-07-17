package cn.dombro.cloudCall.dao.info;

import cn.dombro.cloudCall.entity.CustomerService;
import cn.dombro.cloudCall.entity.SystemAdministrator;

/**
 * Author Caole
 * CreateDate: 2017/7/16
 * CreateTime: 11:40
 */
public interface SystemAdministratorMapper {

    public SystemAdministrator selectByPrimaryKey(Integer saId);

    public void deleteByPrimaryKey(Integer saId);

    public void insert(SystemAdministrator systemAdministrator);

    public void insertSelective(SystemAdministrator systemAdministrator);

    public void updateByPrimaryKeySelective(Integer saId);

    public void updateByPrimaryKey(Integer saId);
}
