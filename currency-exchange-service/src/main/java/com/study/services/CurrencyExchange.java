package com.study.services;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.study.currencyrepository.CurrencyRespository;
import com.study.models.CurrencyExchageModel;

@RestController
public class CurrencyExchange {
	
	@Autowired
	private Environment environment;
	@Autowired
	CurrencyRespository currencyRespository;
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyExchageModel currenceExchange(@PathVariable String from, @PathVariable String to){
		
		CurrencyExchageModel exchangeValue=currencyRespository.findByFromAndTo(from, to);
exchangeValue.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
		return exchangeValue;
		
	}

}
