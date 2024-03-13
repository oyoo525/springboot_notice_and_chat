package com.mysite.chat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import com.mysite.chat.domain.Member;
import com.mysite.chat.domain.MemberDTO;
import com.mysite.chat.service.MemberService;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Slf4j
@Controller
public class MemberController {

	@Autowired
	private MemberService memberService;
	

	@GetMapping("/join")
	public String joinPage() {
		return "/views/join";
	}
	
	@PostMapping("/join")
	public String insertMember(@RequestParam("id") String id, @RequestParam("pass") String pass,
			@RequestParam("name") String name, @RequestParam("nickName") String nickName) {
		log.info("MemberController : insertMember");
		
		Member member = new Member();
		member.setId(id);
		member.setPass(pass);
		member.setName(name);
		member.setNickName(nickName);
		memberService.insertMember(member);
		return "redirect:/login";
	}
	
	@GetMapping("/login")
	public String loginPage() {
		return "/views/login";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	

	
	
	
	
	
	
}
