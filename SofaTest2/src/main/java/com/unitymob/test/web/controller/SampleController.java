package com.unitymob.test.web.controller;

import com.alipay.sofa.rpc.common.json.JSON;
import com.google.common.collect.Maps;
import com.unitymob.test.service.HelloSyncService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.ReceiveAndReplyCallback;
import org.springframework.amqp.rabbit.core.RabbitMessagingTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class SampleController {

    Logger logger=LoggerFactory.getLogger(SampleController.class);

    @Autowired
    HelloSyncService helloSyncService;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    RabbitMessagingTemplate rabbitMessagingTemplate;

    @GetMapping("test2")
    @ResponseBody
    public String test2(){
        throw new IllegalArgumentException("dsfda");
       // return "dsd";
    }

    @GetMapping("test")
    @ResponseBody
    public Map<String,Object> test(){
        MDC.put("SOFA-TraceId","dddss");
        Map<String,Object> map=Maps.newHashMap();
        map.put("dd","3");
        logger.error("test error!");
      //  throw new IllegalArgumentException("ddddss");
        helloSyncService.saySync("dd");
        logger.error("test error!");


//        rabbitTemplate.receiveAndReply(new ReceiveAndReplyCallback<Object, Object>() {
//            @Override
//            public Object handle(Object payload) {
//                logger.error("test");
//                return null;
//            }
//        },"facebook","ad");

//        rabbitTemplate.convertAndSend("facebook","ad", JSON.toJSONString("ddd"));
//        rabbitMessagingTemplate.convertAndSend("facebook","ad","hsdsdsd");
//        rabbitTemplate.send("facebook","ad",new Message("fafda".getBytes(),null));
        return map;
    }


    @GetMapping("test1")
    @ResponseBody
    public Map<String,Object> test1(){
        Map<String,Object> map=new HashMap<>();
        map.put("fda","dsfd");
        logger.error("test error!");
        //  throw new IllegalArgumentException("ddddss");
        helloSyncService.dd();
        logger.error("test error!");

        return map;
    }
}
