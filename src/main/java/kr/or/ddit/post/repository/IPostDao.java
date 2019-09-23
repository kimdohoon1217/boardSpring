package kr.or.ddit.post.repository;

import java.util.List;
import java.util.Map;

import kr.or.ddit.post.model.AttachedfileVo;
import kr.or.ddit.post.model.CommentsVo;
import kr.or.ddit.post.model.PostVo;

public interface IPostDao {
	
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
	* Method 설명 : postNum을 파라미터로 보내 일치하는 게시글 정보를 가져온다.
	 */
	public PostVo selectPost(int postNum);
	
	/**
	* Method : getCmtList
	* 작성자 : PC-13
	* 변경이력 :
	* @param sqlSession
	* @param postNum
	* @return
	* Method 설명 : postNum을 파라미터로 보내 일치하는 덧글 리스트를 가져온다.
	 */
	public List<CommentsVo> getCmtList(int postNum);
	
	/**
	* Method : insertCmt
	* 작성자 : PC-13
	* 변경이력 :
	* @param sqlSession
	* @param cvo
	* @return
	* Method 설명 : 덧글 저장
	 */
	public int insertCmt(CommentsVo cvo);
	
	public int getPostSeq();
	
	public int insertPost(PostVo postVo);
	
	public int insertPost2(PostVo postVo);
	
	public int insertAtf(AttachedfileVo atfVo);
	
	public int deletePost(PostVo postVo);
	
	public int updatePost(PostVo postVo);
	
	public List<AttachedfileVo> getAttachedFile(int postNum);
	
	public int deleteAtf(int atfnum);
	
	public int deleteCmt(int cmtnum);
	
	public AttachedfileVo selectAtf(int atfnum);

}
