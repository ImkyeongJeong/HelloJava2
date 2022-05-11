package com.yedam.java.service;

import lombok.Data;

@Data
public class BookVO {
	private String title;
	private String writer;
	private String content;
	private int rental;
	
	@Override
	public String toString() {
		return "책제목 : " + title
				+ ", 저자명 : " + writer
				+ ", 내용 : " + content
				+ ", 대여여부 : " + ((rental==1)? "대여중" : "대여가능");
	}
}
