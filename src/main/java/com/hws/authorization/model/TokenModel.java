package com.hws.authorization.model;

public class TokenModel {

    private Long userId;
    private String token;
    private String role;
    
	public TokenModel(Long userId, String token, String role) {
		super();
		this.userId = userId;
		this.token = token;
		this.role = role;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	
}
