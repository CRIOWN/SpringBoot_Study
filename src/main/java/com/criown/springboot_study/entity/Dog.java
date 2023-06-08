package com.criown.springboot_study.entity;


import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Data
public class Dog {
    @Value("旺财")
    private String name;
    @Value("13")
    private Integer age;

}
