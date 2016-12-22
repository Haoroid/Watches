package com.union.admin.service;

import java.io.Serializable;
import java.util.List;

import com.union.model.Goods;
/**
 * 后台商品管理
 * @author shaoqi
 *
 */
public interface ManagerGoodsService {

	/**
	 * 添加商品
	 * @param goods
	 * @return
	 */
	boolean addGoods(Goods goods);
	/**
	 * 删除某个商品
	 * @param id
	 * @return
	 */
	boolean removeGoods(int id);
	/**
	 * 查询某个商品
	 * @param id
	 * @return
	 */
	Goods selectGoods(int id);
	
	/**
	 * 修改某个商品
	 * @param goods
	 * @return
	 */
	boolean modifyGoods(Goods goods);
	
	/**
	 * 显示所有商品
	 * @return
	 */
	List<Goods> showAllGoods();
	

	
}
