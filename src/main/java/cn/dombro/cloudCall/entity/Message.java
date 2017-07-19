package cn.dombro.cloudCall.entity;

import java.util.Date;

public class Message {
    private Integer msgId;

    private Integer receiverId;

    private String reGroup;

    private Integer sender;

    private String message;

    private Date sendDateTime;

    private Integer readd;

    public Integer getMsgId() {
        return msgId;
    }

    public void setMsgId(Integer msgId) {
        this.msgId = msgId;
    }

    public Integer getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(Integer receiverId) {
        this.receiverId = receiverId;
    }

    public String getReGroup() {
        return reGroup;
    }

    public void setReGroup(String reGroup) {
        this.reGroup = reGroup;
    }

    public Integer getSender() {
        return sender;
    }

    public void setSender(Integer sender) {
        this.sender = sender;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getSendDateTime() {
        return sendDateTime;
    }

    public void setSendDateTime(Date sendDateTime) {
        this.sendDateTime = sendDateTime;
    }

    public Integer getReadd() {
        return readd;
    }

    public void setReadd(Integer readd) {
        this.readd = readd;
    }
}