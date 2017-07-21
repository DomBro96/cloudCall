package cn.dombro.cloudCall.dao.cloud.impl;

import cn.dombro.cloudCall.dao.cloud.MessageMapper;
import cn.dombro.cloudCall.dao.info.CustomerServiceMapper;
import cn.dombro.cloudCall.entity.Message;
import cn.dombro.cloudCall.utils.MySqlSessionFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.io.IOException;
import java.util.List;

/**
 * Author Caole
 * CreateDate: 2017/7/19
 * CreateTime: 12:23
 */
public class MessageMapperImpl implements MessageMapper{

    private static MessageMapper messageMapper = null;
    public static MessageMapper getMessageMapper(){
        messageMapper = new MessageMapperImpl();
        return  messageMapper;
    }

    @Override
    public Message selectByPrimaryKey(Integer msg_id) throws IOException {
        SqlSessionFactory sqlSessionFactory = MySqlSessionFactory.getSqlSessionFactory();
        SqlSession session = sqlSessionFactory.openSession();
        try {
            MessageMapper mapper = session.getMapper(MessageMapper.class);
            return mapper.selectByPrimaryKey(msg_id);
        } finally {
            session.close();
        }
    }


    @Override
    public void deleteByPrimaryKey(Integer msg_id) throws IOException {
        SqlSessionFactory sqlSessionFactory = MySqlSessionFactory.getSqlSessionFactory();
        SqlSession session = sqlSessionFactory.openSession();
        try {
            MessageMapper mapper = session.getMapper(MessageMapper.class);
            mapper.deleteByPrimaryKey(msg_id);
            session.commit();
        } finally {
            session.close();
        }
    }

    @Override
    public void insert(Message message) throws IOException {
        SqlSessionFactory sqlSessionFactory = MySqlSessionFactory.getSqlSessionFactory();
        SqlSession session = sqlSessionFactory.openSession();
        try {
            MessageMapper mapper = session.getMapper(MessageMapper.class);
            mapper.insert(message);
            session.commit();
        } finally {
            session.close();
        }
    }

    @Override
    public void insertSelective(Message message) throws IOException {
        SqlSessionFactory sqlSessionFactory = MySqlSessionFactory.getSqlSessionFactory();
        SqlSession session = sqlSessionFactory.openSession();
        try {
            MessageMapper mapper = session.getMapper(MessageMapper.class);
            mapper.insertSelective(message);
            session.commit();
        } finally {
            session.close();
        }
    }

    @Override
    public void updateByPrimaryKeySelective(Integer msg_id) throws IOException {
        SqlSessionFactory sqlSessionFactory = MySqlSessionFactory.getSqlSessionFactory();
        SqlSession session = sqlSessionFactory.openSession();
        try {
            MessageMapper mapper = session.getMapper(MessageMapper.class);
            mapper.updateByPrimaryKeySelective(msg_id);
            session.commit();
        } finally {
            session.close();
        }
    }

    @Override
    public void updateByPrimaryKey(Integer msg_id) throws IOException {
        SqlSessionFactory sqlSessionFactory = MySqlSessionFactory.getSqlSessionFactory();
        SqlSession session = sqlSessionFactory.openSession();
        try {
            MessageMapper mapper = session.getMapper(MessageMapper.class);
            mapper.updateByPrimaryKey(msg_id);
            session.commit();
        } finally {
            session.close();
        }
    }

    @Override
    public List<Message> getAll() throws IOException {
        SqlSessionFactory sqlSessionFactory = MySqlSessionFactory.getSqlSessionFactory();
        SqlSession session = sqlSessionFactory.openSession();
        try {
            MessageMapper mapper = session.getMapper(MessageMapper.class);
            //List<Message> messages =
            return mapper.getAll();

            //return session.selectList("cn.dombro.cloudCall.dao.cloud.MessageMapper.getAll");
        } finally {
            session.close();
        }
    }

    @Override
    public List<Message> getListByIdGroup(Integer receiverId, String group) throws IOException {
        SqlSessionFactory sqlSessionFactory = MySqlSessionFactory.getSqlSessionFactory();
        SqlSession session = sqlSessionFactory.openSession();
        try {
            MessageMapper mapper = session.getMapper(MessageMapper.class);
            //List<Message> messages =
             return mapper.getListByIdGroup(receiverId, group);
            //return messages;
            //return session.selectList("cn.dombro.cloudCall.dao.cloud.MessageMapper.getListByIdGroup");
        } finally {
            session.close();
        }
    }

    //@Override
    //public void updateReadById(Integer msg_id) throws IOException {
    //    SqlSessionFactory sqlSessionFactory = MySqlSessionFactory.getSqlSessionFactory();
    //    SqlSession session = sqlSessionFactory.openSession();
    //    try {
    //        MessageMapper mapper = session.getMapper(MessageMapper.class);
    //        mapper.updateReadById(msg_id);
    //        session.commit();
    //    } finally {
    //        session.close();
    //    }
    //}


}
