package com.jieshun.handle;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.jieshun.handle.dao")
public class HandleApplication {

    public static void main(String[] args) {
        SpringApplication.run(HandleApplication.class, args);
        System.out.println("启动完成...");
    }
}
