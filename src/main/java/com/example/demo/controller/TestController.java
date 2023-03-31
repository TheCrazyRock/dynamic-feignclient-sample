
package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.feign.DynamicFeignClientInvoker;
import com.example.demo.spi.TestDynamicClient;

/**
 * TestController.
 */

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    TestDynamicClient testDynamicClient;

    @GetMapping
    public String listUsers(String clientName) {
        return DynamicFeignClientInvoker.build(clientName).invoke(() -> testDynamicClient.health());
    }

}
