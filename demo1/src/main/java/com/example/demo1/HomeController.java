package com.example.demo1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	@RequestMapping(method = RequestMethod.GET, value = "/main")
	public String main() {
		return "user/main";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/join")
	public String join() {
		return "user/join";
	}
	
	@RequestMapping("/login")
	public String login() {
		return "user/login";
	}

}