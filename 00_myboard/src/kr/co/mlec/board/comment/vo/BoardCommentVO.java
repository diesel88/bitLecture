package kr.co.mlec.board.comment.vo;

import java.util.Date;

public class BoardCommentVO {
	private int commentNoNumber;
	private int no;
	private String content;
	private String userId;
	private Date regDate;
	public int getCommentNoNumber() {
		return commentNoNumber;
	}
	public void setCommentNoNumber(int commentNoNumber) {
		this.commentNoNumber = commentNoNumber;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	
}
