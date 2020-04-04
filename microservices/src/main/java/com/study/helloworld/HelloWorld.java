package com.study.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {
	//1st Way writing rest service using spring web
		@RequestMapping(method = RequestMethod.GET, path="/helloworld_v1")
		public String helloworld_v1() {
			
			return "Hi! the is demo app";
		}
		
		//2nd Way writing rest service using spring web
		@GetMapping(path="/helloworld_v2")
		public String helloworld_v2() {
			
			return "Hi! the is demo app";
		}
		
		//3rd Way writing rest service using spring web
		@GetMapping("/helloworld_v3")
		public String helloworld_v3() {
			
			return "Hi! the is demo app";
		}
		
		//Returning bean(java pojo class) in a json respoonse using internally calling jackson api
		@GetMapping("/helloworld_v4")
		public JavaBean helloworld_v4() {
			
			return new JavaBean("Hi! the is demo app converting java pojo class into json response automatically by jackson api");
		}
		
		//example of path varibale 
		@GetMapping("/helloworld_v5/{message}")
		public JavaBean helloworld_v5(@PathVariable String message) {
			
				return new JavaBean(String.format("Hi!, %s", message));
		}

}
