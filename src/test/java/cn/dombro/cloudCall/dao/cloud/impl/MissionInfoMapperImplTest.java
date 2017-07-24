package cn.dombro.cloudCall.dao.cloud.impl;

import cn.dombro.cloudCall.dao.info.Impl.EnterpriseCustomerMapperImpl;
import cn.dombro.cloudCall.entity.MissionInfo;
import cn.dombro.cloudCall.entity.UnauditMissionInfo;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
            System.out.println(info.getEndDate());
        }
    }

    @Test
    public void test() throws IOException {

        List<UnauditMissionInfo> unauditMissionInfoList =  UnauditMissionInfoMapperImpl.getMissionInfoMapper().getListByEcId(1);
        for (UnauditMissionInfo unauditMissionInfo:unauditMissionInfoList){
            System.out.println(unauditMissionInfo);
        }
    }

    @Test
    public void test2() throws IOException {
        String com = EnterpriseCustomerMapperImpl.getCustomerMapper().getComNameById(1);
        System.out.println(com);
    }


}
