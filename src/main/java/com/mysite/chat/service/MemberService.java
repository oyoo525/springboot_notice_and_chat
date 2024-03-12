package com.mysite.chat.service;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.mysite.chat.domain.Member;
import com.mysite.chat.repository.MemberRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MemberService {

	@Autowired
	private MemberRepository memberRepository;
	
	public List<Member> memberList() {
		log.info("MemberService : memberList()");
		return memberRepository.findAll();
	}
	
	public void insertMember(Member member) {
		memberRepository.insertMember(member);
	}
	
	public Member getMemberInfo (String id) {
		return memberRepository.getMemberInfo(id); 
	}
	
	
	
	
}
