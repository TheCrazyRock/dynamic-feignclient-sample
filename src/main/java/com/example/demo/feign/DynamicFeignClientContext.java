package com.example.demo.feign;

import java.util.ArrayDeque;
import java.util.Deque;

import org.springframework.core.NamedThreadLocal;
import org.springframework.util.StringUtils;

/**
 * DynamicFeignClientContext.
 */
public class DynamicFeignClientContext {

    private static final ThreadLocal<Deque<String>> LOOKUP_KEY_HOLDER = new NamedThreadLocal<Deque<String>>("dynamic-feign-client") {
        @Override
        protected Deque<String> initialValue() {
            return new ArrayDeque<>();
        }
    };
    /**
     * 获得当前已制定的FeignClient名称
     *
     * @return FeignClient名称
     */
    public static String peek() {
        return LOOKUP_KEY_HOLDER.get().peek();
    }

    public static String push(String clientName) {
        String client = StringUtils.hasLength(clientName)? clientName:"" ;
        LOOKUP_KEY_HOLDER.get().push(client);
        return client;
    }

    /**
     * 清空当前指定的客户端名称
     */
    public static void poll() {
        Deque<String> deque = LOOKUP_KEY_HOLDER.get();
        deque.poll();
        if (deque.isEmpty()) {
            LOOKUP_KEY_HOLDER.remove();
        }
    }

    /**
     * 强制清空
     */
    public static void clear() {
        LOOKUP_KEY_HOLDER.remove();
    }
    

}
