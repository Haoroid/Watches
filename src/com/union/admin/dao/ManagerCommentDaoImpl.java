package com.union.admin.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import java.sql.PreparedStatement;
import com.union.model.Comment;
import com.union.utils.DBUtils;

public class ManagerCommentDaoImpl implements ManagerCommentDao {

	private static final String SELECT_COMMENT = "SELECT * FROM T_COMMENT";
	Connection connection = null;

	public ManagerCommentDaoImpl(Connection connection) {
		this.connection = connection;
	}

	@Override
	public List<Comment> showAllComment() throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Comment> commentList = new ArrayList<>();
		try{
		
		pstmt = connection.prepareStatement(SELECT_COMMENT);
		rs = pstmt.executeQuery();
		if(rs.next())
		{
			Comment comment = new Comment();
			comment.setEmail(rs.getString("EMAIL"));
			comment.setMessage(rs.getString("MESSAGE"));
			comment.setId(rs.getInt("ID"));
			comment.setName(rs.getString("NAME"));
			comment.setTime(rs.getString("TIME"));
			comment.setPhone(rs.getString("PHONE"));
			commentList.add(comment);
		}
		
		}finally
		{
			DBUtils.closeStatement(rs, pstmt);
		}
		return commentList;
	}
}
