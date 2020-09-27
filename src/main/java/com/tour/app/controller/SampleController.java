package com.tour.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tour.app.service.SampleService;

@Controller
//@RequestMapping("/sample/*")
public class SampleController {

	@Autowired
	private SampleService sampleService;
	
	@RequestMapping(value = "/sample/sampleJsp")
//	public ModelAndView faqMain(Model model) {
	public String faqMain(Model model) {
	
		int result = sampleService.SampleSelect();
		model.addAttribute("result",result);
		
		return "/sample/sampleJsp";
//		return "tiles/sample/sampleJsp";	//	tiles »ç¿ë
	}
	
}
