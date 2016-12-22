package com.union.admin.dao;

import java.sql.SQLException;
import java.util.List;

import com.union.model.Comment;

public interface ManagerCommentDao {
	/**
	 * 显示所有留言
	 * @return
	 * @throws SQLException 
	 */
	List<Comment> showAllComment() throws SQLException;
}
