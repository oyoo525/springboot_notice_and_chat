package com.mysite.chat.repository;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mysite.chat.domain.Member;

import jakarta.transaction.Transactional;

@Repository
public interface MemberRepository extends JpaRepository<Member, String> {

	List<Member> findAll();
	
	@Modifying
	@Transactional
	@Query(value = "INSERT INTO springboot_chat_member "
			+ "VALUES(:#{#member.id}, :#{#member.name}, :#{#member.nickName}, "
			+ ":#{#member.pass}, NOW())", 
			nativeQuery = true)
	public abstract void insertMember(@Param("member") Member member);
	
	
	@Query("SELECT m FROM Member m WHERE m.id= :id")
	public abstract Member getMemberInfo(@Param("id") String id);

	
	
	
}
