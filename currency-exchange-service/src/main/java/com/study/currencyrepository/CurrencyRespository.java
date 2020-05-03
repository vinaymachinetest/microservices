package com.study.currencyrepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.study.models.CurrencyExchageModel;

@Repository
public interface CurrencyRespository extends JpaRepository<CurrencyExchageModel, Long>{
	
	CurrencyExchageModel findByFromAndTo(String from, String to);

}
