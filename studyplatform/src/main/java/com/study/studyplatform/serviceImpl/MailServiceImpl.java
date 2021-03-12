package com.study.studyplatform.serviceImpl;

import com.study.studyplatform.service.MailService;
import org.mybatis.logging.Logger;
import org.mybatis.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@Service
public class MailServiceImpl implements MailService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private JavaMailSender mailSender;
    /**
     * 配置文件中我的163邮箱
     */
    @Value("823246120@qq.com")
    private String from;

    /**
     * 发送HTML邮件
     * @param to 收件者
     * @param subject 邮件主题
     * @param content 文本内容
     */
    @Override
    public void sendHtmlMail(String to,String subject,String content) {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = null;
        try {
            helper = new MimeMessageHelper(message, true);
            helper.setFrom(from);
            helper.setTo(subject);
            helper.setTo(to);
            helper.setText(content, true);
            mailSender.send(message);

//            String[] copyto={"itboys_feipeng@163.com"};
//            if(copyto!= null&&copyto.length>0){
//                String ccListStr=getMailList(copyto);
//                message.setRecipients(MimeMessage.RecipientType.CC, InternetAddress.parse(ccListStr));
//            }

        } catch (MessagingException e) {
            e.getNextException();
        }
    }

//    public static String getMailList(String[] mailArray) {
//        StringBuffer toList = new StringBuffer();
//        int length = mailArray.length;
//        if (mailArray != null &&length<2) {
//            toList.append(mailArray[0]);
//        } else {
//            for (int i = 0; i<length; i++) {
//                toList.append(mailArray[i]);
//                if (i != (length - 1)) {
//                    toList.append(",");
//                }
//
//            }
//        }
//        return toList.toString();
//    }
}
