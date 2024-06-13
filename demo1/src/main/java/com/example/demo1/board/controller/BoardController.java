package com.example.demo1.board.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo1.board.model.Board;
import com.example.demo1.board.model.BoardDao;
import com.example.demo1.board.model.BoardRequestDto;

@RequestMapping("/board")
@Controller
public class BoardController {
	
	@GetMapping("/list")
	public ModelAndView boardList() {
		ModelAndView mv = new ModelAndView("board/list");
		
		BoardDao boardDao = BoardDao.getInstance();
		List<Board> list = boardDao.findAll();
		
		mv.addObject("boardList", list);
		
		return mv;
	}
	
	@GetMapping("/write")
	public ModelAndView boardWrite() {
		ModelAndView mv = new ModelAndView("board/write");
		
		BoardDao boardDao = BoardDao.getInstance();
		
		return mv;
	}
	
	@GetMapping("/write/action")
	public String boardWriteAction(@RequestParam("title") String title, @RequestParam("content") String content, HttpServletRequest request) {
		HttpSession session = request.getSession();
		
		int author = (int) session.getAttribute("log");
		
		BoardDao boardDao = BoardDao.getInstance();
		BoardRequestDto boardRequestDto = new BoardRequestDto(author, title, content);
		boardDao.createBoard(boardRequestDto);
		
		return "redirect:/board/list";
	}
	
	@GetMapping("/detail")
	public ModelAndView boardDetail(int code) {
		ModelAndView mv = new ModelAndView("board/detail");
	
		BoardDao boardDao = BoardDao.getInstance();
		Board board = boardDao.findBoardByCode(code);
		mv.addObject("board", board);
		
		return mv;
	}
	
	@GetMapping("/delete")
	public String boardDelete(int code) {
		BoardDao boardDao = BoardDao.getInstance();
		
		boardDao.deleteBoardByCode(code);
		
		return "redirect:/board/list";
	}

	@GetMapping("/update")
	public ModelAndView boardUpdate(int code) {
		ModelAndView mv = new ModelAndView("board/update");
		
		BoardDao boardDao = BoardDao.getInstance();
		Board board = boardDao.findBoardByCode(code);
		
		mv.addObject("board",board);
		
		return mv;
	}
	
	@GetMapping("/update/action")
	public String boardUpdateAction(@ModelAttribute BoardRequestDto boardRequestDto) {
		System.out.println("업데이트 액션 실행 ㅇㅇ");
		
		BoardDao boardDao = BoardDao.getInstance();
		boardDao.updateBoard(boardRequestDto);
		
		return "redirect:/board/list";
	}
	
}
