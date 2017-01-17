package com.example;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("MINI-SERVICES-1")
public interface MiniGreeting {
	
	@RequestMapping("/greetingFromMini")
	String greetingFromMini();

}
