package com.union.admin.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import com.union.model.Order;

public interface ManagerOrderDao {
	/**
	 * 显示所有的订单
	 * @return
	 */
	List<Order> showAllOrder()  throws SQLException ;
	
	/**
	 * 修改订单状态
	 * @param id
	 * @return
	 */
	boolean modifyOrder(Serializable id);
}
