package com.union.dao;

import java.sql.Connection;
import java.sql.SQLException;

import java.sql.PreparedStatement;
import com.union.model.Comment;

public class CommentDaoImpl implements CommentDao {

	private static final String INSERT_COMMENT = "INSERT INTO T_COMMENT(EMAIL,MESSAGE,NAME,PHONE,TIME) VALUES(?,?,?,?)";

	Connection connection = null;

	public CommentDaoImpl(Connection connection) {
		this.connection = connection;
	}

	@Override
	public boolean saveCommentMsg(Comment comment) {
		PreparedStatement pstmt = null;
		try {
			pstmt = connection.prepareStatement(INSERT_COMMENT);
			pstmt.setString(1, comment.getEmail());
			pstmt.setString(2, comment.getMessage());
			pstmt.setString(3, comment.getName());
			pstmt.setString(4, comment.getPhone());
			pstmt.setString(5, comment.getTime());
			if(pstmt.executeUpdate()!=0)
			{
				return true;
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return false;
	}

}
