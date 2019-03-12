package com.xt.mapper;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.xt.entity.Jzpeizhi;
@Repository(value="jzpeizhiMapper")
public interface JzpeizhiMapper {
    int deleteByPrimaryKey(Integer peizhiid);

    int insert(Map<String, String> map);

    int insertSelective(Jzpeizhi record);

    Jzpeizhi selectByPrimaryKey(Integer peizhiid);

    int updateByPrimaryKeySelective(Jzpeizhi record);

    int updateByPrimaryKey(Jzpeizhi record);
}