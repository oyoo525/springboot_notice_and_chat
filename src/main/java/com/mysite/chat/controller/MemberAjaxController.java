package com.mysite.chat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mysite.chat.domain.Member;
import com.mysite.chat.service.MemberService;

import jakarta.servlet.http.HttpSession;

@Controller
public class MemberAjaxController {

	@Autowired
	private MemberService memberService;
	
	@PostMapping("/joinIdCheck.ajax")
	@ResponseBody
	public Member joinIdCheck(@RequestParam("id") String id) {
		Member m = memberService.getMemberInfo(id);	
		return m;
	}

	@PostMapping("/loginCheck.ajax")
	@ResponseBody
	public boolean loginCheck(HttpSession session,
			@RequestParam("id") String id, @RequestParam("pass") String pass) {
		Member m = memberService.getMemberInfo(id);
		
		if(m.getPass().equals(pass)) {
			session.setAttribute("login", true);
			session.setAttribute("loginId", m.getId());
			return true;
		}	
		return false;
	}
	
	
	
	
	
	
	
}
