package com.unitymob.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;

@ImportResource({"classpath*:rpc-sofa-boot-starter.xml"})
@SpringBootApplication
public class SofaBootRpcSamplesApplication {

    public static void main(String[] args) throws InterruptedException {


        SpringApplication springApplication=new SpringApplication(SofaBootRpcSamplesApplication.class);
        ApplicationContext applicationContext=springApplication.run(args);

        //GenericObject genericObject=new GenericObject("");
//        GenericService genericService=applicationContext.getBean("helloSyncService",GenericService.class);
//        String result=genericService.$genericInvoke("saySync",new String[]{"java.lang.String"},new Object[]{"dd"},String.class);
//        System.out.println(String.format("result:%s",result));

//        HelloSyncService helloSyncService=(HelloSyncService)applicationContext.getBean("helloSyncService");
//        System.out.println(helloSyncService.saySync("sync"));

        //System.out.println(SofaResponseFuture.getResponse(1000L,true));
    }
}
