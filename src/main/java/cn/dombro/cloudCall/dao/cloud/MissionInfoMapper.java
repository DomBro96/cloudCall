package cn.dombro.cloudCall.dao.cloud;

import cn.dombro.cloudCall.entity.CallMission;
import cn.dombro.cloudCall.entity.MissionInfo;

import java.io.IOException;
import java.util.List;

/**
 * Author Caole
 * CreateDate: 2017/7/16
 * CreateTime: 11:39
 */
public interface MissionInfoMapper {

    public MissionInfo selectByPrimaryKey(Integer mId) throws IOException;

    public void deleteByPrimaryKey(Integer mId) throws IOException;

    public void insert(MissionInfo missionInfo) throws IOException;

    public void insertSelective(MissionInfo missionInfo) throws IOException;

    public void updateByPrimaryKeySelective(Integer mId) throws IOException;

    public void updateByPrimaryKey(Integer mId) throws IOException;

    public List<MissionInfo> getAll() throws IOException;
}
