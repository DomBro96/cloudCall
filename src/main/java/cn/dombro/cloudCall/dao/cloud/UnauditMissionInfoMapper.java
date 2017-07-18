package cn.dombro.cloudCall.dao.cloud;

import cn.dombro.cloudCall.entity.MissionInfo;
import cn.dombro.cloudCall.entity.UnauditMissionInfo;

import java.io.IOException;

/**
 * Author Caole
 * CreateDate: 2017/7/16
 * CreateTime: 11:38
 */
public interface UnauditMissionInfoMapper {

    public UnauditMissionInfo selectByPrimaryKey(Integer mId) throws IOException;

    public void deleteByPrimaryKey(Integer mId) throws IOException;

    public void insert(UnauditMissionInfo unauditMissionInfo) throws IOException;

    public void insertSelective(UnauditMissionInfo unauditMissionInfo) throws IOException;

    public void updateByPrimaryKeySelective(Integer mId) throws IOException;

    public void updateByPrimaryKey(Integer mId) throws IOException;
}
