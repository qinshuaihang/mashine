package com.user.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.user.entity.User;

public interface UserService {

	String login(User user,Model model,HttpServletRequest request);

}
