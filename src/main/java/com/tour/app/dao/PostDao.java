package com.tour.app.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tour.app.dto.*;


/**
 * 
 * PostDao입니다.
 * 
 * 
 * @author 박지현
 *
 */
@Repository
public class PostDao {
	@Autowired
	private SqlSession sqlSession;
	private final String namespace = "board";
	
	public List <PostDTO> getPostList(int boardType){ // 게시판 종류에 따른 전체 게시판 목록을 가져오는 메소드
		return sqlSession.selectList(namespace + ".getPostList", boardType);
	}

	public PostDTO getPost(int postId){  // postId에 따른 게시물을 하나 가져오는 메소드
		return sqlSession.selectOne(namespace + ".getPost", postId);
	}
	
	public PostContentDTO getPostContent(int postId) {
		return sqlSession.selectOne(namespace + ".getPostContent", postId);
	}
	
	public List<PostCommentDTO> getPostComments(int postId) {
		return sqlSession.selectOne(namespace + ".getPostComments", postId);
	}
	
	public void insertPost(PostDTO post) { // 게시물 작성 메소드
		sqlSession.insert(namespace + ".insertPost", post);
	}
	
	public void deletePost(int postId) { // 게시물 삭제 메소드
		sqlSession.delete(namespace + ".deletePost", postId);
	}
	public void modifyPost(PostDTO post) { // 게시물 수정 메소드
		System.out.println(post.toString());
	 	sqlSession.update(namespace + ".modifyPost", post);
	}
	
	public void insertPostContent(PostContentDTO content) {
		sqlSession.insert(namespace + ".insertContent", content);
	}
	public void deletePostContent(int postId) { // 게시물 삭제 메소드
		sqlSession.delete(namespace + ".deleteContent", postId);
	}
	public void modifyPostContent(PostContentDTO post) { // 게시물 수정 메소드
		System.out.println(post.toString());
	 	sqlSession.update(namespace + ".modifyContent", post);
	}
	
	public void insertComment(PostCommentDTO comment) {// 댓글 작성 메소드
		sqlSession.insert(namespace + ".insertComment", comment);
	}
	public void deleteComment(int commentId) { // 댓글 삭제 메소드
		sqlSession.delete(namespace + ".deleteComment", commentId);
	}
	public void modifyComment(PostCommentDTO comment) { // 댓글 수정 메소드
		sqlSession.update(namespace + ".modifyComment", comment);
	}
	

}
