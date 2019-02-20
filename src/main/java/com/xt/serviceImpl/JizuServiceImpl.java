package com.xt.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xt.entity.Jizu;
import com.xt.mapper.JizuMapper;
import com.xt.service.JizuService;
@Service(value="jizuService")
@Transactional
public class JizuServiceImpl implements JizuService{
	@Autowired
	private JizuMapper jizuMapper;
	
	@Override
	public List<Jizu> selectAll() {
		// TODO Auto-generated method stub
		return jizuMapper.selectAll();
	}

	@Override
	public void addUnit(Jizu jizu) {
		// TODO Auto-generated method stub
		jizuMapper.insert(jizu);
	}

	@Override
	public void deleteUnit(Integer id) {
		// TODO Auto-generated method stub
		jizuMapper.deleteByPrimaryKey(id);
	}

	@Override
	public Jizu selectById(Integer id) {
		// TODO Auto-generated method stub
		return jizuMapper.selectByPrimaryKey(id);
	}

	@Override
	public void update(Jizu jizu) {
		// TODO Auto-generated method stub
		jizuMapper.updateByPrimaryKey(jizu);
	}

}
