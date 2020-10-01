package com.tour.app.controller;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tour.app.dto.PostContentDTO;
import com.tour.app.dto.PostDTO;
import com.tour.app.service.PostService;

@RestController
@RequestMapping("post")
public class PostController {
	
	@Autowired 
	private PostService postService;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<PostDTO> getPostList(@RequestParam int boardType, Locale locale) {
		List <PostDTO> posts = postService.getPostList(boardType);	
		return posts;
	}
	
	
	@RequestMapping(value = "/{postId}", method = RequestMethod.GET)
	public PostDTO getPost(@PathVariable("postId") int postId) {
		PostDTO post = postService.getPost(postId);	
		return post;
	}
	
	
	@RequestMapping(value="/", method = RequestMethod.POST)
	public String insertPost(@RequestBody PostDTO postDTO) {
		postService.insertPost(postDTO);
		return "insert success";
	}
	
	@RequestMapping(value="/", method=RequestMethod.PUT)
	public String modifyPost(@RequestBody PostDTO postDTO) {
		postService.modifyPost(postDTO);
		return "modify success";
	}
	
	@RequestMapping(value="/", method=RequestMethod.DELETE)
	public String deletPost(@RequestBody PostDTO postDTO) {
		postService.deletePost(postDTO);;
		return "delete success";
	}
}
