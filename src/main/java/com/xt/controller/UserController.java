package com.xt.controller;

import java.io.IOException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;
import com.xt.entity.User;
import com.xt.service.UserService;

/**
 * @deprecated:TODO 用户登录，退出控制类
 */
@Controller
@RequestMapping("user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("tologin")
	public String toLogin() {
		return "user/login";
	}
	
	@RequestMapping("login")
	public String login(User user,Model model,HttpServletRequest request,String code) {
		return userService.login(user,model,request,code);
	}
}
