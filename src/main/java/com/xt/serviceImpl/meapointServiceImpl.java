package com.xt.serviceImpl;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.base.util.ReadExcel;
import com.xt.entity.Jizu;
import com.xt.entity.MeaPoint;
import com.xt.mapper.MeaPointMapper;
import com.xt.service.MeapointService;

@Service(value="meaPointService")
public class meapointServiceImpl implements MeapointService{
	@Autowired
	private MeaPointMapper meaPointMapper;
	
	@Override
	public List<MeaPoint> selectAll() {
		// TODO Auto-generated method stub
		return meaPointMapper.selectAll();
	}

	@Override
	public void addUnit(MeaPoint meaPoint) {
		// TODO Auto-generated method stub
		meaPointMapper.insert(meaPoint);
	}

	@Override
	public void deleteUnit(Integer id) {
		// TODO Auto-generated method stub
		meaPointMapper.deleteByPrimaryKey(id);
	}

	@Override
	public MeaPoint selectById(Integer id) {
		// TODO Auto-generated method stub
		return meaPointMapper.selectByPrimaryKey(id);
	}

	@Override
	public void update(MeaPoint meaPoint) {
		// TODO Auto-generated method stub
		meaPointMapper.updateByPrimaryKey(meaPoint);
	}

	@Override
	public String readExcelFile(MultipartFile file) {
		//创建处理EXCEL的类
        ReadExcel readExcel=new ReadExcel();
        //解析excel，获取上传的事件单
        List<MeaPoint> list = null;
        int insertResult = 0;
		String insertMsg = "";
		try {
			list = readExcel.getExcelInfo(file);
			//至此已经将excel中的数据转换到list里面了,接下来就可以操作list,可以进行保存到数据库,或者其他操作,
			//和你具体业务有关,这里不做具体的示范
			//数据库插入		
			for(MeaPoint m :list) {
				insertResult += meaPointMapper.insertSelective(m);
				System.out.println(m.toString());
			}
			if(insertResult ==0) {
				insertMsg = "All insert false";
			}else if(insertResult == list.size()){
				insertMsg = "All insert success";
			}else {
				insertMsg = "Part insert success";
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("接受excel表格中的数据失败！！！");
		}
		for(MeaPoint m :list) {
        	System.out.println("打印excel中的数据"+m.toString());
        }
		return insertMsg;
	}
}
