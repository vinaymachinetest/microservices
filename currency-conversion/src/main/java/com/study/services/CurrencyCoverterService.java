package com.study.services;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CurrencyCoverterService {	
	
	@GetMapping("/currency-convertor/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyCoverterBean currencyCovertor(@PathVariable String from, @PathVariable String to,
			                                      @PathVariable BigDecimal quantity) {
		
		String url="http://localhost:8000/currency-exchange/from/{from}/to/{to}";
		Map<String, String> urlParameters =new HashMap<String, String>();
		urlParameters.put("from", from);
		urlParameters.put("to", to);
		
		RestTemplate restTemplate =new RestTemplate();
		ResponseEntity<CurrencyCoverterBean> response =  restTemplate.getForEntity(url, CurrencyCoverterBean.class,urlParameters);
		CurrencyCoverterBean responseBody = response.getBody();
		
		return new CurrencyCoverterBean(responseBody.getId(), from, to, responseBody.getConversionMultiple(),
				quantity,quantity.multiply(responseBody.getConversionMultiple()), responseBody.getPort());
		
	}

}
