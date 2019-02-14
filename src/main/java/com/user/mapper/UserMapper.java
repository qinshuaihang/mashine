package com.user.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.user.entity.User;

@Repository(value="userMapper")
public interface UserMapper {
	
	//登录
	public List<User> login(User user);
}
