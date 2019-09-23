package kr.or.ddit.user.repository;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.or.ddit.user.model.UserVo;

@Repository
public class UserDaoImpl implements IUserDao {

	@Resource(name = "sqlSessionTemplate")
	private SqlSessionTemplate sqlSession;
	
	@Override
	public UserVo getUser(String userId) {
		return sqlSession.selectOne("user.getUser", userId);
	}

}
