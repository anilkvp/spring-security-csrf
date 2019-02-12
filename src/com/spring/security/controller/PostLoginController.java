package com.spring.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PostLoginController {

	@RequestMapping(value = "/postlogin.do", method = RequestMethod.GET)
	public ModelAndView postLogin() {

		return new ModelAndView("home");
	}

	@RequestMapping(value = "/list.do", method = RequestMethod.GET)
	public ModelAndView collections() {

		return new ModelAndView("collection");
	}

	@RequestMapping(value = "/list.do", method = RequestMethod.POST)
	public ModelAndView addCollections() {

		return new ModelAndView("unprotected");
	}

}
