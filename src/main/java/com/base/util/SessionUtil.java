package com.base.util;

import javax.servlet.http.HttpServletRequest;

/**
 * 
 *@ClassName:SessionUtil.java
 *@Description:  工具类获取当前用户信息
 *@Author:lxt<839376636@qq.com>
 *@Date:2017年10月9日下午9:57:20
 *@Version:1.1.0
 */
public class SessionUtil {
	/**
	 * 存储在session中的用户key值
	 */
	public static final String  SESSION_USER_KEY = "user";

	/**
	 * 
	 * @Title: setLoginUser 
	 * @Description: 设置登录用户信息 
	 * @param request
	 * @param userKey
	 */
	public static void setLoginUser(HttpServletRequest request,Object user) {
		request.getSession().setAttribute(SESSION_USER_KEY,user);
	}

	/**
	 * 
	 * @Title: getLoginUser 
	 * @Description: 获取登录用户信息 
	 * @param request
	 * @param userKey
	 * @return Object
	 */
	public static Object getLoginUser(HttpServletRequest request) {
		return request.getSession().getAttribute(SESSION_USER_KEY);
	}
}
