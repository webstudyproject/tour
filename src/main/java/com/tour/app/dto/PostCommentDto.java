package com.tour.app.dto;


public class PostCommentDto {
	private int postCommentId;
	private int postId;
	private String postCommentContent;
	private String postCommentMemberId;
	private String postCommentCreateDate;
	private int postCommentParentCommentId;
	
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
	public String getPostCommentContent() {
		return postCommentContent;
	}
	public void setPostCommentContent(String postCommentContent) {
		this.postCommentContent = postCommentContent;
	}
	public String getPostCommentMemberId() {
		return postCommentMemberId;
	}
	public void setPostCommentMemberId(String postCommentMemberId) {
		this.postCommentMemberId = postCommentMemberId;
	}
	public String getPostCommentCreateDate() {
		return postCommentCreateDate;
	}
	public void setPostCommentCreateDate(String postCommentCreateDate) {
		this.postCommentCreateDate = postCommentCreateDate;
	}
	public int getPostCommentParentCommentId() {
		return postCommentParentCommentId;
	}
	public void setPostCommentParentCommentId(int postCommentParentCommentId) {
		this.postCommentParentCommentId = postCommentParentCommentId;
	}
	@Override
	public String toString() {
		return "PostCommentDTO [postCommentId=" + postCommentId + ", postId=" + postId + ", postCommentContent="
				+ postCommentContent + ", postCommentMemberId=" + postCommentMemberId + ", postCommentCreateDate="
				+ postCommentCreateDate + ", postCommentParentCommentId=" + postCommentParentCommentId + "]";
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PostCommentDto other = (PostCommentDto) obj;
		if (postCommentContent == null) {
			if (other.postCommentContent != null)
				return false;
		} else if (!postCommentContent.equals(other.postCommentContent))
			return false;
		if (postCommentCreateDate == null) {
			if (other.postCommentCreateDate != null)
				return false;
		} else if (!postCommentCreateDate.equals(other.postCommentCreateDate))
			return false;
		if (postCommentId != other.postCommentId)
			return false;
		if (postCommentMemberId == null) {
			if (other.postCommentMemberId != null)
				return false;
		} else if (!postCommentMemberId.equals(other.postCommentMemberId))
			return false;
		if (postCommentParentCommentId != other.postCommentParentCommentId)
			return false;
		if (postId != other.postId)
			return false;
		return true;
	}
}	
