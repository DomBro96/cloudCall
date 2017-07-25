package cn.dombro.cloudCall.dao.info;

import cn.dombro.cloudCall.entity.CustomerService;
import cn.dombro.cloudCall.entity.SystemAdministrator;

import java.io.IOException;
import java.util.List;

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

    public void updateByPrimaryKeySelective(SystemAdministrator systemAdministrator) throws IOException;

    public void updateByPrimaryKey(SystemAdministrator systemAdministrator) throws IOException;

    public List<SystemAdministrator> getAll() throws IOException;

    public String selectPswByUser(String username) throws IOException;

    public SystemAdministrator selectByUser(String username) throws IOException;
}
