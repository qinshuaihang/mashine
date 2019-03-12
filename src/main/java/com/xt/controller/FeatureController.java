package com.xt.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xt.entity.Feature;
import com.xt.entity.MeaPoint;
import com.xt.service.FeatureService;
import com.xt.service.MeapointService;
import com.xt.serviceImpl.meapointServiceImpl;

/**
 * @deprecated:TODO 关于特征信息--操作控制器类
 */
@Controller(value="featureController")
@RequestMapping("feature")
public class FeatureController {
	@Autowired
	private FeatureService featureService;
	@Autowired
	private MeapointService meapointService;
	
	//列表显示
	@RequestMapping("feaList")
	public ModelAndView selectAll(HttpServletRequest request,@RequestParam(required=true,defaultValue="1")Integer pageNum,@RequestParam(required=true,defaultValue="10")Integer pageSize){
		PageHelper.startPage(pageNum, pageSize);
		List<Feature> list = featureService.selectAll();
		PageInfo<Feature> pageInfo = new PageInfo<Feature>(list);
		ModelAndView mAndView = new ModelAndView();
		mAndView.addObject("pageInfo", pageInfo);
		mAndView.addObject("list", list);
		mAndView.setViewName("feature/fea_list");
		return mAndView;
	}
	//跳转到增加页面
	@RequestMapping("toadd")
	public ModelAndView toadd() {
		List<Feature> list = featureService.selectAll();
		List<MeaPoint> mList = meapointService.selectAll();
		ModelAndView mAndView = new ModelAndView();
		mAndView.addObject("mlist", mList);
		mAndView.addObject("flist", list);
		mAndView.setViewName("feature/fea_add");
		return mAndView;
	}
	//增加特征信息
	@RequestMapping("addFea")
	public ModelAndView addFea(Feature feature) {
		featureService.addFea(feature);
		ModelAndView mAndView = new ModelAndView("redirect:feaList");
		return mAndView;
	}
	//删除特征信息
	@RequestMapping("deleteFea")
	public ModelAndView deleteFea(Integer id) {
		featureService.deleteFea(id);
		ModelAndView mAndView = new ModelAndView("redirect:feaList");
		return mAndView;
	}
	//修改,先通过get方法得到一个对象
	@RequestMapping("editFea")
	public ModelAndView editFea(Feature feature) {
		Feature fea = featureService.selectById(feature.getId());
		ModelAndView mAndView = new ModelAndView();
		mAndView.addObject("fea",fea);
		mAndView.setViewName("feature/fea_edit");
		return mAndView;
	}
	//修改
	@RequestMapping("updateFea")
	public ModelAndView updateFea(Feature feature) {
		featureService.update(feature);
		ModelAndView mAndView = new ModelAndView("redirect:feaList");
		return mAndView;
	}
	@RequestMapping("selectById")
	public ModelAndView selectById(Integer id) {
		Feature feature = featureService.selectById(id);
		ModelAndView mAndView = new ModelAndView();
		mAndView.addObject("feature", feature);
		mAndView.setViewName("feature/fea_add");
		return mAndView;
	}
}
