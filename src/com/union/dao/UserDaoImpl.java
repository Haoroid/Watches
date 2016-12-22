package com.union.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.lang.model.element.Name;
import com.union.admin.dao.BaseDao;
import com.union.model.User;

public  class UserDaoImpl implements UserDao{
	
	static final String INSERT_T_USER_ALL="INSERT INTO T_USER(ID,USERNAME,REALNAME,PASSWORD,GENDER,ADDRESS,PHONE,EMAIL,STATUS)"
			+ " VALUES(?,?,?,?,?,?,?,?,?)";
	static final String UPDATE_T_USER_ID_PWD="UPDATE T_USER SET status=? WHERE NAME=?";
	Connection connection = null;
	public  UserDaoImpl(Connection connection) {
		this.connection  = connection;
		
	}
	
	public void add(User user){

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
		System.out.println("添加异常");
		e.printStackTrace();
	}finally{
		  try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	}
	public void  freeze(User user) {
		PreparedStatement	pstmt=null;
				try {
					pstmt=	connection.prepareStatement(UPDATE_T_USER_ID_PWD);
					pstmt.setString(1, "1");
					pstmt.setString(2, user.getUsername());
				    pstmt.executeQuery();	
			
				} catch (SQLException e) {
					System.out.println("冻结异常");
					e.printStackTrace();
				}finally{
				    try {
						connection.close();
					} catch (SQLException e) {
						System.out.println("冻结关闭异常");
						e.printStackTrace();
					}
				}
		
		
	}


	@Override
	public void unfreeze(User user) {
		PreparedStatement	pstmt=null;
		try {
			pstmt=	connection.prepareStatement(UPDATE_T_USER_ID_PWD);
			pstmt.setString(0, "0");
			pstmt.setString(1, user.getUsername());
		    pstmt.executeQuery();	
		    connection.close();
		} catch (SQLException e) {
			System.out.println("解冻异常");
			e.printStackTrace();
		}finally{
		    try {
				connection.close();
			} catch (SQLException e) {
				System.out.println("解冻关闭异常");
				e.printStackTrace();
			}
		}
		
	}

	}

