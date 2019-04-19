package com.example.springframework.service;

import org.springframework.stereotype.Service;

import com.example.springframework.bean.MyBeanName;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MyService {
    private final MyBeanName myBeanName;
}
