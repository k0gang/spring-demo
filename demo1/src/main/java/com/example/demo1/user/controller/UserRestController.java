package com.example.demo1.user.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo1.user.model.User;
import com.example.demo1.user.model.UserDao;

@RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "/user")
@RestController
public class UserRestController {
	
	// * 요청 데이터는 모두 RequestBody로 받음.

	// 데이터를 JSON 타입으로 응답하는 메소드
	// jackson json parser가 
	// ResponseBody 로 java object -> json으로 반환
	
	// POST		/user/join					회원 가입 처리 (insert)
	// POST 	/user/update				회원 수정 처리 (update)
	// POST 	/user/login					로그인 처리 (HttpServletRequest) -> session 저장
	// POST 	/user/logout/{userCode}		로그아웃 처리 (HttpServletRequest) -> session 비우기
	// DELETE 	/user/delete 				회원 탈퇴 처리 (delete) , (HttpServletRequest) -> session 비우기
	
	@PostMapping("/logout/{userCode}")
	public void logout(@PathVariable(name = "userCode") int userCode, HttpServletRequest request) {
		System.out.println("userCode : " + userCode);
		
		HttpSession session = request.getSession();
		
		session.removeAttribute("log");
		session.invalidate();
				
	}
	
}
