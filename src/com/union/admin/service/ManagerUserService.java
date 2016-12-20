package com.union.admin.service;

import java.io.Serializable;
import java.util.List;

import com.union.model.User;

public interface ManagerUserService {

	/**
	 * 冻结用户
	 * @param id
	 * @return
	 */
	boolean	stopUser(Serializable id);
	
	/**
	 * 显示用户
	 * @return
	 */
	List<User> showAllUser();
	/**
	 * 激活用户
	 * @param id
	 * @return
	 */
	boolean resumeUser(Serializable id);
	
}
