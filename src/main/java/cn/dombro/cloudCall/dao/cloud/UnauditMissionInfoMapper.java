package cn.dombro.cloudCall.dao.cloud;

import cn.dombro.cloudCall.entity.UnauditMissionInfo;

import java.io.IOException;
import java.util.List;

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

    public void updateByPrimaryKeySelective(UnauditMissionInfo unauditMissionInfo) throws IOException;

    public void updateByPrimaryKey(UnauditMissionInfo unauditMissionInfo) throws IOException;

    public List<UnauditMissionInfo> getAll() throws IOException;

    public List<UnauditMissionInfo> getListByNameAndClassLike(String queryStatement) throws IOException;

    public List<UnauditMissionInfo> getListByEcId(Integer ecId) throws IOException;

    public int getAuditStatusNumByEcId(Integer ecId) throws IOException;

    public int getAuditStatusNumByAuditStatus(Integer auditStatus) throws IOException;
}
