package com.tour.app.dto;

import java.util.Date;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

public class FaqDto {
	private Long id;
	private String catCd1;
	private String catCd2;
	private String que;
	private String answer;
	private String ord;
	private Date regDate;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCatCd1() {
		return catCd1;
	}
	public void setCatCd1(String catCd1) {
		this.catCd1 = catCd1;
	}
	public String getCatCd2() {
		return catCd2;
	}
	public void setCatCd2(String catCd2) {
		this.catCd2 = catCd2;
	}
	public String getQue() {
		return que;
	}
	public void setQue(String que) {
		this.que = que;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getOrd() {
		return ord;
	}
	public void setOrd(String ord) {
		this.ord = ord;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	
	
	
}
