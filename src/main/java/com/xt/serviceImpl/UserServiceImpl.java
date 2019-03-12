package com.xt.serviceImpl;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.base.util.SessionUtil;
import com.xt.entity.User;
import com.xt.mapper.UserMapper;
import com.xt.service.UserService;

@Service(value="userService")
@Transactional
public class UserServiceImpl implements UserService{
	@Autowired
	private UserMapper userMapper;
	@Override
	public String login(User user, Model model,HttpServletRequest request,String code) {
		// TODO Auto-generated method stub
		/*HttpSession session = request.getSession();
		String verifyCode=session.getAttribute("code").toString();
		if(!code.equalsIgnoreCase(verifyCode)) {
			System.out.println(code);
			model.addAttribute("msg", "验证码错误");
			return "user/login";
		}*/
		if (userMapper.login(user)!=null&&userMapper.login(user).size()>0) {
			SessionUtil.setLoginUser(request, user);
			return "jsp/result_main";
		}else {
			model.addAttribute("msg", "用户名或密码错误");
			return "user/login";
		}
		
	}

}
