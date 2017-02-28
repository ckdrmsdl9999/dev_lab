package com.jibnawa.member;
//DB서버에 테이블 정보와 매핑되는 클래스
//VO(Value Object)
//자바와 오라클서버 사이에서 매핑하는데
//사용하는 클래스
//DTO(Data Transfer Object)패턴
public class JibnawaMemberVO {
	private int mem_num   =0;          
	private String mem_email       ="";      
	private String mem_name        ="";          
	private String mem_nickname    ="";           
	private String mem_div         ="";           
	private String mem_lev          ="";         
	private String mem_pw           ="";          
	private String mem_phone_f      ="";      
	private String mem_phone_m      ="";          
	private String mem_phone_e      ="";          
	private String mem_chk           =""; 
	
	
	public int getMem_num() {
		return mem_num;
	}
	public void setMem_num(int mem_num) {
		this.mem_num = mem_num;
	}
	public String getMem_email() {
		return mem_email;
	}
	public void setMem_email(String mem_email) {
		this.mem_email = mem_email;
	}
	public String getMem_name() {
		return mem_name;
	}
	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}
	public String getMem_nickname() {
		return mem_nickname;
	}
	public void setMem_nickname(String mem_nickname) {
		this.mem_nickname = mem_nickname;
	}
	public String getMem_div() {
		return mem_div;
	}
	public void setMem_div(String mem_div) {
		this.mem_div = mem_div;
	}
	public String getMem_lev() {
		return mem_lev;
	}
	public void setMem_lev(String mem_lev) {
		this.mem_lev = mem_lev;
	}
	public String getMem_pw() {
		return mem_pw;
	}
	public void setMem_pw(String mem_pw) {
		this.mem_pw = mem_pw;
	}
	public String getMem_phone_f() {
		return mem_phone_f;
	}
	public void setMem_phone_f(String mem_phone_f) {
		this.mem_phone_f = mem_phone_f;
	}
	public String getMem_phone_m() {
		return mem_phone_m;
	}
	public void setMem_phone_m(String mem_phone_m) {
		this.mem_phone_m = mem_phone_m;
	}
	public String getMem_phone_e() {
		return mem_phone_e;
	}
	public void setMem_phone_e(String mem_phone_e) {
		this.mem_phone_e = mem_phone_e;
	}
	public String getMem_chk() {
		return mem_chk;
	}
	public void setMem_chk(String mem_chk) {
		this.mem_chk = mem_chk;
	}    

}
