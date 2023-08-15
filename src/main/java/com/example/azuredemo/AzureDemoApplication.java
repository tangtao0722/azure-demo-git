package com.example.azuredemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.azuredemo.**.mapper")
public class AzureDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(AzureDemoApplication.class, args);
    }

}
