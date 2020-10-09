package com.tour.app.dto;


public class PostContentDto {
	private int postId;
	private int postBoardTypeId;
	private String postContent;

	public int getPostId() {
		return postId;
	}
	public void setPostId(int postId) {
		this.postId = postId;
	}
	public int getBoardTypeId() {
		return postBoardTypeId;
	}
	public void setBoardTypeId(int postBoardTypeId) {
		this.postBoardTypeId = postBoardTypeId;
	}
	public String getPostContent() {
		return postContent;
	}
	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}
	
	@Override
	public String toString() {
		return "PostContentDTO [postId=" + postId + ", boardTypeId=" + postBoardTypeId + ", postContent=" + postContent
				+ "]";
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PostContentDto other = (PostContentDto) obj;
		if (postBoardTypeId != other.postBoardTypeId)
			return false;
		if (postContent == null) {
			if (other.postContent != null)
				return false;
		} else if (!postContent.equals(other.postContent))
			return false;
		if (postId != other.postId)
			return false;
		return true;
	}
}
