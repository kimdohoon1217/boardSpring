package kr.or.ddit.post.service;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.config.test.RootTestConfig;
import kr.or.ddit.post.model.AttachedfileVo;
import kr.or.ddit.post.model.CommentsVo;
import kr.or.ddit.post.model.PostVo;
import kr.or.ddit.post.service.IPostService;
import kr.or.ddit.post.service.PostServiceImpl;
import kr.or.ddit.user.repository.UserDaoTest;

public class PostServiceTest extends RootTestConfig{

	private static final Logger logger = LoggerFactory.getLogger(PostServiceTest.class);
	@Resource(name = "postServiceImpl")
	private IPostService serv;
	
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
		List<PostVo> list = serv.getPostList(map);
		
		/***Then***/
		assertEquals(5, list.size());
	}

	@Test
	public void selectPostTest() {
		/***Given***/
		int postNum = 21;

		/***When***/
		Map<String, Object> map = serv.selectPost(postNum);
		PostVo pvo = (PostVo) map.get("pvo");
		List<CommentsVo> cmtList = (List<CommentsVo>) map.get("cmtList");
		
		/***Then***/
		assertEquals("가나다", pvo.getPostNm());
		assertEquals(0, cmtList.size());
	}
	
	@Test
	public void insertCmtTest() {
		/***Given***/
		CommentsVo cvo = new CommentsVo(0, "테스트3", null, 101, "cony", "N");

		/***When***/
		int cnt = serv.insertCmt(cvo);
		
		/***Then***/
		assertEquals(1, cnt);
	}
	
	@Test 
	public void deletePost() {
		/***Given***/
		PostVo pvo = new PostVo();
		pvo.setDelStatus("Y");
		pvo.setPostNum2(40);
		
		/***When***/
		int cnt = serv.deletePost(pvo);
		
		/***Then***/
		assertEquals(1, cnt);
	}
	
	@Test
	public void updatePost() {
		/***Given***/
		PostVo pvo = new PostVo();
		pvo.setPostNm("수정테스트");
		pvo.setPostCont("수정테스트입니다.");
		pvo.setPostNum2(40);
		
		/***When***/
		int cnt = serv.updatePost(pvo);
		
		/***Then***/
		assertEquals(1, cnt);
	}
	
	@Test
	public void getAttachedFile() {
		/***Given***/
		int postnum = 22;

		/***When***/
		List<AttachedfileVo> list = serv.getAttachedFile(postnum);
		
		/***Then***/
		assertEquals(3, list.size());
	}
	
	@Test
	public void deleteAtf() {
		/***Given***/
		int atfnum = 40;

		/***When***/
		int cnt = serv.deleteAtf(atfnum);
		
		/***Then***/
		assertEquals(1, cnt);
	}
	
	@Test
	public void deleteCmt() {
		/***Given***/
		int cmtnum=40;

		/***When***/
		int cnt = serv.deleteCmt(cmtnum);
				
		/***Then***/
		assertEquals(1, cnt);
	}
	
	@Test
	public void selectAtf() {
		/***Given***/
		int atfnum=12;

		/***When***/
		AttachedfileVo avo = serv.selectAtf(atfnum);

		/***Then***/
		assertEquals(12, avo.getAtfNum());
	}
}
