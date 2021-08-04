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

public class Email {
    private static final String HOST = "smtp.163.com";
    private static final String PORT = "587";
    private static final String USERNAME = "@163.com";
    private static final String PASSWORD = "";
    private static final boolean IS_DEBUG = Boolean.TRUE;

    private static final String MIMETYPE_TEXT_HTML_UTF_8 = "text/html; charset=utf-8";

    public static void send(List<String> primaryRecipients, String subject, String content)
            throws AddressException, MessagingException {
        send(primaryRecipients, null, subject, content);
    }

    public static void send(List<String> primaryRecipients, List<String> carbonCopyRecipients, String subject,
            String content) throws AddressException, MessagingException {
        Session session = createSession();
        session.setDebug(IS_DEBUG);

        MimeMessage message = new MimeMessage(session);

        message.setFrom(new InternetAddress(USERNAME));
        message.setSubject(subject, StandardCharsets.UTF_8.toString());
        message.setContent(content, MIMETYPE_TEXT_HTML_UTF_8);
        setRecipientsByList(message, Message.RecipientType.TO, primaryRecipients);

        Transport.send(message, USERNAME, PASSWORD);
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
        props.put("mail.smtp.host", HOST);
        props.put("mail.smtp.port", PORT);
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.ssl.enable", "true");
        return props;
    }
}