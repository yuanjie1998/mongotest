package com.atminzhi.mongotest.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/*
发送邮件接口
 */
@Component //将EmailClient组件注入bean实例 ,都可以用
public class EmailClient {
    //获取本类的日志
    private static final Logger logger = LoggerFactory.getLogger(EmailClient.class);
    //注入发送邮件接口
    @Autowired
    JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String from;

    public void sendMail(String to,String subject,String content){

        try {
 //        模板
            MimeMessage message = mailSender.createMimeMessage();
//        帮助类构建邮件里详细的内容
            MimeMessageHelper helper = new MimeMessageHelper(message);
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject(subject);
//            true支持发送html文件
//            helper.setText(content,true);
            //发送文本
            helper.setText(content);
            //发送邮件
            mailSender.send(helper.getMimeMessage());
            logger.info("邮件发送成功");
        } catch (MessagingException e) {
           logger.error("发送邮件失败："+e.getMessage());
        }
    }
}
