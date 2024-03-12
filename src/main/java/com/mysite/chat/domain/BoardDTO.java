package com.mysite.chat.domain;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BoardDTO {
	
	private int no;
	private String title;
	private String writer;
	private String content;
	private int thumb;
	private int views;
	private LocalDateTime regDate;
	
	
	public BoardDTO(Board board) {
		this.no = board.getNo();
		this.title = board.getTitle();
		this.writer = board.getWriter();
		this.content = board.getContent();
		this.thumb = board.getThumb();
		this.views = board.getViews();
		this.regDate = board.getRegDate();
	}
	
	public static Board toEntity(BoardDTO dto) {
		return Board.builder()
				.no(dto.getNo())
				.title(dto.getTitle())
				.writer(dto.getWriter())
				.content(dto.getContent())
				.thumb(dto.getThumb())
				.views(dto.getViews())
				.regDate(dto.getRegDate())
				.build();
	}
	
	
	
	
	
	
}
