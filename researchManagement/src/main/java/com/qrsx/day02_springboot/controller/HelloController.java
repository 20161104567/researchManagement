package com.qrsx.day02_springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/test")
public class HelloController {
	@RequestMapping("/hello")
	@ResponseBody
	public String testHello() {
		return "hello hello";
	}
	@RequestMapping("/mv")
	public String testmv() {
		return "/test"; //      /jsp/test.jsp
	}
}
