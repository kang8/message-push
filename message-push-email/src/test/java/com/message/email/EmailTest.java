package com.message.email;

import java.util.Collections;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = Email.class)
public class EmailTest {

  @Test
  void testSendFor3Param() throws AddressException, MessagingException {
    Email.send(Collections.singletonList("@qq.com"), "test send email", "I want to send email");
  }
}
