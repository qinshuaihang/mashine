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
import com.sun.org.apache.bcel.internal.generic.NEW;
import com.sun.org.apache.xpath.internal.operations.Mod;
import com.xt.entity.Jizu;
import com.xt.service.JizuService;
/**
 * 
 * @author 18426
 * @deprecated:TODO 机组及配置信息管理
 */
@Controller(value="jizuController")
@RequestMapping("jizu")
public class JizuController {
	@Autowired
	private JizuService jizuService;
	
	@RequestMapping("unitList")
	public ModelAndView selectAll(HttpServletRequest request,@RequestParam(required=true,defaultValue="1")Integer pageNum,@RequestParam(required=true,defaultValue="10")Integer pageSize){
		PageHelper.startPage(pageNum, pageSize);
		List<Jizu> list = jizuService.selectAll();
		//request.getSession().setAttribute("unitList", list);
		PageInfo<Jizu> pageInfo = new PageInfo<Jizu>(list);
		ModelAndView mAndView = new ModelAndView();
		mAndView.addObject("pageInfo", pageInfo);
		mAndView.addObject("list", list);
		mAndView.setViewName("jizu/unit_list");
		return mAndView;
	}
	//跳转到增加页面
	@RequestMapping("toadd")
	public String toadd() {
		return "jizu/unit_add";
	}
	//增加机组信息
	@RequestMapping("addUnit")
	public ModelAndView addUnit(Jizu jizu) {
		jizuService.addUnit(jizu);
		ModelAndView mAndView = new ModelAndView("redirect:unit_list");
		return mAndView;
	}
	//删除机组信息
	@RequestMapping("deleteUnit")
	public ModelAndView deleteUnit(Integer id) {
		jizuService.deleteUnit(id);
		ModelAndView mAndView = new ModelAndView("redirect:unit_list");
		return mAndView;
	}
	//修改,先通过get方法得到一个对象
	@RequestMapping("editUnit")
	public ModelAndView editUnit(Jizu jizu) {
		Jizu jz = jizuService.selectById(jizu.getId());
		ModelAndView mAndView = new ModelAndView();
		mAndView.addObject(jz);
		mAndView.setViewName("jizu/unit_add");
		return mAndView;
	}
	//修改
	@RequestMapping("updateUnit")
	public ModelAndView updateUnit(Jizu jizu) {
		jizuService.update(jizu);
		ModelAndView mAndView = new ModelAndView("redirect:unit_list");
		return mAndView;
	}
}
