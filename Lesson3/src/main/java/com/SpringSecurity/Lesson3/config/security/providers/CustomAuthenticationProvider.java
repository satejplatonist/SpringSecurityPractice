package com.SpringSecurity.Lesson3.config.security.providers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import com.SpringSecurity.Lesson3.config.security.authentication.CustomAuthentication;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider 
{
	@Value("${very.very.secret.key}")
	private String key;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		CustomAuthentication authentication2 = (CustomAuthentication) authentication;
		
		String headerkeyToauthenticate = authentication2.getKey();
		System.out.println("key from header : " + headerkeyToauthenticate);
		System.out.println("key expected : " + key);
		
		if(key.trim().equals(headerkeyToauthenticate))
		{
			return new CustomAuthentication(true, null);
		}
		
		System.out.println("Failed Authentication. Property Key: " + key + ", Header Key: " + headerkeyToauthenticate);
		throw new BadCredentialsException(" 1 Oh no !!! you have put wrong key can't authenticate you");
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return CustomAuthentication.class.equals(authentication);
	}

}
