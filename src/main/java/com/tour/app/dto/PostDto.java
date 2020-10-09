package com.tour.app.dto;

import java.util.List;


public class PostDto {
	
	private int postId;
	private int postBoardTypeId;
	private String postTitle;
	private String postMemberId;
	private String postCreateDate;
	private boolean postNotifyFlag;
	private int postHitsNumber;
	
	private List<PostCommentDto> postComments;
	private PostContentDto postContent;
	
	public int getPostId() {
		return postId;
	}
	public void setPostId(int postId) {
		this.postId = postId;
	}
	public int getPostBoardTypeId() {
		return postBoardTypeId;
	}
	public void setPostBoardTypeId(int postBoardTypeId) {
		this.postBoardTypeId = postBoardTypeId;
	}
	public String getPostTitle() {
		return postTitle;
	}
	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}
	public String getPostMemberId() {
		return postMemberId;
	}
	public void setPostMemberId(String postMemberId) {
		this.postMemberId = postMemberId;
	}
	public String getPostCreateDate() {
		return postCreateDate;
	}
	public void setPostCreateDate(String postCreateDate) {
		this.postCreateDate = postCreateDate;
	}
	public boolean isPostNotifyFlag() {
		return postNotifyFlag;
	}
	public void setPostNotifyFlag(boolean postNotifyFlag) {
		this.postNotifyFlag = postNotifyFlag;
	}
	public int getPostHitsNumber() {
		return postHitsNumber;
	}
	public void setPostHitsNumber(int postHitsNumber) {
		this.postHitsNumber = postHitsNumber;
	}
	public List<PostCommentDto> getPostComments() {
		return postComments;
	}
	public void setPostComments(List<PostCommentDto> postComments) {
		this.postComments = postComments;
	}
	public PostContentDto getPostContent() {
		return postContent;
	}
	public void setPostContent(PostContentDto postContent) {
		this.postContent = postContent;
	}


	@Override
	public String toString() {
		return "PostDTO [postId=" + postId + ", postBoardTypeId=" + postBoardTypeId + ", postTitle=" + postTitle
				+ ", postMemberId=" + postMemberId + ", postCreateDate=" + postCreateDate + ", postNotifyFlag="
				+ postNotifyFlag + ", postHitsNumber=" + postHitsNumber + ", postComments=" + postComments
				+ ", postContent=" + postContent + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PostDto other = (PostDto) obj;
		if (postBoardTypeId != other.postBoardTypeId)
			return false;
		if (postComments == null) {
			if (other.postComments != null)
				return false;
		} else if (!postComments.equals(other.postComments))
			return false;
		if (postContent == null) {
			if (other.postContent != null)
				return false;
		} else if (!postContent.equals(other.postContent))
			return false;
		if (postCreateDate == null) {
			if (other.postCreateDate != null)
				return false;
		} else if (!postCreateDate.equals(other.postCreateDate))
			return false;
		if (postHitsNumber != other.postHitsNumber)
			return false;
		if (postId != other.postId)
			return false;
		if (postMemberId == null) {
			if (other.postMemberId != null)
				return false;
		} else if (!postMemberId.equals(other.postMemberId))
			return false;
		if (postNotifyFlag != other.postNotifyFlag)
			return false;
		if (postTitle == null) {
			if (other.postTitle != null)
				return false;
		} else if (!postTitle.equals(other.postTitle))
			return false;
		return true;
	}


}
