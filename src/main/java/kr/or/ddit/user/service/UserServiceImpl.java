package kr.or.ddit.user.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.repository.IUserDao;

@Service
public class UserServiceImpl implements IUserService {

	@Resource(name = "userDaoImpl")
	private IUserDao dao;

	/**
	* Method : getUser
	* 작성자 : JEON MIN GYU
	* 변경이력 :
	* @param userId
	* @return
	* Method 설명 : 유저 정보 조회
	*/
	@Override
	public UserVo getUser(String userId) {
		UserVo uvo = dao.getUser(userId);
		
		return uvo;
	}
}
