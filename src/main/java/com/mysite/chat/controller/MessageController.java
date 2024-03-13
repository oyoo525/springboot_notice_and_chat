package com.mysite.chat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mysite.chat.domain.ReceivedMessage;
import com.mysite.chat.domain.SentMessage;
import com.mysite.chat.service.MessageService;

import jakarta.servlet.http.HttpSession;

@Controller
public class MessageController {

	@Autowired
	private MessageService messageService;
	
	
	@GetMapping("/messageForm")
	public String messageFormPage(Model model, HttpSession session) {
		model.addAttribute("loginId", session.getAttribute("loginId"));
		return "views/messageForm";
	}
	
	@PostMapping("/sendMessage")
	public String sendMessage(HttpSession session, @RequestParam("fromId") String fromId,
			@RequestParam("toId") String toId, @RequestParam("content") String content) {
		messageService.sendMessage(fromId, toId, content);
		return "views/messageForm";
	}
	
	@GetMapping("/receivedMessage")
	public String receivedMessagePage(Model model, HttpSession session,
			@PageableDefault(size = 20, sort = "regDate", direction = Direction.DESC) Pageable pageable) {
		String loginId = (String) session.getAttribute("loginId");
		model.addAttribute("messageList", messageService.receivedMessage(pageable, loginId));
		return "views/receivedMessage";
	}
	
	@GetMapping("sentMessage")
	public String sentMessagePage(Model model, HttpSession session,
			@PageableDefault(size = 20, sort = "regDate", direction = Direction.DESC) Pageable pageable) {
		String loginId = (String) session.getAttribute("loginId");
		model.addAttribute("messageList", messageService.sentMessage(pageable, loginId));
		return "views/sentMessage";
	}
	
	
}
