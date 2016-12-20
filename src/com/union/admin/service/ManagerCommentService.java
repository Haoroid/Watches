package com.union.admin.service;

import java.util.List;

import com.union.model.CommentMsg;

public interface ManagerCommentService {


	/**
	 * 显示所有留言
	 * @return
	 */
	List<CommentMsg> showAllComment();
}
