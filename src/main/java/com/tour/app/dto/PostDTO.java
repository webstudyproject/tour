package com.tour.app.dto;

import java.sql.Date;
import java.util.List;

/**
 * 
 * postDTO �엯�땲�떎.
 * @author  諛뺤��쁽
 *
 */
public class PostDTO {


	private int postId;
	private int boardTypeId;
	private String title;
	private String memberId;
	private Date createDate;
	private boolean notifyFlag;
	private int hitsNumber;
	
	private List<PostCommentDTO> postComments;
	private PostContentDTO postContent;
	
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
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
	public boolean isNotifyFlag() {
		return notifyFlag;
	}
	public void setNotifyFlag(boolean notifyFlag) {
		this.notifyFlag = notifyFlag;
	}
	public int getHitsNumber() {
		return hitsNumber;
	}
	public void setHitsNumber(int hitsNumber) {
		this.hitsNumber = hitsNumber;
	}
	public List<PostCommentDTO> getPostComments() {
		return postComments;
	}
	public void setPostComments(List<PostCommentDTO> postComments) {
		this.postComments = postComments;
	}
	public PostContentDTO getPostContent() {
		return postContent;
	}
	public void setPostContent(PostContentDTO postContent) {
		this.postContent = postContent;
	}
	@Override
	public String toString() {
		return "PostDTO [postId=" + postId + ", boardTypeId=" + boardTypeId + ", title=" + title + ", memberId="
				+ memberId + ", createDate=" + createDate + ", notifyFlag=" + notifyFlag + ", hitsNumber=" + hitsNumber
				+ ", postComments=" + postComments + ", postContent=" + postContent + "]";
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PostDTO other = (PostDTO) obj;
		if (boardTypeId != other.boardTypeId)
			return false;
		if (createDate == null) {
			if (other.createDate != null)
				return false;
 		} else if (!createDate.equals(other.createDate))
			return false;
		if (hitsNumber != other.hitsNumber)
			return false;
		if (memberId == null) {
			if (other.memberId != null)
				return false;
		} else if (!memberId.equals(other.memberId))
			return false;
		if (notifyFlag != other.notifyFlag)
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
		if (postId != other.postId)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}



}
