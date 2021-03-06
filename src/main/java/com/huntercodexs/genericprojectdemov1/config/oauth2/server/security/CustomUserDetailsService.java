package com.huntercodexs.genericprojectdemov1.config.oauth2.server.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.huntercodexs.genericprojectdemov1.config.oauth2.server.security.RoleOperator.*;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	private String usernameCred;
	private String passwordCred;
	private List<GrantedAuthority> authorities;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		LoggedOperator loggedOperator = new LoggedOperator(this.usernameCred, this.passwordCred, this.authorities);

		UserDetails user = new User(
				username,
				loggedOperator.getPassword(),
				true,
				true,
				true,
				true,
				AuthorityUtils.NO_AUTHORITIES);

		if (user.getUsername().equals("") || !user.isEnabled()) {
			return new User(
					user.getUsername(),
					user.getPassword(),
					!user.isEnabled(),
					user.isAccountNonExpired(),
					user.isCredentialsNonExpired(),
					user.isAccountNonLocked(),
					AuthorityUtils.NO_AUTHORITIES);
		}

		return loggedOperator;

	}

	public void setUserCredentials(int userLevel, String usernameCred, String passwordCred) {

		String roles;

		switch (userLevel) {
			case 0:
				roles = ROLE_ADMIN.name();
				break;
			case 1:
				roles = ROLE_USER.name();
				break;
			case 2:
				roles = ROLE_CLIENT.name();
				break;
			case 3:
				roles = ROLE_OPERATOR.name();
				break;
			case 4:
				roles = ROLE_MODERATOR.name();
				break;
			default:
				roles = "";

		}

		this.usernameCred = usernameCred;
		this.passwordCred = passwordCred;
		this.authorities = AuthorityUtils.commaSeparatedStringToAuthorityList(roles);
	}

	public void setUserCredentialsFromDatabase(String userRole, String usernameCred, String passwordCred) {
		this.usernameCred = usernameCred;
		this.passwordCred = passwordCred;
		this.authorities = AuthorityUtils.commaSeparatedStringToAuthorityList(userRole);
	}

}

