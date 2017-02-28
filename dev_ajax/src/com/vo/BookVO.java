package com.vo;

public class BookVO {
	private int    ab_no          =0;//
	private String ab_title       ="";//
	private String ab_author      ="";//
	private String ab_img         ="";//
	private int    ab_price       =0;//
	private String ab_publisher   ="";//
	private int    ab_size        =0;//
	private int total = 0;
	public int getAb_no() {
		return ab_no;
	}
	public void setAb_no(int ab_no) {
		this.ab_no = ab_no;
	}
	public String getAb_title() {
		return ab_title;
	}
	public void setAb_title(String ab_title) {
		this.ab_title = ab_title;
	}
	public String getAb_author() {
		return ab_author;
	}
	public void setAb_author(String ab_author) {
		this.ab_author = ab_author;
	}
	public String getAb_img() {
		return ab_img;
	}
	public void setAb_img(String ab_img) {
		this.ab_img = ab_img;
	}
	public int getAb_price() {
		return ab_price;
	}
	public void setAb_price(int ab_price) {
		this.ab_price = ab_price;
	}
	public String getAb_publisher() {
		return ab_publisher;
	}
	public void setAb_publisher(String ab_publisher) {
		this.ab_publisher = ab_publisher;
	}
	public int getAb_size() {
		return ab_size;
	}
	public void setAb_size(int ab_size) {
		this.ab_size = ab_size;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
}
