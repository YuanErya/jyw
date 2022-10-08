package com.jyw.jywcommon;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.jyw.jywcommon.mapper")
public class JywCommonApplication {

    public static void main(String[] args) {
        SpringApplication.run(JywCommonApplication.class, args);
    }

}
