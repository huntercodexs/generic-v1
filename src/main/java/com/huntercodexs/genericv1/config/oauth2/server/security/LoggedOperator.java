package com.huntercodexs.genericv1.config.oauth2.server.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.List;

public class LoggedOperator extends User {

	public LoggedOperator(String usernameCred, String passwordCred, List<GrantedAuthority> authorities) {
		super(usernameCred, passwordCred, authorities);
	}

}
