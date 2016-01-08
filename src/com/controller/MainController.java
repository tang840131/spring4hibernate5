package com.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biz.UserBiz;

@Controller
@RequestMapping("/")
public class MainController {
	@Resource
	private UserBiz userBiz;
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String index(){
		return "index";
	}
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String list(HttpServletRequest request){
		request.setAttribute("page", userBiz.getUserPage(10,1));
		return "list";
	}
}
