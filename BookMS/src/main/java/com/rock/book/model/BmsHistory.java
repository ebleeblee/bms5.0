package com.rock.book.model;

public class BmsHistory {
	private String code;
	private String bookNum;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getBookNum() {
		return bookNum;
	}
	public void setBookNum(String bookNum) {
		this.bookNum = bookNum;
	}
	@Override
	public String toString() {
		return "BmsHistory [code=" + code + ", bookNum=" + bookNum + "]";
	}
	
	

}
