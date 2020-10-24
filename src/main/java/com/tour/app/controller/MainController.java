package com.tour.app.controller;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonObjectFormatVisitor;
import com.fasterxml.jackson.databind.util.JSONPObject;

import javassist.expr.Instanceof;



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
	
	//Tmap길찾기 좌표 받아와서 json가공 jsp로 넘겨주는 메소드
	@ResponseBody
	@RequestMapping(value = "/arrPoint", method = { RequestMethod.GET, RequestMethod.POST})
	@ResponseStatus(value=HttpStatus.OK)
	public List TmapApi_location(Locale locale, 
			@RequestBody ArrayList<Map<String, String>> arrPoint){
		
		Map<String, String> map = new HashMap<String, String>();
		String addr = "";
		Map<String,String> location;
		List jsonList = new ArrayList<Object>();

		System.out.println("arrPoint가져오기");
		for (int i =0; i<arrPoint.size(); i++) {
			// url로 api호출하여 받은 json을 List에 add
			addr = get_addr(arrPoint.get(i).get("_lat"), arrPoint.get(i).get("_lng"));
			location = get_location_json(addr);
			jsonList.add(location);
//			System.out.println(location.get("response"));
			
		}
//		System.out.println(jsonList.size());
		//148
		
		return jsonList;
		
	}
	// 좌표값으로 api url만들기
	public String get_addr(String lat, String lng){
		String addr = "http://api.visitkorea.or.kr/openapi/service/rest/KorService/";
		String op = "locationBasedList"; 
		String ServiceKey_format = "?ServiceKey=";
		String ServiceKey = "LkOQNzjtZIaxM8vgQmZVD1CoRwlA2fc59aEgTKgIcr8%2BrGhuDC9Cw99tzi8z5gtKope9sBpHgn%2Fva698dmmjLQ%3D%3D";
		
		try {
			ServiceKey = URLDecoder.decode(ServiceKey.toString(), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String parameter ="";
	
		parameter = parameter + "&" + "mapX=" + lng; 
		parameter = parameter + "&" + "mapY=" + lat; 
		parameter = parameter + "&" + "radius=" + "100";
		parameter = parameter + "&" + "listYN=" + "Y";
		parameter = parameter + "&" + "arrange=" + "A";
		parameter = parameter + "&" + "MobileOS=" + "ETC";
		parameter = parameter + "&" + "MobileApp=" + "Whee"; 
		parameter = parameter + "&" + "_type=" + "json";
		
		addr = addr + op + ServiceKey_format +ServiceKey + parameter;
		return addr;
	}
	
	// url로 api 요청하여 json 받아오기
	public Map<String, String> get_location_json(String addr){
		
		RestTemplate template = new RestTemplate();
		Map body = template.getForObject(addr, Map.class);
		return body;
	}
	
	
	// List_Json_파싱작업메소드
	public List jsonParsing(List location) {
		
		
		return null;
		
	}
	
	
	
	
	/*
	 * 한국관광공사_12[위치기반 관광정보 조회]
	 * 내주변 좌표를 기반으로 관광정보 목록을 조회하는 기능입니다. 
	 * 파라미터에 따라 제목순, 수정일순(최신순), 등록일순, 인기순, 거리순 정렬검색을 제공합니다.
	 */
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public void test(String addr,HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();

		String addr2 = "http://api.visitkorea.or.kr/openapi/service/rest/KorService/";
		String op = "locationBasedList"; 
		String ServiceKey_format = "?ServiceKey=";
		String ServiceKey = "LkOQNzjtZIaxM8vgQmZVD1CoRwlA2fc59aEgTKgIcr8%2BrGhuDC9Cw99tzi8z5gtKope9sBpHgn%2Fva698dmmjLQ%3D%3D";
		String parameter ="";
		
		parameter = parameter + "&" + "mapX=" + "127.00156908060765"; 
		parameter = parameter + "&" + "mapY=" + "37.57080412410098"; 
		parameter = parameter + "&" + "radius=" + "1000";
		parameter = parameter + "&" + "listYN=" + "Y";
		parameter = parameter + "&" + "arrange=" + "A";

		// parameter
		parameter = parameter + "&" + "MobileOS=" + "ETC";
		parameter = parameter + "&" + "MobileApp=" + "Whee"; 
		// default => xml 
		// json parameter => json
		parameter = parameter + "&" + "_type=" + "json";
		
		
		addr2 = addr2 + op + ServiceKey_format +ServiceKey + parameter;
		
		URL url = new URL(addr2);
		
		System.out.println("url: " + addr2);
		
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
