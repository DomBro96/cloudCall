package cn.dombro.cloudCall.dao.tradition;

import cn.dombro.cloudCall.entity.CallResult;
import cn.dombro.cloudCall.entity.MissionInfo;

/**
 * Author Caole
 * CreateDate: 2017/7/16
 * CreateTime: 11:38
 */
public interface CallResultMapper {

    public CallResult selectByPrimaryKey(Long runningId);

    public void deleteByPrimaryKey(Long runningId);

    public void insert(CallResult callResult);

    public void insertSelective(CallResult callResult);

    public void updateByPrimaryKeySelective(Long runningId);

    public void updateByPrimaryKey(Long runningId);
}
