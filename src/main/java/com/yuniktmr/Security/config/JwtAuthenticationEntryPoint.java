package com.yuniktmr.Security.config;

import java.io.IOException;
import java.util.Collections;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint{

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {
		// TODO Auto-generated method stub
		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		response.setContentType(MediaType.APPLICATION_JSON_VALUE);
		
		String message;
		final Exception exception = (Exception) request.getAttribute("exception");
		
		if(exception != null) {
			if(exception.getCause()!= null) {
				message = exception.getCause().toString()+" "+exception.getMessage();
			}else {
				message = exception.getMessage();
			}
			byte [] body = new ObjectMapper().
					writeValueAsBytes(Collections.singletonMap("error", message));
			
				response.getOutputStream().write(body);	
		}else {
				if(authException.getCause() != null) {
					message = authException.getCause().toString() + " "+authException.getMessage();
				}else {
					message = authException.getMessage();
				}
				byte [] body = new ObjectMapper().
					writeValueAsBytes(Collections.singletonMap("error", message));
			
				response.getOutputStream().write(body);	
		}
	}

}
