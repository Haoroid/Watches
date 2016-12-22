package com.union.dao;

import java.io.Serializable;
import java.util.List;

import com.union.model.Goods;
import com.union.model.ShopCart;

public interface ShopCartDao {

	/**
	 * 添加商品至购物车
	 * @param goods
	 * @return
	 */
	boolean addShopCart(ShopCart shopCart);
	/**
	 * 从购物车中移除商品
	 * @param id
	 * @return
	 */
	boolean removeShopCart(int id);
	
	/**
	 * 显示购物车
	 * @return
	 */
	List<ShopCart> showShopCart(int userId);
}
