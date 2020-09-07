package com.tour.app.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
 
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
		ModelAndView md = new ModelAndView("tiles/main/home");
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		md.addObject("serverTime", formattedDate );
		
		return md;
	}
	
	
//	 /**
//     * Tiles를 사용하지 않은 일반적인 형태
//     */    
//    @RequestMapping("/test")
//    public String test() {
//        return "test";
//    }    
//    
//    /**
//     * Tiles를 사용(header, left, footer 포함)
//     */        
//    @RequestMapping("/testPage")
//    public String testPage() {
//        return "test.page";
//    }
//    
//    /**
//     * Tiles를 사용(header, left, footer 제외)
//     */    
//    @RequestMapping("/testPart")
//    public String testPart() {
//        return "test.part";
//    }
//	
//	
//	
}
