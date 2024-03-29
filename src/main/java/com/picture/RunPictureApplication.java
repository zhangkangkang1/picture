package com.picture;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * author zk
 * date 2022/7/12 15:19
 */
@SpringBootApplication
@EnableScheduling
public class RunPictureApplication {
    public static void main(String[] args) {
        SpringApplication.run(RunPictureApplication.class, args);
    }
}
