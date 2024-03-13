package com.mysite.chat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mysite.chat.service.BoardService;

@Controller
public class BoardAjaxController {

	@Autowired
	private BoardService boardService;
	
	@PostMapping("/boardDelete.ajax")
	@ResponseBody
	public boolean boardDeletePage(@RequestParam("no") int no) {
		int res = boardService.deleteBoard(no);
		System.out.println(res);
		if(res == 1) return true;
		return false;
	}
	
	
}
