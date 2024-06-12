package com.example.demo1.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo1.user.model.UserDao;

///join  page mapping
// /update page mapping
// /login  page mapping
// /mypage  page mapping

@RequestMapping("/user")
@Controller
public class UserController {

//	@ResponseBody
	@GetMapping("/login")
	public String login() {

		return "user/login";
	}

	@GetMapping("/join")
	public String join() {

		return "user/join";
	}

	@GetMapping("/update")
	public String update() {

		return "user/update";
	}

	@GetMapping("/mypage")
	public String mypage() {

		return "user/mypage";
	}
	
	@GetMapping("/logout")
	public void logout( HttpServletRequest request) {
		HttpSession session = request.getSession();

		session.removeAttribute("log");
		session.invalidate();
		
		System.out.println("로그아웃 성공");
	}
	
	@GetMapping("/delete")
	public String delete(HttpServletRequest request) {
		HttpSession session = request.getSession();
		int code = (int)session.getAttribute("log");
		System.out.println("session 에 저장된 log : " + code);
		
		return "user/delete";
	}

}