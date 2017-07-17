package cn.dombro.cloudCall.dao.tradition;

import cn.dombro.cloudCall.entity.MissionInfo;
import cn.dombro.cloudCall.entity.SiteNumber;

/**
 * Author Caole
 * CreateDate: 2017/7/16
 * CreateTime: 11:37
 */
public interface SiteNumberMapper {

    public SiteNumber selectByPrimaryKey(Integer mId);

    public void deleteByPrimaryKey(Integer mId);

    public void insert(SiteNumber siteNumber);

    public void insertSelective(SiteNumber siteNumber);

    public void updateByPrimaryKeySelective(Integer mId);

    public void updateByPrimaryKey(Integer mId);
}
