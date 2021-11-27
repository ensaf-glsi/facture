package com.ids.model;

import lombok.Data;

@Data
public class UsernamePassword {
	
	private String username;
	private String password;
	private Boolean rememberMe;

}
