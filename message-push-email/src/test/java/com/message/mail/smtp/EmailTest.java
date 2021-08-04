package com.message.mail.smtp;

import java.util.Collections;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = Email.class)
public class EmailTest {
  @Value("${mail.recipient}")
  private String recipient;

  @Test
  void testSendFor3Param() throws AddressException, MessagingException {
    Email.send(Collections.singletonList(recipient), "test send email", "I want to send email");
  }
}
