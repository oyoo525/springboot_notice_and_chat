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
public class ReplyDTO {
	
	private int no;
	private int boardNo;
	private String id;
	private String reply;
	private LocalDateTime regDate;
	
	
	public ReplyDTO (Reply reply) {
		this.no = reply.getNo();
		this.boardNo = reply.getBoardNo();
		this.id = reply.getId();
		this.reply = reply.getReply();
		this.regDate = reply.getRegDate();
	}
	
	public static Reply toEntity(ReplyDTO dto) {
		return Reply.builder()
				.no(dto.getNo())
				.boardNo(dto.getBoardNo())
				.id(dto.getId())
				.reply(dto.getReply())
				.regDate(dto.getRegDate())
				.build();
	}
	
	
}
