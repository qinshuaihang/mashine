package com.xt.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.xt.entity.Session;
@Repository(value="sessionMapper")
public interface SessionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Session record);

    int insertSelective(Session record);

    Session selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Session record);

    int updateByPrimaryKey(Session record);

	List<Session> selectAll();
}