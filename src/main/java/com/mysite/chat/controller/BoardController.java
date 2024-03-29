package com.mysite.chat.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mysite.chat.domain.Board;
import com.mysite.chat.repository.ReplyRepository;
import com.mysite.chat.service.BoardService;

import jakarta.servlet.http.HttpSession;

@Controller
public class BoardController {

	@Autowired
	private BoardService boardService;
	@Autowired
	private ReplyRepository replyRepository;
	
	
	@GetMapping("/")
	public String memberList(Model model, HttpSession session,
			@PageableDefault(size = 10, sort = "no", direction = Sort.Direction.DESC) Pageable pageable) {
		model.addAttribute("login", session.getAttribute("login"));
		model.addAttribute("loginId", session.getAttribute("loginId"));		
		model.addAttribute("boardList", boardService.getBoardList(pageable));
		return "views/index";
	}
	
	@GetMapping("/writeBoard")
	public String writeBoardPage(Model model, HttpSession session) {
		model.addAttribute("loginId", session.getAttribute("loginId"));
		return "views/writeBoard";
	}
	
	@PostMapping("/writeBoard")
	public String writeBoard(@RequestParam("title") String title, 
			@RequestParam("writer") String writer, 
			@RequestParam("content") String content) {
		
		boardService.writeBoard(title, writer, content);
		
		return "redirect:/";
	}
	
	
	@GetMapping("/boardDetail")
	public String boardDetailPage(Model model, HttpSession session, 
			@RequestParam("no") int no,
			@PageableDefault(size = 20, sort = "no", direction = Direction.DESC) Pageable pageable) {
		model.addAttribute("board",  boardService.getBoard(no));
		model.addAttribute("loginId", session.getAttribute("loginId"));
		
		model.addAttribute("replyList", replyRepository.findByBoardNo(pageable, no));
		
		return "views/boardDetail";
	}
	
	
	@GetMapping("/boardUpdate")
	public String boardUpdatePage(Model model, HttpSession session, 
			@RequestParam("no") int no) {
		Board board = boardService.getBoard(no);
		model.addAttribute("board", board);
		model.addAttribute("loginId", session.getAttribute("loginId"));
		
		return "views/boardUpdate";
	}
	
	@PostMapping("/boardUpdate")
	public String boardUpdate(@RequestParam("no") int no,
			@RequestParam("title") String title, @RequestParam("writer") String writer,
			@RequestParam("content") String content) {
		boardService.updateBoard(no, title, writer, content);
		return "redirect:/";
	}

	
	
	
}
