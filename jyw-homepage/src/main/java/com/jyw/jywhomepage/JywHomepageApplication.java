package com.jyw.jywhomepage;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.jyw.jywhomepage.mapper")
public class JywHomepageApplication {

    public static void main(String[] args) {
        SpringApplication.run(JywHomepageApplication.class, args);
    }

}
