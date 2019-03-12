package com.xt.service;

import java.util.List;

import com.xt.entity.Rule;

public interface RuleService {

	List<Rule> selectAll();

	void addRule(Rule rule);

	void deleteRule(Integer id);

	Rule selectById(Integer ruleNum);

	void update(Rule rule);

}
