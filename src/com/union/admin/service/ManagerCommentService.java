package com.union.admin.service;

import java.util.List;

import com.union.model.Comment;

public interface ManagerCommentService {


	/**
	 * 显示所有留言
	 * @return
	 */
	List<Comment> showAllComment();
}
