package kr.or.ddit.post.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.config.test.RootTestConfig;
import kr.or.ddit.post.model.AttachedfileVo;
import kr.or.ddit.post.model.CommentsVo;
import kr.or.ddit.post.model.PostVo;

public class PostDaoTest extends RootTestConfig{

	private static final Logger logger = LoggerFactory.getLogger(PostDaoTest.class);
	@Resource(name = "postDaoImpl")
	private IPostDao dao;
	
	@Test
	public void getPostListTest() {
		/***Given***/
		int boardNum = 1;
		int page = 1;
		int pagesize = 5;
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("boardNum", boardNum);
		map.put("page", page);
		map.put("pagesize", pagesize);
		
		/***When***/
		List<PostVo> list = dao.getPostList(map);
		
		/***Then***/
		assertEquals(5, list.size());
	}
	
	@Test
	public void selectPostTest() {
		/***Given***/
		int postNum = 11;

		/***When***/
		PostVo pvo = dao.selectPost(postNum);
		
		/***Then***/
		assertEquals("테스트", pvo.getPostNm());
	}
	
	@Test
	public void getCmtListTest() {
		/***Given***/
		int postNum = 30;

		/***When***/
		List<CommentsVo> list = dao.getCmtList(postNum);
		
		/***Then***/
		assertTrue(list.size()>2);
	}
	
	@Test
	public void insertCmtTest() {
		/***Given***/
		CommentsVo cvo = new CommentsVo(0, "테스트2", null, 101, "cony", "N");

		/***When***/
		int cnt = dao.insertCmt(cvo);
		
		/***Then***/
		assertEquals(1, cnt);
	}
	
	@Test
	public void getPostSeqTest() {
		/***Given***/

		/***When***/
		int seq = dao.getPostSeq();

		/***Then***/
		assertEquals(182, seq);
	}
	
	@Test
	public void insertPostTest() {
		/***Given***/
		PostVo pvo = new PostVo();
		pvo.setPostNm("테스트");	
		pvo.setPostCont("테스트입니다.아아아");
		pvo.setUserId("cony");
		pvo.setBoardNum(1);	
		pvo.setPostNum(182);
		/***When***/
		int cnt = dao.insertPost(pvo);
		
		/***Then***/
		assertEquals(1, cnt);
	}
	
	@Test
	public void insertPost2Test() {
		/***Given***/
		PostVo pvo = new PostVo();
		pvo.setPostNm("테스트");	
		pvo.setPostCont("테스트입니다.아아아");
		pvo.setUserId("cony");
		pvo.setBoardNum(1);	
		pvo.setPostNum2(8);
		pvo.setGn(4);
		pvo.setPostNum(182);
		
		/***When***/
		int cnt = dao.insertPost2(pvo);
		
		/***Then***/
		assertEquals(1, cnt);
	}
	
	@Test
	public void insertAtfTest() {
		/***Given***/
		AttachedfileVo avo = new AttachedfileVo();
		avo.setAtfNm("테스트");
		avo.setAtfPath("테스트용");
		avo.setPostNum(8);
		
		/***When***/
		int cnt = dao.insertAtf(avo);
		
		/***Then***/
		assertEquals(1, cnt);
	}
	
	@Test 
	public void deletePostTest() {
		/***Given***/
		PostVo pvo = new PostVo();
		pvo.setDelStatus("Y");
		pvo.setPostNum2(40);
		
		/***When***/
		int cnt = dao.deletePost(pvo);
		
		/***Then***/
		assertEquals(1, cnt);
	}
	
	@Test
	public void updatePostTest() {
		/***Given***/
		PostVo pvo = new PostVo();
		pvo.setPostNm("수정테스트");
		pvo.setPostCont("수정테스트입니다.");
		pvo.setPostNum2(30);
		
		/***When***/
		int cnt = dao.updatePost(pvo);
		
		/***Then***/
		assertEquals(1, cnt);
	}
	
	@Test
	public void getAttachedFileTest() {
		/***Given***/
		int postnum = 22;

		/***When***/
		List<AttachedfileVo> list = dao.getAttachedFile(postnum);
		
		/***Then***/
		assertTrue(list.size()>1);
	}
			
	@Test
	public void deleteAtfTest() {
		/***Given***/
		int atfnum = 19;

		/***When***/
		int cnt = dao.deleteAtf(atfnum);
		
		/***Then***/
		assertEquals(1, cnt);
	}
	
	@Test
	public void deleteCmtTest() {
		/***Given***/
		int cmtnum=40;

		/***When***/
		int cnt = dao.deleteCmt(cmtnum);
				
		/***Then***/
		assertEquals(1, cnt);
	}
	
	@Test
	public void selectAtfTest() {
		/***Given***/
		int atfnum=40;

		/***When***/
		AttachedfileVo avo = dao.selectAtf(atfnum);
		
		/***Then***/
		assertEquals(40, avo.getAtfNum());
	}
}
