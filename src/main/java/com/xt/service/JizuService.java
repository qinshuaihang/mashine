package com.xt.service;

import java.util.List;

import com.xt.entity.Jizu;

public interface JizuService {
	
	public List<Jizu> selectAll();
	
	public void addUnit(Jizu jizu);

	public void deleteUnit(Integer id);

	public Jizu selectById(Integer id);

	public void update(Jizu jizu);
}
