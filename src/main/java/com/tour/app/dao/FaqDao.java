package com.tour.app.dao;

import java.util.*;

import org.apache.ibatis.annotations.Mapper;

public interface FaqDao {
	public ArrayList tabMenu();
	public ArrayList allList();
	public ArrayList allList(String catCd2);
}
