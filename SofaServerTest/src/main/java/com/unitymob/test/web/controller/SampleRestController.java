package com.unitymob.test.web.controller;

import com.google.common.collect.Maps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class SampleRestController {

    Logger logger=LoggerFactory.getLogger(SampleRestController.class);

    @GetMapping("test")
    public Map<String,Object> springmvc(){
        Map<String,Object> map=Maps.newHashMap();
        map.put("dd","3");
        logger.error("test error!");
        return map;
    }
}
