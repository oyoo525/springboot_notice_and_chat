package com.mysite.chat.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.util.HtmlUtils;

import com.mysite.chat.domain.Chat;
import com.mysite.chat.test.Greeting;
import com.mysite.chat.test.HelloMessage;

import jakarta.servlet.http.HttpSession;

@Controller
public class ChatController {
	
	@GetMapping("/chatList")
	public String chatList(Model model, HttpSession session) {
		model.addAttribute("loginId", session.getAttribute("loginId"));
		return "views/chatList";
	}
	
 
	@MessageMapping("/chat.register")
	@SendTo("/topic/public")
	public Chat register(@Payload Chat chatMessage, 
			SimpMessageHeaderAccessor headerAccessor) {
		headerAccessor.getSessionAttributes().put("userName", chatMessage.getSender());
		return chatMessage;
	}
	
	@MessageMapping("/chat.send")
	@SendTo("/topic/public")
	public Chat sendChat(@Payload Chat chatMessage) {
		return chatMessage;
	}
    
    
}
