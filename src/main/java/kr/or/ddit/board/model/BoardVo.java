package kr.or.ddit.board.model;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class BoardVo {

	private int boardNum;
	private String boardNm;
	private String useStatus;
	private Date boardDate;
	private String userId;
	
	public BoardVo() {
	}
	public BoardVo(int boardNum, String boardNm, String useStatus, Date boardDate, String userId) {
		this.boardNum = boardNum;
		this.boardNm = boardNm;
		this.useStatus = useStatus;
		this.boardDate = boardDate;
		this.userId = userId;
	}
	
	public int getBoardNum() {
		return boardNum;
	}
	public void setBoardNum(int boardNum) {
		this.boardNum = boardNum;
	}
	public String getBoardNm() {
		return boardNm;
	}
	public void setBoardNm(String boardNm) {
		this.boardNm = boardNm;
	}
	public String getUseStatus() {
		return useStatus;
	}
	public void setUseStatus(String useStatus) {
		this.useStatus = useStatus;
	}
	public Date getBoardDate() {
		return boardDate;
	}
	public void setBoardDate(Date boardDate) {
		this.boardDate = boardDate;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
}
