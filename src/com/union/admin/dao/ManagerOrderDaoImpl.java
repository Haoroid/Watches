package com.union.admin.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.union.model.Order;
import com.union.model.Order;
import com.union.utils.DBUtils;

public class ManagerOrderDaoImpl implements ManagerOrderDao{
	Connection connection = null;
	private static final String SELECT_ORDER_ALL = "SELECT * FROM T_ORDER";

	public ManagerOrderDaoImpl(Connection connection) {
		this.connection = connection;
	}
	@Override
	public List<Order> showAllOrder() throws SQLException {
		List<Order> orderList = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = connection.prepareStatement(SELECT_ORDER_ALL );
			rs = pstmt.executeQuery();
			if(rs.next())
			{
				Order order = new Order();
				order.setAddress(rs.getString("ADDRESS"));
				order.setCommitTime(rs.getString("COMMITTIME"));
				order.setGoodsId(rs.getInt("GOODSID"));
				order.setId(rs.getInt("ID"));
				order.setRealname(rs.getString("REALNAME"));
				//order.setShopCartId(rs.getInt("SHOPCARTID"));
				order.setStatus(rs.getString("STATUS"));
				order.setUsername(rs.getString("USERNAME"));
				orderList.add(order);
				
			}
		} finally{
			DBUtils.closeStatement(rs, pstmt);
		}
		
		return orderList;
	}

	@Override
	public boolean modifyOrder(Serializable id) {
		// TODO Auto-generated method stub
		return false;
	}

}
