package com.SpringSecurity.Lesson3.config.security.managers;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import com.SpringSecurity.Lesson3.config.security.providers.CustomAuthenticationProvider;

import lombok.AllArgsConstructor;


@Component
@AllArgsConstructor
public class CustomAuthenticationManager implements AuthenticationManager
{
	private CustomAuthenticationProvider authenticationProvider;

	@Override
	public Authentication authenticate(Authentication authentication) 
			throws AuthenticationException 
	{
		if(authenticationProvider.supports(authentication.getClass()))
		{
			return authenticationProvider.authenticate(authentication);
		}
		
		throw new BadCredentialsException(" 2 Oh no !!! you have put wrong key can't authenticate you");
	}
  
}
