package com.dk.location.Util;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;


@Component
public class EmailUtilImpl implements EmailUtil {

	
	@Autowired
	private JavaMailSenderImpl sender;
	
	@Override
	public void sendEmail(String toAddress, String Subject, String body) {
 
		MimeMessage message = sender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);
		
		try {
			helper.setTo(toAddress);
			helper.setText(body);
			helper.setSubject(Subject);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
				
		
		sender.send(message);
	}

}
