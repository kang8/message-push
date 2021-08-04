package com.message;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author kang
 * @date 2021/7/28 11:22
 */
class MainTest extends IntegrationTest {
    @Value("${test.message}")
    private String message;

    @Test
    public void contextLoads() {
        assertEquals("This is test message", message);
    }
}