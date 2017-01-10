package com.rock.book.model;

import javax.servlet.http.HttpSession;

public class BookHolder {
	private String bookName;
	private String bookNum;
	private String empCode;
	private String empName;
	//2016.10.05 변경사유 추가
	private String changeReason;
	//2016.10.06 adminHistory에 넣을 데이터
	private String beforeEmpCode;
	
	public String getBeforeEmpCode() {
		return beforeEmpCode;
	}
	public void setBeforeEmpCode(String beforeEmpCode) {
		this.beforeEmpCode = beforeEmpCode;
	}
	public String getChangeReason() {
		return changeReason;
	}
	public void setChangeReason(String changeReason) {
		this.changeReason = changeReason;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getBookNum() {
		return bookNum;
	}
	public void setBookNum(String bookNum) {
		this.bookNum = bookNum;
	}
	public String getEmpCode() {
		return empCode;
	}
	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	@Override
	public String toString() {
		return "BookHolder [bookName=" + bookName + ", bookNum=" + bookNum + ", empCode=" + empCode + ", empName="
				+ empName + ", changeReason=" + changeReason + ", beforeEmpCode=" + beforeEmpCode + "]";
	}
	
	
	
	
}
