package com.itheima;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
@EnableScheduling  // 开启定时任务注解功能支持
@SpringBootApplication
public class ItheimaApplication {

    public static void main(String[] args) {
        SpringApplication.run(ItheimaApplication.class, args);
    }
}


