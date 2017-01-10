package com.rock.book.model;

public class Book {
	private String bookNum;
	private String proposalNum;
	private String bookName;
	private String bookWriter;
	private String bookTranslator;
	private String publisher;
	private Boolean isCopy;
	private String price;
	private String bookShop;
	private Integer ea;
	private String lastname;
	private String firstname;
	private String request;
	//hwpark 검색기능 추가
	private String search_value;
	private String booksearch;
	//eblee 2016/10/01 proposalRequestDept추가
	private String proposalRequestDept;
	//관리자(정),관리자(부) 추가
	private String firstCharge; //관리자(정)
	private String secondCharge; //관리자(부)
	
	private String firstChargeName; //관리자(정)
	private String secondChargeName; //관리자(부)
	
	private String bookFirstCharge;
	
	private String acceptNum;
	
	public String getAcceptNum() {
		return acceptNum;
	}
	public void setAcceptNum(String acceptNum) {
		this.acceptNum = acceptNum;
	}
	public String getFirstChargeName() {
		return firstChargeName;
	}
	public void setFirstChargeName(String firstChargeName) {
		this.firstChargeName = firstChargeName;
	}
	public String getSecondChargeName() {
		return secondChargeName;
	}
	public void setSecondChargeName(String secondChargeName) {
		this.secondChargeName = secondChargeName;
	}
	public String getBookFirstCharge() {
		return bookFirstCharge;
	}
	public void setBookFirstCharge(String bookFirstCharge) {
		this.bookFirstCharge = bookFirstCharge;
	}
	public String getFirstCharge() {
		return firstCharge;
	}
	public void setFirstCharge(String firstCharge) {
		this.firstCharge = firstCharge;
	}
	public String getSecondCharge() {
		return secondCharge;
	}
	public void setSecondCharge(String secondCharge) {
		this.secondCharge = secondCharge;
	}
	public String getProposalRequestDept() {
		return proposalRequestDept;
	}
	public void setProposalRequestDept(String proposalRequestDept) {
		this.proposalRequestDept = proposalRequestDept;
	}
	public String getBooksearch() {
		return booksearch;
	}
	public void setBooksearch(String booksearch) {
		this.booksearch = booksearch;
	}
	public String getSearch_value() {
		return search_value;
	}
	public void setSearch_value(String search_value) {
		this.search_value = search_value;
	}
	public String getBookNum() {
		return bookNum;
	}
	public void setBookNum(String bookNum) {
		this.bookNum = bookNum;
	}
	public String getProposalNum() {
		return proposalNum;
	}
	public void setProposalNum(String proposalNum) {
		this.proposalNum = proposalNum;
	}
	
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getBookWriter() {
		return bookWriter;
	}
	public void setBookWriter(String bookWriter) {
		this.bookWriter = bookWriter;
	}
	public String getBookTranslator() {
		return bookTranslator;
	}
	public void setBookTranslator(String bookTranslator) {
		this.bookTranslator = bookTranslator;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public Boolean getIsCopy() {
		return isCopy;
	}
	public void setIsCopy(Boolean isCopy) {
		this.isCopy = isCopy;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getBookShop() {
		return bookShop;
	}
	public void setBookShop(String bookShop) {
		this.bookShop = bookShop;
	}
	public Integer getEa() {
		return ea;
	}
	public void setEa(Integer ea) {
		this.ea = ea;
	}
	
	
	
	
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	
	public String getRequest() {
		return request;
	}
	public void setRequest(String request) {
		this.request = request;
	}
	/*@Override
	public String toString() {
		return "Book [bookNum=" + bookNum + ", proposalNum=" + proposalNum + ", bookName=" + bookName + ", bookWriter="
				+ bookWriter + ", bookTranslator=" + bookTranslator + ", publisher=" + publisher + ", isCopy=" + isCopy
				+ ", price=" + price + ", bookShop=" + bookShop + ", ea=" + ea + "]";
	}*/
	/*@Override
	public String toString() {
		return "Book [bookNum=" + bookNum + ", proposalNum=" + proposalNum + ", bookName=" + bookName + ", bookWriter="
				+ bookWriter + ", bookTranslator=" + bookTranslator + ", publisher=" + publisher + ", isCopy=" + isCopy
				+ ", price=" + price + ", bookShop=" + bookShop + ", ea=" + ea + ", lastname=" + lastname
				+ ", firstname=" + firstname + ", request=" + request + ", search_value=" + search_value
				+ ", booksearch=" + booksearch + ", proposalRequestDept=" + proposalRequestDept + ", firstCharge="
				+ firstCharge + ", secondCharge=" + secondCharge + ", firstChargeName=" + firstChargeName
				+ ", secondChargeName=" + secondChargeName + ", bookFirstCharge=" + bookFirstCharge + "]";
	}*/
	@Override
	public String toString() {
		return "Book [bookNum=" + bookNum + ", proposalNum=" + proposalNum + ", bookName=" + bookName + ", bookWriter="
				+ bookWriter + ", bookTranslator=" + bookTranslator + ", publisher=" + publisher + ", isCopy=" + isCopy
				+ ", price=" + price + ", bookShop=" + bookShop + ", ea=" + ea + ", lastname=" + lastname
				+ ", firstname=" + firstname + ", request=" + request + ", search_value=" + search_value
				+ ", booksearch=" + booksearch + ", proposalRequestDept=" + proposalRequestDept + ", firstCharge="
				+ firstCharge + ", secondCharge=" + secondCharge + ", firstChargeName=" + firstChargeName
				+ ", secondChargeName=" + secondChargeName + ", bookFirstCharge=" + bookFirstCharge + ", acceptNum="
				+ acceptNum + "]";
	}
	
	
	
	
	
}
