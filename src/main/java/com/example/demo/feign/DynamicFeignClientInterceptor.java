package com.example.demo.feign;

import org.springframework.stereotype.Component;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import feign.Target;

/**
 * DynamicFeignClientInterceptor.
 */
@Component
public class DynamicFeignClientInterceptor implements RequestInterceptor {
    
    @Override
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public void apply(RequestTemplate template) {
        Target<?> target = template.feignTarget();
        System.out.println("origin:"+target);
        String originClientName = target.name();
        String targetClientName =convertTargetClientName(target.name());
        if (!originClientName.equals(targetClientName)) {
            String newUrl = target.url().replace(originClientName, targetClientName);
            Target.HardCodedTarget newTarget = new Target.HardCodedTarget(target.type(), targetClientName, newUrl);
            System.out.println("target:" + newTarget);
            newTarget.apply(template);
        }
        
    }

    public static final String DYNAMIC_CLIENT_NAME="DYNAMIC-CLIENT";
    
    /**
     * 根据需求转换目标客户端名称
     * @param originClient
     * @return 
     */
    protected String convertTargetClientName(String originClient) {
        if (DYNAMIC_CLIENT_NAME.equals(originClient)) {
            //从线程上下文获取当前请求对应的目标客户端名称
            return DynamicFeignClientContext.peek();
        }
        return originClient;
    }
}
