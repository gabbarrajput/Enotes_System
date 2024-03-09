package com.gabbar.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.gabbar.entity.User;
import com.gabbar.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService 
{ 
	@Autowired
	private UserRepository urepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = urepo.findByEmail(username);
		
		if (user==null)
		{
			throw new UsernameNotFoundException("user not found");
		}
		else
		{
			return new CustomUser(user);
		}
		
	}

}
