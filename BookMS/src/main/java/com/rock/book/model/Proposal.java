package com.rock.book.model;

public class Proposal {
	
	private int proposal_num;
	private String proposal_date;
	private String email;
	private String department_name;
	private String book_status;
	private String search_value;
	private String search;
	private String search_status;
	private String user_name;
	
	private String purpose;
	private String pay;
	private String proposal_price;
	private String price;
	private String others;
	private String refer;
	private String agenda_1;
	private String agenda_2;
	private String agenda_3;
	private String agenda_4;
	private String book_name;
	private String ea;
	private String book_price;
	private String book_shop;
	private String deny;
	private String code;
	private String vat;
	private String company;
	private String first_charge; //관리자(정) 
	private String first_charge_name;
	private String second_charge; //관리자(부) 
	private String second_charge_name;
	
	
	
	public int getProposal_num() {
		return proposal_num;
	}



	public void setProposal_num(int proposal_num) {
		this.proposal_num = proposal_num;
	}



	public String getProposal_date() {
		return proposal_date;
	}



	public void setProposal_date(String proposal_date) {
		this.proposal_date = proposal_date;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getDepartment_name() {
		return department_name;
	}



	public void setDepartment_name(String department_name) {
		this.department_name = department_name;
	}



	public String getBook_status() {
		return book_status;
	}



	public void setBook_status(String book_status) {
		this.book_status = book_status;
	}



	public String getSearch_value() {
		return search_value;
	}



	public void setSearch_value(String search_value) {
		this.search_value = search_value;
	}



	public String getSearch() {
		return search;
	}



	public void setSearch(String search) {
		this.search = search;
	}



	public String getSearch_status() {
		return search_status;
	}



	public void setSearch_status(String search_status) {
		this.search_status = search_status;
	}



	public String getUser_name() {
		return user_name;
	}



	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}



	public String getPurpose() {
		return purpose;
	}



	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}



	public String getPay() {
		return pay;
	}



	public void setPay(String pay) {
		this.pay = pay;
	}



	public String getProposal_price() {
		return proposal_price;
	}



	public void setProposal_price(String proposal_price) {
		this.proposal_price = proposal_price;
	}



	public String getPrice() {
		return price;
	}



	public void setPrice(String price) {
		this.price = price;
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



	public String getBook_name() {
		return book_name;
	}



	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}



	public String getEa() {
		return ea;
	}



	public void setEa(String ea) {
		this.ea = ea;
	}



	public String getBook_price() {
		return book_price;
	}



	public void setBook_price(String book_price) {
		this.book_price = book_price;
	}



	public String getBook_shop() {
		return book_shop;
	}



	public void setBook_shop(String book_shop) {
		this.book_shop = book_shop;
	}



	public String getDeny() {
		return deny;
	}



	public void setDeny(String deny) {
		this.deny = deny;
	}



	public String getCode() {
		return code;
	}



	public void setCode(String code) {
		this.code = code;
	}



	public String getVat() {
		return vat;
	}



	public void setVat(String vat) {
		this.vat = vat;
	}



	public String getCompany() {
		return company;
	}



	public void setCompany(String company) {
		this.company = company;
	}



	public String getFirst_charge() {
		return first_charge;
	}



	public void setFirst_charge(String first_charge) {
		this.first_charge = first_charge;
	}



	public String getFirst_charge_name() {
		return first_charge_name;
	}



	public void setFirst_charge_name(String first_charge_name) {
		this.first_charge_name = first_charge_name;
	}



	public String getSecond_charge() {
		return second_charge;
	}



	public void setSecond_charge(String second_charge) {
		this.second_charge = second_charge;
	}



	public String getSecond_charge_name() {
		return second_charge_name;
	}



	public void setSecond_charge_name(String second_charge_name) {
		this.second_charge_name = second_charge_name;
	}



	@Override
	public String toString() {
		return "Proposal [proposal_num=" + proposal_num + ", proposal_date=" + proposal_date + ", email=" + email
				+ ", department_name=" + department_name + ", book_status=" + book_status + ", search_value="
				+ search_value + ", search=" + search + ", search_status=" + search_status + ", user_name=" + user_name
				+ ", purpose=" + purpose + ", pay=" + pay + ", proposal_price=" + proposal_price + ", price=" + price
				+ ", others=" + others + ", refer=" + refer + ", agenda_1=" + agenda_1 + ", agenda_2=" + agenda_2
				+ ", agenda_3=" + agenda_3 + ", agenda_4=" + agenda_4 + ", book_name=" + book_name + ", ea=" + ea
				+ ", book_price=" + book_price + ", book_shop=" + book_shop + ", deny=" + deny + ", code=" + code
				+ ", vat=" + vat + ", company=" + company + ", first_charge=" + first_charge + "]";
	}

	
}
