package com.huntercodexs.genericv1.config.oauth2.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.AccessTokenConverter;
import org.springframework.security.oauth2.provider.token.DefaultAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;

import java.util.Base64;

@EnableResourceServer
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class SecurityOauthConfiguration extends ResourceServerConfigurerAdapter {

	@Value("${api.prefix}")
	private String apiPrefix;

	@Value("${oauth2.client-id}")
	private String username;

	@Value("${oauth2.client-secret}")
	private String password;

	@Value("${oauth2.url.check-token}")
	private String oauth2ServerCheckTokenUrl;

	@Bean
	public AccessTokenConverter accessTokenConverter() {
		return new DefaultAccessTokenConverter();
	}

	@Bean
	public RemoteTokenServices remoteTokenServices() {
		RemoteTokenServices remoteTokenServices = new RemoteTokenServices();
		AccessTokenConverter accessTokenConverter = accessTokenConverter();
		String secret = new String(Base64.getDecoder().decode(password));

		remoteTokenServices.setCheckTokenEndpointUrl(oauth2ServerCheckTokenUrl);
		remoteTokenServices.setClientId(username);
		remoteTokenServices.setClientSecret(secret);
		remoteTokenServices.setAccessTokenConverter(accessTokenConverter);

		return remoteTokenServices;
	}

	@Override
	public void configure(ResourceServerSecurityConfigurer resources) {
		resources.tokenServices(remoteTokenServices());
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http/*.requestMatcher(new OAuthRequestedMatcher())*/.authorizeRequests()
				/*App Services*/
				.antMatchers(apiPrefix+"/skeleton-v1").authenticated()
				/*Others*/
				.antMatchers(apiPrefix+"/alive").permitAll()
				/*Swagger*/
				.antMatchers("/swagger-ui/**").permitAll()
				.antMatchers("/api-docs/**").permitAll()
				/*Actuator*/
				.antMatchers("/actuator/**").permitAll().anyRequest().authenticated();
	}

}
