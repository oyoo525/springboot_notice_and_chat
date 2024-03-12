package com.mysite.chat.domain;

import java.time.LocalDateTime;

import org.hibernate.annotations.ColumnDefault;
import org.springframework.boot.context.properties.bind.DefaultValue;

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
@Table(name="springboot_chat_board")
public class Board {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int no;
	
	@Column(length = 100)
	private String title;
	
	@Column
	private String writer;
	
	@Column(columnDefinition = "TEXT")
	private String content;
	
	@Column
	@ColumnDefault("0")
	@Builder.Default()
	private int thumb = 0;
	
	@Column
	@ColumnDefault("0")
	@Builder.Default()
	private int views = 0;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column
	private LocalDateTime regDate;
	
	
	
	
	
	
}
