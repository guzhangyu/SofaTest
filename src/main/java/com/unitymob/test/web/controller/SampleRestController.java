package com.unitymob.test.web.controller;

import com.google.common.collect.Maps;
import com.unitymob.test.service.HelloSyncService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.amqp.core.ReceiveAndReplyCallback;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

@RestController
public class SampleRestController {

    Logger logger=LoggerFactory.getLogger(SampleRestController.class);

    @Autowired
    HelloSyncService helloSyncService;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping("test")
    public Map<String,Object> springmvc(){
        MDC.put("SOFA-TraceId","dddss");
        Map<String,Object> map=Maps.newHashMap();
        map.put("dd","3");
        //helloSyncService.saySync("dd");
        logger.error("test error!");

        rabbitTemplate.receiveAndReply(new ReceiveAndReplyCallback<Object, Object>() {
            @Override
            public Object handle(Object payload) {
                logger.error("test");
                return null;
            }
        },"facebook","ad");
        return map;
    }
}
