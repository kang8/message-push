package com.message.mail.smtp;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.Message.RecipientType;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.message.mail.smtp.config.MailProperties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Email {
    private static MailProperties mail;

    @Autowired
    private Email(MailProperties mail) {
        Email.mail = mail;
    }

    private static final String MIMETYPE_TEXT_HTML_UTF_8 = "text/html; charset=utf-8";

    public static void send(List<String> primaryRecipients, String subject, String content)
            throws AddressException, MessagingException {
        send(primaryRecipients, null, subject, content);
    }

    public static void send(List<String> primaryRecipients, List<String> carbonCopyRecipients, String subject,
            String content) throws AddressException, MessagingException {
        Session session = createSession();
        session.setDebug(mail.isDebug());

        MimeMessage message = new MimeMessage(session);

        message.setFrom(new InternetAddress(mail.getFrom()));
        message.setSubject(subject, StandardCharsets.UTF_8.toString());
        message.setContent(content, MIMETYPE_TEXT_HTML_UTF_8);
        setRecipientsByList(message, Message.RecipientType.TO, primaryRecipients);

        Transport.send(message, mail.getUsername(), mail.getPassword());
    }

    private static void setRecipientsByList(MimeMessage message, RecipientType type, List<String> recipients)
            throws AddressException, MessagingException {
        if (recipients == null) {
            return;
        }

        for (String recipientString : recipients) {
            message.setRecipient(type, new InternetAddress(recipientString));
        }
    }

    private static Session createSession() {
        Properties prop = prepareProperties();

        return Session.getInstance(prop, null);
    }

    private static Properties prepareProperties() {
        Properties props = new Properties();
        props.put("mail.smtp.host", mail.getHost());
        props.put("mail.smtp.port", mail.getPort());
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.ssl.enable", "true");
        return props;
    }
}