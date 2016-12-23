package com.union.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import java.sql.PreparedStatement;

import com.union.model.Goods;
import com.union.model.ShopCart;
import com.union.utils.DBUtils;

public class ShopCartDaoImpl implements ShopCartDao {

	
	private final static String INSERT_SHOPCART_GOODSID = "insert into T_SHOPCART(GOODSID,USERID,NAME,PRICE) VALUES(?,?,?,?)"; 
	private final static String DELETE_SHOPCART_GOODSID = "DELETE FROM T_SHOPCART WHERE ID = ?";
	private final static String SELECT_SHOPCART = "SELECT * FROM T_SHOPCART WHERE USERID = ?";
	private final static String SELECT_ALL_SHOPCART = "SELECT * FROM T_SHOPCART";
	
	Connection connection = null;
	public ShopCartDaoImpl(Connection connection) {
		this.connection = connection;
	}
	@Override
	public boolean addShopCart(ShopCart shopCart) {
	
		
		PreparedStatement pstmt = null;
		try {

			pstmt = connection.prepareStatement(INSERT_SHOPCART_GOODSID);
			pstmt.setInt(1,shopCart.getGoodsId());
			pstmt.setInt(2, shopCart.getUserId());
			pstmt.setString(3,shopCart.getName());
			pstmt.setString(4,shopCart.getPrice());
			if(pstmt.executeUpdate()!=0)
			{
				return true;
			}
			
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally
		{
			DBUtils.closeStatement(null, pstmt);
		}
		
		return false;
	}

	@Override
	public boolean removeShopCart(int id) {

		PreparedStatement pstmt = null;
		try {
			
			pstmt = connection.prepareStatement(DELETE_SHOPCART_GOODSID);
			pstmt.setInt(1, id);
			if(pstmt.executeUpdate()!=0)
			{
				return true;
			}
			
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally
		{
			DBUtils.closeStatement(null, pstmt);
		}
		return false;
	}

	@Override
	public List<ShopCart> showShopCart(int userId) {
	
		
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			List<ShopCart> shopCartList = new ArrayList<>();
			
			try {

				pstmt = connection.prepareStatement(SELECT_SHOPCART);
				pstmt.setInt(1, userId);
				rs = pstmt.executeQuery();
				while(rs.next())
				{
					ShopCart  shopCart = new ShopCart();
					shopCart.setId(rs.getInt("ID"));
					shopCart.setGoodsId(rs.getInt("GOODSID"));
					shopCart.setUserId(rs.getInt("USERID"));
					shopCart.setName(rs.getString("NAME"));
					shopCart.setPrice(rs.getString("PRICE"));
					shopCartList.add(shopCart);
				}
				
			
			} catch (SQLException e) {
				
				e.printStackTrace();
			}finally
			{
				DBUtils.closeStatement(rs, pstmt);
			}
			return shopCartList;
		
	}
	@Override
	public List<ShopCart> showAllShopCart() {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<ShopCart> shopCartList = new ArrayList<>();
		
		try {

			pstmt = connection.prepareStatement(SELECT_ALL_SHOPCART);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				ShopCart  shopCart = new ShopCart();
				shopCart.setId(rs.getInt("ID"));
				shopCart.setGoodsId(rs.getInt("GOODSID"));
				shopCart.setUserId(rs.getInt("USERID"));
				shopCart.setName(rs.getString("NAME"));
				shopCart.setPrice(rs.getString("PRICE"));
				shopCartList.add(shopCart);
			}
			
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally
		{
			DBUtils.closeStatement(rs, pstmt);
		}
		return shopCartList;
	}

}
