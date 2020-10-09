package com.tour.app.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tour.app.dto.*;



@Repository
public class PostDao {
	@Autowired
	private SqlSession sqlSession;
	private final String namespace = "board";
	
	public List <PostDto> getPostList(int boardType){ // 寃뚯떆�뙋 醫낅쪟�뿉 �뵲瑜� �쟾泥� 寃뚯떆�뙋 紐⑸줉�쓣 媛��졇�삤�뒗 硫붿냼�뱶
		return sqlSession.selectList(namespace + ".getPostList", boardType);
	}

	public PostDto getPost(int postId){  // postId�뿉 �뵲瑜� 寃뚯떆臾쇱쓣 �븯�굹 媛��졇�삤�뒗 硫붿냼�뱶
		return sqlSession.selectOne(namespace + ".getPost", postId);
	}
	
	public PostContentDto getPostContent(int postId) {
		return sqlSession.selectOne(namespace + ".getPostContent", postId);
	}
	
	public List<PostCommentDto> getPostComments(int postId) {
		return sqlSession.selectOne(namespace + ".getPostComments", postId);
	}
	
	public void insertPost(PostDto post) { // 寃뚯떆臾� �옉�꽦 硫붿냼�뱶
		System.out.println(post);
		sqlSession.insert(namespace + ".insertPost", post);
	}
	
	public void deletePost(int postId) { // 寃뚯떆臾� �궘�젣 硫붿냼�뱶
		sqlSession.delete(namespace + ".deletePost", postId);
	}
	public void modifyPost(PostDto post) { // 寃뚯떆臾� �닔�젙 硫붿냼�뱶
		System.out.println(post.toString());
	 	sqlSession.update(namespace + ".modifyPost", post);
	}
	
	public void insertPostContent(PostContentDto content) {
		sqlSession.insert(namespace + ".insertContent", content);
	}
	public void deletePostContent(int postId) { // 寃뚯떆臾� �궘�젣 硫붿냼�뱶
		sqlSession.delete(namespace + ".deleteContent", postId);
	}
	public void modifyPostContent(PostContentDto post) { // 寃뚯떆臾� �닔�젙 硫붿냼�뱶
		System.out.println(post.toString());
	 	sqlSession.update(namespace + ".modifyContent", post);
	}
	
	public void insertComment(PostCommentDto comment) {// �뙎湲� �옉�꽦 硫붿냼�뱶
		sqlSession.insert(namespace + ".insertComment", comment);
	}
	public void deleteComment(int commentId) { // �뙎湲� �궘�젣 硫붿냼�뱶
		sqlSession.delete(namespace + ".deleteComment", commentId);
	}
	public void modifyComment(PostCommentDto comment) { // �뙎湲� �닔�젙 硫붿냼�뱶
		sqlSession.update(namespace + ".modifyComment", comment);
	}
	

}
