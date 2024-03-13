package com.mysite.chat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mysite.chat.domain.Reply;
import com.mysite.chat.repository.ReplyRepository;

@Service
public class ReplyService {

	@Autowired
	private ReplyRepository replyRepository;
	
	
	public void insertReply(int boardNo, String id, String reply) {
		replyRepository.insertReply(boardNo, id, reply);
	}
	
	public Page<Reply> getReplyList(Pageable pageable, int boardNo) {
		return replyRepository.findByBoardNo(pageable, boardNo);
	}
	
	public void updateReply(int no, String id, String reply) {
		replyRepository.updateReply(no, id, reply);
	}
	
	public void deleteReply(int no) {
		System.out.println("delete service 시작");
		replyRepository.deleteById(Integer.valueOf(no));
		System.out.println("delete service 끝");
	}	
	
}
