package com.crowd.funding.module.controller.constants;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class CrowdFundingMail {
	
	public static void crowdFundingMailSending(Session session, String mailSubject, String mailBody, String sendMailTo){
		   
		try {
			  MimeMessage message = new MimeMessage(session);
			  message.addHeader("Content-type", "text/HTML; charset=UTF-8");
			  message.addHeader("format", "flowed");
			  message.addHeader("Content-Transfer-Encoding", "8bit");
		      message.setFrom(new InternetAddress("crowdfundasia@gmail.com", "Crowd Funding"));
		      message.setReplyTo(InternetAddress.parse("crowdfundasia@gmail.com", false));
		      message.setSubject(mailSubject, "UTF-8");
		      message.setText(mailBody, "UTF-8");
		      message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(sendMailTo, false));
		      Transport.send(message);
			  
		   } catch (Exception e) {
				e.printStackTrace();
			}
		}
	
	public static void sendMail(String mailSubject, String mailBody, String sendMailTo){
		    
				final String fromEmail = "crowdfundasia@gmail.com"; //requires valid gmail id
				final String password = "Prakat@123"; // correct password for gmail id
				
				Properties props = new Properties();
				props.put("mail.smtp.host", "smtp.gmail.com"); 
				props.put("mail.smtp.port", "587"); 
				props.put("mail.smtp.auth", "true"); 
				props.put("mail.smtp.starttls.enable", "true"); 
				
				Session session = Session.getInstance(props, new javax.mail.Authenticator() {
				    protected PasswordAuthentication getPasswordAuthentication() {
				        return new PasswordAuthentication(fromEmail, password);
				    }
				});
				crowdFundingMailSending(session, mailSubject, mailBody, sendMailTo);
	}
}
