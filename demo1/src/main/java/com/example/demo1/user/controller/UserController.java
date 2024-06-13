package com.example.demo1.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo1.user.model.User;
import com.example.demo1.user.model.UserDao;
import com.example.demo1.user.model.UserRequestDto;

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
	public String mypage(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();

		if (session.getAttribute("log") != null) {
			int code = (int) session.getAttribute("log");
			UserDao userDao = UserDao.getInstance();
			User user = userDao.findUserByCode(code);

			model.addAttribute("user", user);

			return "user/mypage";
		}else {
			return "user/login";
		}

	}
	
	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession();

		session.removeAttribute("log");
		session.invalidate();

		System.out.println("로그아웃 성공");

		return "user/login";
	}

	@GetMapping("/delete")
	public String delete(HttpServletRequest request) {
		HttpSession session = request.getSession();
		int code = (int) session.getAttribute("log");
		System.out.println("session 에 저장된 log : " + code);

		return "user/delete";
	}

//	@ResponseBody
//	@PostMapping(value = "/test", consumes = "multipart/form-data")
//	public UserRequestDto test(@ModelAttribute UserRequestDto userDto) {
//		return userDto;
//	}
	
//	@ResponseBody
//	@PostMapping(value = "/test")
//	public UserRequestDto test(@RequestParam(name = "userName") String userName,@RequestParam(name = "firstName") String firstName) {
//		UserRequestDto userDto = new UserRequestDto();
//		userDto.setUserName(userName);
//		userDto.setFirstName(firstName);
//		return userDto;
//	}
	
//	@GetMapping("/mypage")
//	public ModelAndView mypage() {
//		ModelAndView mv = new ModelAndView("user/main");
//		
////		mv.addObject("data","새로운데이터");
//		ModelMap attribute = new ModelMap();
//		attribute.addAttribute("data", "새로운 데이터");
//		attribute.addAttribute("log", "apple");
//		attribute.addAttribute("user", new UserRequestDto());
//		
//		return mv;
//	}
}