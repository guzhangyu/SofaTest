package com.unitymob.test.service.impl;

import com.unitymob.test.service.HelloSyncService;
import com.unitymob.test.web.controller.SampleRestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloSyncServiceImpl implements HelloSyncService {

    Logger logger=LoggerFactory.getLogger(SampleRestController.class);

    @Override
    public String saySync(String str) {
        logger.error("testss");
        throw new IllegalArgumentException("dd");
        //return "test";
    }

    public void dd(){
        logger.error("ddasds");
        throw new IllegalArgumentException("fdafdsafdadd");
    }
}
