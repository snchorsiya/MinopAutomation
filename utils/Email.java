package utils;

import jakarta.activation.DataHandler;
import jakarta.activation.DataSource;
import jakarta.activation.FileDataSource;
import jakarta.mail.*;
import jakarta.mail.internet.*;

import java.util.Properties;

import base.initBase;

public class Email {
	private void Confmail(String to, String cc, String subject, String content, String attachmentPath,
			String signature) {
		final String username = "jenkinsmxface@outlook.com";
		final String password = "Mantra@123"; // Replace with your actual password
		// Set properties
		Properties props = new Properties();
		// Setup mail server
		String host = "smtp-mail.outlook.com";
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", "587");
//        props.put("mail.smtp.auth", "true");
//        props.put("mail.smtp.starttls.enable", "true");
//        props.put("mail.smtp.host", "smtp.gmail.com");
//        props.put("mail.smtp.port", "587");
		// Get session
		Session session = Session.getInstance(props, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});
		try {
			// Create a default MimeMessage object
			Message message = new MimeMessage(session);
			// Set From: header field
			message.setFrom(new InternetAddress(username));
			// Set To: header field
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
			// Set Cc: header field
			if (cc != null && !cc.isEmpty()) {
				message.setRecipients(Message.RecipientType.CC, InternetAddress.parse(cc));
			}
			// Set Subject: header field
			message.setSubject(subject);
			// Create the message part
			BodyPart messageBodyPart = new MimeBodyPart();
			messageBodyPart.setText(content + "\n\n" + signature);
			// Create a multipart message
			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(messageBodyPart);
			// Add attachment
			if (attachmentPath != null && !attachmentPath.isEmpty()) {
				messageBodyPart = new MimeBodyPart();
				DataSource source = new FileDataSource(attachmentPath);
				messageBodyPart.setDataHandler(new DataHandler(source));
				multipart.addBodyPart(messageBodyPart);
//				messageBodyPart.setFileName(attachmentPath);
			}
			// Send the complete message parts
			message.setContent(multipart);
			// Send message
			Transport.send(message);
			System.out.println("Email sent successfully!");
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}

	void SendEmail() {
		boolean SEndEmail = true; // This flag should be set based on your automation scripts' execution
		if (SEndEmail) {
			String sStatus="Passed.";
			if (initBase.totalFail > 0 )
				sStatus="Failed.";
			if (initBase.reportName.contains("Mobile"))
				initBase.browser="Mobile";
			String repNam=initBase.reportName + "-" + initBase.browser + " - " + initBase.testenv.toUpperCase() +
					" ENV, Test suite has " + sStatus + " - " + initBase.executionRunTime;
			String to = "rishikesh.patel@mantratec.com, mayur.jadhav@mantratec.com, sheetal.chorsiya@mantratec.com";
			String cc = "tapan.gandhi@mantratec.com";
			String subject = repNam;
			String content ="";
			content = "Hi,\r\n\n" + " Below is the test plan result.\r\n" + " \r\n"
					+ " \r---------------------------------------------------------------\n";
			content = content + "\rTotal Pass : " + initBase.totalPass + " Total Fail : " + initBase.totalFail
					+ " Total TC : " + (initBase.totalPass + initBase.totalFail);
			content = content + "\r---------------------------------------------------------------\n";
			content = content + "\rRefer Report links: http://192.168.6.201:8000/HTML-" + initBase.executionRunTime + " , for further details.\n";
			String attachmentPath = ""; //".\\test-output\\index.html";
			String signature = "\nRegards,\nAutomation Team";
			Confmail(to, cc, subject, content, attachmentPath, signature);
		}
	}
}