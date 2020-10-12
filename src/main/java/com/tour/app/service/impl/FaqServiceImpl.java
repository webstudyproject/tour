package com.tour.app.service.impl;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tour.app.dao.FaqDao;
import com.tour.app.service.FaqService;

import lombok.AllArgsConstructor;

@Service
public class FaqServiceImpl implements FaqService{
	
	@Autowired
	private FaqDao dao;

	@Override
	public ArrayList tabMenu() {
		return dao.tabMenu();
	}
	@Override
	public ArrayList allList() {
		return dao.allList();
	}
	@Override
	public ArrayList allList(String catCd2) {
		return dao.allList(catCd2);
	}
	
}
