package com.union.admin.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import com.union.model.Goods;

public interface ManagerGoodsDao {

	/**
	 * 添加商品
	 * @param goods
	 * @return
	 */
	boolean addGoods(Goods goods) throws SQLException;
	/**
	 * 删除某个商品
	 * @param id
	 * @return
	 */
	boolean removeGoods(int id) throws SQLException;
	/**
	 * 查询某个商品
	 * @param id
	 * @return
	 */
	Goods selectGoods(Serializable id) throws SQLException;
	
	/**
	 * 修改某个商品
	 * @param goods
	 * @return
	 */
	boolean modifyGoods(Goods goods) throws SQLException;
	
	/**
	 * 显示所有商品
	 * @return
	 */
	List<Goods> showAllGoods() throws SQLException;
	
	/**
	 * 通过tag标识进行商品分类
	 * @param tag
	 * @return
	 */
	List<Goods> categoryGoods(Serializable tag) throws SQLException;
}
