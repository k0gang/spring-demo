package com.example.demo1.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/user")
@Controller
public class UserController {
	
	@RequestMapping(method = RequestMethod.GET, value = "/join")
	public String join() {
		return "user/join";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/signin")
	public String signin() {
		return "user/signin";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/signout")
	public String signout() {
		return "redirect:/";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/update")
	public String update() {
		return "user/update";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/delete")
	public String delete() {
		return "user/delete";
	}
	
}