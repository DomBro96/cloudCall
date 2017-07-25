package cn.dombro.cloudCall.viewobject;

public class Msg {

    String msg;

    String read;

    String msgId;

    public Msg(String msg, String read, String msgId) {
        this.msg = msg;
        this.read = read;
        this.msgId = msgId;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setRead(String read) {
        this.read = read;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }

    public String getMsg() {
        return msg;
    }

    public String getRead() {
        return read;
    }

    public String getMsgId() {
        return msgId;
    }

    @Override
    public String toString() {
        return "Msg{" +
                "msg='" + msg + '\'' +
                ", read='" + read + '\'' +
                ", msgId='" + msgId + '\'' +
                '}';
    }
}
