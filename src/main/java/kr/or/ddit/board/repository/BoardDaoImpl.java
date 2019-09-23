package kr.or.ddit.board.repository;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.or.ddit.board.model.BoardVo;

@Repository
public class BoardDaoImpl implements IBoardDao {
	
	@Resource(name = "sqlSessionTemplate")
	private SqlSessionTemplate sqlSession;
	
	@Override
	public List<BoardVo> getBoardList() {
		return sqlSession.selectList("board.getBoardList");
	}

	@Override
	public int insertBoard(BoardVo bvo) {
		return sqlSession.insert("board.insertBoard", bvo);
	}

	@Override
	public int updateBoard(BoardVo bvo) {
		return sqlSession.update("board.updateBoard", bvo);
	}

	@Override
	public BoardVo getBoard(int boardNum) {
		return sqlSession.selectOne("board.getBoard", boardNum);
	}
	
	
}
