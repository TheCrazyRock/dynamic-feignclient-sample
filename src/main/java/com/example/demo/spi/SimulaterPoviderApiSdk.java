package com.example.demo.spi;

import org.springframework.web.bind.annotation.GetMapping;

/**
 * SimulaterPoviderApiSdk.
 * 模拟提供端的SDK接口。
 * 注意新版本Spring Cloud feign 不支持接口类上的RequestMapping注解,BASEURL须使用FeignClient声明
 */
// @RequestMapping("/graflow/api") 
public interface SimulaterPoviderApiSdk {

    @GetMapping("/health")
    String health();
    
}
