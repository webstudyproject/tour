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
import org.springframework.web.bind.annotation.ResponseBody;

import com.tour.app.dto.PostDto;
import com.tour.app.service.PostService;

@Controller
@RequestMapping("post")
public class PostController {
	
	@Autowired 
	private PostService postService;
	
	@RequestMapping(value="/page", method=RequestMethod.GET)
	public String getPostPage() {
		return "tiles/post/list";
	}
	
	@RequestMapping(value="/write/page", method=RequestMethod.GET)
	public String getPostWritePage() {
		return "tiles/post/write";
	}
	
	@ResponseBody
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<PostDto> getPostList(@RequestParam int boardType, Locale locale) {
		List <PostDto> posts = postService.getPostList(boardType);	
		return posts;
	}
	
	@ResponseBody
	@RequestMapping(value = "/{postId}", method = RequestMethod.GET)
	public PostDto getPost(@PathVariable("postId") int postId) {
		PostDto post = postService.getPost(postId);	
		return post;
	}
	
	@ResponseBody
	@RequestMapping(value="/", method = RequestMethod.POST)
	public String insertPost(@RequestBody PostDto postDto) {
		System.out.println(postDto);
		postService.insertPost(postDto);
		return "insert success";
	}
	
	@ResponseBody
	@RequestMapping(value="/", method=RequestMethod.PUT)
	public String modifyPost(@RequestBody PostDto postDto) {
		postService.modifyPost(postDto);
		return "modify success";
	}
	
	@ResponseBody
	@RequestMapping(value="/", method=RequestMethod.DELETE)
	public String deletPost(@RequestBody PostDto postDto) {
		postService.deletePost(postDto);;
		return "delete success";
	}
}
