package com.xt.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xt.entity.Session;
import com.xt.service.SessionService;

/**
 * @deprecated:TODO 会话管理
 * 
 */
@Controller(value="sessionController")
@RequestMapping("session")
public class SessionController {
	@Autowired
	private SessionService sessionService;
	//列表显示
	@RequestMapping("sessionList")
	public ModelAndView selectAll(HttpServletRequest request,@RequestParam(required=true,defaultValue="1")Integer pageNum,@RequestParam(required=true,defaultValue="10")Integer pageSize){
		PageHelper.startPage(pageNum, pageSize);
		List<Session> list = sessionService.selectAll();
		PageInfo<Session> pageInfo = new PageInfo<Session>(list);
		ModelAndView mAndView = new ModelAndView();
		mAndView.addObject("pageInfo", pageInfo);
		mAndView.addObject("list", list);
		mAndView.setViewName("session/session_list");
		return mAndView;
	}
	//跳转到增加页面
	@RequestMapping("toadd")
	public String toadd() {
		return "session/session_add";
	}
	//增加会话信息
	@RequestMapping("addSession")
	public ModelAndView addSession(Session session) {
		sessionService.addSession(session);
		ModelAndView mAndView = new ModelAndView("redirect:sessionList");
		return mAndView;
	}
	//删除会话信息
	@RequestMapping("deleteSession")
	public ModelAndView deleteSession(Integer id) {
		sessionService.deleteSession(id);
		ModelAndView mAndView = new ModelAndView("redirect:sessionList");
		return mAndView;
	}
	//修改,先通过get方法得到一个对象
	@RequestMapping("editSession")
	public ModelAndView editSession(Session session) {
		Session session2 = sessionService.selectById(session.getId());
		ModelAndView mAndView = new ModelAndView();
		mAndView.addObject("session2",session2);
		mAndView.setViewName("session/session_edit");
		return mAndView;
	}
	//修改
	@RequestMapping("updateSession")
	public ModelAndView updateSession(Session session) {
		sessionService.update(session);
		ModelAndView mAndView = new ModelAndView("redirect:sessionList");
		return mAndView;
	}
}
