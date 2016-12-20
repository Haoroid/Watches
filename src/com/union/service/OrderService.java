package com.union.service;

import java.io.Serializable;
import java.util.List;

import com.union.model.Order;

public interface OrderService {

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
	Order commitOrder(Order order);
	/**
	 * 取消订单
	 * @param id
	 * @return
	 */
	boolean cancelOrder(Serializable id);
	
	
}
