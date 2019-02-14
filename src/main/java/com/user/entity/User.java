package com.user.entity;
/**
 * @Author 王海啸
 * @Description: TODO 用户实体类
 */
public class User {
	private Integer id;
	private String user_num;
	private String username;
	private String password;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUser_num() {
		return user_num;
	}
	public void setUser_num(String user_num) {
		this.user_num = user_num;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @param id
	 * @param user_num
	 * @param username
	 * @param password
	 */
	public User(Integer id,String user_num, String username, String password) {
		super();
		this.id = id;
		this.user_num = user_num;
		this.username = username;
		this.password = password;
	}
	/**
	 * 
	 */
	public User() {
		super();
	}
}
