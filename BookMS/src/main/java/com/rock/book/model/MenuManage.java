package com.rock.book.model;

public class MenuManage {
	
	private Integer menu_id;
	private String menu_name;
	private String start_date;
	private String end_date;
	private Integer apply_flag;
	
	public Integer getMenu_id() {
		return menu_id;
	}
	public void setMenu_id(Integer menu_id) {
		this.menu_id = menu_id;
	}
	public String getMenu_name() {
		return menu_name;
	}
	public void setMenu_name(String menu_name) {
		this.menu_name = menu_name;
	}
	public String getStart_date() {
		return start_date;
	}
	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}
	public String getEnd_date() {
		return end_date;
	}
	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}
	public Integer getApply_flag() {
		return apply_flag;
	}
	public void setApply_flag(Integer apply_flag) {
		this.apply_flag = apply_flag;
	}
	
}
