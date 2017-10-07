package nl.gpesoft.javaee.service.adapter.notification;

import nl.gpesoft.javaee.domain.entity.Developer;
import nl.gpesoft.javaee.domain.port.notify.NotificationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class NotificationRepositoryAdapter implements NotificationRepository {

    Logger logger = LoggerFactory.getLogger(NotificationRepositoryAdapter.class);

    @Override
    public void sendNotification(Developer developer) {

        String mailRecipient = developer.getEmailAddress();
        String from = "SO-meeting@noreply.com";
        String host = "smtp.kpnmail.nl";

        Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host", host);
        Session session = Session.getDefaultInstance(properties);

        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(mailRecipient));
            message.setSubject("SO-meeting 9 oktober 2017 - Hexagonal architecture");
            message.setText("Bedankt voor je aanwezigheid!");

            Transport.send(message);
            logger.info("message sent successfully.");

        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
}