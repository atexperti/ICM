package org.icm.mail;

import org.apache.log4j.Logger;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

public class MailDispature {

	private static Logger logger = Logger.getLogger(MailDispature.class);
	private MailSender mailSender;
	
	private SimpleMailMessage simpleMailMessage;

	public void setSimpleMailMessage(SimpleMailMessage simpleMailMessage) {
		this.simpleMailMessage = simpleMailMessage;
	}

	public void setMailSender(MailSender mailSender) {
		this.mailSender = mailSender;
	}

	
	public void sendMail(String from, String to, String subject, String msg) {
		try{
		SimpleMailMessage message = new SimpleMailMessage();
		System.out.println("inside send mail");
		message.setFrom(from);
		message.setTo(to);
		message.setSubject(subject);
		message.setText(msg);
		mailSender.send(message);
		}catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}

	
}