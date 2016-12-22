package com.union.service;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;
import com.union.dao.OrderDao;
import com.union.dao.OrderDaoImpl;
import com.union.model.Order;
import com.union.utils.DBUtils;

public class OrderServiceImpl implements OrderService {


	

	@Override
	public List<Order> selectOrder(Serializable id) {
		
		return null;
	}

	@Override
	public boolean commitOrder(Order order) {
		Connection conn = null;
		boolean isCommit = false;
		try {
			conn = DBUtils.getConnection();
			OrderDao orderDao = new OrderDaoImpl(conn);
			DBUtils.beginTransaction(conn);
			isCommit = orderDao.commitOrder(order);
			DBUtils.commit(conn);
		} catch (SQLException e) {
			DBUtils.rollback(conn);
		}finally
		{
			DBUtils.closeConnection(conn);
		}
		
		return isCommit;
	}

	@Override
	public boolean cancelOrder(Serializable id) {
		// TODO Auto-generated method stub
		return false;
	}

	

}
