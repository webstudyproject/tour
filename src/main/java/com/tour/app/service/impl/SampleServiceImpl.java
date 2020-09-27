package com.tour.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tour.app.dao.SampleDao;
import com.tour.app.service.SampleService;

@Service
public class SampleServiceImpl implements SampleService{

	@Autowired
	private SampleDao sampleDao;

	@Override
	public int SampleSelect() {
		// TODO Auto-generated method stub
		return sampleDao.SampleSelect();
	}
	
}
