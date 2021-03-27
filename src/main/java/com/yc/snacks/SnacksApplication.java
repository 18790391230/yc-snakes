package com.yc.snacks;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackages = "com.yc.snacks.mapper")
@SpringBootApplication
public class SnacksApplication {

    public static void main(String[] args) {
        SpringApplication.run(SnacksApplication.class, args);
    }

}
