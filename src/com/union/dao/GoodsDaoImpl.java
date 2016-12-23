package com.union.dao;

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

public class GoodsDaoImpl implements GoodsDao {

	Connection connection = null;
	private static final String SELECT_GOODS = "SELECT * FROM T_GOODS";

	public GoodsDaoImpl(Connection connection) {
		this.connection = connection;

	}

	@Override
	public List<Goods> showAllGoods() throws SQLException {

		List<Goods> goodsList = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = connection.prepareStatement(SELECT_GOODS);
			rs = pstmt.executeQuery();

			while (rs.next()) {
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
		} finally {
			DBUtils.closeStatement(rs, pstmt);
		}

		return goodsList;
	}

	@Override
	public Goods selectGoods(Serializable id) throws SQLException {
		String sql = "select * from T_GOODS where id = " + id;
		Goods goods = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
			if (rs.next()) {
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
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeStatement(rs, stmt);
		}

		return goods;
	}

	@Override
	public List<Goods> searchGoods(Serializable tag) throws SQLException {
		String sql = null;
		switch (tag.toString()) {
		case "type":
			sql = "select * from T_GOODS where type = " + tag;
			break;
		case "name":
			sql = "select * from T_GOODS where name = " + tag;
			break;
		default:
			break;
		}

		List<Goods> goodsList = new ArrayList<>();
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
			if (rs.next()) {
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
		} finally {
			DBUtils.closeStatement(rs, stmt);
		}

		return goodsList;
	}

	@Override
	public List<Goods> categoryGoods(Serializable tag) {
		String sql = null;

		sql = "select * from T_GOODS where TYPE = ?"; 

		List<Goods> goodsList = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1,tag.toString());
			rs = pstmt.executeQuery();
			while (rs.next()) {
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
		} finally {
			DBUtils.closeStatement(rs, pstmt);
		}

		return goodsList;
	}

}
