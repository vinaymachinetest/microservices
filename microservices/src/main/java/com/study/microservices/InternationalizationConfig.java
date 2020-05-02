/*
 * configuration of Internationalization
 */

package com.study.microservices;

import java.util.Locale;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

@Configuration
public class InternationalizationConfig {

	/*
	 * @Bean public LocaleResolver localeResolver() {
	 * 
	 * SessionLocaleResolver localeResolver = new SessionLocaleResolver();
	 * localeResolver.setDefaultLocale(Locale.US); return localeResolver; }
	 */

	// simpler form of above
	@Bean
	public LocaleResolver localeResolver_simpler() {

		AcceptHeaderLocaleResolver localeResolver = new AcceptHeaderLocaleResolver();
		localeResolver.setDefaultLocale(Locale.US);
		return localeResolver;
	}

	// it is not required if we configure in properties file
	/*
	 * @Bean public ResourceBundleMessageSource bundleMessageSource() {
	 * 
	 * ResourceBundleMessageSource messageSource = new
	 * ResourceBundleMessageSource(); messageSource.setBasename("messages"); return
	 * messageSource; }
	 */
}
