package com.criown.springboot_study;

import com.criown.entity.Dog;
import com.criown.entity.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.activation.DataSource;
import javax.annotation.Resource;

@SpringBootTest
class SpringBootStudyApplicationTests {

    @Autowired
    private Dog dog;

    @Autowired
    private Person person;

    //DI注入数据源
    @Resource
    DataSource dataSource;

    @Test
    void contextLoads() {
        System.out.println(dog.getName()+"::"+dog.getAge());
        System.out.println("");
        System.out.println(person);
    }

}
