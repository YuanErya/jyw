package com.jyw.jywdouble;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.jyw.jywdouble.mapper")
public class JywDoubleApplication {

    public static void main(String[] args) {
        SpringApplication.run(JywDoubleApplication.class, args);
    }

}
