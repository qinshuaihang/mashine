package com.xt.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.xt.entity.Jizu;
@Repository(value="jizuMapper")
public interface JizuMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Jizu record);

    int insertSelective(Jizu record);

    Jizu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Jizu record);

    int updateByPrimaryKey(Jizu record);

	List<Jizu> selectAll();
}