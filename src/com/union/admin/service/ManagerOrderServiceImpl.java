package com.union.admin.service;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.union.admin.dao.ManagerOrderDao;
import com.union.admin.dao.ManagerOrderDaoImpl;
import com.union.dao.GoodsDao;
import com.union.dao.GoodsDaoImpl;
import com.union.model.Goods;
import com.union.model.Order;
import com.union.utils.DBUtils;

public class ManagerOrderServiceImpl implements ManagerOrderService {

	@Override
	public List<Order> showAllOrder() {
		Connection conn = null;
		List<Order> orderList = null;
		try{
		conn = DBUtils.getConnection();
		ManagerOrderDao managerOrderDao = new ManagerOrderDaoImpl(conn);
		DBUtils.beginTransaction(conn);
		orderList = managerOrderDao.showAllOrder();
		DBUtils.commit(conn);
		}catch(SQLException e)
		{
			DBUtils.rollback(conn);
			
		}finally
		{
			DBUtils.closeConnection(conn);
		}
		return orderList;
	}

	@Override
	public boolean modifyOrder(Serializable id) {
		// TODO Auto-generated method stub
		return false;
	}

}
