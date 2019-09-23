package kr.or.ddit.post.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class CommentsVo {

	private int cmtNum;
	private String cmtCont;
	@DateTimeFormat
	private Date cmtDate;
	private int postNum;
	private String userId;
	private String delStatus;

	public CommentsVo() {
	}

	public CommentsVo(int cmtNum, String cmtCont, Date cmtDate, int postNum, String userId, String delStatus) {
		this.cmtNum = cmtNum;
		this.cmtCont = cmtCont;
		this.cmtDate = cmtDate;
		this.postNum = postNum;
		this.userId = userId;
		this.delStatus = delStatus;
	}

	public int getCmtNum() {
		return cmtNum;
	}

	public void setCmtNum(int cmtNum) {
		this.cmtNum = cmtNum;
	}

	public String getCmtCont() {
		return cmtCont;
	}

	public void setCmtCont(String cmtCont) {
		this.cmtCont = cmtCont;
	}

	public Date getCmtDate() {
		return cmtDate;
	}

	public void setCmtDate(Date cmtDate) {
		this.cmtDate = cmtDate;
	}

	public int getPostNum() {
		return postNum;
	}

	public void setPostNum(int postNum) {
		this.postNum = postNum;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(String delStatus) {
		this.delStatus = delStatus;
	}

	
	
}
