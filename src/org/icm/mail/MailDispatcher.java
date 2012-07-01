package org.icm.mail;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

public class MailDispatcher {

	private static Logger logger = Logger.getLogger(MailDispatcher.class);
	private JavaMailSender mailSender;

	private SimpleMailMessage simpleMailMessage;

	public void setSimpleMailMessage(SimpleMailMessage simpleMailMessage) {
		this.simpleMailMessage = simpleMailMessage;
	}

	public void setMailSender(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}

	public boolean sendMail(String msg) {

		logger.debug("In MailDispatcher.sendMail2()");
		MimeMessage message = mailSender.createMimeMessage();
		try {
			MimeMessageHelper helper = new MimeMessageHelper(message, true);
			helper.setFrom(simpleMailMessage.getFrom());
			if (simpleMailMessage.getTo() != null && simpleMailMessage.getTo().length > 0) {
				helper.setTo(simpleMailMessage.getTo());
			}
			if (simpleMailMessage.getCc() != null && simpleMailMessage.getCc().length > 0) {
				helper.setCc(simpleMailMessage.getCc());
			}
			if (simpleMailMessage.getBcc() != null && simpleMailMessage.getBcc().length > 0) {
				helper.setBcc(simpleMailMessage.getBcc());
			}
			helper.setSubject(simpleMailMessage.getSubject());
			helper.setText(msg);
			mailSender.send(message);
		} catch (MessagingException e) {
			logger.error("Error occured while sending mail" + e);
			return false;
		} catch (Exception e) {
			logger.error("Error occured while sending mail" + e);
			return false;
		}
		logger.debug("Finished mail sending task");
		return true;
	}
}
