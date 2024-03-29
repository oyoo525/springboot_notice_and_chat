package com.mysite.chat.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mysite.chat.domain.SentMessage;

import jakarta.transaction.Transactional;
import java.util.List;


@Repository
public interface SentMessageRepository extends JpaRepository<SentMessage, Integer>{

	Page<SentMessage> findByFromId(Pageable pageable, String fromId);
	
}
