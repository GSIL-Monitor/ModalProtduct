package com.huimin.mail;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Workbook;
/**
 * 邮件服务
 * @author zhuliang
 *
 * @Date 2018年7月11日下午2:30:05
 */
public interface EmailService {
	 /** 
     * 发送简单邮件 
     * @param sendTo 收件人地址 
     * @param titel  邮件标题 
     * @param content 邮件内容 
     */  
    public void sendSimpleMail(String sendTo, String titel, String content);  
  
    /** 
     * 发送简单邮件 
     * @param sendTo 收件人地址  群发
     * @param titel  邮件标题 
     * @param content 邮件内容 
     */  
    public void sendSimpleMail(List<String> sendTo, String titel, String content);  
      
    /** 
     * 发送简单邮件 
     * @param sendTo 收件人地址 
     * @param titel  邮件标题 
     * @param content 邮件内容 
     * @param attachments<文件名，附件> 附件列表 
     */  
    public void sendAttachmentsMail(String sendTo, String titel, String content, Map<String, File> attachments);  
    /** 
     * 发送简单邮件 
     * @param sendTo 收件人地址  群发
     * @param titel  邮件标题 
     * @param content 邮件内容 
     * @param attachments<文件名，附件> 附件列表 
     */  
    public void sendAttachmentsMail(List<String> sendTo, String titel, String content, Map<String, File> attachments);  
      
    /** 
     * 发送模板邮件 
     * @param sendTo 收件人地址 
     * @param titel  邮件标题 
     * @param attachments<文件名，附件> 附件列表  发送生成的Excel
     */  
    public void sendTemplateMail(String sendTo, String titel, String content,  Map<String, Workbook> attachments);  
}
