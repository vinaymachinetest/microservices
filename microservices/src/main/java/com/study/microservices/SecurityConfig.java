/*
 * configuration for spring security with h2 database
 */

/*package com.study.microservices;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests()
        .antMatchers("/", "/home").permitAll()
        .antMatchers("/admin", "/h2_console/**").hasRole("ADMIN").anyRequest()
        .authenticated()
        .and()
        .formLogin().loginPage("/login").permitAll()
        .and()
        .logout().permitAll();
    http.exceptionHandling().accessDeniedPage("/403");
    http.csrf().disable();
    http.headers().frameOptions().disable();
  }
}*/
