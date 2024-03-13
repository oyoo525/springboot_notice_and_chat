package com.mysite.chat.controller;

import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.util.HtmlUtils;

import com.mysite.chat.test.Greeting;
import com.mysite.chat.test.HelloMessage;

@Controller
public class ChatController {
 
	@GetMapping("hi")
	public String greetingPage() {
		return "views/index2";
	}
	
    @GetMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(HelloMessage message) throws Exception {
    	Thread.sleep(1000);
    	return new Greeting("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");
    }
    
    
    
}
