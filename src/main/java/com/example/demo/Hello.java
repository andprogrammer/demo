package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {
//    https://github.com/mkyong/java-logging/blob/master/slf4j-logback/src/main/resources/logback.xml
    private static final Logger logger = LoggerFactory.getLogger(Hello.class);

    @Value("${envname}")
    private String envname;

    @GetMapping("/hello")
    public String hello() {
        logger.info("Request from /hello");
        return "hello " + envname;
    }

    @GetMapping("/world")
    public String world() {
        logger.info("Request from /world");
        return "world";
    }
}
