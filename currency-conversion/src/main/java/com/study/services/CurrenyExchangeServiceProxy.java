package com.study.services;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name="currency-exchage-service",  url="localhost:8000")	
@FeignClient(name="currency-exchage-service")	
@RibbonClient(name="currency-exchage-service")
public interface CurrenyExchangeServiceProxy {
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyCoverterBean currenceExchange(@PathVariable("from") String from, @PathVariable("to") String to);
	

}
