package com.iris.controller;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iris.service.AdminService;
import com.iris.service.BoardService;

@Controller
public class AdminController {

	@Autowired
	AdminService adminService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public Object login() throws ParseException {
		return "index";
	}


	@RequestMapping(value = "/login/submit", method = RequestMethod.GET)
	public Object submit(@RequestParam(value = "userId") String userId,
			@RequestParam(value = "password") String password) throws ParseException {

		boolean isOk = adminService.login(userId, password);

		if(isOk){
			return "push";
		}else{
			return "index"; 
		}

	}

}
