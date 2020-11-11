package com.yaoyuan.jiscuss;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class JiccussApplication {

    public static void main(String[] args) {
        SpringApplication.run(JiccussApplication.class, args);
    }

}
