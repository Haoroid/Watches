package com.union.service;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.union.dao.ShopCartDao;
import com.union.dao.ShopCartDaoImpl;
import com.union.model.Goods;
import com.union.model.ShopCart;
import com.union.utils.DBUtils;

public class ShopCartServiceImpl implements ShopCartService {


	@Override
	public boolean addShopCart(ShopCart shopCart) {
		Connection connection = null;
		boolean isAdd = false;
		try {
			 connection = DBUtils.getConnection();
				ShopCartDao shopCartDao = new ShopCartDaoImpl(connection);
				DBUtils.beginTransaction(connection);
				isAdd = shopCartDao.addShopCart(shopCart);
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
	public boolean removeShopCart(int id) {
		Connection connection = null;
		boolean isRemove= false;
		try {
			 connection = DBUtils.getConnection();
				ShopCartDao shopCartDao = new ShopCartDaoImpl(connection);
				DBUtils.beginTransaction(connection);
				isRemove = shopCartDao.removeShopCart(id);
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
	public List<ShopCart> showShopCart(int userId) {
		Connection connection = null;
		List<ShopCart> shopCartList = new ArrayList<>();
		try {
			 connection = DBUtils.getConnection();
				ShopCartDao shopCartDao = new ShopCartDaoImpl(connection);
				DBUtils.beginTransaction(connection);
				shopCartList = shopCartDao.showShopCart(userId);
			DBUtils.commit(connection);
		} catch (SQLException e) {
			DBUtils.closeConnection(connection);
		}
		finally
		{
			DBUtils.closeConnection(connection);
		}
		return shopCartList;
	}
	@Override
	public List<ShopCart> showAllShopCart() {
		Connection connection = null;
		List<ShopCart> shopCartList = new ArrayList<>();
		try {
			 connection = DBUtils.getConnection();
				ShopCartDao shopCartDao = new ShopCartDaoImpl(connection);
				DBUtils.beginTransaction(connection);
				shopCartList = shopCartDao.showAllShopCart();
			DBUtils.commit(connection);
		} catch (SQLException e) {
			DBUtils.closeConnection(connection);
		}
		finally
		{
			DBUtils.closeConnection(connection);
		}
		return shopCartList;
	}

	
}
