package kr.or.ddit.user.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.IUserService;

@Controller
public class UserController {
	
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    
    @Resource(name = "userServiceImpl")
    private IUserService userService;
	
    @Resource(name = "boardServiceImpl")
    private IBoardService boardService;
    
    @RequestMapping(path = "login", method = RequestMethod.GET)
    public String loginView() {
//		model.addAttribute("res", res);
    	logger.debug("login");
    	return "login/login";
    }
    
	/**
	* Method : loginProcess
	* 작성자 : JEON MIN GYU
	* 변경이력 : 
	* @param userId
	* @param pass
	* @param rememberMe
	* @param response
	* @param session
	* @return
	* Method 설명 : 로그인 요청 처리
	*/
	@RequestMapping(path = "login", method = RequestMethod.POST)
	public String loginProcess(Model model, HttpServletRequest request, String userId, String pass, String rememberMe, HttpServletResponse response, HttpSession session) {
		
		List<BoardVo> boardList = boardService.getBoardList();
		
		request.getServletContext().setAttribute("boardList", boardList);
		
		manageUserIdCookie(response, userId, rememberMe);
		
		UserVo user = userService.getUser(userId);
		
		if(user==null) {
			return "login/login";
		}else if(user.checkLoginValidate(userId, pass)) {
			session.setAttribute("userVo", user);
			return "main";
		}else {
			return "login/login";
		}
		
	}
	
	private void manageUserIdCookie(HttpServletResponse response, String userId, String rememberMe) {
	     //rememberMe 파라미터가 존재할 경우 userId를 cookie로 생성
	     Cookie cookie = new Cookie("userId", userId);
	     if(rememberMe != null) {
	        cookie.setMaxAge(60*60*24*30); //30일
	     }else {
	          cookie.setMaxAge(0); //삭제
	     }
	        
	     response.addCookie(cookie);
	}

	/**
	* Method : logout
	* 작성자 : JEON MIN GYU
	* 변경이력 :
	* @param session
	* @return
	* Method 설명 : 로그아웃
	*/
	@RequestMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();	//세션 모든 내용 지우기
		return "redirect:/login";
	}
	
}
