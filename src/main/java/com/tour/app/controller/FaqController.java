package com.tour.app.controller;

import java.util.*;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tour.app.dto.CatDto;
import com.tour.app.service.FaqService;

import lombok.AllArgsConstructor;

@Controller
//@RequestMapping("/faq/*")
public class FaqController {

	private static final Logger logger = LoggerFactory.getLogger(FaqController.class);

	@Autowired(required = false)
	private FaqService service;

	@GetMapping(value = "/faq/faqList")
	public String faqMain(Model model, String catCd2) {

		logger.info("=============================================================faq");

		List faqList = new ArrayList();
		List tabList = new ArrayList();

		tabList = service.tabMenu();
		faqList = service.allList(catCd2);

		model.addAttribute("tabList", tabList);
		model.addAttribute("faqList", faqList);
		model.addAttribute("total", faqList.size());

		// return "/faq/faqList";
		return "tiles/faq/faqList";
	}

	@RequestMapping(value = "/ajaxFaqList", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> ajaxFaqList(CatDto dto) {

		logger.info("=============================================================ajaxFaqList cd==" + dto.getCatCd2());
		Map result = new HashMap();
		List faqList = service.allList(dto.getCatCd2());

		logger.info("=============================================================ajaxFaqList size==" + faqList.size());
//		result.put("Code", "100");

		result.put("list", faqList);

		return result;
	}

}
