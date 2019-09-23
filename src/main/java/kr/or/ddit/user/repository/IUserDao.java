package kr.or.ddit.user.repository;

import kr.or.ddit.user.model.UserVo;

public interface IUserDao {

	public UserVo getUser(String userId);
	
}
