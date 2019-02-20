package com.xt.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;

import com.xt.entity.MeaPoint;

public interface MeapointService {

	List<MeaPoint> selectAll();

	void addUnit(MeaPoint meaPoint);

	void deleteUnit(Integer id);

	MeaPoint selectById(Integer id);

	void update(MeaPoint meaPoint);

	String readExcelFile(MultipartFile file);

}
