package kr.or.ddit.post.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.or.ddit.post.model.AttachedfileVo;
import kr.or.ddit.post.model.CommentsVo;
import kr.or.ddit.post.model.PostVo;
import kr.or.ddit.post.repository.IPostDao;

@Service
public class PostServiceImpl implements IPostService {
	
	@Resource(name = "postDaoImpl")
	private IPostDao dao;
	
	@Override
	public List<PostVo> getPostList(Map map) {
		List<PostVo> list = dao.getPostList(map);
		return list;
	}

	@Override
	public Map<String, Object> selectPost(int postNum) {
		PostVo pvo = dao.selectPost(postNum);
		List<CommentsVo> cmtList = dao.getCmtList(postNum);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pvo", pvo);
		map.put("cmtList", cmtList);
		return map;
	}

	@Override
	public int insertCmt(CommentsVo cvo) {
		int cnt = dao.insertCmt(cvo);
		return cnt;
	}

	@Override
	public int insertPost(Map map) {
		PostVo pvo = (PostVo) map.get("pvo");
		
		int cnt = dao.insertPost(pvo);
		return cnt;
	}

	@Override
	public int insertPost2(Map map) {
		int seq = dao.getPostSeq();
		PostVo pvo = (PostVo) map.get("pvo");
		
		int cnt = dao.insertPost2(pvo);
		return cnt;
	}

	@Override
	public List<PostVo> allPostList(int boardNum) {
		List<PostVo> list = dao.allPostList(boardNum);
		return list;
	}

	@Override
	public int getPostSeq() {
		int seq = dao.getPostSeq();
		return seq;
	}

	@Override
	public int insertAtf(AttachedfileVo atfVo) {
		int cnt = dao.insertAtf(atfVo);
		return cnt;
	}

	@Override
	public int deletePost(PostVo postVo) {
		int cnt = dao.deletePost(postVo);
		return cnt;
	}

	@Override
	public int updatePost(PostVo postVo) {
		int cnt = dao.updatePost(postVo);
		return cnt;
	}

	@Override
	public List<AttachedfileVo> getAttachedFile(int postNum) {
		List<AttachedfileVo> list = dao.getAttachedFile(postNum);
		return list;
	}

	@Override
	public int deleteAtf(int atfnum) {
		int cnt = dao.deleteAtf(atfnum);
		return cnt;
	}

	@Override
	public int deleteCmt(int cmtnum) {
		int cnt = dao.deleteCmt(cmtnum);
		return cnt;
	}

	@Override
	public AttachedfileVo selectAtf(int atfnum) {
		AttachedfileVo avo = dao.selectAtf(atfnum);
		return avo;
	}
	
}
