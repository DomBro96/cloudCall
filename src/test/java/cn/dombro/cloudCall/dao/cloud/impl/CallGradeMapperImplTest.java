package cn.dombro.cloudCall.dao.cloud.impl;

import cn.dombro.cloudCall.entity.CallGrade;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Author Caole
 * CreateDate: 2017/7/19
 * CreateTime: 14:15
 */

public class CallGradeMapperImplTest {
    @Test
    public void getAll() throws Exception {
        List<CallGrade> callGrade =  CallGradeMapperImpl.getGradeMapper().getAll();
        System.out.println(callGrade);
    }

    @Test
    public void insertTest() throws IOException {
        CallGrade callGrade = new CallGrade(43,21,80,"Good!",85,"Gooooood!",87);
        CallGradeMapperImpl.getGradeMapper().insertSelective(callGrade);
    }
}
