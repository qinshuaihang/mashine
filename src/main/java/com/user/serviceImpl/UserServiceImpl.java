package com.user.serviceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.base.util.SessionUtil;
import com.user.entity.User;
import com.user.mapper.UserMapper;
import com.user.service.UserService;

@Service(value="userService")
@Transactional
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public String login(User user, Model model,HttpServletRequest request) {
		// TODO Auto-generated method stub
		if (userMapper.login(user)!=null&&userMapper.login(user).size()>0) {
			SessionUtil.setLoginUser(request, user);
			return "jsp/index";
		}else {
			model.addAttribute("msg", "用户名或密码错误");
			return "user/login";
		}
		
	}

}
