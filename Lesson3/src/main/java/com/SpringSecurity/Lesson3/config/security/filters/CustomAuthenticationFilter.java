package com.SpringSecurity.Lesson3.config.security.filters;

import java.io.IOException;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.SpringSecurity.Lesson3.config.security.authentication.CustomAuthentication;
import com.SpringSecurity.Lesson3.config.security.managers.CustomAuthenticationManager;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class CustomAuthenticationFilter extends OncePerRequestFilter
{
	private final CustomAuthenticationManager authenticationManager;

	@Override
	protected void doFilterInternal(HttpServletRequest request, 
			                        HttpServletResponse response, 
			                        FilterChain filterChain)
			                        throws ServletException, IOException 
	{
		
		// 1. Create an authenticated object which is not authenticated but contains all the details
		// 2. delegate that object to authentication manager
		// 3. get back the authentication from authentication manager
		// 4. if object is authenticated then send response to other filter chain
		
		String key  = String.valueOf(request.getHeader("key"));
		CustomAuthentication customAuthentication = new CustomAuthentication(false,key); // step 1
		
		var v = authenticationManager.authenticate(customAuthentication); // step 2 and step 3
		
		if(v.isAuthenticated()) // step 4
		{
			SecurityContextHolder.getContext().setAuthentication(v);
			filterChain.doFilter(request, response);
		}
	}

}
