package com.tour.app.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tour.app.dao.FaqDao;

@Repository
public class FaqDaoImpl implements FaqDao{

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	final static String FAQ_NAMESPACE = "com.tour.app.dao.FaqDao";
	
	@Override
	public ArrayList tabMenu() {
		return (ArrayList) sqlSession.selectList(FAQ_NAMESPACE + ".tabMenu");
	}
	
	@Override
	public ArrayList allList() {
		return (ArrayList) sqlSession.selectList(FAQ_NAMESPACE + ".allList");
	}

	@Override
	public ArrayList allList(String catCd2) {
		return (ArrayList) sqlSession.selectList(FAQ_NAMESPACE + ".allList",catCd2);
	}
	


	
	

}
