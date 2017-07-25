package cn.dombro.cloudCall.dao.cloud.impl;

import cn.dombro.cloudCall.entity.Message;
import cn.dombro.cloudCall.util.MessageUtil;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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

    @Test
    public void messageTest() throws IOException {
        LocalDate endDate = MissionInfoMapperImpl.getInfoMapper().selectByPrimaryKey(1).getEndDate();
        System.out.println(MessageUtil.remindCsByAdmin("按摩",endDate));
    }

    @Test
    public void test() throws IOException {

        LocalDateTime now = LocalDateTime.now().withNano(0);
        Message message = new Message();
        message.setSendDateTime(now);
        MessageMapperImpl.getMessageMapper().insertSelective(message);
    }

    @Test
    public void test3() throws IOException {
        List<Message> messages = MessageMapperImpl.getMessageMapper().getListByIdGroupAndRead(1,"ec",0);
        System.out.println(messages);
    }

}
