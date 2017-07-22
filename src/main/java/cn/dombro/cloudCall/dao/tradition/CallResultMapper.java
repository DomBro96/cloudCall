package cn.dombro.cloudCall.dao.tradition;

import cn.dombro.cloudCall.entity.CallResult;
import cn.dombro.cloudCall.entity.MissionInfo;

import java.io.IOException;
import java.util.List;

/**
 * Author Caole
 * CreateDate: 2017/7/16
 * CreateTime: 11:38
 */
public interface CallResultMapper {

    public CallResult selectByPrimaryKey(Long runningId) throws IOException;

    public void deleteByPrimaryKey(Long runningId) throws IOException;

    public void insert(CallResult callResult) throws IOException;

    public void insertSelective(CallResult callResult) throws IOException;

    public void updateByPrimaryKeySelective(Long runningId) throws IOException;

    public void updateByPrimaryKey(Long runningId) throws IOException;

    public List<CallResult> getAll() throws IOException;

    public CallResult getRemarkAndResultByRunningId(Long runningId) throws IOException;
}
