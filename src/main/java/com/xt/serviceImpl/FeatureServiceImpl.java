package com.xt.serviceImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xt.entity.Feature;
import com.xt.mapper.FeatureMapper;
import com.xt.service.FeatureService;
@Service(value="featureService")
@Transactional
public class FeatureServiceImpl implements FeatureService {
	@Autowired
	private FeatureMapper featureMapper;

	@Override
	public void update(Feature feature) {
		// TODO Auto-generated method stub
		featureMapper.updateByPrimaryKey(feature);
	}

	@Override
	public Feature selectById(Integer id) {
		// TODO Auto-generated method stub
		return featureMapper.selectByPrimaryKey(id);
	}

	@Override
	public void deleteFea(Integer id) {
		// TODO Auto-generated method stub
		featureMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void addFea(Feature feature) {
		// TODO Auto-generated method stub
		featureMapper.insert(feature);
	}

	@Override
	public List<Feature> selectAll() {
		// TODO Auto-generated method stub
		return featureMapper.selectAll();
	}

	@Override
	public List<Feature> selectByIf(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return featureMapper.selectByIf(map);
	}
}
