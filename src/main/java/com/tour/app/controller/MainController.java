package com.tour.app.controller;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;



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
	 * 12 [�쐞移섍린諛� 愿�愿묒젙蹂� 議고쉶]
	 * �궡�슜 :�궡 二쇰� 醫뚰몴瑜� 湲곕컲�쑝濡� 愿�愿묒젙蹂� 紐⑸줉�쓣 議고쉶�븯�뒗 湲곕뒫�엯�땲�떎.
	 * 	      �뙆�씪誘명꽣�뿉 �뵲�씪 �젣紐⑹닚, �닔�젙�씪�닚(理쒖떊�닚), �벑濡앹씪�닚, �씤湲곗닚, 嫄곕━�닚 �젙�젹寃��깋�쓣 �젣怨듯빀�땲�떎.
	 * �삎�떇 : http://api.visitkorea.or.kr/openapi/service/rest/KorService/locationBasedList
	 * 
	 * �궡 二쇰� 醫뚰몴�뿉�꽌 100m �씠�궡�뿉 �엳�뒗 紐⑤뱺���엯�쓽 愿�愿묒젙蹂� 議고쉶 
	 */
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public void test(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		
		String addr = "http://api.visitkorea.or.kr/openapi/service/rest/KorService/";
		String op = "locationBasedList"; //�뜲�씠�꽣�뿉 �뵲�씪�꽌 蹂��븷 �닔 �엳�쓬
		String ServiceKey_format = "?ServiceKey=";
		String ServiceKey = "5hc1FL3etDT088xXejCpTJlt7n04F0615kopSVbUsLU%2FNPRwWJZDLZuECahwmDqQ45kWFQ2ovi2uDFqfmxBHDw%3D%3D";
		String parameter ="";
		
		
		parameter = parameter + "&" + "mapX=" + "126.981611"; // X醫뚰몴
		parameter = parameter + "&" + "mapY=" + "37.568477"; // Y醫뚰몴
		parameter = parameter + "&" + "radius=" + "1000"; //嫄곕━ 諛섍꼍
		parameter = parameter + "&" + "listYN=" + "Y"; //紐⑸줉 援щ텇
		parameter = parameter + "&" + "arrange=" + "A"; // �젙�젹 援щ텇

		// 湲곕낯 parameter
		parameter = parameter + "&" + "MobileOS=" + "ETC"; // OS 援щ텇
		parameter = parameter + "&" + "MobileApp=" + "Whee"; // �꽌鍮꾩뒪紐� 
		// default => xml 
		// json parameter 異붽� => json
		parameter = parameter + "&" + "_type=" + "json";
		
		
		addr = addr + op + ServiceKey_format +ServiceKey + parameter;
		
		URL url = new URL(addr);
		
		System.out.println("url �슂泥�: " + addr);
		
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
