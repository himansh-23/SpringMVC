package com.api.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.api.models.Login;
//import com.api.models.User;
import com.api.services.LoginService;

@Controller
public class LoginController {

	@Autowired
	private LoginService loginservice;
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView getLoginView(HttpServletRequest req, HttpServletResponse resp) {
		ModelAndView mav = new ModelAndView("login");
		mav.addObject("login", new Login());
		return mav;
	}
	
	@RequestMapping(value="/loginProcess", method = RequestMethod.POST)
	public ModelAndView loginProcess(@ModelAttribute Login login) {
		ModelAndView mav=new ModelAndView("successregister");
		boolean b=loginservice.getAuthentic(login);
		if(b==true)
		{
			mav.addObject("value",1);
			return mav;
		}
			mav.addObject("value",2);
			return mav;
		
	}
}
