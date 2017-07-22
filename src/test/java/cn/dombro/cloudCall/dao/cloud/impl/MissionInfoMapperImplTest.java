package cn.dombro.cloudCall.dao.cloud.impl;

import cn.dombro.cloudCall.entity.MissionInfo;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Author Caole
 * CreateDate: 2017/7/22
 * CreateTime: 11:34
 */

public class MissionInfoMapperImplTest {
    @Test
    public void getClassAndClassifyAndInfoByQueryStamLiKe() throws Exception {
        List<MissionInfo> list = MissionInfoMapperImpl.getInfoMapper().getClassAndClassifyAndInfoByQueryStamLiKe("乐");
        for (MissionInfo info : list){
            System.out.println(info);
        }
    }
}
