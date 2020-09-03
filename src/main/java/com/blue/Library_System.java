package com.blue;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//@SpringBootApplication :标注这个类是一个springboot应用
@SpringBootApplication
public class Library_System {
    //将springboot应用启动(通过反射加载)
    public static void main(String[] args) {
        SpringApplication.run(Library_System.class, args);
    }
    
}
