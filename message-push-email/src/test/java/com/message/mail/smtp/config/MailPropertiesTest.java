package com.message.mail.smtp.config;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MailPropertiesTest {

    @Autowired
    private MailProperties mail;

    private static MailProperties staticMail;

    @Autowired
    private MailPropertiesTest(MailProperties mail) {
        MailPropertiesTest.staticMail = mail;
    }

    @Test
    public void testProperties() {
        assertEquals(587, mail.getPort());
        assertFalse(mail.isDebug());
    }

    @Test
    public void testPropertiesForStaticVariable() {
        assertEquals(587, staticMail.getPort());
        assertFalse(mail.isDebug());
    }
}
