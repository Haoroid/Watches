package com.union.service;

import java.io.Serializable;

import com.union.model.User;
/**
 * 用户操作
 * @author shaoqi
 *
 */
public interface UserService {

	/**
	 * 用户注册
	 * @param user
	 * @return
	 */
	User userRegister(User user);
	/**
	 * 用户登录
	 * @param username
	 * @param password
	 * @return
	 */
	int userLogin(Serializable username,Serializable password);
	
}
