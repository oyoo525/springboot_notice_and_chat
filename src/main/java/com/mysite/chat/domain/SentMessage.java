package com.mysite.chat.domain;

import java.time.LocalDateTime;

import org.hibernate.annotations.ColumnDefault;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
@Table(name="springboot_chat_send_message")
public class SentMessage {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int no;
	
	@Column
	private String fromId;
	
	@Column
	private String toId;
	
	@Column(columnDefinition = "TEXT")
	private String content;
	
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	@Builder.Default()
	private LocalDateTime regDate = LocalDateTime.now();
	
	
}
