package com.example.springframework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.ComponentScan;

import com.example.springframework.service.MyService;

import lombok.RequiredArgsConstructor;

@SpringBootConfiguration
@ComponentScan("com.example.springframework")
@RequiredArgsConstructor
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    private final MyService myService;
}
