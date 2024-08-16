package com.SpringSecurity.Lesson3.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.SpringSecurity.Lesson3.config.security.filters.CustomAuthenticationFilter;

import lombok.AllArgsConstructor;

@Configuration
@AllArgsConstructor
public class SecurityConfig 
{
   private final CustomAuthenticationFilter customAuthenticationFilter;
	
   @Bean
   public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception
   {
	   return http
			   .addFilterAt(customAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
			   .authorizeHttpRequests().anyRequest().authenticated() 
			   //meaning of line above : to call any endpoint you should be authenticated
			   .and()
			   .build();
   }
}
