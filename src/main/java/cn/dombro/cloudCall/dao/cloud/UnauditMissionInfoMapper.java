package cn.dombro.cloudCall.dao.cloud;

import cn.dombro.cloudCall.entity.MissionInfo;
import cn.dombro.cloudCall.entity.UnauditMissionInfo;

/**
 * Author Caole
 * CreateDate: 2017/7/16
 * CreateTime: 11:38
 */
public interface UnauditMissionInfoMapper {

    public UnauditMissionInfo selectByPrimaryKey(Integer mId);

    public void deleteByPrimaryKey(Integer mId);

    public void insert(UnauditMissionInfo unauditMissionInfo);

    public void insertSelective(UnauditMissionInfo unauditMissionInfo);

    public void updateByPrimaryKeySelective(Integer mId);

    public void updateByPrimaryKey(Integer mId);
}
