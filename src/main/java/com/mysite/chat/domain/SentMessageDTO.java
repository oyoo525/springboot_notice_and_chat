package com.mysite.chat.domain;

import java.time.LocalDateTime;

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

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SentMessageDTO {

	private int no;
	private String fromId;
	private String toId;
	private String content;
	private LocalDateTime regDate;

	
	public SentMessageDTO (SentMessage m) {
		this.no = m.getNo();
		this.fromId = m.getFromId();
		this.toId = m.getToId();
		this.content = m.getContent();
		this.regDate = m.getRegDate();
	}
	
	public static SentMessage toEntity(SentMessageDTO dto) {
		return SentMessage.builder()
				.no(dto.getNo())
				.fromId(dto.getFromId())
				.toId(dto.getToId())
				.content(dto.getContent())
				.regDate(dto.getRegDate())
				.build();
	}
	
	
}
