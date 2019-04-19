package com.example.springframework.bean;

import org.springframework.beans.factory.BeanNameAware;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class MyBeanName implements BeanNameAware {
    @Override
    public void setBeanName(String name) {
        System.out.println(name);
    }
}
