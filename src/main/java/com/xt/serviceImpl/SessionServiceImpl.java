package com.xt.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xt.entity.Session;
import com.xt.mapper.SessionMapper;
import com.xt.service.SessionService;
@Service(value="sessionService")
public class SessionServiceImpl implements SessionService{
	@Autowired
	private SessionMapper sessionMapper;

	@Override
	public List<Session> selectAll() {
		// TODO Auto-generated method stub
		return sessionMapper.selectAll();
	}

	@Override
	public void addSession(Session session) {
		// TODO Auto-generated method stub
		sessionMapper.insert(session);
	}

	@Override
	public void deleteSession(Integer id) {
		// TODO Auto-generated method stub
		sessionMapper.deleteByPrimaryKey(id);
	}

	@Override
	public Session selectById(Integer id) {
		// TODO Auto-generated method stub
		return sessionMapper.selectByPrimaryKey(id);
	}

	@Override
	public void update(Session session) {
		// TODO Auto-generated method stub
		sessionMapper.updateByPrimaryKey(session);
	}
}
