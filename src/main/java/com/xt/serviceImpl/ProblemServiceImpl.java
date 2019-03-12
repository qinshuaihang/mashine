package com.xt.serviceImpl;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.http.HttpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.base.util.ReadExcel;
import com.sun.org.apache.regexp.internal.recompile;
import com.xt.entity.Problem;
import com.xt.mapper.ProblemMapper;
import com.xt.service.ProblemService;

@Service(value="problemService")
@Transactional
public class ProblemServiceImpl implements ProblemService {
	@Autowired
	private ProblemMapper problemMapper;

	@Override
	public List<Problem> selectAll() {
		// TODO Auto-generated method stub
		return problemMapper.selectAll();
	}

	@Override
	public String addPro(Problem problem,HttpServletRequest request,String updateAct) {
		// TODO Auto-generated method stub
		//防止文件重名
		String newFileName="";
		String fileName = problem.getErrorImage().getOriginalFilename();
		//选择了文件
		if (fileName.length()>0) {
			String realpath=request.getServletContext().getRealPath("images");
			//实现文件上传
			String fileType = fileName.substring(fileName.lastIndexOf('.'));
			//防止文件重名
			newFileName = ReadExcel.getStringID()+fileType;
			problem.setImage(newFileName);
			File targetFile = new File(realpath,newFileName);
			if (!targetFile.exists()) {
				targetFile.mkdirs();
			}
			//上传
			try {
				problem.getErrorImage().transferTo(targetFile);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		problemMapper.insert(problem);
		//修改
		return "redirect:problem/peoList";
		
	}

	@Override
	public void deletePro(Integer id) {
		// TODO Auto-generated method stub
		problemMapper.deleteByPrimaryKey(id);
	}

	@Override
	public Problem selectById(Integer id) {
		// TODO Auto-generated method stub
		return problemMapper.selectByPrimaryKey(id);
	}

	@Override
	public void update(Problem problem) {
		// TODO Auto-generated method stub
		problemMapper.updateByPrimaryKey(problem);
	}
}
