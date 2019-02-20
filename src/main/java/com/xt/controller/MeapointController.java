package com.xt.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xt.entity.MeaPoint;
import com.xt.service.MeapointService;

@Controller(value="meapointController")
@RequestMapping("meaPoint")
public class MeapointController {
	
	@Autowired
	private MeapointService meaPointService;
	//查询列表
	@RequestMapping("meaList")
	public ModelAndView selectAll(@RequestParam(required=true,defaultValue="1")Integer pageNum,@RequestParam(required=true,defaultValue="10")Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<MeaPoint> list = meaPointService.selectAll();
		PageInfo<MeaPoint> pageInfo = new PageInfo<MeaPoint>(list);
		ModelAndView mAndView = new ModelAndView();
		mAndView.addObject("meaList", list);
		mAndView.addObject("pageInfo", pageInfo);
		mAndView.setViewName("meapoint/mea_list");
		return mAndView;
	}
	//跳转到增加页面
	@RequestMapping("toadd")
	public String toadd() {
		return "meapoint/mea_add";
	}
	//增加测点信息
	@RequestMapping("addPoint")
	public ModelAndView addPoint(MeaPoint meaPoint) {
		meaPointService.addUnit(meaPoint);
		ModelAndView mAndView = new ModelAndView("redirect:mea_list");
		return mAndView;
	}
	//删除测点信息
	@RequestMapping("deletePoint")
	public ModelAndView deletePoint(Integer id) {
		meaPointService.deleteUnit(id);
		ModelAndView mAndView = new ModelAndView("redirect:mea_list");
		return mAndView;
	}
	//修改,先通过get方法得到一个对象
	@RequestMapping("editPoint")
	public ModelAndView editUnit(MeaPoint meaPoint) {
		MeaPoint mPoint = meaPointService.selectById(meaPoint.getId());
		ModelAndView mAndView = new ModelAndView();
		mAndView.addObject(mPoint);
		mAndView.setViewName("meapoint/mea_add");
		return mAndView;
	}
	//修改
	@RequestMapping("updatePoint")
	public ModelAndView updateUnit(MeaPoint meaPoint) {
		meaPointService.update(meaPoint);
		ModelAndView mAndView = new ModelAndView("redirect:meaList");
		return mAndView;
	}	
	//读取Excel
	@RequestMapping(value="readExcel",method= {RequestMethod.POST})
	public ModelAndView DoExcel(@RequestParam(value="file_excel")MultipartFile file,HttpServletRequest request) {
		ModelAndView mAndView = new ModelAndView();
		String readResult = null;
		try {
			readResult = meaPointService.readExcelFile(file);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("上传失败");
		}
		System.out.println("插入结果"+readResult);
		mAndView.setViewName("redirect:meaList");
		return mAndView;
	}
		
}
