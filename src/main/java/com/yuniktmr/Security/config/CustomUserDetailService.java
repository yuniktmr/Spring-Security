package com.yuniktmr.Security.config;

import java.util.Arrays;
import java.util.List;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
@Service
public class CustomUserDetailService implements UserDetailsService{
	
	


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		List<SimpleGrantedAuthority> roles = null;
		
		if(username.equals("admin")) {
			roles = Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
			return new User("admin","$2y$12$YP.QrhN5AzccvaJgzoNr4.gPOh7PT.DAsVlBi4CDCTv6fZKo.p0JO",roles);
		}
		if(username.equals("user")) {
			roles = Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
			return new User("user","$2y$12$in4cOg6.ky6Q/FlvEknqN.TrgWY66lIraSdaRNhGjBDSMnbPr0aDS",roles);
		}
		throw new UsernameNotFoundException("User not found with name = "+username);
		
	}
}
