package com.security.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

	@RequestMapping("login")
	public String tologin() {
		return "login";
	}

	@RequestMapping("/index")
	public String index() {
		return "index";
	}

	@RequestMapping("/add")
	@PreAuthorize("hasPermission('','add')")
	public String add() {
		System.out.println("=======================");
		return "success";
	}

	@RequestMapping("/user/add")
	@PreAuthorize("hasAuthority('user')")
	public String user() {
		System.out.println("=======================");
		return "success";
	}
}
