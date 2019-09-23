package kr.or.ddit.post.model;

public class AttachedfileVo {

	private int atfNum;
	private String atfNm;
	private String atfPath;
	private int postNum;
	
	public AttachedfileVo() {
	}
	
	public AttachedfileVo(int atfNum, String atfNm, String atfPath, int postNum) {
		this.atfNum = atfNum;
		this.atfNm = atfNm;
		this.atfPath = atfPath;
		this.postNum = postNum;
	}
	
	public int getAtfNum() {
		return atfNum;
	}
	public void setAtfNum(int atfNum) {
		this.atfNum = atfNum;
	}
	public String getAtfNm() {
		return atfNm;
	}
	public void setAtfNm(String atfNm) {
		this.atfNm = atfNm;
	}
	public String getAtfPath() {
		return atfPath;
	}
	public void setAtfPath(String atfPath) {
		this.atfPath = atfPath;
	}
	public int getPostNum() {
		return postNum;
	}
	public void setPostNum(int postNum) {
		this.postNum = postNum;
	}
	
	
}
