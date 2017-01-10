package com.rock.book.model;

public class ProposalList {
	private Integer proposalNum;
	private String code;
	private String proposalDate;
	private String pay;
	private String bookStatus;
	private String deny;
	private String others;
	private String refer;
	private String agenda_1;
	private String agenda_2;
	private String agenda_3;
	private String agenda_4;
	public Integer getProposalNum() {
		return proposalNum;
	}
	public void setProposalNum(Integer proposalNum) {
		this.proposalNum = proposalNum;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getProposalDate() {
		return proposalDate;
	}
	public void setProposalDate(String proposalDate) {
		this.proposalDate = proposalDate;
	}
	public String getPay() {
		return pay;
	}
	public void setPay(String pay) {
		this.pay = pay;
	}
	public String getBookStatus() {
		return bookStatus;
	}
	public void setBookStatus(String bookStatus) {
		this.bookStatus = bookStatus;
	}
	public String getDeny() {
		return deny;
	}
	public void setDeny(String deny) {
		this.deny = deny;
	}
	public String getOthers() {
		return others;
	}
	public void setOthers(String others) {
		this.others = others;
	}
	public String getRefer() {
		return refer;
	}
	public void setRefer(String refer) {
		this.refer = refer;
	}
	public String getAgenda_1() {
		return agenda_1;
	}
	public void setAgenda_1(String agenda_1) {
		this.agenda_1 = agenda_1;
	}
	public String getAgenda_2() {
		return agenda_2;
	}
	public void setAgenda_2(String agenda_2) {
		this.agenda_2 = agenda_2;
	}
	public String getAgenda_3() {
		return agenda_3;
	}
	public void setAgenda_3(String agenda_3) {
		this.agenda_3 = agenda_3;
	}
	public String getAgenda_4() {
		return agenda_4;
	}
	public void setAgenda_4(String agenda_4) {
		this.agenda_4 = agenda_4;
	}
	@Override
	public String toString() {
		return "Proposal [proposalNum=" + proposalNum + ", code=" + code + ", proposalDate=" + proposalDate + ", pay="
				+ pay + ", bookStatus=" + bookStatus + ", deny=" + deny + ", others=" + others + ", refer=" + refer
				+ ", agenda_1=" + agenda_1 + ", agenda_2=" + agenda_2 + ", agenda_3=" + agenda_3 + ", agenda_4="
				+ agenda_4 + "]";
	}
	
	
}
