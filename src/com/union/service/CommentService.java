package com.union.service;

import com.union.model.Comment;

public interface CommentService {

	/**
	 * 发送留言
	 * @param message
	 * @return
	 */
	boolean sendComment(Comment message);
}
