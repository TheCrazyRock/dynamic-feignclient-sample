package com.example.demo.feign;

import java.util.concurrent.Callable;

/**
 * DynamicFeignClientInvoker.
 */
public class DynamicFeignClientInvoker {
    
    private String clientName;
    
    private DynamicFeignClientInvoker(String name) {
        this.clientName=name;
    }
    
    public static DynamicFeignClientInvoker build(String clientName) {
        return new DynamicFeignClientInvoker(clientName);
    }

    public <V> V invoke(Callable<V> callable) {
        try {
            DynamicFeignClientContext.push(clientName);
            return callable.call();
        } catch (Exception e) {
            if (e instanceof RuntimeException) {
                throw (RuntimeException)e;
            }else {
                throw new RuntimeException(e);
            }
        }finally {
            DynamicFeignClientContext.poll();
        }
    }
    
    
    
}
