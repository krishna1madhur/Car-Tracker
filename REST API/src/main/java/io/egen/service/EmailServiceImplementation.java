package io.egen.service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Service;

import io.egen.entity.Alert;
import io.egen.entity.Reading;
import io.egen.entity.Vehicle;
import io.egen.exception.MailNotSentException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

@Service
public class EmailServiceImplementation implements EmailService {

	@Autowired
	private JavaMailSender mailSender;

	public void sendEmail(Vehicle vehicle, Reading reading, Alert alert) {

		MimeMessage mimeMessage = mailSender.createMimeMessage();
		MimeMessageHelper mailMsg = new MimeMessageHelper(mimeMessage);

		String mailSubject = "Alert from Car Tracker: " + alert.getPriorityValue();
		String messageBody = "\n" + alert.getAlertType() + ":\t" + alert.getPriorityValue() + "\n\n" + vehicle + "\n\n"
				+ reading;

		try {
			mailMsg.setFrom("kmkrishna1madhur@gmail.com");
			mailMsg.setTo("kmkrishna1madhur@gmail.com");
			mailMsg.setSubject(mailSubject);
			mailMsg.setText(messageBody);
			mailSender.send(mimeMessage);

		} catch (MessagingException e) {
			throw new MailNotSentException("There is a problem while sending alerts to customer");
		}

	}
}
