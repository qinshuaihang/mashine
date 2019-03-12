package com.xt.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.support.ServletContextAttributeFactoryBean;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xt.entity.Feature;
import com.xt.entity.Jizu;
import com.xt.entity.Rule;
import com.xt.service.FeatureService;
import com.xt.service.RuleService;

/**
 * @deprecated:TODO 关于规则信息--操作控制器类
 */
@Controller(value="ruleController")
@RequestMapping("rule")
public class RuleController {
	@Autowired
	private RuleService ruleService;
	@Autowired
	private FeatureService featureService;
	//跳转到增加页面
	@RequestMapping("toadd")
	public String toadd() {
		return "rule/rule_add";
	}
	//发送增加信息
	@RequestMapping("ruleAdd")
	public ModelAndView addRule() {
		List<Feature> fealist = featureService.selectAll();
		ModelAndView mAndView = new ModelAndView();
		mAndView.addObject("flist", fealist);
		mAndView.setViewName("rule/rule_add");
		return mAndView;
	}
	
	//列表显示
	@RequestMapping("ruleList")
	public ModelAndView selectAll(HttpServletRequest request,@RequestParam(required=true,defaultValue="1")Integer pageNum,@RequestParam(required=true,defaultValue="10")Integer pageSize){
		//PageHelper.startPage(pageNum, pageSize);
		List<Rule> rulelist = ruleService.selectAll();
		List<Feature> fealist = featureService.selectAll();
		//PageInfo<Rule> pageInfo = new PageInfo<Rule>(rulelist);
		ModelAndView mAndView = new ModelAndView();
		//mAndView.addObject("pageInfo", pageInfo);
		mAndView.addObject("Rlist", rulelist);
		mAndView.addObject("Flist", fealist);
		mAndView.setViewName("rule/rule_list");
		return mAndView;
	}
	
	//增加规则信息
	@RequestMapping("addRule")
	public ModelAndView addRule(Rule rule) {
		ruleService.addRule(rule);
		ModelAndView mAndView = new ModelAndView("redirect:ruleList");
		return mAndView;
	}
	//删除规则信息
	@RequestMapping("deleteRule")
	public ModelAndView deleteRule(Integer id) {
		ruleService.deleteRule(id);
		ModelAndView mAndView = new ModelAndView("redirect:ruleList");
		return mAndView;
	}
	//修改,先通过get方法得到一个对象
	@RequestMapping("editRule")
	public ModelAndView editRule(Rule rule) {
		Rule rule2 = ruleService.selectById(rule.getRuleNum());
		ModelAndView mAndView = new ModelAndView();
		mAndView.addObject("rule",rule2);
		mAndView.setViewName("rule/rule_edit");
		return mAndView;
	}
	//修改
	@RequestMapping("updateRule")
	public ModelAndView updateRule(Rule rule) {
		ruleService.update(rule);
		ModelAndView mAndView = new ModelAndView("redirect:ruleList");
		return mAndView;
	}	
}