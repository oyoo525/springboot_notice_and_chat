package com.mysite.chat.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mysite.chat.domain.Reply;

import jakarta.transaction.Transactional;
import java.util.List;


@Repository
public interface ReplyRepository extends JpaRepository<Reply, Integer> {

	@Modifying
	@Transactional
	@Query(value="INSERT INTO springboot_chat_reply (board_no, id, reply, reg_date) "
	        + "VALUES(:boardNo, :id, :reply, NOW())", nativeQuery = true)
	public void insertReply(@Param("boardNo") int boardNo, 
	        @Param("id") String id, @Param("reply") String reply);

	Page<Reply> findByBoardNo(Pageable pageable, int boardNo);
	
	@Modifying
	@Transactional
	@Query(value="UPDATE Reply SET id = :id, reply = :reply WHERE no = :no")
	public void updateReply(@Param("no") int no, 
	        @Param("id") String id, @Param("reply") String reply);
	
	

	
}
