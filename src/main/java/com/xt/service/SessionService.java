package com.xt.service;

import java.util.List;

import com.xt.entity.Session;

public interface SessionService {

	List<Session> selectAll();

	void addSession(Session session);

	void deleteSession(Integer id);

	Session selectById(Integer id);

	void update(Session session);

}
