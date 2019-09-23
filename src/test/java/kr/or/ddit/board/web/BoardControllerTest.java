package kr.or.ddit.board.web;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Test;
import org.springframework.mock.web.MockHttpSession;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.config.test.WebTestConfig;
import kr.or.ddit.user.model.UserVo;

public class BoardControllerTest extends WebTestConfig{

	/**
	* Method : addBoardTest
	* 작성자 : JEON MIN GYU
	* 변경이력 :
	* @return
	* Method 설명 : 게시판 관리 화면 요청 테스트
	 * @throws Exception 
	*/
	@Test
	public void addBoardTest() throws Exception {
		mockMvc.perform(get("/addBoard"))
				.andExpect(status().isOk())
				.andExpect(view().name("board/addBoard"));
	}

	/**
	* Method : insertBoardTest
	* 작성자 : JEON MIN GYU
	* 변경이력 :
	* Method 설명 : 게시판 생성, 수정
	 * @throws Exception 
	*/
	@Test
	public void insertBoardTest() throws Exception {
		MockHttpSession session = new MockHttpSession();
		
		UserVo userVo = new UserVo();
		userVo.setUserId("brown");
		
		session.setAttribute("userVo", userVo);
		
		BoardVo boardVo = new BoardVo(0, "하하하", "Y", null, "brown");
		
		mockMvc.perform(post("/addBoard")
				.param("btnValue", "사용")
				.param("boardNm", boardVo.getBoardNm())
				.param("useStatus", boardVo.getUseStatus())
				.param("userId", boardVo.getUserId())
				.session(session))
		.andExpect(status().isOk())
		.andExpect(view().name("board/addBoard"));
	}
	
}
