package com.union.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 数据库工具类
 * 
 * @author shaoqi
 * 
 */
public class DBUtils {

	private static final String driverName = "oracle.jdbc.OracleDriver";
	private static final String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	private static final String user = "Haoroid";
	private static final String password = "Haoroid";

	/**
	 * 获取数据库连接
	 * 
	 * @return
	 */
	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName(driverName);
			conn = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return conn;

	}

	/**
	 * 开启事务
	 * 
	 * @param conn
	 */

	public static void beginTransaction(Connection conn) {
		try {
			conn.setAutoCommit(false);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

	/**
	 * 提交事务
	 * 
	 * @param conn
	 * @throws SQLException 
	 */
	public static void commit(Connection conn) throws SQLException {

		
			conn.commit();
			conn.setAutoCommit(true);
		
	}

	/**
	 * 回滚事务
	 * 
	 * @param conn
	 */
	public static void rollback(Connection conn) {
		try {
			conn.rollback();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

	/**
	 * 关闭连接
	 * 
	 * @param conn
	 */
	public static void closeConnection(Connection conn) {

		try {
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

	/**
	 * 关闭ResultSet Statement
	 * @param rs
	 * @param stmt
	 */
	public static void closeStatement(ResultSet rs, Statement stmt) {
		try {
			if (rs != null)
				rs.close();
			if (stmt!=null)
				stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
