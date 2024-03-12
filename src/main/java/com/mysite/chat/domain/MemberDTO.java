package com.mysite.chat.domain;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberDTO {

	private String id;
	private String pass;
	private String name;
	private String nickName;
	private LocalDateTime regDate;

	
	public MemberDTO(Member member) {
		this.id = member.getId();
		this.pass = member.getPass();
		this.name = member.getName();
		this.nickName = member.getNickName();
		this.regDate = member.getRegDate();
	}
	
	public static Member toEntity(MemberDTO dto) {
		return Member.builder()
				.id(dto.getId())
				.pass(dto.getPass())
				.name(dto.getName())
				.nickName(dto.getNickName())
				.build();
	}
	
	
	
	
}
