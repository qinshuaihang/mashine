package com.xt.mapper;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.xt.entity.Jizu;
@Repository(value="jizuMapper")
public interface JizuMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Map<String, String> map);

    int insertSelective(Jizu record);

    Jizu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Jizu record);

    int updateByPrimaryKey(Jizu record);

	List<Jizu> selectAll();
}