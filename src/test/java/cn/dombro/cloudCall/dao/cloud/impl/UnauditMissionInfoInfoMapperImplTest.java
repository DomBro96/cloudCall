package cn.dombro.cloudCall.dao.cloud.impl;


import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Author Caole
 * CreateDate: 2017/7/24
 * CreateTime: 16:18
 */

public class UnauditMissionInfoInfoMapperImplTest {
    @Test
    public void getAuditStatusNumByEcId() throws Exception {
        int num =  UnauditMissionInfoMapperImpl.getMissionInfoMapper().getAuditStatusNumByEcId(1);
        System.out.println(num);
    }



}
