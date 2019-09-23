package kr.or.ddit.board.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.board.repository.IBoardDao;

@Service
public class BoardServiceImpl implements IBoardService {
	
	@Resource(name = "boardDaoImpl")
	private IBoardDao dao;
	
	@Override
	public List<BoardVo> getBoardList() {
		List<BoardVo> list = dao.getBoardList();
		return list;
	}

	@Override
	public int insertBoard(BoardVo bvo) {
		int cnt = dao.insertBoard(bvo);
		return cnt;
	}

	@Override
	public int updateBoard(BoardVo bvo) {
		int cnt = dao.updateBoard(bvo);
		return cnt;
	}

	@Override
	public BoardVo getBoard(int boardNum) {
		BoardVo bvo = dao.getBoard(boardNum);
		return bvo;
	}
}
