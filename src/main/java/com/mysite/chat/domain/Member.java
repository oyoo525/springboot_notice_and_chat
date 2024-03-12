package com.mysite.chat.domain;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="springboot_chat_member")
public class Member {

	@Id
	@Column(length=20, nullable = false, unique = true)
	private String id;
	
	@Column(length=50, nullable = false)
	private String pass;
	
	@Column(length=5, nullable = false)
	private String name;
	
	@Column(length=15, nullable = false)
	private String nickName;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(length=50, nullable = false)
	private LocalDateTime regDate;
	
}
