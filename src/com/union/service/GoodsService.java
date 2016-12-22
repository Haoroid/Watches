package com.union.service;

import java.io.Serializable;
import java.util.List;

import com.union.model.Goods;
/**
 * 用户查看商品
 * @author shaoqi
 *
 */
public interface GoodsService {

	/**
	 * 查看所有的商品
	 * @return
	 */
	List<Goods> showAllGoods();
	/**
	 * 查看商品的详细信息
	 * @param id
	 * @return
	 */
	Goods selectGoods(Serializable id);
	
	/**
	 * 通过tag标识进行商品分类
	 * @param tag
	 * @return
	 */
	List<Goods> searchGoods(Serializable tag);
	
	/**
	 * 通过tag标识进行商品分类
	 * @param tag
	 * @return
	 */
	List<Goods> categoryGoods(Serializable tag);
}
