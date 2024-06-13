package com.example.demo1.board.model;

import java.sql.Timestamp;

import org.springframework.web.multipart.MultipartFile;

public class BoardRequestDto {

	private int code;
	private int author;
	private String title;
	private String content;
	private Timestamp regDate;
	private Timestamp modDate;

	public BoardRequestDto(int author, String title, String content) {
		super();
		this.author = author;
		this.title = title;
		this.content = content;
	}

	public BoardRequestDto(int code, int author, String title, String content, Timestamp regDate, Timestamp modDate) {
		super();
		this.code = code;
		this.author = author;
		this.title = title;
		this.content = content;
		this.regDate = regDate;
		this.modDate = modDate;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public int getAuthor() {
		return author;
	}

	public void setAuthor(int author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Timestamp getRegDate() {
		return regDate;
	}

	public void setRegDate(Timestamp regDate) {
		this.regDate = regDate;
	}

	public Timestamp getModDate() {
		return modDate;
	}

	public void setModDate(Timestamp modDate) {
		this.modDate = modDate;
	}

}
