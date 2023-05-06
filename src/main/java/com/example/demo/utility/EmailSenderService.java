package com.example.demo.utility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailSenderService {
	@Autowired
	private JavaMailSender mailSender;
	public boolean sendEmail(String toEmail,String subject,String body)
	{
		SimpleMailMessage msg=new SimpleMailMessage();
		msg.setFrom("prayaspikalmunde@gmail.com");
		msg.setTo("prayaspikalmunde@gmail.com");
		msg.setText(body);
		msg.setSubject(subject);
		mailSender.send(msg);
		System.out.println("Mail sent");
		return true;
	}

}
