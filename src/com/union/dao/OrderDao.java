package com.union.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import com.union.model.Order;

public interface OrderDao {

	
	/**
	 * 查看订单
	 * @param id
	 * @return
	 */
	List<Order> selectOrder(Serializable id);
	/**
	 * 提交订单
	 * @param order
	 * @return
	 */
	boolean commitOrder(Order order) ;
	/**
	 * 取消订单
	 * @param id
	 * @return
	 */
	boolean cancelOrder(Serializable id);
	
}
