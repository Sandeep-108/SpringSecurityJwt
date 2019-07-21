package com.security.assignment.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.security.assignment.model.JwtAuthenticationToken;
import com.security.assignment.model.JwtUser;
import com.security.assignment.model.JwtUserDetails;

@Component
public class JwtAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {

	 @Autowired
	 private JwtValidator validator;
	 
	@Override
	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		return JwtAuthenticationToken.class.isAssignableFrom(authentication);
	}

	@Override
	protected void additionalAuthenticationChecks(UserDetails userDetails,
			UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken authentication)
			throws AuthenticationException {
		// TODO Auto-generated method stub
		JwtAuthenticationToken jwtToken =(JwtAuthenticationToken)authentication;
		String token = jwtToken.getToken();
		JwtUser user = validator.validate(token);
		
		if(user==null) {
			  throw new RuntimeException("JWT Token is incorrect");
		}
		
		 List<GrantedAuthority> grantedAuthorities = AuthorityUtils
	                .commaSeparatedStringToAuthorityList(String.valueOf(user.getId()));
	        return new JwtUserDetails(user.getMobileNo(), user.getId(),
	                token,
	                grantedAuthorities);
	}

}
