package com.mysite.chat.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mysite.chat.domain.Board;
import com.mysite.chat.repository.BoardRepository;

@Service
public class BoardService {

	@Autowired
	private BoardRepository boardRepository;
	
	
	public void writeBoard(String title, String writer, String content) {
		boardRepository.insertBoard(title, writer, content);
	}
	
	public Page<Board> getBoardList(Pageable pageable) {
		return boardRepository.findAll(pageable);
	}
	
	public Board getBoard(int no) {
		Optional<Board> optionalBoard = boardRepository.findById(no);
		Board board = optionalBoard.orElse(new Board());
		return board;
	}
	
	public void updateBoard(int no, String title, String writer, String content) {
		boardRepository.updateBoard(no, title, writer, content);
	}
	
	public int deleteBoard(int no) {
		return boardRepository.deleteByNo(no);
	}
	
	
}
