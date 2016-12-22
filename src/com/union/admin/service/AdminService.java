package com.union.admin.service;



import java.io.Serializable;

import com.union.model.Admin;

public interface AdminService {

	/**
	 * 管理员登录
	 * @param id
	 * @param password
	 * @return
	 */
	Admin adminLogin(Serializable id,Serializable password);
	
}
