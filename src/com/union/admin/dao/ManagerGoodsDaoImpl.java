package com.union.admin.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.union.model.Goods;
import com.union.utils.DBUtils;

public class ManagerGoodsDaoImpl implements ManagerGoodsDao {

	private static final String INSERT_GOODS = "INSERT INTO T_GOODS(COLOR,DESCRIPTION,DISCOUNT,GOODSNUM,GOODSSIZE,NAME,PICTURE,PRICE,TYPE) VALUES(?,?,?,?,?,?,?,?,?)";
	private static final String DELETE_GOODS = "DELETE FROM T_GOODS WHERE ID = ?";
	private static final String SELECT_GOODS_ID = "SELECT * FROM T_GOODS WHERE ID = ?"; 
	private static final String SELECT_GOODS_ALL = "SELECT * FROM T_GOODS";
	Connection connection = null;

	public ManagerGoodsDaoImpl(Connection connection) {
		this.connection = connection;
	}

	@Override
	public boolean addGoods(Goods goods) throws SQLException {
		PreparedStatement pstmt = null;

		try {

			pstmt = connection.prepareStatement(INSERT_GOODS);
			pstmt.setString(1, goods.getColor());
			pstmt.setString(2, goods.getDescription());
			pstmt.setString(3, goods.getDiscount());
			pstmt.setInt(4, goods.getGoodsNum());
			pstmt.setString(5, goods.getGoodsSize());
			pstmt.setString(6, goods.getName());
			pstmt.setString(7, goods.getPicture());
			pstmt.setString(8, goods.getPrice());
			pstmt.setString(9, goods.getType());
			int iExeUpdate = pstmt.executeUpdate();
			if (iExeUpdate != 0) {
				return true;
			}

		} finally {
			DBUtils.closeStatement(null, pstmt);
		}

		return false;
	}

	@Override
	public boolean removeGoods(int id) throws SQLException {

		PreparedStatement pstmt = null;

		try {
			pstmt = connection.prepareStatement(DELETE_GOODS);
			pstmt.setInt(1, id);
			int iExeUpdate = pstmt.executeUpdate();
			if (iExeUpdate != 0) {
				return true;
			}

		} finally {
			DBUtils.closeStatement(null, pstmt);
		}

		return false;
	}

	@Override
	public Goods selectGoods(Serializable id) throws SQLException {
		
		Goods goods = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = connection.prepareStatement(SELECT_GOODS_ID);
			rs = stmt.executeQuery();
			if(rs.next())
			{
				goods = new Goods();
				goods.setColor(rs.getString("COLOR"));
				goods.setDescription(rs.getString("DESCRIPTION"));
				goods.setGoodsNum(rs.getInt("GOODSNUM"));
				goods.setDiscount(rs.getString("DISCOUNT"));
				goods.setId(rs.getInt("ID"));
				goods.setName(rs.getString("NAME"));
				goods.setPicture(rs.getString("PICTURE"));
				goods.setPrice(rs.getString("PRICE"));
				goods.setType(rs.getString("TYPE"));
				goods.setGoodsSize(rs.getString("GOODSSIZE"));
				
				
			}
		}finally{
			DBUtils.closeStatement(rs, stmt);
		}
		
		return goods;
		
	}

	@Override
	public boolean modifyGoods(Goods goods) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Goods> showAllGoods() throws SQLException {
		List<Goods> goodsList = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = connection.prepareStatement(SELECT_GOODS_ALL);
			rs = pstmt.executeQuery();
			if(rs.next())
			{
				Goods goods = new Goods();
				goods.setColor(rs.getString("COLOR"));
				goods.setDescription(rs.getString("DESCRIPTION"));
				goods.setGoodsNum(rs.getInt("GOODSNUM"));
				goods.setDiscount(rs.getString("DISCOUNT"));
				goods.setId(rs.getInt("ID"));
				goods.setName(rs.getString("NAME"));
				goods.setPicture(rs.getString("PICTURE"));
				goods.setPrice(rs.getString("PRICE"));
				goods.setType(rs.getString("TYPE"));
				goods.setGoodsSize(rs.getString("GOODSSIZE"));
				goodsList.add(goods);
				
			}
		} finally{
			DBUtils.closeStatement(rs, pstmt);
		}
		
		return goodsList;
	}

	@Override
	public List<Goods> categoryGoods(Serializable tag) throws SQLException {
		String sql = null;
		switch (tag.toString()) {
		case "type":
			sql = "select * from T_GOODS where type = "+tag;
			break;
		case "name":
			sql = "select * from T_GOODS where name = "+tag;
			break;
		default:
			break;
		}
		List<Goods> goodsList = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = connection.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next())
			{
				Goods goods = new Goods();
				goods.setColor(rs.getString("COLOR"));
				goods.setDescription(rs.getString("DESCRIPTION"));
				goods.setGoodsNum(rs.getInt("GOODSNUM"));
				goods.setDiscount(rs.getString("DISCOUNT"));
				goods.setId(rs.getInt("ID"));
				goods.setName(rs.getString("NAME"));
				goods.setPicture(rs.getString("PICTURE"));
				goods.setPrice(rs.getString("PRICE"));
				goods.setType(rs.getString("TYPE"));
				goods.setGoodsSize(rs.getString("GOODSSIZE"));
				goodsList.add(goods);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtils.closeStatement(rs, pstmt);
		}
		
		return goodsList;
		
	}

}
