package com.union.admin.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;


import com.union.admin.dao.ManagerCommentDao;
import com.union.admin.dao.ManagerCommentDaoImpl;
import com.union.model.Comment;
import com.union.utils.DBUtils;

public class ManagerCommentServiceImpl implements ManagerCommentService {

	@Override
	public List<Comment> showAllComment() {
		Connection connection = null;
		connection = DBUtils.getConnection();
		List<Comment> comment = null;
		ManagerCommentDao commentDao = new ManagerCommentDaoImpl(connection);
		DBUtils.beginTransaction(connection);
		try {
			comment = commentDao.showAllComment();
			DBUtils.commit(connection);
		} catch (SQLException e) {
			DBUtils.rollback(connection);
		}finally{
			
			DBUtils.closeConnection(connection);
		}
		
		return comment;
	}

}
