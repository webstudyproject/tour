package com.tour.app.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * 예시
 * Method : detailPageController
 * 최초작성일 : 2020. 10. 01
 * 작성자 : HyoBeom
 * 변경이력 :
 * @param 
 * @param 
 * @return
 * Method 설명 : - 
 */

@Controller
public class detailPageController {
	
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);
	
	@RequestMapping(value = "/detailPage", method = RequestMethod.GET)
	public ModelAndView detailPage(Locale locale) {
		logger.info("detailPage! {}.", locale);
		
		ModelAndView md = new ModelAndView("tiles/main/detailPage");
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		md.addObject("serverTime", formattedDate);
		
		return md;
		
	}
}


