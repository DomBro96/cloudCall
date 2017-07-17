package cn.dombro.cloudCall.dao.cloud;

import cn.dombro.cloudCall.entity.CallMission;
import cn.dombro.cloudCall.entity.MissionInfo;

/**
 * Author Caole
 * CreateDate: 2017/7/16
 * CreateTime: 11:39
 */
public interface MissionInfoMapper {

    public MissionInfo selectByPrimaryKey(Integer mId);

    public void deleteByPrimaryKey(Integer mId);

    public void insert(MissionInfo missionInfo);

    public void insertSelective(MissionInfo missionInfo);

    public void updateByPrimaryKeySelective(Integer mId);

    public void updateByPrimaryKey(Integer mId);
}
