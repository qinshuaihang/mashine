package com.xt.serviceImpl;

import java.util.List;

import org.dom4j.rule.RuleManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xt.entity.Rule;
import com.xt.mapper.RuleMapper;
import com.xt.service.RuleService;

@Service(value="ruleService")
@Transactional
public class RuleServiceImpl implements RuleService {
	@Autowired
	private RuleMapper ruleMapper;

	@Override
	public List<Rule> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addRule(Rule rule) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteRule(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Rule selectById(Integer ruleNum) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Rule rule) {
		// TODO Auto-generated method stub
		
	}
}
