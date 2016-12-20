package com.union.service;

import com.union.model.CommentMsg;

public interface CommentService {

	/**
	 * 发送留言
	 * @param message
	 * @return
	 */
	boolean sendCommentMsg(CommentMsg message);
}
