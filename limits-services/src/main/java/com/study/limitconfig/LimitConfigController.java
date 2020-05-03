package com.study.limitconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitConfigController {

	@Autowired
	private LimitConfig limitConfig;
	
	@GetMapping("/get/config")
	public Configuration config() {
		
		return new Configuration(limitConfig.getMax(), limitConfig.getMin());
		
	}
}
