package com.tour.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/member/*")
public class MemberController {
	
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView getRegister() throws Exception{
	ModelAndView md = new ModelAndView("tiles/member/register");
	
	return md;
	}
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView getLogin() throws Exception{
	ModelAndView md = new ModelAndView("tiles/member/login");
	
	return md;
	}
	
}