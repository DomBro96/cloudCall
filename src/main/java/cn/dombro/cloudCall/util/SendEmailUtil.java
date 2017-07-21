package cn.dombro.cloudCall.util;

import com.jfinal.kit.PropKit;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.HtmlEmail;
import org.apache.commons.mail.MultiPartEmail;
import org.apache.commons.mail.SimpleEmail;

import javax.mail.internet.MimeUtility;

public class SendEmailUtil {
    // smtp服务器
    private static String hostName = PropKit.use("email_config.properties").get("email_hostName");
    // 帐号与密码
    private static String userName = PropKit.use("email_config.properties").get("email_userName");
    //授权码
    private static String authorization = PropKit.use("email_config.properties").get("email_authorization");
    // 发件人
    private static String fromAddress =  PropKit.use("email_config.properties").get("email_fromAddress");
    // 发件人姓名
    private static String fromName =  PropKit.use("email_config.properties").get("email_fromName");
    //stmp 服务器 端口
    private static String port = PropKit.use("email_config.properties").get("email_stmPort");



    // 发送简单邮件，类似一条信息
    public static void sendSimpleEmail(String toAddress, String toName,String subject,String message) throws Exception {
        SimpleEmail email = new SimpleEmail();
        // 设置smtp服务器
        email.setHostName(hostName);
        // 设置授权信息
        email.setAuthentication(userName, authorization);
        email.setCharset("utf-8");
        // 设置发件人信息
        email.setFrom(fromAddress, fromName, "utf-8");
        //email.setSSLOnConnect(true);
        email.setSmtpPort(Integer.parseInt(port));
        // 设置收件人信息
        email.addTo(toAddress, toName, "utf-8");
        // 设置主题
        email.setSubject(subject);
        // 设置邮件内容
        email.setMsg(message);
        email.send();// 发送邮件
    }
    // 发送Html内容的邮件
    public static void sendHtmlEmail(String toAddress, String toName,String htmlMessage,String subject) throws Exception {
        HtmlEmail email = new HtmlEmail();
        email.setHostName(hostName);
        email.setAuthentication(userName, authorization);
        email.setCharset("utf-8");
        email.addTo(toAddress, toName, "utf-8");
        email.setFrom(fromAddress, fromName, "utf-8");
        email.setSmtpPort(Integer.parseInt(port));
        email.setSubject(subject);
        // 设置html内容，实际使用时可以从文本读入写好的html代码
        email.setHtmlMsg(htmlMessage);
        email.send();
    }

    public static void sendMultiPartEmail(String toAddress, String toName,String subject,String message,String filepath,String attachmentName) throws Exception {
        MultiPartEmail email = null;
        email = new MultiPartEmail();
        email.setHostName(hostName);
        email.setAuthentication(userName, authorization);
        email.setCharset("utf-8");
        email.addTo(toAddress, toName, "utf-8");
        email.setFrom(fromAddress, fromName, "utf-8");
        email.setSmtpPort(Integer.parseInt(port));
        email.setSubject(subject);
        email.setMsg(message);
        // 为邮件添加附加内容
        EmailAttachment attachment = new EmailAttachment();
        attachment.setPath(filepath);// 本地文件
        //attachment.setURL(new URL("http://xxx/a.gif"));//远程文件
        attachment.setDisposition(EmailAttachment.ATTACHMENT);
        attachment.setDescription("描述信息");
        // 设置附件显示名字，必须要编码，不然中文会乱码
        attachment.setName(MimeUtility.encodeText(attachmentName));
        // 将附件添加到邮件中
        email.attach(attachment);
        email.send();
    }
}
