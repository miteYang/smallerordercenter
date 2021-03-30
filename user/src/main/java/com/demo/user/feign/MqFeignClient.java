package com.demo.user.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "mq-service")
public interface MqFeignClient {
    @GetMapping("/mq/getMessage")
    String getMessage();
}
