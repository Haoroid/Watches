package com.union.admin.service;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.union.admin.dao.ManagerGoodsDao;
import com.union.admin.dao.ManagerGoodsDaoImpl;
import com.union.dao.GoodsDao;
import com.union.dao.GoodsDaoImpl;
import com.union.dao.ShopCartDao;
import com.union.dao.ShopCartDaoImpl;
import com.union.model.Goods;
import com.union.utils.DBUtils;

public class ManagerGoodsServiceImpl implements ManagerGoodsService {

	@Override
	public boolean addGoods(Goods goods) {
		Connection connection = null;
		boolean isAdd = false;
		try {
			 connection = DBUtils.getConnection();
			 	ManagerGoodsDao managerGoodsDao = new ManagerGoodsDaoImpl(connection);
				DBUtils.beginTransaction(connection);
				isAdd = managerGoodsDao.addGoods(goods);
			DBUtils.commit(connection);
		} catch (SQLException e) {
			DBUtils.rollback(connection);
		}
		finally
		{
			DBUtils.closeConnection(connection);
		}
		return isAdd;
	}

	@Override
	public boolean removeGoods(int id) {
		Connection connection = null;
		boolean isRemove= false;
		try {
			 connection = DBUtils.getConnection();
			 ManagerGoodsDao managerGoodsDao = new ManagerGoodsDaoImpl(connection);
				DBUtils.beginTransaction(connection);
				isRemove = managerGoodsDao.removeGoods(id);
			DBUtils.commit(connection);
		} catch (SQLException e) {
			DBUtils.rollback(connection);
		}
		finally
		{
			DBUtils.closeConnection(connection);
		}
		return isRemove;
	}

	@Override
	public Goods selectGoods(int id) {
		Connection conn = null;
		Goods goods = null;
		try {
		conn = DBUtils.getConnection();
		ManagerGoodsDao managerGoodsDao = new ManagerGoodsDaoImpl(conn);
		DBUtils.beginTransaction(conn);
		goods = managerGoodsDao.selectGoods(id);
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
	public boolean modifyGoods(Goods goods) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Goods> showAllGoods() {
		Connection conn = null;
		List<Goods> goodsList = null;
		try{
		conn = DBUtils.getConnection();
		ManagerGoodsDao managerGoodsDao = new ManagerGoodsDaoImpl(conn);
		DBUtils.beginTransaction(conn);
		goodsList = managerGoodsDao.showAllGoods();
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

}
