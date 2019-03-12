package com.xt.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion.User;
import com.xt.entity.Jizu;
import com.xt.entity.Jzpeizhi;
import com.xt.service.JizuService;
/**
 * @deprecated:TODO 机组及配置信息管理
 * 
 */
@Controller(value="jizuController")
@RequestMapping("jizu")
public class JizuController {
	@Autowired
	private JizuService jizuService;
	//列表显示
	@RequestMapping("unitList")
	public ModelAndView selectAll(@RequestParam(value="pageNo",required=false,defaultValue="1")Integer pageNo,
								  @RequestParam(value="pageSize",required=false,defaultValue="5")Integer pageSize){
		PageHelper.startPage(pageNo, pageSize);
		List<Jizu> list = jizuService.selectAll();
		PageInfo<Jizu> pageInfo = new PageInfo<Jizu>(list);
		if (pageNo>pageInfo.getPages()) {
			pageNo = pageInfo.getPages();
			PageHelper.startPage(pageNo, pageSize);
			list = jizuService.selectAll();
			pageInfo = new PageInfo<Jizu>(list);
		}
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
	public ModelAndView addUnit(@RequestParam Map<String, String> map) {
		map.putAll(map);
		jizuService.addUnit(map);
		ModelAndView mAndView = new ModelAndView("redirect:unitList");
		return mAndView;
	}
	//删除机组信息
	@RequestMapping("deleteUnit")
	public ModelAndView deleteUnit(Integer id) {
		jizuService.deleteUnit(id);
		ModelAndView mAndView = new ModelAndView("redirect:unitList");
		return mAndView;
	}
	//修改,先通过get方法得到一个对象
	@RequestMapping("editUnit")
	public ModelAndView editUnit(Jizu jizu) {
		Jizu jz = jizuService.selectById(jizu.getId());
		ModelAndView mAndView = new ModelAndView();
		mAndView.addObject("jz",jz);
		mAndView.setViewName("jizu/unit_edit");
		return mAndView;
	}
	//修改
	@RequestMapping("updateUnit")
	public ModelAndView updateUnit(Jizu jizu) {
		jizuService.update(jizu);
		ModelAndView mAndView = new ModelAndView("redirect:unitList");
		return mAndView;
	}
}
