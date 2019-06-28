package com.example.book.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfigurer extends WebSecurityConfigurerAdapter {

  @Override
  protected void configure(HttpSecurity security) throws Exception {
    security.csrf()
        .disable()
        .authorizeRequests()
        .anyRequest()
        .permitAll();
  }
}
