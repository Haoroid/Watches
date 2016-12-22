package com.union.service;

import java.sql.Connection;
import java.sql.SQLException;

import com.union.dao.CommentDao;
import com.union.dao.CommentDaoImpl;
import com.union.model.Comment;
import com.union.utils.DBUtils;

public class CommentServiceImpl implements CommentService{

	@Override
	public boolean sendComment(Comment comment) {
		
		Connection connection = null;
		boolean isSend = false;
		
		try {
			CommentDao commentDao = new CommentDaoImpl(connection);
			DBUtils.beginTransaction(connection);
			isSend = commentDao.saveCommentMsg(comment);
			DBUtils.commit(connection);
		} catch (SQLException e) {
			
			DBUtils.rollback(connection);
			isSend = false;
		}finally{
			DBUtils.closeConnection(connection);
		}
		return isSend;
	}

}
