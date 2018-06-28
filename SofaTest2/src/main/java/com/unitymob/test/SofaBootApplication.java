package com.unitymob.test;

import org.hibernate.validator.internal.engine.ConfigurationImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;

@ImportResource({"classpath*:rpc-sofa-boot-starter.xml"})
@SpringBootApplication
public class SofaBootApplication {

    public static void main(String[] args) {
        SpringApplication springApplication=new SpringApplication(SofaBootApplication.class);
        ConfigurableApplicationContext applicationContext=springApplication.run(args);
    }
}
