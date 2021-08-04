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

    @Test
    public void testProperties() {
        assertEquals(587, mail.getPort());
        assertFalse(mail.isDebug());
    }
}
