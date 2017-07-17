package cn.dombro.cloudCall.dao.cloud;

import cn.dombro.cloudCall.entity.CallMission;
import cn.dombro.cloudCall.entity.CustomerService;

/**
 * Author Caole
 * CreateDate: 2017/7/16
 * CreateTime: 11:39
 */
public interface CallMissionMapper {

    public CallMission selectByPrimaryKey(Long runningId);

    public void deleteByPrimaryKey(Long runningId);

    public void insert(CallMission callMission);

    public void insertSelective(CallMission callMission);

    public void updateByPrimaryKeySelective(Long runningId);

    public void updateByPrimaryKey(Long runningId);
}
