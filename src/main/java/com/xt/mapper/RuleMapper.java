package com.xt.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.xt.entity.Rule;

@Repository(value="ruleMapper")
public interface RuleMapper {
	int deleteByPrimaryKey(Integer id);
	
    int insert(Rule record);

    int insertSelective(Rule record);
    
    List<Rule> selectAll();
}