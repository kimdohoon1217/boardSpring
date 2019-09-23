package kr.or.ddit.user.web;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Test;

import kr.or.ddit.config.test.WebTestConfig;

public class UserControllerTest extends WebTestConfig{

	/**
	* Method : loginProcessTest
	* 작성자 : JEON MIN GYU
	* 변경이력 :
	* Method 설명 : main 화면 이동
	 * @throws Exception 
	*/
	@Test
	public void loginProcessTest() throws Exception {
		mockMvc.perform(post("/login")
						.param("userId", "brown")
						.param("pass", "brown1234"))
				.andExpect(status().isOk())
				.andExpect(view().name("main"));
	}

	/**
	* Method : logoutTest
	* 작성자 : JEON MIN GYU
	* 변경이력 :
	* @param session
	* @return
	* Method 설명 : 로그아웃
	*/
	@Test
	public void logoutTest() throws Exception {
		mockMvc.perform(get("/logout"))
				.andExpect(status().is(302))
				.andExpect(view().name("redirect:/login"));
	}

}
