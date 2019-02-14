package com.index.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * 
 * @deprecated:TODO 主页菜单控制器
 *
 */
@Controller
public class IndexController {
	//机组管理
	@RequestMapping("unitMan")
	public String unitList() {
		return "jizu/unit_list";
	}
	//测点管理
	@RequestMapping("meapointMan")
	public String meapointList() {
		return "meapoint/mea_list";
	}
	//故障管理
	@RequestMapping("problemMan")
	public String problemList() {
		return "problem/pro_list";
	}
	//规则管理
	@RequestMapping("ruleMan")
	public String ruleList() {
		return "rule/rule_list";
	}
	//特征管理
	@RequestMapping("featureMan")
	public String featureList() {
		return "feature/fea_list";
	}
	//运行管理
	@RequestMapping("runMan")
	public String runManage() {
		return "run/run_manage";
	}
	//诊断管理
	@RequestMapping("result")
	public String result() {
		return "index/result";
	}
	//角色管理
	@RequestMapping("information")
	public String role() {
		return "user/myInfor";
	}
}
