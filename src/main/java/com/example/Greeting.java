package com.example;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("MICROC-SERVICE-1")
public interface Greeting {
	
	@RequestMapping("/greeting")
	String greeting();

}
