package com.xt.mapper;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.xt.entity.Feature;
import com.xt.entity.MeaPoint;
@Repository(value="featureMapper")
public interface FeatureMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Feature record);

    int insertSelective(Feature record);

    Feature selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Feature record);

    int updateByPrimaryKey(Feature record);

	List<Feature> selectAll();
	
	List<Feature> selectByIf(Map<String, Object> map);
}