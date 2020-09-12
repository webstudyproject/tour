package com.tour.app.controller;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonObjectFormatVisitor;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.sun.mail.iap.ByteArray;



@Controller
public class MainController {
	
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home(Locale locale) {
		ModelAndView md = new ModelAndView("tiles/main/main");
		
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		md.addObject("serverTime", formattedDate );
		
		return md;
	}
	/* 
	 * 12 [위치기반 관광정보 조회]
	 * 내용 :내 주변 좌표를 기반으로 관광정보 목록을 조회하는 기능입니다.
	 * 	      파라미터에 따라 제목순, 수정일순(최신순), 등록일순, 인기순, 거리순 정렬검색을 제공합니다.
	 * 형식 : http://api.visitkorea.or.kr/openapi/service/rest/KorService/locationBasedList
	 * 
	 * 내 주변 좌표에서 100m 이내에 있는 모든타입의 관광정보 조회 
	 */
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public void test(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		
		String addr = "http://api.visitkorea.or.kr/openapi/service/rest/KorService/";
		String op = "locationBasedList"; //데이터에 따라서 변할 수 있음
		String ServiceKey_format = "?ServiceKey=";
		String ServiceKey = "5hc1FL3etDT088xXejCpTJlt7n04F0615kopSVbUsLU%2FNPRwWJZDLZuECahwmDqQ45kWFQ2ovi2uDFqfmxBHDw%3D%3D";
		String parameter ="";
		
		
		parameter = parameter + "&" + "mapX=" + "126.981611"; // X좌표
		parameter = parameter + "&" + "mapY=" + "37.568477"; // Y좌표
		parameter = parameter + "&" + "radius=" + "1000"; //거리 반경
		parameter = parameter + "&" + "listYN=" + "Y"; //목록 구분
		parameter = parameter + "&" + "arrange=" + "A"; // 정렬 구분

		// 기본 parameter
		parameter = parameter + "&" + "MobileOS=" + "ETC"; // OS 구분
		parameter = parameter + "&" + "MobileApp=" + "Whee"; // 서비스명 
		// default => xml 
		// json parameter 추가 => json
		parameter = parameter + "&" + "_type=" + "json";
		
		
		addr = addr + op + ServiceKey_format +ServiceKey + parameter;
		
		URL url = new URL(addr);
		
		System.out.println("url 요청: " + addr);
		
//		InputStream in = url.openStream();
//		
//		System.out.println(in);
//		ByteArrayOutputStream bos1 = new ByteArrayOutputStream();
//		IOUtils.copy(in, bos1);
//		
//		
//		in.close();
//		bos1.close();
//		
//		String result = bos1.toString("UTF-8");
//		
//		out.println(result);
		
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
