package com.yuniktmr.Security.model;

public class AuthenticationResponse {
	public AuthenticationResponse() {
		
		// TODO Auto-generated constructor stub
	}

	private String token;

	public AuthenticationResponse(String token) {
		
		this.token = token;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
}
