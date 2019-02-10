package com.base.util;
import com.github.pagehelper.PageInfo;

import java.util.List;

import com.github.pagehelper.PageHelper;
/**
 * 
 * @ClassName: PageHelper 
 * @Description: TODO 分页工具类
 * @author: HRX
 * @date: 2019年2月10日 下午2:59:35
 */
public class PageUtil {

	public PageInfo<Object> index(Integer pageNo, Integer pageSize , List<Object> list) {
		PageHelper.startPage(pageNo, pageSize);
		PageInfo<Object> pageInfo = new PageInfo<Object>(list);
		if (pageNo > pageInfo.getPages()) {
			pageNo = pageInfo.getPages();
			PageHelper.startPage(pageNo, pageSize);
			pageInfo = new PageInfo<Object>(list);
		}
		return pageInfo;
	}
}
