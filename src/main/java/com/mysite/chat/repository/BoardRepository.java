package com.mysite.chat.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mysite.chat.domain.Board;

import jakarta.transaction.Transactional;

@Repository
public interface BoardRepository extends JpaRepository<Board, Integer> {

	@Modifying
	@Transactional
	@Query(value= "INSERT INTO springboot_chat_board(title, writer, content, reg_date) "
			+ "VALUES (:title, :writer, :content, NOW())", 
			nativeQuery = true)
	public abstract void insertBoard(@Param("title") String title, 
			@Param("writer") String writer, @Param("content") String content);
	
	
	
	
}
