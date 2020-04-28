package com.study.internationalizantion;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Internationalization {

	@Autowired
	private MessageSource messagesource;

	// internationalization example
	@GetMapping("/internationalization_v1")
	public String internationalization_v1(@RequestHeader(name = "Accept-Language", required = false) Locale locale) {

		return messagesource.getMessage("good.morning.message", null, locale);
	}

	// simpler form of internationalization example
	@GetMapping("/internationalization_v2")
	public String Internationalization_v2() {

		return messagesource.getMessage("good.morning.message", null, LocaleContextHolder.getLocale());
	}

}
