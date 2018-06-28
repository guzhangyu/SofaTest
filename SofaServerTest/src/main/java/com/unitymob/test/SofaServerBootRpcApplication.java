package com.unitymob.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@ImportResource({"classpath*:rpc-sofa-boot-starter.xml"})
@SpringBootApplication
public class SofaServerBootRpcApplication {

    public static void main(String[] args) {
        new SpringApplication(SofaServerBootRpcApplication.class).run(args);
    }
}
