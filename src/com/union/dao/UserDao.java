package com.union.dao;

import org.apache.catalina.deploy.LoginConfig;

import com.union.model.User;

public interface UserDao {
	

  void	add(User user);// �û�����

  void  freeze(User user);//�û�����
  
  void  unfreeze(User user);//�û��ⶳ

}
