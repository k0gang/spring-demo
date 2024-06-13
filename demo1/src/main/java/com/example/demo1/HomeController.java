package com.example.demo1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo1.board.model.BoardRequestDto;

@Controller
public class HomeController {
	
	@RequestMapping(method = RequestMethod.GET, value = "/main")
	public String main() {
		return "user/main";
	}
	
//	@RequestMapping(method = RequestMethod.GET, value = "/join")
//	public String join() {
//		return "user/join";
//	}
	
	@RequestMapping("/login")
	public String login() {
		return "user/login";
	}

	@ResponseBody
	@PostMapping(value = "/test", consumes = "multipart/form-data")
	public BoardRequestDto test(@ModelAttribute BoardRequestDto boardDto) {
		System.out.println("title : "+boardDto.getTitle());
		System.out.println("content : " + boardDto.getContent());
		System.out.println("file : " + boardDto.getFile());
		System.out.println("file.name : " + boardDto.getFile().getName());
		System.out.println("file.type : " + boardDto.getFile().getContentType());
		
		return boardDto;
	}
}