package com.union.service;

import java.io.Serializable;
import java.util.List;

import com.union.model.Goods;

public interface ShopCartService {

	/**
	 * 添加商品至购物车
	 * @param goods
	 * @return
	 */
	List<Goods> addShopCart(Goods goods);
	/**
	 * 从购物车中移除商品
	 * @param id
	 * @return
	 */
	List<Goods> removeShopCart(Serializable id);
	
	
}
