package kr.or.ddit.post.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.post.model.AttachedfileVo;
import kr.or.ddit.post.model.CommentsVo;
import kr.or.ddit.post.model.PostVo;

public interface IPostService {

	public List<PostVo> allPostList(int boardNum);
	
	/**
	* Method : getPostList
	* 작성자 : PC-13
	* 변경이력 :
	* @param sqlSession
	* @param boardNum
	* @return
	* Method 설명 : boardNum을 파라미터로 보내 일치하는 게시판 리스트를 가져온다.
	 */
	public List<PostVo> getPostList(Map map);
	
	/**
	* Method : selectPost
	* 작성자 : PC-13
	* 변경이력 :
	* @param sqlSession
	* @param postNum
	* @return
	* Method 설명 : postNum을 파라미터로 보내 일치하는 게시글에 출력될 정보들을 가져온다.
	 */
	public Map<String, Object> selectPost(int postNum);
	
	/**
	* Method : insertCmt
	* 작성자 : PC-13
	* 변경이력 :
	* @param cvo
	* @return
	* Method 설명 : 덧글등록
	 */
	public int insertCmt(CommentsVo cvo);
	
	public int insertPost(Map map);
	
	public int insertPost2(Map map);
	
	public int getPostSeq();
	
	public int insertAtf(AttachedfileVo atfVo);
	
	public int deletePost(PostVo postVo);
	
	public int updatePost(PostVo postVo);
	
	public List<AttachedfileVo> getAttachedFile(int postNum);
	
	public int deleteAtf(int atfnum);
	
	public int deleteCmt(int cmtnum);
	
	public AttachedfileVo selectAtf(int atfnum);
}
