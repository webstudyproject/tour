package com.tour.app.dao.impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tour.app.dao.SampleDao;

@Repository
public class SampleDaoImpl implements SampleDao{

	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public int SampleSelect() {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("SampleDao.sampleSelect");	//	mybatis-config.xml 에 있는 ("네임스페이스.식별자");
	}
	
	

}
