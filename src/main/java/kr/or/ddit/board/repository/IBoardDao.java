package kr.or.ddit.board.repository;

import java.util.List;

import kr.or.ddit.board.model.BoardVo;

public interface IBoardDao {
	
	public List<BoardVo> getBoardList();
	
	public int insertBoard(BoardVo bvo);
	
	public int updateBoard(BoardVo bvo);
	
	public BoardVo getBoard(int boardNum);
	
}
