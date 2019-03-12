package com.xt.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sun.org.apache.regexp.internal.recompile;
import com.xt.entity.Jizu;
import com.xt.entity.Problem;
import com.xt.service.ProblemService;

/**
 * 
 * @deprecated:TODO 关于故障信息--操作控制器类
 *
 */
@Controller(value="problemController")
@RequestMapping("problem")
public class ProblemController {
	@Autowired
	private ProblemService problemService;
	//列表显示
	@RequestMapping("proList")
	public ModelAndView selectAll(HttpServletRequest request,@RequestParam(required=true,defaultValue="1")Integer pageNum,@RequestParam(required=true,defaultValue="10")Integer pageSize){
		PageHelper.startPage(pageNum, pageSize);
		List<Problem> list = problemService.selectAll();
		PageInfo<Problem> pageInfo = new PageInfo<Problem>(list);
		ModelAndView mAndView = new ModelAndView();
		mAndView.addObject("pageInfo", pageInfo);
		mAndView.addObject("list", list);
		mAndView.setViewName("problem/pro_list");
		return mAndView;
	}
	//跳转至增加页面
	@RequestMapping("toadd")
	public String toadd() {
		return "problem/pro_add";
	}
	//增加故障信息或修改信息
	@RequestMapping("addPro")
	public String FileUpload(Problem problem,HttpServletRequest request,String updateAct) {
		return problemService.addPro(problem, request, updateAct);
	}
	//删除故障信息
	@RequestMapping("deletePro")
	public ModelAndView deletePro(Integer id) {
		problemService.deletePro(id);
		ModelAndView mAndView = new ModelAndView("redirect:proList");
		return mAndView;
	}
	//修改,先通过get方法得到一个对象
	@RequestMapping("editPro")
	public ModelAndView editPro(Problem problem) {
		Problem pro = problemService.selectById(problem.getId());
		ModelAndView mAndView = new ModelAndView();
		mAndView.addObject("pro",pro);
		mAndView.setViewName("problem/pro_edit");
		return mAndView;
	}
	//修改
	@RequestMapping("updatePro")
	public ModelAndView updatePro(Problem problem) {
		problemService.update(problem);
		ModelAndView mAndView = new ModelAndView("redirect:proList");
		return mAndView;
	}	
}
