package com.tour.app.controller;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class MainController {
	
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView home(Locale locale){
		ModelAndView md = new ModelAndView("tiles/main/main");
		
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		md.addObject("serverTime", formattedDate );
		
		
		return md;
	}
	
	@ResponseBody
	@RequestMapping(value = "/arr", method = RequestMethod.POST)
	public ArrayList<Map<String, String>> home2(Locale locale, 
			@RequestBody ArrayList<Map<String, String>> arrPoint){
		System.out.println("컨트롤러테스트");
		
		for (int i = 0; i < arrPoint.size(); i++) {
			System.out.println((String) arrPoint.get(i).get("name"));
			System.out.println((String) arrPoint.get(i).get("_lat"));
			System.out.println((String) arrPoint.get(i).get("_lng"));
		}
		System.out.print(arrPoint);
		
		return arrPoint;
	}
	
	
//	@RequestMapping(value = "/arr", method = RequestMethod.POST)
//	@ResponseBody
//	public void checkTestarr(
//			@RequestParam(value="drawInfoArr") ArrayList drawInfoArr
//			) {
//		
//		System.out.println(drawInfoArr);
//		
//		 
//	}
	
	
	
	/*
	 * 한국관광공사_12[위치기반 관광정보 조회]
	 * 내주변 좌표를 기반으로 관광정보 목록을 조회하는 기능입니다. 
	 * 파라미터에 따라 제목순, 수정일순(최신순), 등록일순, 인기순, 거리순 정렬검색을 제공합니다.
	 */
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public void test(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		
		String addr = "http://api.visitkorea.or.kr/openapi/service/rest/KorService/";
		String op = "locationBasedList"; 
		String ServiceKey_format = "?ServiceKey=";
		String ServiceKey = "5hc1FL3etDT088xXejCpTJlt7n04F0615kopSVbUsLU%2FNPRwWJZDLZuECahwmDqQ45kWFQ2ovi2uDFqfmxBHDw%3D%3D";
		String parameter ="";
		
		
		parameter = parameter + "&" + "mapX=" + "126.981611"; 
		parameter = parameter + "&" + "mapY=" + "37.568477"; 
		parameter = parameter + "&" + "radius=" + "1000";
		parameter = parameter + "&" + "listYN=" + "Y";
		parameter = parameter + "&" + "arrange=" + "A";

		// parameter
		parameter = parameter + "&" + "MobileOS=" + "ETC";
		parameter = parameter + "&" + "MobileApp=" + "Whee"; 
		// default => xml 
		// json parameter => json
		parameter = parameter + "&" + "_type=" + "json";
		
		
		addr = addr + op + ServiceKey_format +ServiceKey + parameter;
		
		URL url = new URL(addr);
		
		System.out.println("url: " + addr);
		
		URLConnection conn = url.openConnection();
		InputStream is = conn.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		try {
			
		
		char[] buff = new char[512];
		int len = -1;
		
		while ( (len = br.read(buff)) != -1 ) {
			out.print(new String(buff, 0, len));
			
		}
		
		br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	 
	
		
}
