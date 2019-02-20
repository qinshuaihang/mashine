package com.xt.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.xt.entity.MeaPoint;

@Repository(value="meaPointMapper")
public interface MeaPointMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MeaPoint record);

    int insertSelective(MeaPoint record);

    MeaPoint selectByPrimaryKey(Integer id);
    
    List<MeaPoint> selectAll();

    int updateByPrimaryKeySelective(MeaPoint record);

    int updateByPrimaryKey(MeaPoint record);
}