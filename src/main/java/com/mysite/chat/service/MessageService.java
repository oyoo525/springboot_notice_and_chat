package com.mysite.chat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.mysite.chat.domain.ReceivedMessage;
import com.mysite.chat.domain.SentMessage;
import com.mysite.chat.repository.ReceivedMessageRepository;
import com.mysite.chat.repository.SentMessageRepository;

@Service
public class MessageService {

	@Autowired
	private SentMessageRepository sentMessageRepository;
	@Autowired
	private ReceivedMessageRepository receivedMessageRepository;
	
	
	
	public void sendMessage(String fromId, String toId, String content) {
		// 보낸메세지 DB
		SentMessage sMessage = new SentMessage();
		sMessage.setFromId(fromId);
		sMessage.setToId(toId);
		sMessage.setContent(content);
		
		sentMessageRepository.save(sMessage);
		
		// 받은 메세지 DB
		ReceivedMessage rMessage = new ReceivedMessage();
		rMessage.setFromId(fromId);
		rMessage.setToId(toId);
		rMessage.setContent(content);
		
		receivedMessageRepository.save(rMessage);
	}
	
	// 받은메세지함
	public Page<ReceivedMessage> receivedMessage(Pageable pageable, String toId) {
		return receivedMessageRepository.findByToId(pageable, toId);
	}
	
	// 보낸메세지함
	public Page<SentMessage> sentMessage(Pageable pageable, String fromId) {
		return sentMessageRepository.findByFromId(pageable, fromId);
	}
	
	
	
	
}
