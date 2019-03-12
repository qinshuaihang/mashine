package com.xt.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.xt.entity.Problem;

public interface ProblemService {

	List<Problem> selectAll();

	void deletePro(Integer id);

	Problem selectById(Integer id);

	void update(Problem problem);

	String addPro(Problem problem, HttpServletRequest request, String updateAct);

}
