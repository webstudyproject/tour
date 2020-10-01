package com.tour.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tour.app.dao.PostDao;
import com.tour.app.dto.*;

@Service
public class PostService {
	
	@Autowired 
	private PostDao postDao;
	
	public List<PostDTO> getPostList(int boardTypeId){
		List<PostDTO> posts = postDao.getPostList(boardTypeId);
		
		for (PostDTO post : posts) {
			post.setPostContent(postDao.getPostContent(post.getPostId()));
			post.setPostComments(postDao.getPostComments(post.getPostId()));
		}
		return posts;
	}
	
	public PostDTO getPost(int postId) {
		PostDTO post = postDao.getPost(postId);
		
		if (post != null) {
			post.setPostContent(postDao.getPostContent(post.getPostId()));
			post.setPostComments(postDao.getPostComments(post.getPostId()));
		}
		return post;
	}
	
	public void insertPost(PostDTO postDTO) {
		postDao.insertPost(postDTO);
		postDTO.getPostContent().setPostId(postDTO.getPostId());
		postDao.insertPostContent(postDTO.getPostContent());
	}
	
	public void deletePost(PostDTO postDTO) {
		postDao.deletePost((postDTO.getPostId()));
		postDao.deletePostContent(postDTO.getPostContent().getPostId());
		if (postDTO.getPostComments() != null) {
			for (PostCommentDTO comment : postDTO.getPostComments()){
				postDao.deleteComment(comment.getPostCommentId());
			}
		}
	}
	
	public void modifyPost(PostDTO postDTO) {
		postDao.modifyPostContent(postDTO.getPostContent());
		postDao.modifyPost(postDTO);
	}
	

}
