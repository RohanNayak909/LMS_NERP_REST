package nirmalya.aatithya.restmodule.common;

import java.util.Date;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;

@Service
public class MailService {

    /*
     * The Spring Framework provides an easy abstraction for sending email by using
     * the JavaMailSender interface, and Spring Boot provides auto-configuration for
     * it as well as a starter module.
     */
    private final JavaMailSender javaMailSender;
    private final String from;
    private final String fromName;

    /**
     * Inject JavaMailSender + Environment to derive From header
     */
    @Autowired
    public MailService(JavaMailSender javaMailSender, Environment env) {
        this.javaMailSender = javaMailSender;
        this.from = env.getProperty("app.mail.from",
                env.getProperty("spring.mail.username", "info@ducisgroup.com"));
        this.fromName = env.getProperty("app.mail.fromName", "Ducis Group");
    }

    /**
     * Send plain-text mail (no attachment)
     */
    public void sendEmail(String myEmail, String subject, String text) throws MailException {
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(myEmail);
        mail.setSubject(subject);
        mail.setText(text);
        mail.setFrom(String.format("%s <%s>", fromName, from));

        System.out.println("myEmail " + myEmail);
        javaMailSender.send(mail);
    }

    /**
     * Send mail with a static PDF attachment (example)
     */
    public void sendEmailWithAttachment(String myEmail, String subject, String text)
            throws MailException, MessagingException {

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

        helper.setTo(myEmail);
        helper.setSubject(subject);
        helper.setText(text);
        helper.setFrom(String.format("%s <%s>", fromName, from));

        ClassPathResource classPathResource = new ClassPathResource("Attachment.pdf");
        helper.addAttachment(classPathResource.getFilename(), classPathResource);

        javaMailSender.send(mimeMessage);
    }

    /**
     * Send HTML email using configured from-address.
     * NOTE: 'from' parameter is kept for backward compatibility but ignored.
     */
    public void sendHtmlEmail(String to, String subject, String htmlContent, String fromIgnored)
            throws MessagingException {

        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(htmlContent, true);
        helper.setFrom(String.format("%s <%s>", fromName, from));

        javaMailSender.send(message);
        System.out.println("HTML Email sent to: " + to);
    }

    /**
     * Deprecated manual SMTP method – disables custom host/user/password usage
     * so everything goes via Spring's JavaMailSender (Office 365 config).
     */
    public static void sendEmailOnlyText(
            String host,
            String port,
            final String addresses,
            final String password,
            List<String> toAddress,
            List<String> ccAddress,
            String subject,
            String message,
            String urlName,
            String urlName1) throws AddressException, MessagingException {

        throw new UnsupportedOperationException(
                "Deprecated: sendEmailOnlyText is disabled. Use JavaMailSender-based methods instead.");
    }
}
