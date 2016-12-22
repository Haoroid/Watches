package com.union.dao;

import org.apache.catalina.deploy.LoginConfig;

import com.union.model.User;

public interface UserDao {
	

  void	add(User user);// 用户增加

  void  freeze(User user);//用户冻结
  
  void  unfreeze(User user);//用户解冻

}
