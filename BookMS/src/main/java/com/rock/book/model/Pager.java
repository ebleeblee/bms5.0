package com.rock.book.model;

import java.io.Serializable;

public class Pager implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = -5629407286531552969L;

	Integer current_page;
	Integer last_page;
	Integer max_rows;
	
	public Integer getCurrent_page() {
		return current_page;
	}
	public void setCurrent_page(Integer current_page) {
		this.current_page = current_page;
	}
	public Integer getLast_page() {
		return last_page;
	}
	public void setLast_page(Integer last_page) {
		this.last_page = last_page;
	}
	public Integer getMax_rows() {
		return max_rows;
	}
	public void setMax_rows(Integer max_rows) {
		this.max_rows = max_rows;
	}
	
}
