package cn.dombro.cloudCall.dao.info;

import cn.dombro.cloudCall.entity.CustomerService;
import cn.dombro.cloudCall.entity.SystemAdministrator;

import java.io.IOException;

/**
 * Author Caole
 * CreateDate: 2017/7/16
 * CreateTime: 11:40
 */
public interface SystemAdministratorMapper {

    public SystemAdministrator selectByPrimaryKey(Integer saId) throws IOException;

    public void deleteByPrimaryKey(Integer saId) throws IOException;

    public void insert(SystemAdministrator systemAdministrator) throws IOException;

    public void insertSelective(SystemAdministrator systemAdministrator) throws IOException;

    public void updateByPrimaryKeySelective(Integer saId) throws IOException;

    public void updateByPrimaryKey(Integer saId) throws IOException;
}
