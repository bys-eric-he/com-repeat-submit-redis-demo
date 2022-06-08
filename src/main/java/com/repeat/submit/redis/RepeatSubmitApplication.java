package com.repeat.submit.redis;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class RepeatSubmitApplication {
    public static void main(String[] args) {
        SpringApplication.run(RepeatSubmitApplication.class, args);
        log.info("------------Service RepeatSubmitApplication Start SUCCESS-----");
    }
}
