package com.huntercodexs.genericv1.config.oauth2.client;

import org.springframework.security.web.util.matcher.RequestMatcher;

import javax.servlet.http.HttpServletRequest;

public class OAuthRequestedMatcher implements RequestMatcher {

    @Override
    public boolean matches(HttpServletRequest request) {
        String auth = request.getHeader("Authorization");
        return (auth != null) && auth.startsWith("Bearer");
    }
    
}
