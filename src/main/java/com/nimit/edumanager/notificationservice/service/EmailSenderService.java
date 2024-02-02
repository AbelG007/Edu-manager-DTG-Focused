package com.nimit.edumanager.notificationservice.service;

import com.nimit.edumanager.common.utility.Constants;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Service
@Transactional
public class EmailSenderService {

    public String sendEmail(String email) throws MessagingException, AddressException {

        String senderEmail = Constants.NOTIFICATION_SENDER_EMAIL;
        String senderPassword = Constants.NOTIFICATION_SENDER_PASSWORD;

        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");


        Authenticator authenticator = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(senderEmail, senderPassword);
            }
        };

        Session session = Session.getInstance(properties, authenticator);
        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress(senderEmail));
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
        message.setText("Payment for the current month is due. Please make the payment as soon as possible.");
        Transport.send(message);
        return "Email sent successfully!";
    }

}
