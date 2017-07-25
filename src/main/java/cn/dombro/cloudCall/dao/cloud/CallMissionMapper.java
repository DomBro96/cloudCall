package cn.dombro.cloudCall.dao.cloud;

import cn.dombro.cloudCall.entity.CallMission;
import cn.dombro.cloudCall.entity.CustomerService;

import java.io.IOException;
import java.util.List;

/**
 * Author Caole
 * CreateDate: 2017/7/16
 * CreateTime: 11:39
 */
public interface CallMissionMapper {

    public CallMission selectByPrimaryKey(Long runningId) throws IOException;

    public void deleteByPrimaryKey(Long runningId) throws IOException;

    public void insert(CallMission callMission) throws IOException;

    public void insertSelective(CallMission callMission) throws IOException;

    public void updateByPrimaryKeySelective(CallMission callMission) throws IOException;

    public void updateByPrimaryKey(CallMission callMission) throws IOException;

    public List<CallMission> getAll() throws IOException;

    public List<CallMission> getListRunningIdByMid(Integer mId) throws IOException;

    public CallMission getByMid(Integer mId) throws IOException;
}
