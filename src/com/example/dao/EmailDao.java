package com.example.dao;

import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.example.model.EmailClient;

public class EmailDao {
	static EmailClient emailClient = new EmailClient();

	public void sendAsHtml(String to, String subject, String messages) throws MessagingException {
		System.out.println("Sending email to " + to);
		Session session = createSession();

		MimeMessage mimeMessage = new MimeMessage(session);
		prepareEmailMessage(mimeMessage, to, subject, messages);
	}

	private static void prepareEmailMessage(MimeMessage mimeMessage, String to, String subject, String messages)
			throws MessagingException {
		mimeMessage.setContent(messages, "text/html");
		mimeMessage.setFrom(new InternetAddress(emailClient.getSenderEmail()));
		mimeMessage.setRecipients(MimeMessage.RecipientType.TO, InternetAddress.parse(to));
		mimeMessage.setSubject(subject);
		Transport.send(mimeMessage);
	}

	private static Session createSession() {
		Properties props = System.getProperties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.starttls.enable", "true"); // enable STARTTLS

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new javax.mail.PasswordAuthentication(emailClient.getSenderEmail(),
						emailClient.getSenderPassword());
			}
		});

		return session;

	}

}
