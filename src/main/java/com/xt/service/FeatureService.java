package com.xt.service;

import java.util.List;
import java.util.Map;

import com.xt.entity.Feature;

public interface FeatureService {

	void update(Feature feature);

	Feature selectById(Integer id);

	void deleteFea(Integer id);

	void addFea(Feature feature);
	
	List<Feature> selectAll();
	
	List<Feature> selectByIf(Map<String, Object> map);
}
