package com.xt.serviceImpl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sun.source.tree.Tree;
import com.sun.source.tree.TreeVisitor;
import com.sun.source.tree.Tree.Kind;
import com.xt.entity.Jizu;
import com.xt.entity.Jzpeizhi;
import com.xt.mapper.JizuMapper;
import com.xt.mapper.JzpeizhiMapper;
import com.xt.service.JizuService;
@Service(value="jizuService")
@Transactional
public class JizuServiceImpl implements JizuService{
	@Autowired
	private JizuMapper jizuMapper;
	
	@Autowired
	private JzpeizhiMapper jzpeizhiMapper;
	
	@Override
	public List<Jizu> selectAll() {
		// TODO Auto-generated method stub
		return jizuMapper.selectAll();
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

	@Override
	public List<Jizu> selectOutId(List<Jizu> list) {
		// TODO Auto-generated method stub
		list=jizuMapper.selectAll();
		Set<Jizu> set = new TreeSet<>(new Comparator<Jizu>() {

			@Override
			public int compare(Jizu o1, Jizu o2) {
				// TODO Auto-generated method stub
				return o1.getJizuNum().compareTo(o2.getJizuNum());
			}
		});
		set.addAll(list);
		List<Jizu> jizus = new ArrayList<>(set);
		return jizus;
	}

	@Override
	public void addUnit(Map<String, String> map) {
		// TODO Auto-generated method stub
		jizuMapper.insert(map);
		jzpeizhiMapper.insert(map);
	}
}
