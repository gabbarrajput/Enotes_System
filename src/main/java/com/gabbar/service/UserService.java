package com.gabbar.service;

import com.gabbar.entity.User;

public interface UserService 
{
	 public User saveUser (User user);
	 
	 public boolean existEmailCheck (String email);
}
