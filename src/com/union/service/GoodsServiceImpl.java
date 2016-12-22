package com.union.service;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.union.dao.GoodsDao;
import com.union.dao.GoodsDaoImpl;
import com.union.model.Goods;
import com.union.utils.DBUtils;

public class GoodsServiceImpl implements GoodsService {

	@Override
	public List<Goods> showAllGoods() {
		Connection conn = null;
		List<Goods> goodsList = null;
		try{
		conn = DBUtils.getConnection();
		GoodsDao goodsDao = new GoodsDaoImpl(conn);
		DBUtils.beginTransaction(conn);
		goodsList = goodsDao.showAllGoods();
		DBUtils.commit(conn);
		}catch(SQLException e)
		{
			DBUtils.rollback(conn);
			
		}finally
		{
			DBUtils.closeConnection(conn);
		}
		return goodsList;
	}

	@Override
	public Goods selectGoods(Serializable id) {
		
		Connection conn = null;
		Goods goods = null;
		try {
		conn = DBUtils.getConnection();
		GoodsDao goodsDao = new GoodsDaoImpl(conn);
		DBUtils.beginTransaction(conn);
		goods = goodsDao.selectGoods(id);
		DBUtils.commit(conn);
		} catch (SQLException e) {
			DBUtils.rollback(conn);
		}finally
		{
			DBUtils.closeConnection(conn);
		}
		
		return goods;
	}

	@Override
	public List<Goods> searchGoods(Serializable tag) {
		
		Connection conn = null;
		List<Goods> goodsList = null;
		try{
		conn = DBUtils.getConnection();
		GoodsDao goodsDao = new GoodsDaoImpl(conn);
		DBUtils.beginTransaction(conn);
		goodsList = goodsDao.searchGoods(tag);
		DBUtils.commit(conn);
		}catch(SQLException e)
		{
			DBUtils.rollback(conn);
			
		}finally
		{
			DBUtils.closeConnection(conn);
		}
		return goodsList;
	}

	@Override
	public List<Goods> categoryGoods(Serializable tag) {
		// TODO Auto-generated method stub
		return null;
	}

}
