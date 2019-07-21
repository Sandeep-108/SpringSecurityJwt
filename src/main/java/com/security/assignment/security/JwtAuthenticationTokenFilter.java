package com.security.assignment.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;

import com.security.assignment.model.JwtAuthenticationToken;

public class JwtAuthenticationTokenFilter extends AbstractAuthenticationProcessingFilter {

	public JwtAuthenticationTokenFilter() {
        super("/send/**");
    }
	public void setAuthenticationSuccessHandler(JwtSuccessHandler jwtSuccessHandler) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException, IOException, ServletException {
		
		String header = request.getHeader("Authorization");


        if (header == null) {
            throw new RuntimeException("JWT Token is missing");
        }

        String authenticationToken =header;

        JwtAuthenticationToken token = new JwtAuthenticationToken(authenticationToken);
        return getAuthenticationManager().authenticate(token);
	}

	 @Override
	    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
	        super.successfulAuthentication(request, response, chain, authResult);
	        chain.doFilter(request, response);
	    }
}
