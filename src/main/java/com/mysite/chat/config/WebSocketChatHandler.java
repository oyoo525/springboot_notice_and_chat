package com.mysite.chat.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.messaging.support.ImmutableMessageChannelInterceptor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class WebSocketChatHandler extends ImmutableMessageChannelInterceptor {

	
	

	
}
