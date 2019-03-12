package com.xt.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.xt.entity.Jizu;
import com.xt.entity.Jzpeizhi;

public interface JizuService {
	
	public List<Jizu> selectAll();

	public void deleteUnit(Integer id);

	public Jizu selectById(Integer id);

	public void update(Jizu jizu);
	
	public List<Jizu> selectOutId(List<Jizu> list);

	public void addUnit(Map<String, String> map);
}
