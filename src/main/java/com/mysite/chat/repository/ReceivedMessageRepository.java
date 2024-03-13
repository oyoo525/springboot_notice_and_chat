package com.mysite.chat.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mysite.chat.domain.ReceivedMessage;
import java.util.List;


@Repository
public interface ReceivedMessageRepository extends JpaRepository<ReceivedMessage, Integer> {

	Page<ReceivedMessage> findByToId(Pageable pageable, String toId);
	
	
	
	
}
