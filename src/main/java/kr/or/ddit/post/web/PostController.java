package kr.or.ddit.post.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.post.model.AttachedfileVo;
import kr.or.ddit.post.model.CommentsVo;
import kr.or.ddit.post.model.PostVo;
import kr.or.ddit.post.service.IPostService;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.util.FileUtil;
import kr.or.ddit.util.model.FileInfo;

@Controller
public class PostController{
	
	@Resource(name = "postServiceImpl")
    private IPostService postServ;
	
	@Resource(name = "boardServiceImpl")
    private IBoardService boardServ;
	
	@GetMapping("post")
	public String postView(BoardVo boardVo, Integer page, Integer pagesize, Model model) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		if(page==null) page=1;
		if(pagesize==null) pagesize=10;
		
		map.put("boardNum", boardVo.getBoardNum());
		map.put("page", page);
		map.put("pagesize", pagesize);
		
		List<PostVo> postList = postServ.getPostList(map);
		
		List<PostVo> pageList = postServ.allPostList(boardVo.getBoardNum());
		
		int paginationSize = (int)Math.ceil((double)pageList.size()/pagesize);
		
		model.addAttribute("boardNum", boardVo.getBoardNum());
		model.addAttribute("boardNm", boardVo.getBoardNm());
		model.addAttribute("postList", postList);
		model.addAttribute("page", page);
		model.addAttribute("pagesize", pagesize);
		model.addAttribute("paginationSize", paginationSize);
		
		return "post/post";
	}
	
	@GetMapping("selectPost")
	public String selectPostView(String boardNm, String postNum, Integer boardNum, Model model) {
		
		if(postNum.equals("")) {
//			String res = "삭제된 게시물입니다";
			model.addAttribute("boardNm", boardNm);
			model.addAttribute("boardNum", boardNum);
//			model.addAttribute("res", res);
			return "redirect:/post";
		}else {
			Map<String, Object> map = postServ.selectPost(Integer.parseInt(postNum));
			
			PostVo pvo = (PostVo) map.get("pvo");
			List<CommentsVo> cmtList = (List<CommentsVo>) map.get("cmtList");
			List<AttachedfileVo> atfList = postServ.getAttachedFile(Integer.parseInt(postNum));
			
			model.addAttribute("atfList", atfList);
			model.addAttribute("boardNum", boardNum);
			model.addAttribute("pvo", pvo);
			model.addAttribute("cmtList", cmtList);
			model.addAttribute("boardNm", boardNm);
			
			return "post/selectPost";
		}
	}
	
	@GetMapping("writePost")
	public String writePostView(Integer boardNum, Model model) {
		
		model.addAttribute("postNum2", 0);
		model.addAttribute("gn", 0);
		model.addAttribute("boardNum", boardNum);
		
		return "post/writePost";
	}
	
	@PostMapping("writePost")
	public String writePost(String smarteditor, PostVo postVo, Integer boardNum, Model model, HttpSession session, @RequestPart("attachedFile") List<MultipartFile> attachedFiles) {
		UserVo uvo = (UserVo) session.getAttribute("userVo");
		PostVo pvo = new PostVo();
		int seq = postServ.getPostSeq();
		Map<String, Object> map = new HashMap<String, Object>();
		
		if(postVo.getPostNum2()==0) {
			pvo.setPostNum(seq);
			pvo.setPostNm(postVo.getPostNm());	
			pvo.setPostCont(smarteditor);
			pvo.setUserId(uvo.getUserId());
			pvo.setBoardNum(boardNum);	
			
			map.put("pvo", pvo);
			
			postServ.insertPost(map);
		}else {
			pvo.setPostNum(seq);
			pvo.setPostNm(postVo.getPostNm());	
			pvo.setPostCont(smarteditor);
			pvo.setUserId(uvo.getUserId());
			pvo.setBoardNum(boardNum);	
			pvo.setPostNum2(postVo.getPostNum2());
			pvo.setGn(pvo.getGn());	
			
			map.put("pvo", pvo);
			
			postServ.insertPost2(map);
		}
		
		for(MultipartFile attachedFile : attachedFiles) {
			FileInfo fileInfo = FileUtil.getFileInfo(attachedFile.getOriginalFilename());
			
			//첨부된 파일이 있을 경우만 업로드 처리
			if(attachedFile.getSize() > 0) {
				AttachedfileVo avo = new AttachedfileVo();
				try {
					attachedFile.transferTo(fileInfo.getFile());
					avo.setPostNum(seq);
					avo.setAtfNm(fileInfo.getOriginalFileName());		//originalFileName
					avo.setAtfPath(fileInfo.getFile().getPath());
					
					int insertCnt = postServ.insertAtf(avo);
					
				} catch (IllegalStateException | IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		model.addAttribute("postNum", seq);
		model.addAttribute("boardNum", boardNum);

		return "redirect:/selectPost";
	}

	@GetMapping(path = "modifyPost")
	public String modifyPostView(Integer boardNum, PostVo postVo, String btnValue, HttpSession session, Model model) {
		
		Map<String, Object> map = postServ.selectPost(postVo.getPostNum2());
		
		PostVo pvo1 = (PostVo) map.get("pvo");
		model.addAttribute("boardNum", boardNum);
		
		if(btnValue.equals("답글")) {
			model.addAttribute("postNum2", postVo.getPostNum2());
			model.addAttribute("gn", postVo.getGn());
			return "post/writePost";
		}else if(btnValue.equals("삭제")) {
			postVo.setDelStatus("Y");
			
			int cnt = postServ.deletePost(postVo);
			
			return "redirect:/post";
		}else if(btnValue.equals("수정")) {
			
			List<AttachedfileVo> atfList = postServ.getAttachedFile(postVo.getPostNum2());
			
			model.addAttribute("postNum2", postVo.getPostNum2());
			model.addAttribute("pvo", pvo1);
			model.addAttribute("atfList", atfList);

			return "post/modifyPost";
		}
		return "redirect:/post";
	}
	
	@PostMapping("modifyPost")
	public String modifyPost(PostVo postVo, Integer boardNum, String[] file, Model model, @RequestPart("attachedFile") List<MultipartFile> attachedFiles) {
		
		int cnt = postServ.updatePost(postVo);
		
		List<AttachedfileVo> avoList = postServ.getAttachedFile(postVo.getPostNum2());
		
		String files[] = file;
		
		List<Integer> atfnumList = new ArrayList<Integer>();
		
		if(files==null || files.length == 0) {
			for(AttachedfileVo atfVo : avoList) {
				postServ.deleteAtf(atfVo.getAtfNum());
			}
		}else {
			
			for(AttachedfileVo atfVo : avoList) {
				atfnumList.add(atfVo.getAtfNum());
			}
			
			for(int atfnum : atfnumList) {
				boolean flag = true;
				for(String filenum : files) {
					if(atfnum == Integer.parseInt(filenum)) {
						flag = false;
						break;
					}
				}
				if(flag) {
					postServ.deleteAtf(atfnum);
				}
			}
		}
		
		for(MultipartFile attachedFile : attachedFiles) {
			FileInfo fileInfo = FileUtil.getFileInfo(attachedFile.getOriginalFilename());
			
			//첨부된 파일이 있을 경우만 업로드 처리
			if(attachedFile.getSize() > 0) {
				AttachedfileVo avo = new AttachedfileVo();
				try {
					attachedFile.transferTo(fileInfo.getFile());
					avo.setPostNum(postVo.getPostNum2());
					avo.setAtfNm(fileInfo.getOriginalFileName());		//originalFileName
					avo.setAtfPath(fileInfo.getFile().getPath());
					
					int insertCnt = postServ.insertAtf(avo);
					
				} catch (IllegalStateException | IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		model.addAttribute("boardNum", boardNum);
		model.addAttribute("postNum", postVo.getPostNum2());
		
		return "redirect:/selectPost";
	}
	
	@PostMapping("insertCmt")
	public String insertCmt(Integer boardNum, CommentsVo commentsVo, Model model, HttpSession session) {
		
		UserVo uvo = (UserVo) session.getAttribute("userVo");
		
		String userId = uvo.getUserId();
		
		CommentsVo cvo = new CommentsVo(0, commentsVo.getCmtCont(), null, commentsVo.getPostNum(), userId, "N");
		
		postServ.insertCmt(cvo);
		
		model.addAttribute("boardNum", boardNum);
		model.addAttribute("postNum", commentsVo.getPostNum());
		
		return "redirect:/selectPost";
	}
	
	@PostMapping("deleteCmt")
	public String DeleteCmt(CommentsVo commentsVo, Integer boardNum, Model model) {
		
		int cnt = postServ.deleteCmt(commentsVo.getCmtNum());
		
		model.addAttribute("postNum", commentsVo.getPostNum());
		model.addAttribute("boardNum", boardNum);
		
		return "redirect:/selectPost";
	}
	
	@RequestMapping("fileDownloadView")
	public String fileDownloadView(Integer atfNum, Model model) {
		
		AttachedfileVo atfVo = postServ.selectAtf(atfNum);
		
		model.addAttribute("atfVo", atfVo);
		return "fileDownloadView";
	}
}
