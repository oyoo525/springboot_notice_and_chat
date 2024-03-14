package com.mysite.chat.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mysite.chat.domain.ChatRoom;
import com.mysite.chat.repository.ChatRoomRepository;

@Service
public class ChatService {

	@Autowired
	private ChatRoomRepository chatRoomRepository;
	
	
	public String insertChatRoom(String roomName) {
		ChatRoom cr =  new ChatRoom();
		cr.setRoonName(roomName);
		cr = chatRoomRepository.save(cr);
		return cr.getUuid();
	} 
	
	public Page<ChatRoom> getChatRoomList(Pageable pageable) {
		return chatRoomRepository.findAll(pageable);
	}
	
	
}
