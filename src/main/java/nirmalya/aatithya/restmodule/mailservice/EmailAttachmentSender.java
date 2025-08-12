package nirmalya.aatithya.restmodule.mailservice;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.URLDataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class EmailAttachmentSender {
	
	static Logger logger = LoggerFactory.getLogger(EmailAttachmentSender.class);

	/**
	 * @author Pankaj Kumar
	 * @param host
	 * @param port
	 * @param addresses
	 * @param password
	 * @param toAddress
	 * @param ccAddress
	 * @param bccAddress
	 * @param subject
	 * @param message
	 * @param attachURL
	 * @param attachURLName
	 * @throws AddressException
	 * @throws MessagingException
	 * @apiNote Email with attachment
	 */
	
	public static void sendEmailWithAttachmentsURLS(String host, String port, final String addresses,
			final String password, List<String> toAddress, List<String> ccAddress,List<String> bccAddress, String subject, String message,
			String attachURL, String attachURLName) {
	
		System.out.println("host@@@" + host);
		System.out.println(port);
		System.out.println(addresses);
		System.out.println(password);
		System.out.println(toAddress);
		System.out.println(attachURL);
		System.out.println(attachURLName);
	
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
	
		try {
			msg.setFrom(new InternetAddress(addresses));
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		InternetAddress[] toAddresses = new InternetAddress[toAddress.size()];
		int counter = 0;
		for (String toAddress1 : toAddress) {
			try {
				toAddresses[counter] = new InternetAddress(toAddress1.trim());
			} catch (AddressException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			counter++;
		}
		if (ccAddress != null && ccAddress.size() > 0) {
			InternetAddress[] ccAddresses = new InternetAddress[ccAddress.size()];
			int counter1 = 0;
			for (String ccAddress1 : ccAddress) {
				System.out.print(ccAddress1);
				try {
					ccAddresses[counter1] = new InternetAddress(ccAddress1.trim());
				} catch (AddressException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				counter1++;
			}
			try {
				msg.setRecipients(Message.RecipientType.CC, ccAddresses);
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if (bccAddress != null && bccAddress.size() > 0) {
	        InternetAddress[] bccAddresses = new InternetAddress[bccAddress.size()];
	        int counter2 = 0;
	        for (String bccAddress1 : bccAddress) {
	            try {
					bccAddresses[counter2] = new InternetAddress(bccAddress1.trim());
				} catch (AddressException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	            counter2++;
	        }
	        try {
				msg.setRecipients(Message.RecipientType.BCC, bccAddresses);
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
		try {
			msg.setRecipients(Message.RecipientType.TO, toAddresses);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		try {
			msg.setSubject(subject);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			msg.setSentDate(new Date());
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	
	//			// creates message part
		MimeBodyPart messageBodyPart = new MimeBodyPart();
		try {
			messageBodyPart.setContent(message, "text/html");
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
			// Create the Multipart object to hold the email content
			MimeMultipart multipart = new MimeMultipart();
	
			try {
				multipart.addBodyPart(messageBodyPart);
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
		if(attachURL != null && attachURLName != null && !attachURLName.isEmpty() && !attachURL.isEmpty()) {
			logger.info("Hello Pankaj");
			// Create the attachment part
			BodyPart attachmentPart = new MimeBodyPart();
			DataSource source = null;
			try {
				source = new URLDataSource(new URL(attachURL));
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				attachmentPart.setDataHandler(new DataHandler(source));
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// attachmentPart.setFileName("Attachment");
			try {
				attachmentPart.setFileName(attachURLName);
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				multipart.addBodyPart(attachmentPart);
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
			
		}
		// sets the multi-part as e-mail's content
		try {
			msg.setContent(multipart);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		// sends the e-mail
		
		try {
			msg.setHeader("Priority", "low");
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		try {
			Transport.send(msg);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
