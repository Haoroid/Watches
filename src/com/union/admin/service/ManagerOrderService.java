package com.union.admin.service;

import java.io.Serializable;
import java.util.List;

import com.union.model.Order;

public interface ManagerOrderService {


	/**
	 * 显示所有的订单
	 * @return
	 */
	List<Order> showAllOrder();
	
	/**
	 * 修改订单状态
	 * @param id
	 * @return
	 */
	boolean modifyOrder(Serializable id);
}
