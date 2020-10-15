package com.tour.app.dto;

import java.util.Date;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

public class CatDto {
	private Long catId;
	private String catCd1;
	private String catNm1;
	private String catCd2;
	private String catNm2;
	
	public Long getCatId() {
		return catId;
	}
	public void setCatId(Long catId) {
		this.catId = catId;
	}
	public String getCatCd1() {
		return catCd1;
	}
	public void setCatCd1(String catCd1) {
		this.catCd1 = catCd1;
	}
	public String getCatNm1() {
		return catNm1;
	}
	public void setCatNm1(String catNm1) {
		this.catNm1 = catNm1;
	}
	public String getCatCd2() {
		return catCd2;
	}
	public void setCatCd2(String catCd2) {
		this.catCd2 = catCd2;
	}
	public String getCatNm2() {
		return catNm2;
	}
	public void setCatNm2(String catNm2) {
		this.catNm2 = catNm2;
	}
	
	
	
}
