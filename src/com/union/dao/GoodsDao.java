package com.union.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import com.union.model.Goods;

public interface GoodsDao {

	/**
	 * 查看所有的商品
	 * @return
	 */
	List<Goods> showAllGoods() throws SQLException;
	/**
	 * 查看商品的详细信息
	 * @param id
	 * @return
	 */
	Goods selectGoods(Serializable id) throws SQLException;
	
	/**
	 * 通过tag标识进行商品分类
	 * @param tag
	 * @return
	 */
	List<Goods> searchGoods(Serializable tag) throws SQLException;
}
