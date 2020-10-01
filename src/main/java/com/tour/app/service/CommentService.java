package com.tour.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tour.app.dao.PostDao;
import com.tour.app.dto.PostCommentDTO;

@Service
public class CommentService {
	@Autowired
	private PostDao postDao;

	public List<PostCommentDTO> getPostCommentList(int postId) {
		return postDao.getPostComments(postId);

	}

	public void insertPostComment(PostCommentDTO postCommentDTO) {
		postDao.insertComment(postCommentDTO);
	}

	public void deletePostComment(PostCommentDTO postCommentDTO) {
		postDao.deleteComment(postCommentDTO.getPostCommentId());
	}

	public void modifyPostComment(PostCommentDTO postCommentDTO) {
		postDao.modifyComment(postCommentDTO);
	}

	public boolean numberCompare(int number1, int number2) {
		if (number1 == number2) {
			return true;
		} else {
			return false;
		}
	}
}
