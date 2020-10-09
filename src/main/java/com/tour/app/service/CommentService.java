package com.tour.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tour.app.dao.PostDao;
import com.tour.app.dto.PostCommentDto;

@Service
public class CommentService {
	@Autowired
	private PostDao postDao;

	public List<PostCommentDto> getPostCommentList(int postId) {
		return postDao.getPostComments(postId);
	}

	public void insertPostComment(PostCommentDto postCommentDto) {
		postDao.insertComment(postCommentDto);
	}

	public void deletePostComment(PostCommentDto postCommentDto) {
		postDao.deleteComment(postCommentDto.getPostCommentId());
	}

	public void modifyPostComment(PostCommentDto postCommentDto) {
		postDao.modifyComment(postCommentDto);
	}

}
