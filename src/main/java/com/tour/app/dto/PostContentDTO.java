package com.tour.app.dto;

/**
 * 
 * PostContentDto �엯�땲�떎.
 * @author 諛뺤��쁽
 * 
 */
public class PostContentDTO {
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PostContentDTO other = (PostContentDTO) obj;
		if (boardTypeId != other.boardTypeId)
			return false;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (postId != other.postId)
			return false;
		return true;
	}
	private int postId;
	private int boardTypeId;
	private String content;
	
	public int getPostId() {
		return postId;
	}
	public void setPostId(int postId) {
		this.postId = postId;
	}
	public int getBoardTypeId() {
		return boardTypeId;
	}
	public void setBoardTypeId(int boardTypeId) {
		this.boardTypeId = boardTypeId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "PostContentDTO [postId=" + postId + ", boardTypeId=" + boardTypeId + ", content=" + content + "]";
	}
	
}
