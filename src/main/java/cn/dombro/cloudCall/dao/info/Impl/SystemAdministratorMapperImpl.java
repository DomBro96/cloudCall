package cn.dombro.cloudCall.dao.info.Impl;

import cn.dombro.cloudCall.dao.info.SystemAdministratorMapper;
import cn.dombro.cloudCall.entity.SystemAdministrator;

/**
 * Author Caole
 * CreateDate: 2017/7/17
 * CreateTime: 12:34
 */
public class SystemAdministratorMapperImpl implements SystemAdministratorMapper{

    private static SystemAdministratorMapper administratorMapper = null;
    public static SystemAdministratorMapper getAdministratorMapper(){
        administratorMapper = new SystemAdministratorMapperImpl();
        return  administratorMapper;
    }
    @Override
    public SystemAdministrator selectByPrimaryKey(Integer saId) {
        return null;
    }

    @Override
    public void deleteByPrimaryKey(Integer saId) {

    }

    @Override
    public void insert(SystemAdministrator systemAdministrator) {

    }

    @Override
    public void insertSelective(SystemAdministrator systemAdministrator) {

    }

    @Override
    public void updateByPrimaryKeySelective(Integer saId) {

    }

    @Override
    public void updateByPrimaryKey(Integer saId) {

    }
}
