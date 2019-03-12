package com.xt.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.xt.entity.Problem;

@Repository(value="problemMapper")
public interface ProblemMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Problem record);

    int insertSelective(Problem record);

    Problem selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Problem record);

    int updateByPrimaryKey(Problem record);

	List<Problem> selectAll();
}