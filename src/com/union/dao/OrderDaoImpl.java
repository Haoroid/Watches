package com.union.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import java.sql.PreparedStatement;
import com.union.model.Order;
import com.union.utils.DBUtils;

public class OrderDaoImpl implements OrderDao{

	private static final String INSERT_ORDER = "INSERT INTO T_ORDER(ADDRESS,GOODSID,STATUS,USERNAME,COMMITTIME,REALNAME) VALUES(?,?,?,?,?,?)";

	Connection connection = null;
	public OrderDaoImpl(Connection connection) {
		this.connection = connection;
	}
	@Override
	public List<Order> selectOrder(Serializable id) {
		
		return null;
	}

	@Override
	public boolean commitOrder(Order order) {
		
		PreparedStatement pstmt = null;
		try {
			pstmt = connection.prepareStatement(INSERT_ORDER);
			pstmt.setString(1, order.getAddress());
			pstmt.setInt(2,order.getGoodsId());
			pstmt.setString(3,order.getStatus());
			pstmt.setString(4, order.getUsername());
			pstmt.setString(5, order.getCommitTime());
			pstmt.setString(6, order.getRealname());

			if(pstmt.executeUpdate()!=0)
			{
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			DBUtils.closeStatement(null, pstmt);
		}
		
		
		
		return false;
	}

	@Override
	public boolean cancelOrder(Serializable id) {
		// TODO Auto-generated method stub
		return false;
	}

}
