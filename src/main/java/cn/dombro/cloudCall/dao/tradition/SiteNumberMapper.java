package cn.dombro.cloudCall.dao.tradition;

import cn.dombro.cloudCall.entity.MissionInfo;
import cn.dombro.cloudCall.entity.SiteNumber;

import java.io.IOException;

/**
 * Author Caole
 * CreateDate: 2017/7/16
 * CreateTime: 11:37
 */
public interface SiteNumberMapper {

    public SiteNumber selectByPrimaryKey(Integer mId) throws IOException;

    public void deleteByPrimaryKey(Integer mId) throws IOException;

    public void insert(SiteNumber siteNumber) throws IOException;

    public void insertSelective(SiteNumber siteNumber) throws IOException;

    public void updateByPrimaryKeySelective(Integer mId) throws IOException;

    public void updateByPrimaryKey(Integer mId) throws IOException;
}
