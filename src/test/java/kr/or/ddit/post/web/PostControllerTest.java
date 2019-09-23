package kr.or.ddit.post.web;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.fileUpload;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.io.File;
import java.io.FileInputStream;

import org.junit.Test;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.mock.web.MockMultipartFile;

import kr.or.ddit.config.test.WebTestConfig;
import kr.or.ddit.user.model.UserVo;

public class PostControllerTest extends WebTestConfig{

	/**
	* Method : PostControllerTest
	* 작성자 : JEON MIN GYU
	* 변경이력 :
	* Method 설명 : 게시글 페이징 리스트 출력
	 * @throws Exception 
	*/
	@Test
	public void PostControllerTest() throws Exception {
		mockMvc.perform(get("/post")
						.param("boardNum", "1"))
				.andExpect(status().isOk())
				.andExpect(view().name("post/post"));
	}

	/**
	* Method : selectPostView
	* 작성자 : JEON MIN GYU
	* 변경이력 :
	* @throws Exception
	* Method 설명 : 게시글 조회 화면 요청
	*/
	@Test
	public void selectPostView() throws Exception {
		mockMvc.perform(get("/selectPost")
				.param("postNum", ""))
		.andExpect(status().is(302))
		.andExpect(view().name("redirect:/post"));
	}
	
	/**
	* Method : writePostView
	* 작성자 : JEON MIN GYU
	* 변경이력 :
	* @throws Exception
	* Method 설명 : 글작성 페이지 화면 요청
	*/
	@Test
	public void writePostView() throws Exception {
		mockMvc.perform(get("/writePost"))
		.andExpect(status().isOk())
		.andExpect(view().name("post/writePost"));
	}
	
	/**
	* Method : writePostTest
	* 작성자 : JEON MIN GYU
	* 변경이력 :
	* @throws Exception
	* Method 설명 : 게시글 작성
	*/
	@Test
	public void writePostTest() throws Exception {
		File f = new File("src/test/resources/kr/or/ddit/test/brown.png");
		FileInputStream fis = new FileInputStream(f);
		
		MockMultipartFile file = new MockMultipartFile("picture", "brown.png", "", fis);
		
		MockHttpSession session = new MockHttpSession();
		UserVo userVo = new UserVo();
		userVo.setUserId("brown");
		session.setAttribute("userVo", userVo);
		
		mockMvc.perform(fileUpload("/writePost")
				.file(file)
				.param("postNum2", "0")
				.param("postNm", "가나다")
				.param("smarteditor", "아아아")
				.param("boardNum", "1")
				.session(session)
				)
		.andExpect(status().is(302))
		.andExpect(view().name("redirect:/selectPost"));
	}
	
	/**
	* Method : modifyPostViewTest
	* 작성자 : JEON MIN GYU
	* 변경이력 :
	* @throws Exception
	* Method 설명 : 게시글 수정화면 요청
	*/
	@Test
	public void modifyPostViewTest() throws Exception {
		mockMvc.perform(get("/modifyPost")
						.param("btnValue", "삭제")
						.param("postNum2", "2")
						.param("postDelStatus", "Y"))
		.andExpect(status().is(302))
		.andExpect(view().name("redirect:/post"));
	}
	
	@Test
	public void modifyPost() throws Exception {
		File f = new File("src/test/resources/kr/or/ddit/test/brown.png");
		FileInputStream fis = new FileInputStream(f);
		
		MockMultipartFile file = new MockMultipartFile("picture", "brown.png", "", fis);
		
		mockMvc.perform(fileUpload("/modifyPost")
						.file(file)
						.param("boardNum", "1")
						.param("postNm", "하하하")
						.param("postNum2", "2")
						.param("postCont", "하하하"))
		.andExpect(status().is(302))
		.andExpect(view().name("redirect:/selectPost"));
	}
	
	@Test
	public void insertCmt() throws Exception {
		MockHttpSession session = new MockHttpSession();
		UserVo userVo = new UserVo();
		userVo.setUserId("brown");
		session.setAttribute("userVo", userVo);
		
		mockMvc.perform(post("/insertCmt")
				.param("boardNum", "1")
				.param("cmtCont", "하하하")
				.param("postNum", "2")
				.session(session))
		.andExpect(status().is(302))
		.andExpect(view().name("redirect:/selectPost"));
	}
	
	@Test
	public void DeleteCmt() throws Exception {
		mockMvc.perform(post("/deleteCmt")
				.param("boardNum", "1")
				.param("cmtNum", "3"))
		.andExpect(status().is(302))
		.andExpect(view().name("redirect:/selectPost"));
	}
	
	@Test
	public void fileDownloadView() throws Exception {
		mockMvc.perform(post("/fileDownloadView")
				.param("atfNum", "6"))
		.andExpect(status().isOk())
		.andExpect(view().name("fileDownloadView"));
	}
}
