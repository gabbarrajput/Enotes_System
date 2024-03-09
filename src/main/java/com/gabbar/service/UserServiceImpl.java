package com.gabbar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.gabbar.entity.User;
import com.gabbar.repository.UserRepository;

import jakarta.servlet.http.HttpSession;

@Service
public class UserServiceImpl implements UserService 
{
	@Autowired
	private UserRepository ur;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	
	@Override
	public User saveUser(User user) {
		user.setRole("ROLE_USER");
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		User newuser = ur.save(user);
		return newuser;
	}

	@Override
	public boolean existEmailCheck(String email) {
		
		return ur.existsByEmail(email);
	}
	
	public void removeMessage()
	{
		HttpSession session = ((ServletRequestAttributes)(RequestContextHolder.getRequestAttributes()))
		.getRequest().getSession();
		 session.removeAttribute("msg");
		
	}
  
   
   
}
