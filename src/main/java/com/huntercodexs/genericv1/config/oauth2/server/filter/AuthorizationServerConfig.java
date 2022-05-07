package com.huntercodexs.genericv1.config.oauth2.server.filter;

import com.huntercodexs.genericv1.config.oauth2.server.security.CustomAuthenticationManager;
import com.huntercodexs.genericv1.config.oauth2.server.security.CustomClientDetailsService;
import com.huntercodexs.genericv1.config.oauth2.server.security.CustomUserDetailsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.approval.TokenStoreUserApprovalHandler;
import org.springframework.security.oauth2.provider.approval.UserApprovalHandler;
import org.springframework.security.oauth2.provider.request.DefaultOAuth2RequestFactory;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

@Configuration
@EnableWebSecurity
@EnableResourceServer
@EnableAuthorizationServer
@SuppressWarnings("deprecation")
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    private final Logger LOG = LoggerFactory.getLogger(AuthorizationServerConfig.class);

    @Value("${oauth.server.custom.endpoint}")
    private String oauth2CustomEndpoint;
	
    @Autowired
    private TokenStore tokenStore;

    @Autowired
    private UserApprovalHandler userApprovalHandler;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private CustomAuthenticationManager customAuthenticationManager;

    @Autowired
    private CustomClientDetailsService customClientDetailsService;
    
	@Autowired
	private CustomUserDetailsService customUserDetailsService;

	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
	
    @Bean
    public TokenStore tokenStore() {
        return new InMemoryTokenStore();
    }
    
    @Bean
    @Autowired
    public UserApprovalHandler userApprovalHandler(TokenStore tokenStore) {
        TokenStoreUserApprovalHandler handler = new TokenStoreUserApprovalHandler();
        handler.setTokenStore(tokenStore);
        handler.setRequestFactory(new DefaultOAuth2RequestFactory(customClientDetailsService));
        handler.setClientDetailsService(customClientDetailsService);

        return handler;
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints
                .pathMapping("/oauth/token", oauth2CustomEndpoint+"/token" )
                .pathMapping("/oauth/check_token", oauth2CustomEndpoint+"/check_token")
                .tokenStore(this.tokenStore)
                .userApprovalHandler(this.userApprovalHandler)
                .authenticationManager(customAuthenticationManager)
                .userDetailsService(customUserDetailsService);
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.withClientDetails(customClientDetailsService);
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) {
        security
                .allowFormAuthenticationForClients()
                .tokenKeyAccess("permitAll()")
                .checkTokenAccess("isAuthenticated()")
                .passwordEncoder(this.passwordEncoder);
    }
    
    @Configuration
    protected static class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

       @Override
       public void configure(final HttpSecurity http) throws Exception {
           http/*.requestMatcher(new OAuthRequestedMatcher())*/.authorizeRequests()
                   .antMatchers("/actuator/**").permitAll().anyRequest().authenticated();

       }
       
    }

}