package com.mysite.chat.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.HtmlUtils;

import com.mysite.chat.domain.Chat;
import com.mysite.chat.domain.ChatRoom;
import com.mysite.chat.service.ChatService;
import com.mysite.chat.test.Greeting;
import com.mysite.chat.test.HelloMessage;

import jakarta.servlet.http.HttpSession;

@Controller
public class ChatController {
	
	@Autowired
	private ChatService chatService;
	
	@GetMapping("/chatList")
	public String chatList(Model model, HttpSession session,
			@PageableDefault(size = 20, sort = "roomNo", direction = Direction.DESC) Pageable pageable) {
		model.addAttribute("loginId", session.getAttribute("loginId"));
		Page<ChatRoom> cList = chatService.getChatRoomList(pageable);
		model.addAttribute("chatList", cList);
		return "views/chatList";
	}
	
	@PostMapping("/chat")
	public String makeChatRoom (@RequestParam("makeChatRoomName") String roomName){
		String uuid = chatService.insertChatRoom(roomName);
		return "redirect:/chatList";
	}
	
	@MessageMapping("/chat.register/{uuid}")
	@SendTo("/topic/{uuid}")
	public Chat register(@Payload Chat chatMessage, 
			@DestinationVariable("uuid") String uuid,
			SimpMessageHeaderAccessor headerAccessor) {
		headerAccessor.getSessionAttributes().put("userName", chatMessage.getSender());
	
		System.out.println("chat.register - Message : " +  chatMessage);
		return chatMessage;
	}
	
	@MessageMapping("/chat.send/{uuid}")
	@SendTo("/topic/{uuid}")
	public Chat sendChat(@Payload Chat chatMessage,
			@DestinationVariable("uuid") String uuid) {
		
		System.out.println("chat.send - Message : " +  chatMessage);
		return chatMessage;
	}
    
    
}
