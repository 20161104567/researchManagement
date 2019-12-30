package com.imnu.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.imnu.shop.pojo.User;
import com.imnu.shop.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	@RequestMapping("/login")
	public ModelAndView login(User user) {
		User u = userService.login(user);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home");
		mv.addObject("user",u);
		return mv;
	}
	@RequestMapping("/regist")
	public ModelAndView regist(User user) {
		System.out.println(user);
		userService.register(user);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home");
		return mv;
	}
	@RequestMapping("/checkUserName")
	@ResponseBody//表示返回的类型是json数据
	public String checkUserName(String username) {
		System.out.println(username);
		boolean isExist=userService.findUserByUserName(username);
		return "{\"isExist\":"+isExist+"}";
	}
}
