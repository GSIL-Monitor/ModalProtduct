package com.huimin.mail;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.huimin.util.LogUtil;


@Service
public class EmailServiceImpl implements EmailService {

	private LogUtil logger = LogUtil.logger(EmailServiceImpl.class);
	@Autowired
	private JavaMailSender mailSender;

	@Value("${spring.mail.username}")
	public String userName;// 发送者

	@Override
	public void sendSimpleMail(String sendTo, String titel, String content) {
		List<String> sendTos = new ArrayList<String>();
		sendTos.add(sendTo);
		sendSimpleMail(sendTos, titel, content);
	}
	
	@Override
	public void sendSimpleMail(List<String> sendTo, String titel, String content) {
		logger.info("开始发送邮件，{} 发送给 {}", userName, sendTo);
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom(userName);
		message.setTo(sendTo.toArray(new String[sendTo.size()]));
		message.setSubject(titel);
		message.setText(content);
		mailSender.send(message);
		logger.info("邮件发送成功，{} 发送给 {}", userName, sendTo);

	}
	
	@Override
	public void sendAttachmentsMail(String sendTo, String titel, String content, Map<String, File> attachments) {
		List<String> sendTos = new ArrayList<String>();
		sendTos.add(sendTo);
		sendAttachmentsMail(sendTos, titel, content, attachments);
	}

	@Override
	public void sendAttachmentsMail(List<String> sendTo, String titel, String content, Map<String, File> attachments) {
		MimeMessage mimeMessage = mailSender.createMimeMessage();  
		logger.info("开始发送邮件，{} 发送给 {}", userName, sendTo);
        try {  
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);  
            helper.setFrom(userName);  
            helper.setTo(sendTo.toArray(new String[sendTo.size()]));  
            helper.setSubject(titel);  
            helper.setText(content);  
            attachments.forEach((name, file) -> {
                try {
					helper.addAttachment(name, new FileSystemResource(file));
				} catch (MessagingException e) {
		    		logger.info("邮件发送失败，{} 发送给 {}", userName, sendTo);
					throw new RuntimeException(e);  				}  
            });
        } catch (Exception e) { 
    		logger.info("邮件发送失败，{} 发送给 {}", userName, sendTo);
            throw new RuntimeException(e);  
        }  
        mailSender.send(mimeMessage); 
		logger.info("邮件发送成功，{} 发送给 {}", userName, sendTo);
	}

	@Override
	public void sendTemplateMail(String sendTo, String titel, String content, Map<String, Workbook> attachments) {
		MimeMessage mimeMessage = mailSender.createMimeMessage();  
		logger.info("开始发送邮件，{} 发送给 {}", userName, sendTo);
        try {  
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);  
            helper.setFrom(userName);  
            helper.setTo(sendTo);  
            helper.setSubject(titel);  
            helper.setText(content);  
            attachments.forEach((name, workBook) -> {
                try {
                	//POI对Excel文件加密	
                	ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    workBook.write(baos);
                    baos.flush();
                    byte[] bt = baos.toByteArray();
                   baos.close();
					helper.addAttachment(name, new ByteArrayResource(bt) );
				} catch (Exception e) {
		    		logger.info("邮件发送失败，{} 发送给 {}", userName, sendTo);
					throw new RuntimeException(e);  				}  
            });
        } catch (Exception e) { 
    		logger.info("邮件发送失败，{} 发送给 {}", userName, sendTo);
            throw new RuntimeException(e);  
        }  
        mailSender.send(mimeMessage); 
		logger.info("邮件发送成功，{} 发送给 {}", userName, sendTo);
	}

}
