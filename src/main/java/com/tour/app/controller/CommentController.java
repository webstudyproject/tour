package com.tour.app.controller;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tour.app.dto.PostCommentDto;
import com.tour.app.service.CommentService;

@RestController
@RequestMapping("post/comment")

public class CommentController {
	@Autowired
	CommentService commentService;
	
	@RequestMapping(value = "/list/{postId}", method = RequestMethod.GET)
	public List<PostCommentDto> getCommentList(@PathVariable int postId, Locale locale) {
		List <PostCommentDto> comments = commentService.getPostCommentList(postId);		
		System.out.println(comments);
		return comments;
	}
	
	@RequestMapping(value="/", method=RequestMethod.POST)
	public String insertComment(@RequestBody PostCommentDto postCommentDto) {
		commentService.insertPostComment(postCommentDto);
		return "insert Success";
	}
	
	@RequestMapping(value="/", method=RequestMethod.PUT)
	public String modifyComment(@RequestBody PostCommentDto postCommentDto) {
		commentService.modifyPostComment(postCommentDto);
		return "modify Success";
	}
	
	@RequestMapping(value="/", method=RequestMethod.DELETE)
	public String deleteComment(@RequestBody PostCommentDto postCommentDto) {
		commentService.deletePostComment(postCommentDto);
		return "delete Success";
	}

	
}
