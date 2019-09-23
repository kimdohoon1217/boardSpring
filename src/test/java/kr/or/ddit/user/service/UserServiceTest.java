package kr.or.ddit.user.service;

import static org.junit.Assert.assertEquals;

import javax.annotation.Resource;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.config.test.RootTestConfig;
import kr.or.ddit.user.model.UserVo;

public class UserServiceTest extends RootTestConfig{

	private static final Logger logger = LoggerFactory.getLogger(UserServiceTest.class);
	@Resource(name = "userServiceImpl")
	private IUserService serv;
	private String userId = "brown";
	
	@Test
	public void getUserTest() {
		/***Given***/
		
		/***When***/
		UserVo uvo = serv.getUser(userId);
		
		/***Then***/
		assertEquals("brown", uvo.getUserId());
	}

}
