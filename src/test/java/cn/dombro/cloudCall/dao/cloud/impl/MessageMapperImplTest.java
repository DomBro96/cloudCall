package cn.dombro.cloudCall.dao.cloud.impl;

import cn.dombro.cloudCall.entity.Message;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Author Caole
 * CreateDate: 2017/7/21
 * CreateTime: 13:38
 */

public class MessageMapperImplTest {

    @Test
    public void getListByIdGroupTest() throws IOException {
        List<Message> list = MessageMapperImpl.getMessageMapper().getListByIdGroup(1,"ec");
        for (Message message : list){
            System.out.println(message);
        }
    }

}
