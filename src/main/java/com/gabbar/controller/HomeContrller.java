package com.gabbar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.gabbar.entity.User;
import com.gabbar.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class HomeContrller 
{
	@Autowired
	private UserService uservice;
	
	@GetMapping("/")
   public String index ()
   {
	return "index";
	   
   }
	
	@GetMapping("/register")
	   public String register ()
	   {
		return "Register";
		   
	   }
	
	@PostMapping("/savUser")
	   public String savUser (@ModelAttribute User user, HttpSession session)
	   {
		
		boolean f = uservice.existEmailCheck(user.getEmail());
		if (f)
		{
			session.setAttribute("msg", "Email already exist");
		}
		else
		{
			User saveu = uservice.saveUser(user);
			if (saveu!=null)
			{
				session.setAttribute("msg", "Register Success");
			}
			else
			{
				session.setAttribute("msg", "Something wrong on Server");
			}
		}
		return "redirect:/register";
		   
	   }
	
	@GetMapping("/signin")
	   public String login ()
	   {
		return "Login";
		   
	   }
	
	
}
