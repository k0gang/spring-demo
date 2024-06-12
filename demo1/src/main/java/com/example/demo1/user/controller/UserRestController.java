package com.example.demo1.user.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo1.user.model.User;
import com.example.demo1.user.model.UserDao;
import com.example.demo1.user.model.UserRequestDto;

import util.Response;

@RequestMapping(value = "/user")
@RestController
public class UserRestController {

	// * 요청 데이터는 모두 RequestBody로 받음.

	// 데이터를 JSON 타입으로 응답하는 메소드
	// jackson json parser가
	// ResponseBody 로 java object -> json으로 반환

	// POST /user/join 회원 가입 처리 (insert)
	// POST /user/update 회원 수정 처리 (update)
	// POST /user/login 로그인 처리 (HttpServletRequest) -> session 저장
	// POST /user/logout/{userCode} 로그아웃 처리 (HttpServletRequest) -> session 비우기
	// DELETE /user/delete 회원 탈퇴 처리 (delete) , (HttpServletRequest) -> session 비우기

	@RequestMapping(method = RequestMethod.POST, value = "/join")
	public ResponseEntity<Response> join(@RequestBody UserRequestDto user) {

		System.out.println("userName : " + user.getUserName());
		System.out.println("password : " + user.getPassword());
		System.out.println("firstName : " + user.getFirstName());
		System.out.println("email : " + user.getEmail());

		UserDao userDao = UserDao.getInstance();

		boolean joinResult = userDao.joinUser(user);

		if (joinResult) {
			System.out.println("가입 성공");
			Response res =  new Response("회워가입 성공");
			return new ResponseEntity<>(res, HttpStatus.OK);			
		} else {
			System.out.println("가입 실패");
			Response res =  new Response("회워가입 실패");
			return new ResponseEntity<>(res, HttpStatus.NOT_FOUND);			
		}
		
	}
	
	@PostMapping("/update")
	public void update(@RequestBody UserRequestDto userRequestDto, HttpServletRequest request) {
		UserDao userDao = UserDao.getInstance();
		HttpSession session = request.getSession();
		
		int code = (int)session.getAttribute("log");
		System.out.println("session 에 저장된 code : " + code);
		
		boolean updateResult = userDao.updateUser(userRequestDto, code);
		
		if(updateResult) {
			System.out.println("업데이트 성공");
		}else {
			System.out.println("업데이트 실패");
		}
	}

	@RequestMapping(method = RequestMethod.POST, value = "/login")
	public ResponseEntity<Response> login(@RequestBody UserRequestDto userRequestDto, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();

		System.out.println("userName : " + userRequestDto.getUserName());
		System.out.println("password : " + userRequestDto.getPassword());

		UserDao userDao = UserDao.getInstance();

		User loginResult = userDao.findUserByIdAndPassword(userRequestDto);

		if (loginResult != null) {
			session.setAttribute("log", loginResult.getCode());
			Response res =  new Response("로그인 성공");
			return new ResponseEntity<>(res, HttpStatus.OK);		
		} else {
			Response res =  new Response("로그인 실패");
			return new ResponseEntity<>(res, HttpStatus.NOT_FOUND);		
		}
	}

	@PostMapping("/delete")
	public void delete(HttpServletRequest request) {
		HttpSession session = request.getSession();
		UserDao userDao = UserDao.getInstance();
		int code = (int)session.getAttribute("log");
		
		userDao.deleteUser(code);
	}


//	@RequestMapping(method = RequestMethod.POST, value = "/delete")
//	public void delete() {
//
//	}

//	@PostMapping("/login/{userCode}")
//	public void login(User user , HttpServletRequest request) {
//		HttpSession session = request.getSession();
//		
//		session.setAttribute("userCode", user.getCode());
//	}

//	@PostMapping("/logout/{userCode}")
//	public void logout(@PathVariable(name = "userCode") int userCode, HttpServletRequest request) {
//		System.out.println("userCode : " + userCode);
//		
//		HttpSession session = request.getSession();
//		
//		session.removeAttribute("log");
//		session.invalidate();	// 세션 닫기
//	}	
}
