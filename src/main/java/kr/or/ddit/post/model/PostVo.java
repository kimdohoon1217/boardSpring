package kr.or.ddit.post.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class PostVo {

	private int postNum;
	private String postNm;
	private String postCont;
	@DateTimeFormat
	private Date postDate;
	private String delStatus;
	private String userId;
	private int boardNum;
	private int postNum2;
	private int gn;
	private int level;
	
	public PostVo() { }

	public PostVo(int postNum, String postNm, String postCont, Date postDate, String delStatus, String userId,
			int boardNum, int postNum2, int gn, int level) {
		this.postNum = postNum;
		this.postNm = postNm;
		this.postCont = postCont;
		this.postDate = postDate;
		this.delStatus = delStatus;
		this.userId = userId;
		this.boardNum = boardNum;
		this.postNum2 = postNum2;
		this.gn = gn;
		this.level = level;
	}

	public int getPostNum() {
		return postNum;
	}

	public void setPostNum(int postNum) {
		this.postNum = postNum;
	}

	public String getPostNm() {
		return postNm;
	}

	public void setPostNm(String postNm) {
		this.postNm = postNm;
	}

	public String getPostCont() {
		return postCont;
	}

	public void setPostCont(String postCont) {
		this.postCont = postCont;
	}

	public Date getPostDate() {
		return postDate;
	}

	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}

	public String getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(String delStatus) {
		this.delStatus = delStatus;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getBoardNum() {
		return boardNum;
	}

	public void setBoardNum(int boardNum) {
		this.boardNum = boardNum;
	}

	public int getPostNum2() {
		return postNum2;
	}

	public void setPostNum2(int postNum2) {
		this.postNum2 = postNum2;
	}

	public int getGn() {
		return gn;
	}

	public void setGn(int gn) {
		this.gn = gn;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

}
