package com.unitymob.test.web.controller;

import com.alipay.common.tracer.core.context.trace.SofaTraceContext;
import com.alipay.common.tracer.core.holder.SofaTraceContextHolder;
import com.alipay.common.tracer.core.span.SofaTracerSpan;
import com.alipay.sofa.tracer.plugins.springmvc.SpringMvcTracer;
import com.unitymob.test.service.HelloSyncService;
import io.opentracing.tag.Tags;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Consumers {

    Logger logger=LoggerFactory.getLogger(Consumers.class);

    @Autowired
    HelloSyncService helloSyncService;

    @RabbitListener(
            bindings = @QueueBinding(
                    value = @Queue(value = "ad",durable = "true",autoDelete = "false"),
                    exchange = @Exchange(value = "facebook",durable = "true"),
                    key = "ad"
            )
    )
    public void readAds(Object object){
//        MDC.put("SOFA-TraceId","dddss");
//        MDC.put("SOFA-SpanId","sssdd");

        //开始，当然  this.sofaTracer 是需要继承构建好的实例，简单的可以看下 `com.alipay.sofa.tracer.plugins.springmvc.SpringMvcTracer` 构建方法
        SofaTraceContext sofaTraceContext=SofaTraceContextHolder.getSofaTraceContext();
        SofaTracerSpan span = sofaTraceContext.getCurrentSpan();
        if(span==null){
            span= (SofaTracerSpan) SpringMvcTracer.getSpringMvcTracerSingleton().getSofaTracer().buildSpan("testInjectSpan")
                    .withTag(Tags.SPAN_KIND.getKey(), Tags.SPAN_KIND_CLIENT).start();
            sofaTraceContext.push(span);
        }

        logger.error(object+"");
        logger.error("hahah");
//        MDC.put("SOFA-TraceId","dddss1");
//        MDC.put("SOFA-SpanId","sssdd1");
        logger.error("test error!");
        helloSyncService.saySync("dd");
//        MDC.put("SOFA-TraceId","dddss2");
//        MDC.put("SOFA-SpanId","sssdd2");
        logger.error("test error!");
        span.finish();
        sofaTraceContext.pop();
    }
}
