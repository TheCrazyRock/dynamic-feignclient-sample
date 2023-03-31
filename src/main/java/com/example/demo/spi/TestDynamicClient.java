package com.example.demo.spi;

import org.springframework.cloud.openfeign.FeignClient;

import com.example.demo.feign.DynamicFeignClientInterceptor;

/**
 * TestDynamicClient.
 * 
 * @author therock
 */
@FeignClient(name =DynamicFeignClientInterceptor.DYNAMIC_CLIENT_NAME ,path = "/graflow/api",configuration = DynamicFeignClientInterceptor.class)
public interface TestDynamicClient extends SimulaterPoviderApiSdk {

}
