package com.rock.book.model;

public class ProposalWrite {
	private Integer proposalNum;
	private String code;
	private String date;
	private String purpose;
	private String pay;
	private String bookStatus;
	private String deny;
	private String others;
	private String refer;
	private String agenda1;
	private String agenda2;
	private String agenda3;
	private String agenda4;
	private Integer proposalPrice;
	private String vat;
	private String count;
	//요청부서 추가 . 2016/10/04
	private String departmentName;
	//관리자(정),(부) 추가. 2016/10/04
	private String firstCharge;
	private String secondCharge;
	
	private String firstChargeId;
	private String secondChargeId;
	private String firstChargeName;
	private String secondChargeName;
	
	//책 개수 추가. 2016/11/24
	private Integer bookCount;
	
	public Integer getBookCount() {
		return bookCount;
	}
	public void setBookCount(Integer bookCount) {
		this.bookCount = bookCount;
	}
	//book
	private String bookNum1;
	private String bookName1;
	private String bookWriter1;
	private String bookTranslator1;
	private String publisher1;
	private String is_copy1;
	private String price1;
	private String bookShop1;
	private Integer ea1;
	private String option11;
	private String option21;
	private String copyX1;
	private String copyY1;
	private String payCard1;
	private String payCash1;
	//end;1
	private String bookNum2;
	private String bookName2;
	private String bookWriter2;
	private String bookTranslator2;
	private String publisher2;
	private String is_copy2;
	private String price2;
	private String bookShop2;
	private Integer ea2;
	private String option12;
	private String option22;
	private String copyX2;
	private String copyY2;
	private String payCard2;
	private String payCash2;
	//end;2
	private String bookNum3;
	private String bookName3;
	private String bookWriter3;
	private String bookTranslator3;
	private String publisher3;
	private String is_copy3;
	private String price3;
	private String bookShop3;
	private Integer ea3;
	private String option13;
	private String option23;
	private String copyX3;
	private String copyY3;
	private String payCard3;
	private String payCash3;
	//end;3
	private String bookNum4;
	private String bookName4;
	private String bookWriter4;
	private String bookTranslator4;
	private String publisher4;
	private String is_copy4;
	private String price4;
	private String bookShop4;
	private Integer ea4;
	private String option14;
	private String option24;
	private String copyX4;
	private String copyY4;
	private String payCard4;
	private String payCash4;
	//end;4
	private String bookNum5;
	private String bookName5;
	private String bookWriter5;
	private String bookTranslator5;
	private String publisher5;
	private String is_copy5;
	private String price5;
	private String bookShop5;
	private Integer ea5;
	private String option15;
	private String option25;
	private String copyX5;
	private String copyY5;
	private String payCard5;
	private String payCash5;
	//end;5
	private String bookNum6;
	private String bookName6;
	private String bookWriter6;
	private String bookTranslator6;
	private String publisher6;
	private String is_copy6;
	private String price6;
	private String bookShop6;
	private Integer ea6;
	private String option16;
	private String option26;
	private String copyX6;
	private String copyY6;
	private String payCard6;
	private String payCash6;
	//end;6
	private String bookNum7;
	private String bookName7;
	private String bookWriter7;
	private String bookTranslator7;
	private String publisher7;
	private String is_copy7;
	private String price7;
	private String bookShop7;
	private Integer ea7;
	private String option17;
	private String option27;
	private String copyX7;
	private String copyY7;
	private String payCard7;
	private String payCash7;
	//end;7
	private String bookNum8;
	private String bookName8;
	private String bookWriter8;
	private String bookTranslator8;
	private String publisher8;
	private String is_copy8;
	private String price8;
	private String bookShop8;
	private Integer ea8;
	private String option18;
	private String option28;
	private String copyX8;
	private String copyY8;
	private String payCard8;
	private String payCash8;
	//end;8
	private String bookNum9;
	private String bookName9;
	private String bookWriter9;
	private String bookTranslator9;
	private String publisher9;
	private String is_copy9;
	private String price9;
	private String bookShop9;
	private Integer ea9;
	private String option19;
	private String option29;
	private String copyX9;
	private String copyY9;
	private String payCard9;
	private String payCash9;
	//end;9
	private String bookNum10;
	private String bookName10;
	private String bookWriter10;
	private String bookTranslator10;
	private String publisher10;
	private String is_copy10;
	private String price10;
	private String bookShop10;
	private Integer ea10;
	private String option110;
	private String option210;
	private String copyX10;
	private String copyY10;
	private String payCard10;
	private String payCash10;
	//end;10
	
	//요청부서 추가.. 2016/10/04
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	
	//관리자(정),(부) 추가

	
	public String getCount() {
		return count;
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
	public String getFirstChargeId() {
		return firstChargeId;
	}
	public void setFirstChargeId(String firstChargeId) {
		this.firstChargeId = firstChargeId;
	}
	public String getSecondChargeId() {
		return secondChargeId;
	}
	public void setSecondChargeId(String secondChargeId) {
		this.secondChargeId = secondChargeId;
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
	public void setCount(String count) {
		this.count = count;
	}
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
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date= date;
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
	public String getAgenda1() {
		return agenda1;
	}
	public void setAgenda1(String agenda1) {
		this.agenda1 = agenda1;
	}
	public String getAgenda2() {
		return agenda2;
	}
	public void setAgenda2(String agenda2) {
		this.agenda2 = agenda2;
	}
	public String getAgenda3() {
		return agenda3;
	}
	public void setAgenda3(String agenda3) {
		this.agenda3 = agenda3;
	}
	public String getAgenda4() {
		return agenda4;
	}
	public void setAgenda4(String agenda4) {
		this.agenda4 = agenda4;
	}
	public Integer getProposalPrice() {
		return proposalPrice;
	}
	public void setProposalPrice(Integer proposalPrice) {
		this.proposalPrice = proposalPrice;
	}
	public String getVat() {
		return vat;
	}
	public void setVat(String vat) {
		this.vat = vat;
	}
	public String getBookNum1() {
		return bookNum1;
	}
	public void setBookNum1(String bookNum1) {
		this.bookNum1 = bookNum1;
	}
	public String getBookName1() {
		return bookName1;
	}
	public void setBookName1(String bookName1) {
		this.bookName1 = bookName1;
	}
	public String getBookWriter1() {
		return bookWriter1;
	}
	public void setBookWriter1(String bookWriter1) {
		this.bookWriter1 = bookWriter1;
	}
	public String getBookTranslator1() {
		return bookTranslator1;
	}
	public void setBookTranslator1(String bookTranslator1) {
		this.bookTranslator1 = bookTranslator1;
	}
	public String getPublisher1() {
		return publisher1;
	}
	public void setPublisher1(String publisher1) {
		this.publisher1 = publisher1;
	}
	public String getIs_copy1() {
		return is_copy1;
	}
	public void setIs_copy1(String is_copy1) {
		this.is_copy1 = is_copy1;
	}
	public String getPrice1() {
		return price1;
	}
	public void setPrice1(String price1) {
		this.price1 = price1;
	}
	public String getBookShop1() {
		return bookShop1;
	}
	public void setBookShop1(String bookShop1) {
		this.bookShop1 = bookShop1;
	}
	public Integer getEa1() {
		return ea1;
	}
	public void setEa1(Integer ea1) {
		this.ea1 = ea1;
	}
	public String getOption11() {
		return option11;
	}
	public void setOption11(String option11) {
		this.option11 = option11;
	}
	public String getOption21() {
		return option21;
	}
	public void setOption21(String option21) {
		this.option21 = option21;
	}
	public String getCopyX1() {
		return copyX1;
	}
	public void setCopyX1(String copyX1) {
		this.copyX1 = copyX1;
	}
	public String getCopyY1() {
		return copyY1;
	}
	public void setCopyY1(String copyY1) {
		this.copyY1 = copyY1;
	}
	public String getPayCard1() {
		return payCard1;
	}
	public void setPayCard1(String payCard1) {
		this.payCard1 = payCard1;
	}
	public String getPayCash1() {
		return payCash1;
	}
	public void setPayCash1(String payCash1) {
		this.payCash1 = payCash1;
	}
	public String getBookNum2() {
		return bookNum2;
	}
	public void setBookNum2(String bookNum2) {
		this.bookNum2 = bookNum2;
	}
	public String getBookName2() {
		return bookName2;
	}
	public void setBookName2(String bookName2) {
		this.bookName2 = bookName2;
	}
	public String getBookWriter2() {
		return bookWriter2;
	}
	public void setBookWriter2(String bookWriter2) {
		this.bookWriter2 = bookWriter2;
	}
	public String getBookTranslator2() {
		return bookTranslator2;
	}
	public void setBookTranslator2(String bookTranslator2) {
		this.bookTranslator2 = bookTranslator2;
	}
	public String getPublisher2() {
		return publisher2;
	}
	public void setPublisher2(String publisher2) {
		this.publisher2 = publisher2;
	}
	public String getIs_copy2() {
		return is_copy2;
	}
	public void setIs_copy2(String is_copy2) {
		this.is_copy2 = is_copy2;
	}
	public String getPrice2() {
		return price2;
	}
	public void setPrice2(String price2) {
		this.price2 = price2;
	}
	public String getBookShop2() {
		return bookShop2;
	}
	public void setBookShop2(String bookShop2) {
		this.bookShop2 = bookShop2;
	}
	public Integer getEa2() {
		return ea2;
	}
	public void setEa2(Integer ea2) {
		this.ea2 = ea2;
	}
	public String getOption12() {
		return option12;
	}
	public void setOption12(String option12) {
		this.option12 = option12;
	}
	public String getOption22() {
		return option22;
	}
	public void setOption22(String option22) {
		this.option22 = option22;
	}
	public String getCopyX2() {
		return copyX2;
	}
	public void setCopyX2(String copyX2) {
		this.copyX2 = copyX2;
	}
	public String getCopyY2() {
		return copyY2;
	}
	public void setCopyY2(String copyY2) {
		this.copyY2 = copyY2;
	}
	public String getPayCard2() {
		return payCard2;
	}
	public void setPayCard2(String payCard2) {
		this.payCard2 = payCard2;
	}
	public String getPayCash2() {
		return payCash2;
	}
	public void setPayCash2(String payCash2) {
		this.payCash2 = payCash2;
	}
	public String getBookNum3() {
		return bookNum3;
	}
	public void setBookNum3(String bookNum3) {
		this.bookNum3 = bookNum3;
	}
	public String getBookName3() {
		return bookName3;
	}
	public void setBookName3(String bookName3) {
		this.bookName3 = bookName3;
	}
	public String getBookWriter3() {
		return bookWriter3;
	}
	public void setBookWriter3(String bookWriter3) {
		this.bookWriter3 = bookWriter3;
	}
	public String getBookTranslator3() {
		return bookTranslator3;
	}
	public void setBookTranslator3(String bookTranslator3) {
		this.bookTranslator3 = bookTranslator3;
	}
	public String getPublisher3() {
		return publisher3;
	}
	public void setPublisher3(String publisher3) {
		this.publisher3 = publisher3;
	}
	public String getIs_copy3() {
		return is_copy3;
	}
	public void setIs_copy3(String is_copy3) {
		this.is_copy3 = is_copy3;
	}
	public String getPrice3() {
		return price3;
	}
	public void setPrice3(String price3) {
		this.price3 = price3;
	}
	public String getBookShop3() {
		return bookShop3;
	}
	public void setBookShop3(String bookShop3) {
		this.bookShop3 = bookShop3;
	}
	public Integer getEa3() {
		return ea3;
	}
	public void setEa3(Integer ea3) {
		this.ea3 = ea3;
	}
	public String getOption13() {
		return option13;
	}
	public void setOption13(String option13) {
		this.option13 = option13;
	}
	public String getOption23() {
		return option23;
	}
	public void setOption23(String option23) {
		this.option23 = option23;
	}
	public String getCopyX3() {
		return copyX3;
	}
	public void setCopyX3(String copyX3) {
		this.copyX3 = copyX3;
	}
	public String getCopyY3() {
		return copyY3;
	}
	public void setCopyY3(String copyY3) {
		this.copyY3 = copyY3;
	}
	public String getPayCard3() {
		return payCard3;
	}
	public void setPayCard3(String payCard3) {
		this.payCard3 = payCard3;
	}
	public String getPayCash3() {
		return payCash3;
	}
	public void setPayCash3(String payCash3) {
		this.payCash3 = payCash3;
	}
	public String getBookNum4() {
		return bookNum4;
	}
	public void setBookNum4(String bookNum4) {
		this.bookNum4 = bookNum4;
	}
	public String getBookName4() {
		return bookName4;
	}
	public void setBookName4(String bookName4) {
		this.bookName4 = bookName4;
	}
	public String getBookWriter4() {
		return bookWriter4;
	}
	public void setBookWriter4(String bookWriter4) {
		this.bookWriter4 = bookWriter4;
	}
	public String getBookTranslator4() {
		return bookTranslator4;
	}
	public void setBookTranslator4(String bookTranslator4) {
		this.bookTranslator4 = bookTranslator4;
	}
	public String getPublisher4() {
		return publisher4;
	}
	public void setPublisher4(String publisher4) {
		this.publisher4 = publisher4;
	}
	public String getIs_copy4() {
		return is_copy4;
	}
	public void setIs_copy4(String is_copy4) {
		this.is_copy4 = is_copy4;
	}
	public String getPrice4() {
		return price4;
	}
	public void setPrice4(String price4) {
		this.price4 = price4;
	}
	public String getBookShop4() {
		return bookShop4;
	}
	public void setBookShop4(String bookShop4) {
		this.bookShop4 = bookShop4;
	}
	public Integer getEa4() {
		return ea4;
	}
	public void setEa4(Integer ea4) {
		this.ea4 = ea4;
	}
	public String getOption14() {
		return option14;
	}
	public void setOption14(String option14) {
		this.option14 = option14;
	}
	public String getOption24() {
		return option24;
	}
	public void setOption24(String option24) {
		this.option24 = option24;
	}
	public String getCopyX4() {
		return copyX4;
	}
	public void setCopyX4(String copyX4) {
		this.copyX4 = copyX4;
	}
	public String getCopyY4() {
		return copyY4;
	}
	public void setCopyY4(String copyY4) {
		this.copyY4 = copyY4;
	}
	public String getPayCard4() {
		return payCard4;
	}
	public void setPayCard4(String payCard4) {
		this.payCard4 = payCard4;
	}
	public String getPayCash4() {
		return payCash4;
	}
	public void setPayCash4(String payCash4) {
		this.payCash4 = payCash4;
	}
	public String getBookNum5() {
		return bookNum5;
	}
	public void setBookNum5(String bookNum5) {
		this.bookNum5 = bookNum5;
	}
	public String getBookName5() {
		return bookName5;
	}
	public void setBookName5(String bookName5) {
		this.bookName5 = bookName5;
	}
	public String getBookWriter5() {
		return bookWriter5;
	}
	public void setBookWriter5(String bookWriter5) {
		this.bookWriter5 = bookWriter5;
	}
	public String getBookTranslator5() {
		return bookTranslator5;
	}
	public void setBookTranslator5(String bookTranslator5) {
		this.bookTranslator5 = bookTranslator5;
	}
	public String getPublisher5() {
		return publisher5;
	}
	public void setPublisher5(String publisher5) {
		this.publisher5 = publisher5;
	}
	public String getIs_copy5() {
		return is_copy5;
	}
	public void setIs_copy5(String is_copy5) {
		this.is_copy5 = is_copy5;
	}
	public String getPrice5() {
		return price5;
	}
	public void setPrice5(String price5) {
		this.price5 = price5;
	}
	public String getBookShop5() {
		return bookShop5;
	}
	public void setBookShop5(String bookShop5) {
		this.bookShop5 = bookShop5;
	}
	public Integer getEa5() {
		return ea5;
	}
	public void setEa5(Integer ea5) {
		this.ea5 = ea5;
	}
	public String getOption15() {
		return option15;
	}
	public void setOption15(String option15) {
		this.option15 = option15;
	}
	public String getOption25() {
		return option25;
	}
	public void setOption25(String option25) {
		this.option25 = option25;
	}
	public String getCopyX5() {
		return copyX5;
	}
	public void setCopyX5(String copyX5) {
		this.copyX5 = copyX5;
	}
	public String getCopyY5() {
		return copyY5;
	}
	public void setCopyY5(String copyY5) {
		this.copyY5 = copyY5;
	}
	public String getPayCard5() {
		return payCard5;
	}
	public void setPayCard5(String payCard5) {
		this.payCard5 = payCard5;
	}
	public String getPayCash5() {
		return payCash5;
	}
	public void setPayCash5(String payCash5) {
		this.payCash5 = payCash5;
	}
	public String getBookNum6() {
		return bookNum6;
	}
	public void setBookNum6(String bookNum6) {
		this.bookNum6 = bookNum6;
	}
	public String getBookName6() {
		return bookName6;
	}
	public void setBookName6(String bookName6) {
		this.bookName6 = bookName6;
	}
	public String getBookWriter6() {
		return bookWriter6;
	}
	public void setBookWriter6(String bookWriter6) {
		this.bookWriter6 = bookWriter6;
	}
	public String getBookTranslator6() {
		return bookTranslator6;
	}
	public void setBookTranslator6(String bookTranslator6) {
		this.bookTranslator6 = bookTranslator6;
	}
	public String getPublisher6() {
		return publisher6;
	}
	public void setPublisher6(String publisher6) {
		this.publisher6 = publisher6;
	}
	public String getIs_copy6() {
		return is_copy6;
	}
	public void setIs_copy6(String is_copy6) {
		this.is_copy6 = is_copy6;
	}
	public String getPrice6() {
		return price6;
	}
	public void setPrice6(String price6) {
		this.price6 = price6;
	}
	public String getBookShop6() {
		return bookShop6;
	}
	public void setBookShop6(String bookShop6) {
		this.bookShop6 = bookShop6;
	}
	public Integer getEa6() {
		return ea6;
	}
	public void setEa6(Integer ea6) {
		this.ea6 = ea6;
	}
	public String getOption16() {
		return option16;
	}
	public void setOption16(String option16) {
		this.option16 = option16;
	}
	public String getOption26() {
		return option26;
	}
	public void setOption26(String option26) {
		this.option26 = option26;
	}
	public String getCopyX6() {
		return copyX6;
	}
	public void setCopyX6(String copyX6) {
		this.copyX6 = copyX6;
	}
	public String getCopyY6() {
		return copyY6;
	}
	public void setCopyY6(String copyY6) {
		this.copyY6 = copyY6;
	}
	public String getPayCard6() {
		return payCard6;
	}
	public void setPayCard6(String payCard6) {
		this.payCard6 = payCard6;
	}
	public String getPayCash6() {
		return payCash6;
	}
	public void setPayCash6(String payCash6) {
		this.payCash6 = payCash6;
	}
	public String getBookNum7() {
		return bookNum7;
	}
	public void setBookNum7(String bookNum7) {
		this.bookNum7 = bookNum7;
	}
	public String getBookName7() {
		return bookName7;
	}
	public void setBookName7(String bookName7) {
		this.bookName7 = bookName7;
	}
	public String getBookWriter7() {
		return bookWriter7;
	}
	public void setBookWriter7(String bookWriter7) {
		this.bookWriter7 = bookWriter7;
	}
	public String getBookTranslator7() {
		return bookTranslator7;
	}
	public void setBookTranslator7(String bookTranslator7) {
		this.bookTranslator7 = bookTranslator7;
	}
	public String getPublisher7() {
		return publisher7;
	}
	public void setPublisher7(String publisher7) {
		this.publisher7 = publisher7;
	}
	public String getIs_copy7() {
		return is_copy7;
	}
	public void setIs_copy7(String is_copy7) {
		this.is_copy7 = is_copy7;
	}
	public String getPrice7() {
		return price7;
	}
	public void setPrice7(String price7) {
		this.price7 = price7;
	}
	public String getBookShop7() {
		return bookShop7;
	}
	public void setBookShop7(String bookShop7) {
		this.bookShop7 = bookShop7;
	}
	public Integer getEa7() {
		return ea7;
	}
	public void setEa7(Integer ea7) {
		this.ea7 = ea7;
	}
	public String getOption17() {
		return option17;
	}
	public void setOption17(String option17) {
		this.option17 = option17;
	}
	public String getOption27() {
		return option27;
	}
	public void setOption27(String option27) {
		this.option27 = option27;
	}
	public String getCopyX7() {
		return copyX7;
	}
	public void setCopyX7(String copyX7) {
		this.copyX7 = copyX7;
	}
	public String getCopyY7() {
		return copyY7;
	}
	public void setCopyY7(String copyY7) {
		this.copyY7 = copyY7;
	}
	public String getPayCard7() {
		return payCard7;
	}
	public void setPayCard7(String payCard7) {
		this.payCard7 = payCard7;
	}
	public String getPayCash7() {
		return payCash7;
	}
	public void setPayCash7(String payCash7) {
		this.payCash7 = payCash7;
	}
	public String getBookNum8() {
		return bookNum8;
	}
	public void setBookNum8(String bookNum8) {
		this.bookNum8 = bookNum8;
	}
	public String getBookName8() {
		return bookName8;
	}
	public void setBookName8(String bookName8) {
		this.bookName8 = bookName8;
	}
	public String getBookWriter8() {
		return bookWriter8;
	}
	public void setBookWriter8(String bookWriter8) {
		this.bookWriter8 = bookWriter8;
	}
	public String getBookTranslator8() {
		return bookTranslator8;
	}
	public void setBookTranslator8(String bookTranslator8) {
		this.bookTranslator8 = bookTranslator8;
	}
	public String getPublisher8() {
		return publisher8;
	}
	public void setPublisher8(String publisher8) {
		this.publisher8 = publisher8;
	}
	public String getIs_copy8() {
		return is_copy8;
	}
	public void setIs_copy8(String is_copy8) {
		this.is_copy8 = is_copy8;
	}
	public String getPrice8() {
		return price8;
	}
	public void setPrice8(String price8) {
		this.price8 = price8;
	}
	public String getBookShop8() {
		return bookShop8;
	}
	public void setBookShop8(String bookShop8) {
		this.bookShop8 = bookShop8;
	}
	public Integer getEa8() {
		return ea8;
	}
	public void setEa8(Integer ea8) {
		this.ea8 = ea8;
	}
	public String getOption18() {
		return option18;
	}
	public void setOption18(String option18) {
		this.option18 = option18;
	}
	public String getOption28() {
		return option28;
	}
	public void setOption28(String option28) {
		this.option28 = option28;
	}
	public String getCopyX8() {
		return copyX8;
	}
	public void setCopyX8(String copyX8) {
		this.copyX8 = copyX8;
	}
	public String getCopyY8() {
		return copyY8;
	}
	public void setCopyY8(String copyY8) {
		this.copyY8 = copyY8;
	}
	public String getPayCard8() {
		return payCard8;
	}
	public void setPayCard8(String payCard8) {
		this.payCard8 = payCard8;
	}
	public String getPayCash8() {
		return payCash8;
	}
	public void setPayCash8(String payCash8) {
		this.payCash8 = payCash8;
	}
	public String getBookNum9() {
		return bookNum9;
	}
	public void setBookNum9(String bookNum9) {
		this.bookNum9 = bookNum9;
	}
	public String getBookName9() {
		return bookName9;
	}
	public void setBookName9(String bookName9) {
		this.bookName9 = bookName9;
	}
	public String getBookWriter9() {
		return bookWriter9;
	}
	public void setBookWriter9(String bookWriter9) {
		this.bookWriter9 = bookWriter9;
	}
	public String getBookTranslator9() {
		return bookTranslator9;
	}
	public void setBookTranslator9(String bookTranslator9) {
		this.bookTranslator9 = bookTranslator9;
	}
	public String getPublisher9() {
		return publisher9;
	}
	public void setPublisher9(String publisher9) {
		this.publisher9 = publisher9;
	}
	public String getIs_copy9() {
		return is_copy9;
	}
	public void setIs_copy9(String is_copy9) {
		this.is_copy9 = is_copy9;
	}
	public String getPrice9() {
		return price9;
	}
	public void setPrice9(String price9) {
		this.price9 = price9;
	}
	public String getBookShop9() {
		return bookShop9;
	}
	public void setBookShop9(String bookShop9) {
		this.bookShop9 = bookShop9;
	}
	public Integer getEa9() {
		return ea9;
	}
	public void setEa9(Integer ea9) {
		this.ea9 = ea9;
	}
	public String getOption19() {
		return option19;
	}
	public void setOption19(String option19) {
		this.option19 = option19;
	}
	public String getOption29() {
		return option29;
	}
	public void setOption29(String option29) {
		this.option29 = option29;
	}
	public String getCopyX9() {
		return copyX9;
	}
	public void setCopyX9(String copyX9) {
		this.copyX9 = copyX9;
	}
	public String getCopyY9() {
		return copyY9;
	}
	public void setCopyY9(String copyY9) {
		this.copyY9 = copyY9;
	}
	public String getPayCard9() {
		return payCard9;
	}
	public void setPayCard9(String payCard9) {
		this.payCard9 = payCard9;
	}
	public String getPayCash9() {
		return payCash9;
	}
	public void setPayCash9(String payCash9) {
		this.payCash9 = payCash9;
	}
	public String getBookNum10() {
		return bookNum10;
	}
	public void setBookNum10(String bookNum10) {
		this.bookNum10 = bookNum10;
	}
	public String getBookName10() {
		return bookName10;
	}
	public void setBookName10(String bookName10) {
		this.bookName10 = bookName10;
	}
	public String getBookWriter10() {
		return bookWriter10;
	}
	public void setBookWriter10(String bookWriter10) {
		this.bookWriter10 = bookWriter10;
	}
	public String getBookTranslator10() {
		return bookTranslator10;
	}
	public void setBookTranslator10(String bookTranslator10) {
		this.bookTranslator10 = bookTranslator10;
	}
	public String getPublisher10() {
		return publisher10;
	}
	public void setPublisher10(String publisher10) {
		this.publisher10 = publisher10;
	}
	public String getIs_copy10() {
		return is_copy10;
	}
	public void setIs_copy10(String is_copy10) {
		this.is_copy10 = is_copy10;
	}
	public String getPrice10() {
		return price10;
	}
	public void setPrice10(String price10) {
		this.price10 = price10;
	}
	public String getBookShop10() {
		return bookShop10;
	}
	public void setBookShop10(String bookShop10) {
		this.bookShop10 = bookShop10;
	}
	public Integer getEa10() {
		return ea10;
	}
	public void setEa10(Integer ea10) {
		this.ea10 = ea10;
	}
	public String getOption110() {
		return option110;
	}
	public void setOption110(String option110) {
		this.option110 = option110;
	}
	public String getOption210() {
		return option210;
	}
	public void setOption210(String option210) {
		this.option210 = option210;
	}
	public String getCopyX10() {
		return copyX10;
	}
	public void setCopyX10(String copyX10) {
		this.copyX10 = copyX10;
	}
	public String getCopyY10() {
		return copyY10;
	}
	public void setCopyY10(String copyY10) {
		this.copyY10 = copyY10;
	}
	public String getPayCard10() {
		return payCard10;
	}
	public void setPayCard10(String payCard10) {
		this.payCard10 = payCard10;
	}
	public String getPayCash10() {
		return payCash10;
	}
	public void setPayCash10(String payCash10) {
		this.payCash10 = payCash10;
	}
	@Override
	public String toString() {
		return "ProposalWrite [proposalNum=" + proposalNum + ", code=" + code + ", date=" + date + ", purpose="
				+ purpose + ", pay=" + pay + ", bookStatus=" + bookStatus + ", deny=" + deny + ", others=" + others
				+ ", refer=" + refer + ", agenda1=" + agenda1 + ", agenda2=" + agenda2 + ", agenda3=" + agenda3
				+ ", agenda4=" + agenda4 + ", proposalPrice=" + proposalPrice + ", vat=" + vat + ", count=" + count
				+ ", departmentName=" + departmentName + ", firstCharge=" + firstCharge + ", secondCharge="
				+ secondCharge + ", firstChargeId=" + firstChargeId + ", secondChargeId=" + secondChargeId
				+ ", firstChargeName=" + firstChargeName + ", secondChargeName=" + secondChargeName + ", bookCount="
				+ bookCount + ", bookNum1=" + bookNum1 + ", bookName1=" + bookName1 + ", bookWriter1=" + bookWriter1
				+ ", bookTranslator1=" + bookTranslator1 + ", publisher1=" + publisher1 + ", is_copy1=" + is_copy1
				+ ", price1=" + price1 + ", bookShop1=" + bookShop1 + ", ea1=" + ea1 + ", option11=" + option11
				+ ", option21=" + option21 + ", copyX1=" + copyX1 + ", copyY1=" + copyY1 + ", payCard1=" + payCard1
				+ ", payCash1=" + payCash1 + ", bookNum2=" + bookNum2 + ", bookName2=" + bookName2 + ", bookWriter2="
				+ bookWriter2 + ", bookTranslator2=" + bookTranslator2 + ", publisher2=" + publisher2 + ", is_copy2="
				+ is_copy2 + ", price2=" + price2 + ", bookShop2=" + bookShop2 + ", ea2=" + ea2 + ", option12="
				+ option12 + ", option22=" + option22 + ", copyX2=" + copyX2 + ", copyY2=" + copyY2 + ", payCard2="
				+ payCard2 + ", payCash2=" + payCash2 + ", bookNum3=" + bookNum3 + ", bookName3=" + bookName3
				+ ", bookWriter3=" + bookWriter3 + ", bookTranslator3=" + bookTranslator3 + ", publisher3=" + publisher3
				+ ", is_copy3=" + is_copy3 + ", price3=" + price3 + ", bookShop3=" + bookShop3 + ", ea3=" + ea3
				+ ", option13=" + option13 + ", option23=" + option23 + ", copyX3=" + copyX3 + ", copyY3=" + copyY3
				+ ", payCard3=" + payCard3 + ", payCash3=" + payCash3 + ", bookNum4=" + bookNum4 + ", bookName4="
				+ bookName4 + ", bookWriter4=" + bookWriter4 + ", bookTranslator4=" + bookTranslator4 + ", publisher4="
				+ publisher4 + ", is_copy4=" + is_copy4 + ", price4=" + price4 + ", bookShop4=" + bookShop4 + ", ea4="
				+ ea4 + ", option14=" + option14 + ", option24=" + option24 + ", copyX4=" + copyX4 + ", copyY4="
				+ copyY4 + ", payCard4=" + payCard4 + ", payCash4=" + payCash4 + ", bookNum5=" + bookNum5
				+ ", bookName5=" + bookName5 + ", bookWriter5=" + bookWriter5 + ", bookTranslator5=" + bookTranslator5
				+ ", publisher5=" + publisher5 + ", is_copy5=" + is_copy5 + ", price5=" + price5 + ", bookShop5="
				+ bookShop5 + ", ea5=" + ea5 + ", option15=" + option15 + ", option25=" + option25 + ", copyX5="
				+ copyX5 + ", copyY5=" + copyY5 + ", payCard5=" + payCard5 + ", payCash5=" + payCash5 + ", bookNum6="
				+ bookNum6 + ", bookName6=" + bookName6 + ", bookWriter6=" + bookWriter6 + ", bookTranslator6="
				+ bookTranslator6 + ", publisher6=" + publisher6 + ", is_copy6=" + is_copy6 + ", price6=" + price6
				+ ", bookShop6=" + bookShop6 + ", ea6=" + ea6 + ", option16=" + option16 + ", option26=" + option26
				+ ", copyX6=" + copyX6 + ", copyY6=" + copyY6 + ", payCard6=" + payCard6 + ", payCash6=" + payCash6
				+ ", bookNum7=" + bookNum7 + ", bookName7=" + bookName7 + ", bookWriter7=" + bookWriter7
				+ ", bookTranslator7=" + bookTranslator7 + ", publisher7=" + publisher7 + ", is_copy7=" + is_copy7
				+ ", price7=" + price7 + ", bookShop7=" + bookShop7 + ", ea7=" + ea7 + ", option17=" + option17
				+ ", option27=" + option27 + ", copyX7=" + copyX7 + ", copyY7=" + copyY7 + ", payCard7=" + payCard7
				+ ", payCash7=" + payCash7 + ", bookNum8=" + bookNum8 + ", bookName8=" + bookName8 + ", bookWriter8="
				+ bookWriter8 + ", bookTranslator8=" + bookTranslator8 + ", publisher8=" + publisher8 + ", is_copy8="
				+ is_copy8 + ", price8=" + price8 + ", bookShop8=" + bookShop8 + ", ea8=" + ea8 + ", option18="
				+ option18 + ", option28=" + option28 + ", copyX8=" + copyX8 + ", copyY8=" + copyY8 + ", payCard8="
				+ payCard8 + ", payCash8=" + payCash8 + ", bookNum9=" + bookNum9 + ", bookName9=" + bookName9
				+ ", bookWriter9=" + bookWriter9 + ", bookTranslator9=" + bookTranslator9 + ", publisher9=" + publisher9
				+ ", is_copy9=" + is_copy9 + ", price9=" + price9 + ", bookShop9=" + bookShop9 + ", ea9=" + ea9
				+ ", option19=" + option19 + ", option29=" + option29 + ", copyX9=" + copyX9 + ", copyY9=" + copyY9
				+ ", payCard9=" + payCard9 + ", payCash9=" + payCash9 + ", bookNum10=" + bookNum10 + ", bookName10="
				+ bookName10 + ", bookWriter10=" + bookWriter10 + ", bookTranslator10=" + bookTranslator10
				+ ", publisher10=" + publisher10 + ", is_copy10=" + is_copy10 + ", price10=" + price10 + ", bookShop10="
				+ bookShop10 + ", ea10=" + ea10 + ", option110=" + option110 + ", option210=" + option210 + ", copyX10="
				+ copyX10 + ", copyY10=" + copyY10 + ", payCard10=" + payCard10 + ", payCash10=" + payCash10 + "]";
	}
	
	
	
	
	
	
}
