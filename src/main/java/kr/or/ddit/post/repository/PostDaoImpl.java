package kr.or.ddit.post.repository;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.or.ddit.post.model.AttachedfileVo;
import kr.or.ddit.post.model.CommentsVo;
import kr.or.ddit.post.model.PostVo;

@Repository
public class PostDaoImpl implements IPostDao {
	
	@Resource(name = "sqlSessionTemplate")
	private SqlSessionTemplate sqlSession;
	
	@Override
	public List<PostVo> getPostList(Map map) {
		return sqlSession.selectList("post.getPostList", map);
	}

	@Override
	public PostVo selectPost(int postNum) {
		return sqlSession.selectOne("post.selectPost", postNum);
	}

	@Override
	public List<CommentsVo> getCmtList(int postNum) {
		return sqlSession.selectList("comments.getCmtList", postNum);
	}

	@Override
	public int insertCmt(CommentsVo cvo) {
		return sqlSession.insert("comments.insertCmt", cvo);
	}

	@Override
	public int insertPost(PostVo postVo) {
		return sqlSession.insert("post.insertPost", postVo);
	}
	
	@Override
	public int insertPost2(PostVo postVo) {
		return sqlSession.insert("post.insertPost2", postVo);
	}

	@Override
	public int insertAtf(AttachedfileVo atfVo) {
		return sqlSession.insert("atf.insertAtf", atfVo);
	}

	@Override
	public int getPostSeq() {
		return sqlSession.selectOne("post.getPostSeq");
	}

	@Override
	public List<PostVo> allPostList(int boardNum) {
		return sqlSession.selectList("post.allPostList", boardNum);
	}

	@Override
	public int deletePost(PostVo postVo) {
		return sqlSession.update("post.deletePost", postVo);
	}

	@Override
	public int updatePost(PostVo postVo) {
		return sqlSession.update("post.updatePost", postVo);
	}

	@Override
	public List<AttachedfileVo> getAttachedFile(int postNum) {
		return sqlSession.selectList("atf.getAttachedFile", postNum);
	}

	@Override
	public int deleteAtf(int atfnum) {
		return sqlSession.delete("atf.deleteAtf", atfnum);
	}

	@Override
	public int deleteCmt(int cmtnum) {
		return sqlSession.update("comments.deleteCmt", cmtnum);
	}

	@Override
	public AttachedfileVo selectAtf(int atfnum) {
		return sqlSession.selectOne("atf.selectAtf", atfnum);
	}
	
	
}
