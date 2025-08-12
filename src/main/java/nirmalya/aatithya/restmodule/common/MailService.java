package nirmalya.aatithya.restmodule.common;

import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class MailService {
	/*
	 * The Spring Framework provides an easy abstraction for sending email by using
	 * the JavaMailSender interface, and Spring Boot provides auto-configuration for
	 * it as well as a starter module.
	 */
	private JavaMailSender javaMailSender;

	/**
	 * 
	 * @param javaMailSender
	 */
	@Autowired
	public MailService(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}

	/**
	 * This function is used to send mail without attachment.
	 * 
	 * @param user
	 * @throws MailException
	 */

	public void sendEmail(String myEmail, String Subject, String text) throws MailException {
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(myEmail);
		mail.setSubject(Subject);
		mail.setText(text);
		
		System.out.println("myEmail "+myEmail);
		/*
		 * This send() contains an Object of SimpleMailMessage as an Parameter
		 */
		javaMailSender.send(mail);
	}

	/**
	 * This fucntion is used to send mail that contains a attachment.
	 * 
	 * @param user
	 * @throws MailException
	 * @throws MessagingException
	 */
	public void sendEmailWithAttachment(String myEmail, String Subject, String text)
			throws MailException, MessagingException {

		MimeMessage mimeMessage = javaMailSender.createMimeMessage();

		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

		helper.setTo(myEmail);
		helper.setSubject(Subject);
		helper.setText(text);

		ClassPathResource classPathResource = new ClassPathResource("Attachment.pdf");
		helper.addAttachment(classPathResource.getFilename(), classPathResource);

		javaMailSender.send(mimeMessage);
	}
	
	public void sendHtmlEmail(String to, String subject, String htmlContent) throws MessagingException {
	    MimeMessage message = javaMailSender.createMimeMessage();
	    MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

	    helper.setTo(to);
	    helper.setSubject(subject);
	    helper.setText(htmlContent, true);

	    javaMailSender.send(message);
	    System.out.println("HTML Email sent to: " + to);
	}
	//sendEmailOnlyText
			public static void sendEmailOnlyText(String host, String port, final String addresses, final String password,
					List<String> toAddress, List<String> ccAddress, String subject, String message, String urlName,String urlName1)
					throws AddressException, MessagingException {
				
				// sets SMTP server properties
				Properties properties = new Properties();
				properties.put("mail.smtp.host", host);
				properties.put("mail.smtp.port", port);
				properties.put("mail.smtp.auth", "true");
				properties.put("mail.smtp.starttls.enable", "true");
				properties.put("mail.user", addresses);
				properties.put("mail.password", password);

				// creates a new session with an authenticator
				Authenticator auth = new Authenticator() {
					public PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(addresses, password);
					}
				};
				Session session = Session.getInstance(properties, auth);

				// creates a new e-mail message
				Message msg = new MimeMessage(session);

				msg.setFrom(new InternetAddress(addresses));

				InternetAddress[] toAddresses = new InternetAddress[toAddress.size()];
				int counter = 0;
				for (String toAddress1 : toAddress) {
					toAddresses[counter] = new InternetAddress(toAddress1.trim());
					counter++;
				}
				if (ccAddress != null) {
					InternetAddress[] ccAddresses = new InternetAddress[ccAddress.size()];
					int counter1 = 0;
					for (String ccAddress1 : ccAddress) {
						ccAddresses[counter1] = new InternetAddress(ccAddress1.trim());
						counter1++;
					}
					msg.setRecipients(Message.RecipientType.CC, ccAddresses);
				}
				msg.setRecipients(Message.RecipientType.TO, toAddresses);

				msg.setSubject(subject);
				msg.setSentDate(new Date());

				// creates message part
				MimeBodyPart messageBodyPart = new MimeBodyPart();
				//messageBodyPart.setContent(message, "text/plain");
				messageBodyPart.setContent(message, "text/html");  // For HTML formatted email

				// Create the Multipart object to hold the email content
		        MimeMultipart multipart = new MimeMultipart();

		        multipart.addBodyPart(messageBodyPart);

				// sets the multi-part as e-mail's content
				msg.setContent(multipart);

				// sends the e-mail
				Transport.send(msg);

			}
}