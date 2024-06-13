package com.example.demo1.board.model;

import java.sql.Timestamp;

import org.springframework.web.multipart.MultipartFile;

public class Board {

	private int code;
	private int author;
	private String title;
	private String content;
	private Timestamp regDate;
	private Timestamp modDate;

	private MultipartFile file;

	public Board() {

	}

	public Board(int code, int author, String title, String content, Timestamp regDate, Timestamp modDate) {
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

	public int getAuthor() {
		return author;
	}

	public Timestamp getRegDate() {
		return regDate;
	}

	public Timestamp getModDate() {
		return modDate;
	}

	public String getTitle() {
		return title;
	}

	public String getContent() {
		return content;
	}

	public MultipartFile getFile() {
		return file;
	}

}
