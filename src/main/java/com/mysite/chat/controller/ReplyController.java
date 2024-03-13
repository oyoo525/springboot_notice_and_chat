package com.mysite.chat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mysite.chat.service.ReplyService;

@Controller
public class ReplyController {
	
	@Autowired
	private ReplyService replyService;
	
	
	@PostMapping("insertReply")
	public String insertReply(@RequestParam("boardNo") int boardNo, 
			@RequestParam("id") String id, @RequestParam("reply") String reply) {
		replyService.insertReply(boardNo, id, reply);
		return "redirect:/boardDetail?no=" + boardNo;
	}
	
	@PostMapping("updateReply")
	public String updateReply(@RequestParam("boardNo") int boardNo, @RequestParam("replyNo") int no, 
			@RequestParam("id") String id, @RequestParam("reply") String reply) {
		replyService.updateReply(no, id, reply);
		return "redirect:/boardDetail?no=" + boardNo;
	}
	
	@PostMapping("deleteReply.ajax")
	@ResponseBody
	public String deleteReply(@RequestParam("no") int no) {
		replyService.deleteReply(no);
		return "삭제완료";
	}
	
	
}
