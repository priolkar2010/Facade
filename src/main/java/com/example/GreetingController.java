package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Controller
public class GreetingController {

	@Autowired
	Greeting greeting;
	
	@Autowired
	MiniGreeting miniGreeting;
	
	@RequestMapping("greet")
	@HystrixCommand(fallbackMethod="problem")
	public String greeting(Model model){
		System.out.println("Inside the greeting");
		model.addAttribute("greeting", greeting.greeting());
		System.out.println(greeting.greeting());
		return "greeting";
	}
	
	@RequestMapping("mingreet")
	@HystrixCommand(fallbackMethod="problem")
	public String greetingFromMini(Model model){
		System.out.println(greeting.greeting());
		model.addAttribute("greeting", miniGreeting.greetingFromMini() +"--"+ greeting.greeting());
		System.out.println(miniGreeting.greetingFromMini());
		return "greeting";
	}	
	
	public String problem(Model model){
		model.addAttribute("greeting","Emergency");
		return "greeting";
	}
	

}
