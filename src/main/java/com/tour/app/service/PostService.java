package com.tour.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tour.app.dao.PostDao;
import com.tour.app.dto.PostCommentDto;
import com.tour.app.dto.PostDto;

@Service
public class PostService {
	
	@Autowired 
	private PostDao postDao;
	
	public List<PostDto> getPostList(int boardTypeId){
		List<PostDto> posts = postDao.getPostList(boardTypeId);
		
		for (PostDto post : posts) {
			post.setPostContent(postDao.getPostContent(post.getPostId()));
			post.setPostComments(postDao.getPostComments(post.getPostId()));
		}
		return posts;
	}
	
	public PostDto getPost(int postId) {
		PostDto post = postDao.getPost(postId);
		
		if (post != null) {
			post.setPostContent(postDao.getPostContent(post.getPostId()));
			post.setPostComments(postDao.getPostComments(post.getPostId()));
		}
		return post;
	}
	
	public void insertPost(PostDto postDto) {
		postDao.insertPost(postDto);
		postDto.getPostContent().setPostId(postDto.getPostId());
		postDao.insertPostContent(postDto.getPostContent());
	}
	
	public void deletePost(PostDto postDto) {
		postDao.deletePost((postDto.getPostId()));
		postDao.deletePostContent(postDto.getPostContent().getPostId());
		if (postDto.getPostComments() != null) {
			for (PostCommentDto comment : postDto.getPostComments()){
				postDao.deleteComment(comment.getPostCommentId());
			}
		}
	}
	
	public void modifyPost(PostDto postDTO) {
		postDao.modifyPostContent(postDTO.getPostContent());
		postDao.modifyPost(postDTO);
	}
	

}
