package com.mysite.chat.domain;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
public class Chat {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int no;
	
	@Column
	private int roomNo;
	
	@Column
	private String sender;
	
	@Column(columnDefinition = "TEXT")
	private String content;
	
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	@Builder.Default()
	private LocalDateTime regDate = LocalDateTime.now();
	
	
	private MessageType type;
	
	public enum MessageType {
		CHAT, LEAVE, JOIN
	}
	
	
	
}
