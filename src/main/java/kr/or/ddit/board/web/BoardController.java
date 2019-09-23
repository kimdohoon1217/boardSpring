package kr.or.ddit.board.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.user.model.UserVo;

@Controller
public class BoardController {
		
	@Resource(name = "boardServiceImpl")
    private IBoardService boardServ;   
	
	/**
	* Method : addBoard
	* 작성자 : JEON MIN GYU
	* 변경이력 :
	* @param model
	* @return
	* Method 설명 : 게시판 관리 화면 요청
	*/
	@GetMapping("addBoard")
	public String addBoard(Model model) {
		return "board/addBoard";
	}
	
	/**
	* Method : insertBoard
	* 작성자 : JEON MIN GYU
	* 변경이력 :
	* @param btnValue
	* @param model
	* @param session
	* @param boardVo
	* @param request
	* @return
	* Method 설명 : 게시판 생성, 수정
	*/
	@PostMapping("addBoard")
	public String insertBoard(String btnValue, Model model, HttpSession session, BoardVo boardVo, HttpServletRequest request) {
		
		UserVo uvo = (UserVo) session.getAttribute("userVo");
		
		boardVo.setUserId(uvo.getUserId());
		
//		String res = "";
		
		if(boardVo.getUseStatus().equals("사용")) {
			boardVo.setUseStatus("Y");
		}else {
			boardVo.setUseStatus("N");
		}
		
		if(btnValue.equals("생성")) {
			
			int cnt = boardServ.insertBoard(boardVo);
			
//			if(cnt == 1) {
//				res = "생성 성공";
//			}else {
//				res = "생성 실패";
//			}
			
		}else if(btnValue.equals("수정")) {
			
			
			
			int cnt = boardServ.updateBoard(boardVo);
			
//			if(cnt == 1) {
//				res = "수정 성공";
//			}else {
//				res = "수정 실패";
//			}
		}
		
		request.getServletContext().setAttribute("boardList", boardServ.getBoardList()); 
		
		return "board/addBoard";
	}
	
}
