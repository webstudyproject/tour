package com.tour.app.dto;

import java.sql.Date;

/**
 * 
 * postcommentDTO 입니다.
 * @author 박지현
 *
 */
public class PostCommentDTO {
	private int postCommentId;
	private int postId;
	private String commentContent;
	private String memberId;
	private Date createDate;
	private int parentCommentId;
	
	public int getPostCommentId() {
		return postCommentId;
	}
	public void setPostCommentId(int postCommentId) {
		this.postCommentId = postCommentId;
	}
	public int getPostId() {
		return postId;
	}
	public void setPostId(int postId) {
		this.postId = postId;
	}
	public String getCommentContent() {
		return commentContent;
	}
	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public int getParentCommentId() {
		return parentCommentId;
	}
	public void setParentCommentId(int parentCommentId) {
		this.parentCommentId = parentCommentId;
	}
	@Override
	public String toString() {
		return "PostCommentDTO [postCommentId=" + postCommentId + ", postId=" + postId + ", commentContent="
				+ commentContent + ", memberId=" + memberId + ", createDate=" + createDate + ", parentCommentId="
				+ parentCommentId + "]";
	}

}	
