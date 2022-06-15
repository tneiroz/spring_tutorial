package me.eun.model;

import lombok.Data;

@Data
public class Board {
	
	//게시판 변수
	private Long id; // 게시판 번호
	private String title;
	private String content;
	private String writer;
}
