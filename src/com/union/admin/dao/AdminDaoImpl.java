package com.union.admin.dao;

import java.net.PasswordAuthentication;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.union.model.Admin;
import com.union.model.User;

public class AdminDaoImpl implements AdminDao{
	static final String INSERT_T_USER_ALL="INSERT INTO T_USER(ID,USERNAME,REALNAME,PASSWORD,GENDER,ADDRESS,PHONE,EMAIL,STATUS)"
			+ " VALUES(?,?,?,?,?,?,?,?,?)";
	static final String SEARCH_T_USER_NAME="select name from T_User";
	static final String SEARCH_T_USER_PASSWORD="select password from T_User where name=?";
	static final String SEARCH_T_USER_ID="select ID from T_User where name=?";
	static final String SEARCH_T_USER_STATUS="select STATUS from T_User where name=?";
	Connection connection = null;

	public  AdminDaoImpl(Connection connection) {
		this.connection  = connection;
		
	}

	//登录
	public void login(Admin admin) {
		try {
			PreparedStatement  pstmt1 = connection.prepareStatement(SEARCH_T_USER_ID);
			pstmt1.setString(0, admin.getName());
			 ResultSet rs1 = pstmt1.executeQuery();
			 if(rs1==null){
				 System.out.println("用户不存在请注册");//查看是否存在用户
			 }else{

					
						PreparedStatement  pstmt2 = connection.prepareStatement(SEARCH_T_USER_PASSWORD);
						pstmt2.setString(0, admin.getName());
						 ResultSet rs2 = pstmt2.executeQuery();
						if(rs2.getString("Password")==admin.getPassword()){
						PreparedStatement  pstmt = connection.prepareStatement(SEARCH_T_USER_STATUS);
						pstmt.setString(0, admin.getName());
						ResultSet rs=pstmt.executeQuery();
						if(rs.getString("ststus")=="1"){
							System.out.println("登录成功");
							
						}else {
							System.out.println("账号被冻结，请找管理员解冻");
						}																									
						}else {
							System.out.println("密码错误请重新登陆");//查看密码是否正确
						}
					
			 }
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally{
			try {
				connection.close();
			} catch (SQLException e) {
				System.out.println("连接关闭异常");
				e.printStackTrace();
			}
		}
		
		
		
		
		//pstmt.setString(2, user.getPassword());
	   // pstmt.executeQuery();	
	    //connection.close();
		
	}

//注册
	public void registerr(User user) {
		try {
			PreparedStatement  pstmt = connection.prepareStatement(INSERT_T_USER_ALL);
			pstmt.setLong(0, user.getId());
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getRealname());
			pstmt.setString(3, user.getPassword());
			pstmt.setString(4, user.getGender());
			pstmt.setString(5, user.getAddress());
			pstmt.setString(6, user.getPhone());
			pstmt.setString(7, user.getEmail());
			pstmt.setString(8, user.getStatus());
		    pstmt.executeQuery();	

		} catch (SQLException e) {
			System.out.println("注册失败");
			e.printStackTrace();
		}finally{
			try {
				connection.close();
			} catch (SQLException e) {
				System.out.println("注册失败");
				e.printStackTrace();
			}
		  
		}
		
	}

}
